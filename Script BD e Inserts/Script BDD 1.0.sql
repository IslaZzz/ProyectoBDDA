DROP DATABASE IF EXISTS ticketWizard;
CREATE DATABASE ticketWizard;
use ticketWizard;

Drop Table If Exists Direcciones;
Create Table Direcciones (
	idDireccion Int Primary Key AUTO_INCREMENT,
    calle Varchar (100) Not Null,
    colonia Varchar (100) Not Null,
	ciudad Varchar (100) Not Null,
    estado Varchar(50) Not Null,
    codigoPostal varchar(5) Not Null
);

Drop Table If Exists Usuarios;
Create Table Usuarios (
	idUsuario Int Primary Key AUTO_INCREMENT,
	nombres Varchar (50) Not Null,
    apellidoMaterno Varchar(50) Not Null,
    apellidoPaterno Varchar(50) Not Null,
    correoElectronico Varchar(150) Not Null,
    contraseña Varchar(255) Not Null,
    fechaNacimiento Date Not Null,
    saldo double(10,2) Not Null,
    idDireccion int,
    Foreign Key (idDireccion) References Direcciones(idDireccion)
);
  
Drop Table If Exists Transacciones;
Create Table Transacciones (
	idTransaccion Int Primary Key AUTO_INCREMENT,
    fechaHora DateTime Not Null,
    TipoCompra Enum ("Boletera", "Reventa") Not Null,
    monto double(10,2) Not Null
);

Drop Table If Exists Usuarios_Transacciones;
Create Table Usuarios_Transacciones (
	idUsuarioTransaccion Int Primary Key AUTO_INCREMENT,
    rol Enum("Comprador", "Vendedor") Not Null,
    idUsuario Int Not Null,
    idTransaccion Int Not Null,
    Foreign Key (idUsuario) References Usuarios(idUsuario),
    Foreign Key (idTransaccion) References Transacciones(idTransaccion)
);

Drop Table If Exists Eventos;
Create Table Eventos (
	idEvento Int Primary Key AUTO_INCREMENT,
	nombre Varchar (100) Not Null,
    fecha Date Not Null,
    ciudad Varchar (50) Not Null,
    Estado Varchar (50) Not Null,
    descripcion Varchar (800),
    recinto Varchar (100) Not Null
);

Drop Table If Exists Boletos;
Create Table Boletos (
	idBoleto VARCHAR(15) Primary Key,
    idEvento Int Not Null,
    numSerie Varchar (8) Not Null Unique,
    fila Varchar(5) Not Null,
    asiento Int Not Null,
    Disponible Bool Default 0,
    precio decimal(10,2),
    precioOriginal decimal(10,2),
    idUsuario int,
    foreign key (idUsuario) references Usuarios(idUsuario),
    Foreign Key (idEvento) References Eventos(idEvento)
);

Drop Table If Exists TransaccionesBoletos;
Create Table TransaccionesBoletos (
	idTransaccionBoletos Int Primary Key AUTO_INCREMENT,
    idTransaccion Int Not Null,
    idBoleto varchar(15) Not Null,
    Foreign Key (idTransaccion) References Transacciones(idTransaccion),
    Foreign Key (idBoleto) References Boletos(idBoleto)
);

Drop Table If Exists Reservas;
Create table Reservas(
	idUsuario Int not null,
    disponibleHasta TimeStamp Default (Current_TimeStamp + Interval 10 Minute),
    idBoleto varchar(15) primary key,
    Foreign Key (idBoleto) References Boletos(idBoleto)
);


-- create procedure comprarBoletera()
DELIMITER //
CREATE PROCEDURE compraBoletera(
    IN idBoleto VARCHAR(20),
    IN precio DECIMAL(10,2),
    IN serie VARCHAR(10),
    IN IDU INT(20)
)
BEGIN
    -- Iniciar la transacción
    START TRANSACTION;

    -- Actualizar el estado del boleto
    UPDATE BOLETOS
    SET DISPONIBLE = FALSE, numSerie = serie
    WHERE idBoleto = idBoleto;

    -- Actualizar el saldo del usuario
    UPDATE USUARIOS 
    SET SALDO = SALDO - precio
    WHERE IDU = IDU;

    -- Insertar una nueva transacción
    INSERT INTO TRANSACCIONES (FECHAHORA, TIPOCOMPRA, MONTO)
    VALUES (NOW(), 'Boletera', precio);

    -- Obtener el ID de la última transacción
    SET @IDTRANSACCION = LAST_INSERT_ID();

    -- Insertar en la tabla de relaciones usuario-transacción
    INSERT INTO USUARIOS_TRANSACCIONES (ROL, IDUSUARIO, IDTRANSACCION) 
    VALUES ('Comprador', IDU, @IDTRANSACCION);

    -- Insertar en la tabla de transacciones de boletos
    INSERT INTO TRANSACCIONESBOLETOS (IDTRANSACCION, IDBOLETO) 
    VALUES (@IDTRANSACCION, idBoleto);

    -- Confirmar la transacción
    COMMIT;

END //
DELIMITER ;

-- create procedure ventaBoletera()
drop procedure if exists comprarReventa;

DELIMITER //
create procedure comprarReventa(
	IN idBoleto VARCHAR(20),
	IN precio DECIMAL(10,2),
    IN serie VARCHAR(10),
    IN IDU INT(20)
)
BEGIN
 DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Aquí puedes manejar el error, como hacer un ROLLBACK y un mensaje de error
        ROLLBACK;
        SELECT 'Error en la transacción. Los cambios han sido revertidos.' AS error_message;
    END;
start transaction;
-- Insertar una nueva transacción
    INSERT INTO TRANSACCIONES (FECHAHORA, TIPOCOMPRA, MONTO)
    VALUES (NOW(), 'Reventa', precio);

    -- Obtener el ID de la última transacción
    SET @IDTRANSACCION = LAST_INSERT_ID();

    -- Insertar en la tabla de relaciones usuario-transacción
    INSERT INTO USUARIOS_TRANSACCIONES (ROL, IDUSUARIO, IDTRANSACCION) 
    VALUES ('Comprador', IDU, @IDTRANSACCION);

    -- Insertar en la tabla de transacciones de boletos
    INSERT INTO TRANSACCIONESBOLETOS (IDTRANSACCION, IDBOLETO) 
    VALUES (@IDTRANSACCION, idBoleto);
    -- Confirmar la transacción
    COMMIT;
    end //
DELIMITER ;
