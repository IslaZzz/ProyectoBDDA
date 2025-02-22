USE ticketWizard;

-- Insertar direcciones
INSERT INTO Direcciones (calle, colonia, ciudad, estado, codigoPostal) VALUES
('Av. Insurgentes Sur', 'Roma Norte', 'Ciudad de México', 'CDMX', '06700'),
('Blvd. Agua Caliente', 'Aviación', 'Tijuana', 'Baja California', '22000'),
('Av. Revolución', 'Centro', 'Guadalajara', 'Jalisco', '44100'),
('Calle 60', 'Centro', 'Mérida', 'Yucatán', '97000'),
('Av. Paseo de la Reforma', 'Juárez', 'Ciudad de México', 'CDMX', '06600');

-- Insertar usuarios
INSERT INTO Usuarios (nombres, apellidoMaterno, apellidoPaterno, correoElectronico, contraseña, fechaNacimiento, saldo, idDireccion) VALUES
('Juan', 'Pérez', 'Gómez', 'juan.perez@gmail.com', 'password123', '1990-05-15', 1500.00, 1),
('María', 'López', 'Hernández', 'maria.lopez@gmail.com', 'password456', '1985-08-22', 2000.00, 2),
('Carlos', 'García', 'Martínez', 'carlos.garcia@gmail.com', 'password789', '1995-02-10', 1000.00, 3),
('Ana', 'Martínez', 'Sánchez', 'ana.martinez@gmail.com', 'password012', '1988-11-30', 2500.00, 4),
('Luis', 'Rodríguez', 'Díaz', 'luis.rodriguez@gmail.com', 'password345', '1992-07-25', 3000.00, 5);

-- Insertar eventos
INSERT INTO Eventos (nombre, fecha, ciudad, Estado, descripcion, recinto) VALUES
('Concierto de Coldplay', '2023-12-15', 'Ciudad de México', 'CDMX', 'Concierto en el Foro Sol.', 'Foro Sol'),
('Festival Cervantino', '2023-10-20', 'Guanajuato', 'Guanajuato', 'Festival cultural en Guanajuato.', 'Teatro Juárez'),
('Lucha Libre AAA', '2023-11-10', 'Guadalajara', 'Jalisco', 'Evento de lucha libre en la Arena VFG.', 'Arena VFG'),
('Feria de León', '2024-01-12', 'León', 'Guanajuato', 'Feria tradicional en León.', 'Poliforum León'),
('Concierto de Bad Bunny', '2023-09-30', 'Monterrey', 'Nuevo León', 'Concierto en el Estadio BBVA.', 'Estadio BBVA');

-- Insertar boletos
INSERT INTO Boletos (idBoleto, idEvento, numSerie, fila, asiento, Disponible, precio, precioOriginal) VALUES
("JAKSJ",1, 'A1B2C3D4', 'A', 1, 1, 500, 500),
("AKLSDK",1, 'E5F6G7H8', 'B', 2, 1,7841,500),
("JAKJDSKSAKD",2, 'I9J0K1L2', 'C', 3, 1,700,500),
("ASDASD",2, 'M3N4O5P6', 'D', 4, 1,612,500),
("ASDASDAS",3, 'Q7R8S9T0', 'E', 5, 1,1024, 1024),
("SDASD",3, 'U1V2W3X4', 'F', 6, 1,976, 976),
("ASDKLSD",4, 'Y5Z6A7B8', 'G', 7, 1,1358, 1358),
("KASLSKDL",4, 'C9D0E1F2', 'H', 8, 1,35813, 35813),
("WKLFLDS",5, 'G3H4I5J6', 'I', 9, 1,500, 500),
("LLSÑDAL",5, 'K7L8M9N0', 'J', 10, 1,500, 500);

-- Insertar transacciones
INSERT INTO Transacciones (fechaHora, TipoCompra, monto) VALUES
('2023-09-01 10:00:00', 'Boletera', 1200.00),
('2023-09-02 11:00:00', 'Reventa', 1500.00),
('2023-09-03 12:00:00', 'Boletera', 800.00),
('2023-09-04 13:00:00', 'Reventa', 2000.00),
('2023-09-05 14:00:00', 'Boletera', 1000.00);

-- Insertar usuarios_transacciones
INSERT INTO Usuarios_Transacciones (rol, idUsuario, idTransaccion) VALUES
('Comprador', 1, 1),
('Vendedor', 2, 1),
('Comprador', 3, 2),
('Vendedor', 4, 2),
('Comprador', 5, 3),
('Vendedor', 1, 3),
('Comprador', 2, 4),
('Vendedor', 3, 4),
('Comprador', 4, 5),
('Vendedor', 5, 5);

-- Insertar transacciones_boletos
INSERT INTO TransaccionesBoletos (idTransaccion, idBoleto) VALUES
(1, "JAKSJ"),
(1, "ASDASDAS"),
(2, "ASDASDAS"),
(2, "ASDASDAS"),
(3, "ASDASDAS"),
(3, "ASDASDAS"),
(4, "ASDASDAS"),
(4, "ASDASDAS"),
(5, "ASDASDAS"),
(5, "ASDASDAS");

drop procedure if exists realizarRegistro;
DELIMITER $$
CREATE PROCEDURE realizarRegistro(
    IN p_nombres VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(50),
    IN p_apellidoMaterno VARCHAR(50),
    IN p_correoElectronico VARCHAR(150),
    IN p_contrasena VARCHAR(255),
    IN p_fechaNacimiento DATE,
    IN p_saldo DECIMAL(10,2),
    IN p_calle VARCHAR(100),
    IN p_colonia VARCHAR(100),
    IN p_ciudad VARCHAR(50),
    IN p_codigoPostal VARCHAR(5),
    IN p_estado VARCHAR(50)
)
BEGIN
    DECLARE existe INT DEFAULT 0;
    DECLARE direccion_id INT;
    
    START TRANSACTION;

    SELECT COUNT(*) INTO existe 
    FROM Usuarios 
    WHERE correoElectronico = p_correoElectronico;
    
    IF existe > 0 THEN
        ROLLBACK;
        SELECT 0 AS resultado;
    ELSE
        INSERT INTO Direcciones (calle, colonia, ciudad, codigoPostal, estado)
        VALUES (p_calle, p_colonia, p_ciudad, p_codigoPostal, p_estado);
        
        SET direccion_id = LAST_INSERT_ID();         

        INSERT INTO Usuarios (
            nombres, 
            apellidoPaterno, 
            apellidoMaterno, 
            correoElectronico, 
            contraseña, 
            fechaNacimiento, 
            saldo, 
            idDireccion
        ) VALUES (
            p_nombres,
            p_apellidoPaterno,
            p_apellidoMaterno,
            p_correoElectronico,
            p_contrasena,
            p_fechaNacimiento,
            p_saldo,
            direccion_id
        );
        
        COMMIT;
        SELECT 1 AS resultado; 
    END IF;
END $$
DELIMITER ;
