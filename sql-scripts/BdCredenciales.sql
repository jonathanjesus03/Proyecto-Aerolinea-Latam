-- Crear la base de datos (si no existe)
CREATE DATABASE PooCredenciales;

-- Usar la base de datos
USE PooCredenciales;

-- Crear la tabla 'dbo.credenciales'
CREATE TABLE dbo.credenciales (
    Users VARCHAR(20) NOT NULL,
    Passwords VARCHAR(20) NOT NULL,
    CONSTRAINT PK_credenciales PRIMARY KEY (Users, Passwords)
);

INSERT INTO dbo.credenciales (Users, Passwords)
VALUES 
    ('12345', '12345'),
    ('admin', 'admin'),
    ('Jonathan', 'Jesus'),
    ('Latam', 'Airlines'),
    ('root', 'root');
select * from credenciales