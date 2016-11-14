-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-11-10 16:18:27.083

-- tables
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
    CONSTRAINT Datos_Egresado_pk PRIMARY KEY (Cedula_Numero,Cedula_Tipo)
)ENGINE = InnoDB;

-- Table: Datos_Empresas
CREATE TABLE Datos_Empresas (
    Nombre varchar(100) NOT NULL,
    direcciom varchar(100) NOT NULL,
    telefono varchar(100) NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    CONSTRAINT Datos_Empresas_pk PRIMARY KEY (Nombre)
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
    CONSTRAINT Datos_Estudiante_pk PRIMARY KEY (Cedula_Numero,Cedula_Tipo)
)ENGINE = InnoDB;

-- Table: Identificacion
CREATE TABLE Identificacion (
    Numero bigint NOT NULL,
    Tipo varchar(2) NOT NULL,
    CONSTRAINT Identificacion_pk PRIMARY KEY (Numero,Tipo)
)ENGINE = InnoDB;

-- Table: Pagos
CREATE TABLE Pagos (
    id_pago int NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    Tipo varchar(100) NOT NULL,
    foto blob NOT NULL,
    validacion varchar(5) NOT NULL,
    CONSTRAINT Pagos_pk PRIMARY KEY (id_pago)
)ENGINE = InnoDB;

-- Table: Programas
CREATE TABLE Programas (
    nombre varchar(100) NOT NULL,
    CONSTRAINT Programas_pk PRIMARY KEY (nombre)
)ENGINE = InnoDB;

-- Table: Solicitud
CREATE TABLE Solicitud (
    fecha date NOT NULL,
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
    tipo varchar(20) NOT NULL,
    aprobado varchar(5) NOT NULL,
    CONSTRAINT Solicitud_pk PRIMARY KEY (fecha,Cedula_Numero,Cedula_Tipo)
)ENGINE = InnoDB;

-- Table: Usos_Convenios
CREATE TABLE Usos_Convenios (
    Usuario_nombre varchar(20) NOT NULL,
    TdeServicio varchar(100) NOT NULL,
    Fecha date NOT NULL,
    CONSTRAINT Usos_Convenios_pk PRIMARY KEY (Usuario_nombre,TdeServicio,Fecha)
)ENGINE = InnoDB;

-- Table: Usuario
CREATE TABLE Usuario (
    nombre varchar(20) NOT NULL,
    clave varchar(25) NOT NULL,
    tipo varchar(15) NOT NULL,
    estado varchar(10) NOT NULL,
    identificacion bigint NOT NULL,
    tipo_identificacion varchar(2) NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (nombre)
)ENGINE = InnoDB;

-- Table: correo
CREATE TABLE correo (
    correo varchar(100) NOT NULL,
    Cedula_Numero bigint NOT NULL,
    Cedula_Tipo varchar(2) NOT NULL,
    CONSTRAINT correo_pk PRIMARY KEY (correo)
)ENGINE = InnoDB;

-- Table: observacion
CREATE TABLE observacion (
    numero_observacion int NOT NULL,
    Usuario_nombre varchar(20) NOT NULL,
    comentario varchar(1000) NOT NULL,
    CONSTRAINT observacion_pk PRIMARY KEY (numero_observacion)
)ENGINE = InnoDB;

-- foreign keys
-- Reference: Beneficios_Usuario (table: Usos_Convenios)
ALTER TABLE Usos_Convenios ADD CONSTRAINT Beneficios_Usuario FOREIGN KEY(Usuario_nombre)
    REFERENCES Usuario(nombre);

-- Reference: Datos_Egresado_Cedula (table: Datos_Egresado)
ALTER TABLE Datos_Egresado ADD CONSTRAINT Datos_Egresado_Cedula FOREIGN KEY(Cedula_Numero,Cedula_Tipo) 
REFERENCES Identificacion(Numero,Tipo);

-- Reference: Datos_Egresado_Programas (table: Datos_Egresado)
ALTER TABLE Datos_Egresado ADD CONSTRAINT Datos_Egresado_Programas FOREIGN KEY(Programas_nombre)
    REFERENCES Programas(nombre);

-- Reference: Datos_Empresas_Usuario (table: Datos_Empresas)
ALTER TABLE Datos_Empresas ADD CONSTRAINT Datos_Empresas_Usuario FOREIGN KEY(Usuario_nombre)
    REFERENCES Usuario(nombre);

-- Reference: Datos_Estudiante_Cedula (table: Datos_Estudiante)
ALTER TABLE Datos_Estudiante ADD CONSTRAINT Datos_Estudiante_Cedula FOREIGN KEY(Cedula_Numero,Cedula_Tipo)
    REFERENCES Identificacion(Numero,Tipo);


-- Reference: Datos_Estudiante_Programas (table: Datos_Estudiante)
ALTER TABLE Datos_Estudiante ADD CONSTRAINT Datos_Estudiante_Programas FOREIGN KEY(Programas_nombre)
    REFERENCES Programas(nombre);

-- Reference: Pagos_Usuario (table: Pagos)
ALTER TABLE Pagos ADD CONSTRAINT Pagos_Usuario FOREIGN KEY(Usuario_nombre)
    REFERENCES Usuario(nombre);

-- Reference: Solicitud_Cedula (table: Solicitud)
ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Cedula FOREIGN KEY(Cedula_Numero)
    REFERENCES Identificacion(Numero);
	
ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Cedula2 FOREIGN KEY(Cedula_Tipo)
    REFERENCES Identificacion(Tipo);

-- Reference: Table_9_Usuario (table: observacion)
ALTER TABLE observacion ADD CONSTRAINT Table_9_Usuario FOREIGN KEY(Usuario_nombre)
    REFERENCES Usuario(nombre);

-- Reference: Usuario_Cedula (table: Usuario)
ALTER TABLE Usuario ADD CONSTRAINT Usuario_Cedula FOREIGN KEY (identificacion,tipo_identificacion)
    REFERENCES Identificacion(Numero,Tipo);


-- Reference: correo_Cedula (table: correo)
ALTER TABLE correo ADD CONSTRAINT correo_Cedula FOREIGN KEY(Cedula_Numero,Cedula_Tipo)
    REFERENCES Identificacion(Numero,Tipo);
	

-- Insertar Programas Determinados.


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