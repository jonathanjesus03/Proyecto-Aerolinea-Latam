-- Crear base de datos y seleccionarla
CREATE DATABASE ProyectoPooAeropuerto;
USE ProyectoPooAeropuerto;

-- ==========================
-- Tabla: Avion
-- ==========================
CREATE TABLE Avion (
    Id_Avion INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Falla VARCHAR(60) NOT NULL,
    Placa CHAR(8) NOT NULL,
    Cantidad_Pasajeros_Maximos INT NOT NULL,
    Estado_Vuelo BIT NOT NULL
);

-- ==========================
-- Tabla: Piloto
-- ==========================
CREATE TABLE Piloto (
    Id_Piloto INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Codigo VARCHAR(50) NOT NULL UNIQUE,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Contacto VARCHAR(50),
    Correo VARCHAR(50),
    Edad INT,
    Documento VARCHAR(25) NOT NULL,
    Rol VARCHAR(50) NOT NULL,
    Jerarquia VARCHAR(50),
    Sueldo DECIMAL(8, 2) NOT NULL
);

-- ==========================
-- Tabla: Azafata
-- ==========================
CREATE TABLE Azafata (
    Id_Azafata INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Codigo VARCHAR(50) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Contacto VARCHAR(50),
    Correo VARCHAR(50),
    Edad INT,
    Jerarquia VARCHAR(50),
    Documento VARCHAR(25) NOT NULL,
    Rol VARCHAR(50) NOT NULL,
    Sueldo DECIMAL(8, 2) NOT NULL
);

-- ==========================
-- Tabla: Tripulacion
-- ==========================
CREATE TABLE Tripulacion (
    Id_Tripulacion INT IDENTITY(1,1) NOT NULL PRIMARY KEY
);

-- ==========================
-- Tabla: Piloto_Tripulacion
-- ==========================
CREATE TABLE Piloto_Tripulacion (
    Id_Piloto INT NOT NULL,
    Id_Tripulacion INT NOT NULL,
    PRIMARY KEY (Id_Piloto, Id_Tripulacion),
    FOREIGN KEY (Id_Piloto) REFERENCES Piloto(Id_Piloto) ON DELETE CASCADE,
    FOREIGN KEY (Id_Tripulacion) REFERENCES Tripulacion(Id_Tripulacion) ON DELETE CASCADE
);

-- ==========================
-- Tabla: Azafata_Tripulacion
-- ==========================
CREATE TABLE Azafata_Tripulacion (
    Id_Azafata INT NOT NULL,
    Id_Tripulacion INT NOT NULL,
    PRIMARY KEY (Id_Azafata, Id_Tripulacion),
    FOREIGN KEY (Id_Azafata) REFERENCES Azafata(Id_Azafata) ON DELETE CASCADE,
    FOREIGN KEY (Id_Tripulacion) REFERENCES Tripulacion(Id_Tripulacion) ON DELETE CASCADE
);

-- ==========================
-- Tabla: Vuelos
-- ==========================
CREATE TABLE Vuelos (
    Id_Vuelo INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Tripulacion INT,
    Id_Avion INT,
    Codigo VARCHAR(20) NOT NULL UNIQUE,
    Destino VARCHAR(50) NOT NULL,
    Origen VARCHAR(50) NOT NULL,
    Estado VARCHAR(50) NOT NULL,
    Fecha DATE NOT NULL,
    Hora_Llegada TIME(7) NOT NULL,
    Hora_Salida TIME(7) NOT NULL,
    Cantidad_Pasajeros INT,
    FOREIGN KEY (Id_Tripulacion) REFERENCES Tripulacion(Id_Tripulacion) ON DELETE SET NULL,
    FOREIGN KEY (Id_Avion) REFERENCES Avion(Id_Avion) ON DELETE SET NULL
);

-- ==========================
-- Tabla: Alimentos
-- ==========================
CREATE TABLE Alimentos (
    Id_Alimentos INT NOT NULL PRIMARY KEY,
    Cod_Vuelo VARCHAR(20) NOT NULL,
    Tipo VARCHAR(50) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    FOREIGN KEY (Cod_Vuelo) REFERENCES Vuelos(Codigo) ON DELETE CASCADE
);

-- ==========================
-- Tabla: Pasaje
-- ==========================
CREATE TABLE Pasaje (
    Id_Pasaje INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Pasajero INT NOT NULL,
    Codigo VARCHAR(10) NOT NULL UNIQUE,
    CodVuelo VARCHAR(50) NOT NULL,
    CodigoAsiento VARCHAR(10)
);

