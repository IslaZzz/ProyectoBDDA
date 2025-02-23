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
SELECT B.IDBOLETO as "idBoleto", E.idEvento as "idEvento", E.NOMBRE, B.FILA as "Fila", B.ASIENTO  as "Asiento", E.FECHA as "Fecha", B.CIUDAD as "Ciudad", B.precio as "precio", B.numSerie as "numero de serie"
FROM BOLETOS AS B
INNER JOIN USUARIO AS U ON B.idUsuario = U.idUsuario
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

CALL consultarSaldoUsuario(1);

-- ACTUALIZAR SALDO 
UPDATE USUARIOS 
SET SALDO=?
 WHERE IDUSUARIO=?;
 
 select *
 from boletos;
 








