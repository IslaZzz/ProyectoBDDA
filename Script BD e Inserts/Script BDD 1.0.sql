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

SELECT * FROM usuarios;