-- ==========================
-- Tabla: Maleta
-- ==========================
CREATE TABLE Maleta (
    Id_Maleta INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Pasajero INT NOT NULL,
    Alto INT NOT NULL,
    Ancho INT NOT NULL,
    Base INT NOT NULL,
    Peso FLOAT NOT NULL
);

-- ==========================
-- Tabla: Pasajero
-- ==========================
CREATE TABLE Pasajero (
    Id_Cliente INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Edad INT,
    Contacto VARCHAR(50),
    Correo VARCHAR(50),
    Documento VARCHAR(50) NOT NULL,
    Discapacidad TEXT DEFAULT 'N/A',
    Chekeado BIT DEFAULT 0,
    Id_Avion INT,
    Id_Vuelo INT,
    Cod_Pasaje VARCHAR(10),
    Id_Maleta INT,
    FOREIGN KEY (Id_Avion) REFERENCES Avion(Id_Avion) ON DELETE SET NULL,
    FOREIGN KEY (Id_Vuelo) REFERENCES Vuelos(Id_Vuelo) ON DELETE SET NULL,
    FOREIGN KEY (Cod_Pasaje) REFERENCES Pasaje(Codigo) ON DELETE SET NULL,
    FOREIGN KEY (Id_Maleta) REFERENCES Maleta(Id_Maleta) ON DELETE SET NULL
);

-- ==========================
-- Triggers para limpiar Pasaje y Maleta al eliminar un Pasajero
-- ==========================
CREATE TRIGGER pa_pasaje
ON Pasajero
AFTER DELETE
AS
BEGIN
    DELETE FROM Pasaje WHERE Id_Pasajero = (SELECT TOP (1) Id_Cliente FROM deleted);
END;

CREATE TRIGGER pa_maleta
ON Pasajero
AFTER DELETE
AS
BEGIN
    DELETE FROM Maleta WHERE Id_Pasajero = (SELECT TOP (1) Id_Cliente FROM deleted);
END;

-- ==========================
-- Tabla: ServicioMascota
-- ==========================
CREATE TABLE ServicioMascota (
    Id_ServicioMascota INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Pasajero INT NOT NULL,
    Descripcion VARCHAR(50),
    FOREIGN KEY (Id_Pasajero) REFERENCES Pasajero(Id_Cliente) ON DELETE CASCADE
);

-- ==========================
-- Tabla: ServicioMascotaCabina
-- ==========================
CREATE TABLE ServicioMascotaCabina (
    Id_ServicioMascotaCabina INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Pasajero INT NOT NULL,
    Descripcion VARCHAR(50),
    FOREIGN KEY (Id_Pasajero) REFERENCES Pasajero(Id_Cliente) ON DELETE CASCADE
);

-- ==========================
-- Tabla: ServicioDiscapacidad
-- ==========================
CREATE TABLE ServicioDiscapacidad (
    Id_ServicioDiscapacidad INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Id_Pasajero INT NOT NULL,
    Tipo VARCHAR(50),
    Descripcion VARCHAR(50),
    FOREIGN KEY (Id_Pasajero) REFERENCES Pasajero(Id_Cliente) ON DELETE CASCADE
);





	
SELECT 
	sm.Id_ServicioMascota,
    'ServicioMascota' AS TipoServicio,
    sm.Descripcion,
	p.Id_Cliente,
    p.Nombre AS NombrePasajero,
    p.Apellido AS ApellidoPasajero,
    v.Id_Vuelo,
    v.Codigo AS CodigoVuelo
FROM 
    ServicioMascota sm
JOIN 
    Pasajero p ON sm.Id_Pasajero = p.Id_Cliente
JOIN 
    Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
WHERE 
    v.Id_Vuelo = 2

UNION ALL

SELECT 
	smc.Id_ServicioMascotaCabina,
    'ServicioMascotaCabina' AS TipoServicio,
    smc.Descripcion,
	p.Id_Cliente,
    p.Nombre AS NombrePasajero,
    p.Apellido AS ApellidoPasajero,
    v.Id_Vuelo,
    v.Codigo AS CodigoVuelo
FROM 
    ServicioMascotaCabina smc
JOIN 
    Pasajero p ON smc.Id_Pasajero = p.Id_Cliente
JOIN 
    Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
WHERE 
    v.Id_Vuelo = 2

UNION ALL

SELECT 
	sd.Id_ServicioDiscapacidad,
    'Servicio_Discapacidad' AS TipoServicio,
	sd.Tipo,
    sd.Descripcion,
	p.Id_Cliente,
    p.Nombre AS NombrePasajero,
    p.Apellido AS ApellidoPasajero,
    v.Id_Vuelo,
    v.Codigo AS CodigoVuelo
FROM 
    ServicioDiscapacidad sd
JOIN 
    Pasajero p ON sd.Id_Pasajero = p.Id_Cliente
