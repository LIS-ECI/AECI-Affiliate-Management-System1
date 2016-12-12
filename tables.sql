-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-12-12 01:32:39.752

-- tables
-- Table: Certificado
CREATE TABLE Certificado (
    id int NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    valido varchar(5) NOT NULL,
)ENGINE = InnoDB;

-- Table: Datos_Egresado
CREATE TABLE Datos_Egresado (
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
    nombre varchar(100) NOT NULL,
    anio_grado int NOT NULL,
    periodo_grado int NOT NULL,
    cargo varchar(100) NOT NULL,
    direccion_vivienda varchar(100) NOT NULL,
    nombreEmpresa varchar(100) NOT NULL,
    direccion_empresa varchar(100) NOT NULL,
    telefono_oficina int NOT NULL,
    telefono_fijo int NOT NULL,
    celular bigint NOT NULL,
    Programas_nombre varchar(100) NOT NULL,
    genero varchar(15) NOT NULL,
    apellido varchar(100) NOT NULL,
)ENGINE = InnoDB;

-- Table: Datos_Empresas
CREATE TABLE Datos_Empresas (
    Nombre varchar(100) NOT NULL,
    direcciom varchar(100) NOT NULL,
    telefono varchar(100) NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
)ENGINE = InnoDB;

-- Table: Datos_Estudiante
CREATE TABLE Datos_Estudiante (
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
    codigo_estudiante int NOT NULL,
    nombre varchar(100) NOT NULL,
    semestre_ponderado int NOT NULL,
    telefono_fijo int NOT NULL,
    celular bigint NOT NULL,
    direccion_vivienda varchar(100) NOT NULL,
    Programas_nombre varchar(100) NOT NULL,
    genero varchar(15) NOT NULL,
    apellido varchar(100) NOT NULL,
    IMAGENES_name varchar(50) NOT NULL,
)ENGINE = InnoDB;

-- Table: IMAGENES
CREATE TABLE IMAGENES (
    name varchar(50) NOT NULL,
    imagen blob NOT NULL,
)ENGINE = InnoDB;

-- Table: Identificacion
CREATE TABLE Identificacion (
    Numero bigint NOT NULL,
    Tipo varchar(2) NOT NULL,
)ENGINE = InnoDB;

-- Table: Pagos
CREATE TABLE Pagos (
    numeroFactura varchar(100) NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    Tipo varchar(100) NOT NULL,
    validacion varchar(5) NOT NULL,
    fechaRegistro date NOT NULL,
    tipoTramite varchar(20) NOT NULL,
    IMAGENES_name varchar(50) NOT NULL,
)ENGINE = InnoDB;

-- Table: Programas
CREATE TABLE Programas (
    nombre varchar(100) NOT NULL,
)ENGINE = InnoDB;

-- Table: Solicitud
CREATE TABLE Solicitud (
    fecha date NOT NULL,
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
    tipo varchar(20) NOT NULL,
    aprobado varchar(5) NOT NULL,
)ENGINE = InnoDB;

-- Table: Usos_Convenios
CREATE TABLE Usos_Convenios (
    Usuario_nombre varchar(20) NOT NULL,
    TdeServicio varchar(100) NOT NULL,
    Fecha date NOT NULL,
)ENGINE = InnoDB;

-- Table: Usuario
CREATE TABLE Usuario (
    nombre varchar(20) NOT NULL,
    clave varchar(100) NOT NULL,
    tipo varchar(15) NOT NULL,
    estado varchar(10) NOT NULL,
    identificacion bigint NOT NULL,
    tipo_identificacion varchar(2) NOT NULL,
    fechaInicio date NOT NULL,
    fechafin date NOT NULL,
)ENGINE = InnoDB;

-- Table: correo
CREATE TABLE correo (
    correo varchar(100) NOT NULL,
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
)ENGINE = InnoDB;

-- Table: observacion
CREATE TABLE observacion (
    numero_observacion int NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    comentario varchar(1000) NOT NULL,
)ENGINE = InnoDB;

insert into Programas(nombre) values('Ingenieria Civil');
insert into Programas(nombre) values('Ingenieria Electronica');
insert into Programas(nombre) values('Ingenieria Electrica');
insert into Programas(nombre) values('Ingenieria De Sistemas');
insert into Programas(nombre) values('Ingenieria Industrial');
insert into Programas(nombre) values('Matematicas');
insert into Programas(nombre) values('Administracion De Empresas');
insert into Programas(nombre) values('Ingenieria Mecanica');
insert into Programas(nombre) values('Ingenieria Ambiental');
insert into Programas(nombre) values('Ingenieria Biomedica');