##Crear la base de datos
CREATE DATABASE GIMNASIO_OLYMPUS_SQL;
USE GIMNASIO_OLYMPUS_SQL;

##Crear la tabla para los instructores
CREATE TABLE TAB_INSTRUCTORES
(
	ID int auto_increment PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    FechaNac date,
    Cedula VARCHAR(100)
);

##Crear la tabla para los Eventos
CREATE TABLE TAB_EVENTOS
(
	ID INT auto_increment PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    Instructor_id int
);

##Crear la tabla para los miembros
CREATE TABLE TAB_MIEMBRO
(
	ID INT auto_increment PRIMARY KEY,
    Nombre VARCHAR(100),
    FechaNac DATE,
    Cedula VARCHAR(100)
);

##Crear la tabla para los recepcionistas
CREATE TABLE TAB_RECEPCIONISTA
(
	ID INT auto_increment PRIMARY KEY,
    Nombre VARCHAR(100),
    FechaNac DATE,
    Cedula VARCHAR(100)
);

##Crear la tabla para los Clientes
CREATE TABLE TAB_CLIENTES
(
	ID INT auto_increment PRIMARY KEY,
    Nombre VARCHAR(100),
    Primer_Apellido VARCHAR(100),
    Segundo_Apellido VARCHAR(100),
    FechaNac DATE,
    Cedula VARCHAR(100),
    genero ENUM('Masculino', 'Femenino', 'Otro')
);

##Crear la tabla para las sesiones inscritas por los clientes
CREATE TABLE TAB_SESION_INSCRITA
(
    CLIENTE_ID INT,
    EVENTO_ID INT,
    PRIMARY KEY (CLIENTE_ID, EVENTO_ID)
);

##Crear la tabla para las sesiones regulares inscritas por los clientes
CREATE TABLE TAB_SESION_REGULARES_INSCRITAS
(
    CLIENTE_ID INT,
    SESION_REGULAR_ID INT,
    PRIMARY KEY (CLIENTE_ID, SESION_REGULAR_ID)
);

##Crear la tabla para las actividades inscritas por los clientes
CREATE TABLE TAB_ACTIVIDAD_INSCRITA
(
    CLIENTE_ID INT,
    EVENTO_ID INT,
    PRIMARY KEY (CLIENTE_ID, EVENTO_ID)
);

##Crear la tabla para las actividades regulares inscritas por los clientes
CREATE TABLE TAB_ACTIVIDAD_REGULARES_INSCRITAS
(
    CLIENTE_ID INT,
    ACTIVIDAD_REGULAR_ID INT,
    PRIMARY KEY (CLIENTE_ID, ACTIVIDAD_REGULAR_ID)
);