JOIN 
    Vuelos v ON p.Id_Vuelo = v.Id_Vuelo
WHERE 
    v.Id_Vuelo = 1;

	DELETE FROM Pasajero WHERE Id_Cliente = 1;



use ProyectoPooAeropuerto
set dateformat dmy
	select * from Piloto
	select * from Azafata
	select * from Tripulacion
select * from Avion
		select * from Vuelos
	select * from Pasajero
select * from Pasaje
select * from Maleta
select * from Alimentos
select * from ServicioMascota
select * from ServicioDiscapacidad
select * from ServicioMascotaCabina
select * from Piloto_Tripulacion
select * from Azafata_Tripulacion
	delete from Piloto_Tripulacion where Id_Piloto = 1
	DELETE FROM ServicioDiscapacidad WHERE Id_Pasajero = 1
	SELECT t.Id_Tripulacion, p.Id_Piloto, a.Id_Azafata FROM Tripulacion t LEFT JOIN Piloto_Tripulacion pt ON t.Id_Tripulacion = pt.Id_Tripulacion 
	LEFT JOIN Piloto p ON pt.Id_Piloto = p.Id_Piloto LEFT JOIN Azafata_Tripulacion at ON t.Id_Tripulacion = at.Id_Tripulacion LEFT JOIN Azafata a ON at.Id_Azafata = a.Id_Azafata 
	WHERE T.Id_Tripulacion = 2
	INSERT INTO Piloto_Tripulacion(Id_Piloto,Id_Tripulacion) VALUES(1,1)
UPDATE Pasajero SET Nombre = 'jonathan', Apellido = 'jesus' ,Edad = 20, Contacto = 99322318, Correo = 'jesusjbjonathan@gmail.com', Documento = '73251587', Discapacidad = 'N/a', Id_Maleta = null , Cod_Pasaje = 'pa001' WHERE Id_Cliente = 1
delete from Pasaje 
delete from Pasajero

ALTER TABLE Piloto_Tripulacion
ADD CONSTRAINT FK_Piloto_Tripulacion_Piloto
FOREIGN KEY (Id_Piloto) REFERENCES Piloto(Id_Piloto)
ON DELETE CASCADE;
DELETE FROM Piloto WHERE Id_Piloto = 1

INSERT INTO Tripulacion DEFAULT VALUES
SELECT * FROM Azafata_Tripulacion
SELECT * FROM Tripulacion

INSERT INTO Piloto_Tripulacion values (1,2)
INSERT INTO Azafata_Tripulacion values (1,2)

ALTER TABLE Tripulacion DROP COLUMN Id_Tripulacion;
ALTER TABLE Tripulacion ADD Id_Tripulacion INT IDENTITY(1,1) NOT NULL PRIMARY KEY;

insert into Pasaje(Id_Pasajero,Codigo,CodVuelo) values(1,33, 'V0001')
SELECT t.Id_Tripulacion, p.Id_Piloto, p.Nombre AS PilotoNombre, p.Apellido AS PilotoApellido, a.Id_Azafata, a.Nombre AS AzafataNombre, a.Apellido AS AzafataApellido 
FROM Tripulacion t LEFT JOIN Piloto_Tripulacion pt ON t.Id_Tripulacion = pt.Id_Tripulacion LEFT JOIN Piloto p ON pt.Id_Piloto = p.Id_Piloto LEFT JOIN Azafata_Tripulacion 
at ON t.Id_Tripulacion = at.Id_Tripulacion LEFT JOIN Azafata a ON at.Id_Azafata = a.Id_Azafata WHERE t.Id_Tripulacion = 5

-- Insertar datos en la tabla Alimentos
INSERT INTO Alimentos (Id_Alimentos, Cod_Vuelo, Tipo, Nombre) VALUES
(1, 'V001', 'Comida', 'Sandwich de Pollo'),
(2, 'V002', 'Bebida', 'Agua Mineral'),
(3, 'V003', 'Postre', 'Tarta de Frutas');

INSERT INTO Azafata (Codigo, Nombre, Apellido, Contacto, Correo, Edad, Jerarquia, Documento, Rol, Sueldo) VALUES
('AZF001', 'Ana', 'Gonzalez', '123456789', 'ana.gonzalez@aero.com', 30, 'Jefa', 'DNI12345678', 'Azafata', 1300.00),
('AZF002', 'Luis', 'Martinez', '987654321', 'luis.martinez@aero.com', 28, 'Asistente', 'DNI87654321', 'Azafata', 1100.00);

INSERT INTO Discapacidad (Id_Discapacidad, Descripcion) VALUES
(1, 'Movilidad Reducida'),
(2, 'Visual'),
(3, 'Auditiva');

