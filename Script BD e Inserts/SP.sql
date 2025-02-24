-- Comandos 
use ticketWizard;

-- SP para consultar las consultas, divididas por usuario.
drop procedure  if exists consultarTransacciones;

DELIMITER //
CREATE  PROCEDURE consultarTransacciones(IN ID VARCHAR(20))
BEGIN 
SELECT TR.FECHAHORA as "Fecha-hora",
TR.TIPOCOMPRA as "Tipo de compra",
TR.MONTO as "Monto",
UT.ROL as "Rol",
b.fila as "Fila",
b.asiento as "Asiento",
E.NOMBRE as "Evento",
TB.IDTRANSACCION as "ID de la transacción",
ut.idUsuario as "ID usuario"

FROM usuarios_transacciones as ut
JOIN transacciones as tr on ut.idtransaccion = tr.idtransaccion 
JOIN TRANSACCIONESBOLETOS AS TB ON UT.idtransaccion = TB.idtransaccion 
JOIN BOLETOS AS B ON  TB.idBoleto = B.idBoleto
JOIN EVENTOS AS E ON B.IDEVENTO = E.IDEVENTO
where ID=UT.IDUSUARIO;
END //
DELIMITER ;

-- Comando de llamada a la funcion, recibe como parametro el id del cliente a consultar
CALL consultarTransacciones(5);

-- SP para consultar boletos por usuario 
drop procedure  if exists consultarBoletosUsuario;

DELIMITER //
CREATE PROCEDURE consultarBoletosUsuario(IN ID VARCHAR(20))
BEGIN
SELECT B.IDBOLETO as "idBoleto", E.idEvento as "idEvento", E.NOMBRE, B.FILA as "Fila", B.ASIENTO  as "Asiento", E.FECHA as "Fecha", E.CIUDAD as "Ciudad", B.precio as "precio", B.numSerie as "numero de serie"
FROM BOLETOS AS B
INNER JOIN USUARIOS AS U ON B.idUsuario = U.idUsuario
INNER JOIN  EVENTOS AS E ON B.idEvento = E.idEvento
WHERE ID=B.IDUSUARIO;
END //
DELIMITER ;  
-- SE LLAMA AL SP PARA MOSTRAR LOS BOLETOS POR USUARIO, RECIBE COMO PARAMETRO AL USUARIO
CALL consultarBoletosUsuario(1);

-- Consultar y actualizar saldo 
-- CONSULTA
DELIMITER //
CREATE PROCEDURE consultarSaldoUsuario(IN ID VARCHAR(20))
BEGIN
SELECT SALDO
FROM USUARIOS AS U 
WHERE ID=U.IDUSUARIO;
END//
DELIMITER ;

drop procedure if exists ActualizarUsuario;
DELIMITER $$
CREATE PROCEDURE ActualizarUsuario(
    IN p_usuario_id INT,
    
    IN p_nombres VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(50),
    IN p_apellidoMaterno VARCHAR(50),
    IN p_correo VARCHAR(150),
    IN p_contrasena VARCHAR(255),
    IN p_fechaNacimiento DATE,
    
    IN p_calle VARCHAR(100),
    IN p_colonia VARCHAR(100),
    IN p_ciudad VARCHAR(100),
    IN p_estado VARCHAR(50),
    IN p_codigoPostal VARCHAR(5)
)
BEGIN
    DECLARE v_direccion_id INT;
    DECLARE v_correo VARCHAR(100);
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 0 AS resultado;
    END;

    START TRANSACTION;


    SELECT correoElectronico, idDireccion
    INTO v_correo, v_direccion_id 
    FROM Usuarios 
    WHERE idUsuario = p_usuario_id;

    IF v_direccion_id IS NULL THEN
        ROLLBACK;
        SELECT 0 AS resultado;
    ELSE
        IF p_correo <> v_correo THEN
            IF EXISTS (SELECT 1 FROM Usuarios WHERE correoElectronico = p_correo) THEN
                ROLLBACK;
                SELECT 0 AS resultado;
            END IF;
        END IF;

        UPDATE Direcciones
        SET 
            calle = p_calle,
            colonia = p_colonia,
            ciudad = p_ciudad,
            estado = p_estado,
            codigoPostal = p_codigoPostal
        WHERE id = v_direccion_id;

        UPDATE Usuarios
        SET 
            nombres = p_nombres,
            apellidoPaterno = p_apellidoPaterno,
            apellidoMaterno = p_apellidoMaterno,
            correo = p_correo,
            contraseña = p_contrasena,
            fechaNacimiento = p_fechaNacimiento
        WHERE id = p_usuario_id;

        COMMIT;
        SELECT 1 AS resultado;
    END IF;
END $$

DELIMITER ;

-- CREAR LA TRANSACCION REVENTA
DELIMITER //
CREATE PROCEDURE crearTransaccionReventa(
    IN PRECIO DECIMAL(10,2),
    IN PORC DECIMAL(5,2),
    OUT IDTRANSACCION INT
)
BEGIN 
    -- Inserta en la tabla de transacciones
    INSERT INTO TRANSACCIONES (FECHAHORA, TIPOCOMPRA, MONTO)
    VALUES (NOW(), 'Reventa', PRECIO * (PORC / 100));

    --  ID de la transacción recién creada
    SET IDTRANSACCION = LAST_INSERT_ID();
END //
DELIMITER ;


-- Reventa de boletos por parte del usuario 
DELIMITER //
DROP PROCEDURE IF EXISTS revenderBoleto;

CREATE PROCEDURE revenderBoleto(
    IN IDUsuario VARCHAR(20),
    IN precio DECIMAL(10,2),
    IN PORCENTAJE DECIMAL(5,2),
    IN idBoleto VARCHAR(20),
    IN idTransaccion INT(10)
    -- IN FECHA DATE
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
ROLLBACK;
END;
START TRANSACTION;

-- Validación de porcentaje
IF PORCENTAJE > 3 OR PORCENTAJE < 0 THEN
ROLLBACK; -- Revertir si el porcentaje es mayor a 3
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Porcentaje inválido'; -- Mensaje de error
ELSE

-- Actualiza el boleto y su precio
UPDATE BOLETOS
SET DISPONIBLE = TRUE, PRECIO = PRECIO * (PORCENTAJE / 100)
WHERE idBoleto = idBoleto;

-- Insertar en la relación entre usuarios y transacciones
INSERT INTO USUARIOS_TRANSACCIONES (Rol, idUsuario, idTransaccion)
VALUES ('Vendedor', IDUsuario, idTransaccion);

-- Insertar la relación entre transacciones y boletos
INSERT INTO TRANSACCIONESBOLETOS (idTransaccion, idBoleto)
VALUES (idTransaccion, idBoleto);

-- Confirmar transacción
COMMIT;
END IF;
END //
DELIMITER ;
