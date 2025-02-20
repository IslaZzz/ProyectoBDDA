DROP DATABASE IF EXISTS ticketWizard;
CREATE DATABASE ticketWizard;
use ticketWizard;

Drop Table If Exists Direcciones;
Create Table Direcciones (
	idDireccion Int Primary Key AUTO_INCREMENT,
    calle Varchar (100) Not Null,
    colonia Varchar (100) Not Null,
	ciudad Varchar (100) Not Null,
    estado Varchar(100) Not Null,
    codigoPostal varchar(5) Not Null
);

Drop Table If Exists Usuarios;
Create Table Usuarios (
	idUsuario Int Primary Key AUTO_INCREMENT,
	nombre Varchar (50) Not Null,
    apellidoMaterno Varchar(50) Not Null,
    apellidoPaterno Varchar(50) Not Null,
    correoElectronico Varchar(150) Not Null,
    contraseña Varchar(100) Not Null,
    fechaNacimiento Date Not Null,
    saldo double(10,2) Not Null,
    idDireccion int Not Null,
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
	idBoleto Int Primary Key AUTO_INCREMENT,
    idEvento Int Not Null,
    numSerie Varchar (8) Not Null,
    fila Varchar(5) Not Null,
    asiento Int Not Null,
    Disponible Bool Default 0,
    precio decimal(10,2), 
    Foreign Key (idEvento) References Eventos(idEvento)
);

Drop Table If Exists TransaccionesBoletos;
Create Table TransaccionesBoletos (
	idTransaccionBoletos Int Primary Key AUTO_INCREMENT,
    idTransaccion Int Not Null,
    idBoleto Int Not Null,
    Foreign Key (idTransaccion) References Transacciones(idTransaccion),
    Foreign Key (idBoleto) References Boletos(idBoleto)
);