-- Insertar datos en la tabla Pasajero
INSERT INTO Pasajero (Nombre, Apellido, Edad, Contacto, Correo, Documento, Discapacidad, Chekeado, Id_Avion, Id_Vuelo, Cod_Pasaje, Id_Maleta) VALUES
('Pedro', 'Ramirez', 45, '555123456', 'pedro.ramirez@example.com', 'DNI123456789', 'N/A', 0, 1, 1, 'P12345', 1),
('Maria', 'Fernandez', 32, '555654321', 'maria.fernandez@example.com', 'DNI987654321', 'Visual', 1, 2, 2, 'M67890', 2);

-- Insertar datos en la tabla Maleta
INSERT INTO Maleta (Id_Pasajero, Alto, Ancho, Base, Peso) VALUES
(1, 60, 40, 30, 15.5),
(2, 55, 35, 25, 12.0);

INSERT INTO Pasaje (Id_Pasajero, Codigo, CodVuelo, CodigoAsiento) VALUES
(1, 'P12345', 'V001', '12A'),
(2, 'M67890', 'V002', '14B');

INSERT INTO Piloto (Codigo, Nombre, Apellido, Contacto, Correo, Edad, Documento, Rol, Jerarquia, Sueldo) VALUES
('P001', 'Juan', 'Pérez', '555789123', 'juan.perez@aero.com', 40, 'DNI12345678', 'Piloto', 'Capitán', 3000.00),
('P002', 'Elena', 'Gómez', '555321987', 'elena.gomez@aero.com', 35, 'DNI87654321', 'Piloto', 'Primer Oficial', 2800.00);

INSERT INTO Vuelos (Id_Tripulacion, Id_Avion, Codigo, Destino, Origen, Estado, Fecha, Hora_Llegada, Hora_Salida, Cantidad_Pasajeros) VALUES
(1, 1, 'V001', 'Lima', 'Cusco', 'En Vuelo', '2024-08-01', '14:00:00', '12:00:00', 140),
(2, 2, 'V002', 'Arequipa', 'Lima', 'Aterrizado', '2024-08-02', '18:00:00', '17:00:00', 175),
(1, 3, 'V003', 'Trujillo', 'Lima', 'En Vuelo', '2024-08-03', '10:30:00', '08:00:00', 100);

INSERT INTO ServicioMascota (Id_Pasajero, Descripcion) VALUES
(1, 'Perro pequeño'),
(2, 'Gato grande');

INSERT INTO ServicioMascotaCabina (Id_Pasajero, Descripcion) VALUES
(1, 'Asiento especial para mascota'),
(2, 'Cuna para gato');

INSERT INTO ServicioDiscapacidad (Id_Pasajero, Tipo, Descripcion) VALUES
(1, 'Movilidad Reducida', 'Silla de ruedas disponible'),
(2, 'Visual', 'Guía para asistencia visual');

INSERT INTO Tripulacion DEFAULT VALUES;

INSERT INTO Piloto_Tripulacion (Id_Piloto, Id_Tripulacion) VALUES
(1, 1),
(2, 1);

INSERT INTO Azafata_Tripulacion (Id_Azafata, Id_Tripulacion) VALUES
(1, 1),
(2, 1);

INSERT INTO Vuelos (Id_Tripulacion, Id_Avion, Codigo, Destino, Origen, Estado, Fecha, Hora_Llegada, Hora_Salida, Cantidad_Pasajeros) VALUES
(1, 1, 'V001', 'Lima', 'Cusco', 'En Vuelo', '2024-08-01', '14:00:00', '12:00:00', 140),
(2, 2, 'V002', 'Arequipa', 'Lima', 'Aterrizado', '2024-08-02', '18:00:00', '17:00:00', 175),
(1, 3, 'V003', 'Trujillo', 'Lima', 'En Vuelo', '2024-08-03', '10:30:00', '08:00:00', 100);

INSERT INTO Avion (Nombre, Falla, Placa, Cantidad_Pasajeros_Maximos, Estado_Vuelo) VALUES
('Boeing 737', 'Ninguna', 'ABC1234', 150, 1),  -- Avión en buen estado y en vuelo
('Airbus A320', 'Problema motor', 'DEF5678', 180, 0),  -- Avión con problema motor y no en vuelo
('Embraer 190', 'Ninguna', 'GHI9101', 100, 1),  -- Avión en buen estado y en vuelo
('Bombardier Q400', 'Revisión programada', 'JKL2345', 90, 0),  -- Avión con revisión programada y no en vuelo
('Cessna 172', 'Ninguna', 'MNO6789', 4, 1);  -- Avión pequeño en buen estado y en vuelo


SELECT * FROM Pasaje