-- database: ../Database/FAEcuaFauna.sqlite
-- DDL: Eliminacion y creacion de tablas

DROP TABLE IF EXISTS FAHormiga;
DROP TABLE IF EXISTS FAIngestaNativa;
DROP TABLE IF EXISTS FAGenoAlimento;
DROP TABLE IF EXISTS FATipoHormiga;
DROP TABLE IF EXISTS FAAlimentoTipo;
DROP TABLE IF EXISTS FALocalidad;
DROP TABLE IF EXISTS FACatalogo;
DROP TABLE IF EXISTS FACatalogoTipo;

-- Se crean las tablas necesarias
CREATE TABLE FACatalogoTipo(
    IdCatalogoTipo INTEGER PRIMARY KEY AUTOINCREMENT,     
    Nombre         VARCHAR(50) NOT NULL,
    Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea      DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica  DATETIME 
);

CREATE TABLE FACatalogo(
    IdCatalogo     INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo INTEGER REFERENCES FACatalogoTipo(IdCatalogoTipo),
    Nombre         VARCHAR(50) NOT NULL,
    Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea      DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica  DATETIME 
);

CREATE TABLE FALocalidad(
    IdLocalidad       INTEGER PRIMARY KEY AUTOINCREMENT,
    IdLocalidadPadre  INTEGER REFERENCES FALocalidad(IdLocalidad), 
    IdCatalogo        INTEGER REFERENCES FACatalogo(IdCatalogo),
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE FAIngestaNativa(
    IdIngestaNativa   INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE FAGenoAlimento(
    IdGenoAlimento    INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE FATipoHormiga(
    IdTipoHormiga     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre            VARCHAR(50) NOT NULL,
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

CREATE TABLE FAHormiga(
    IdHormiga         INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga       INTEGER REFERENCES FATipoHormiga(IdTipoHormiga),
    Sexo              INTEGER REFERENCES FACatalogo(IdCatalogo),
    Provincia         INTEGER REFERENCES FALocalidad(IdLocalidad),
    GenoAlimento      INTEGER REFERENCES FAGenoAlimento(IdGenoAlimento),
    IngestaNativa     INTEGER REFERENCES FAIngestaNativa(IdIngestaNativa),
    Estado            VARCHAR(1) DEFAULT('A') CHECK (Estado IN ('A','X')),
    FechaCrea         DATETIME DEFAULT (DATETIME('now', 'localtime')),
    FechaModifica     DATETIME 
);

-- Insertando datos iniciales
INSERT INTO FACatalogoTipo(Nombre) VALUES
-- Catalogos
('Localidad'),          -- idCatalogoTipo1
('Sexo');               -- idCatalogoTipo2 

INSERT INTO FACatalogo(IdCatalogoTipo, Nombre) VALUES
-- Catalogos
(1, 'Pais'),            
(1, 'Region'),         
(1, 'Provincia'),       
(2, 'Macho'),           
(2, 'Hembra'),          
(2, 'Asexual');         

INSERT INTO FALocalidad(IdLocalidadPadre, IdCatalogo, Nombre) VALUES
(NULL, 1, 'Ecuador'),
(1, 2, 'Sierra'),
(1, 2, 'Oriente'),
(1, 2, 'Costa'),
(1, 2, 'Insular'),
(2, 2, 'Carchi'),
(2, 2, 'Imbabura'),
(2, 2, 'Pichincha'),
(2, 2, 'Cotopaxi'),
(2, 2, 'Tunguragua'),
(2, 2, 'Bolivar'),
(2, 2, 'Chimborazo'),
(2, 2, 'Cañar'),
(2, 2, 'Azuay'),
(2, 2, 'Loja'),
(3, 2, 'Sucumbios'),
(3, 2, 'Napo'),
(3, 2, 'Orellana'),
(3, 2, 'Pastaza'),
(3, 2, 'Morona Santiago'),
(3, 2, 'Zamora Chinchipe'),
(4, 2, 'Esmeraldas'),
(4, 2, 'Santo Domingo de los Tsachilas'),
(4, 2, 'Manabi'),
(4, 2, 'Los Rios'),
(4, 2, 'Guayas'),
(4, 2, 'Santa Elena'),
(4, 2, 'El Oro'),
(5, 2, 'Galapagos');

INSERT INTO FAIngestaNativa(Nombre) VALUES
('Carnivoro'),
('Herbivoro'),
('Omnivoro'),
('Insectivoro');

INSERT INTO FAGenoAlimento(Nombre) VALUES
('X'),
('XX'),
('XY');

INSERT INTO FATipoHormiga(Nombre) VALUES
('Hormiga Larva'),
('Hormiga Soldado'),
('Hormiga Rastrera'),
('Hormiga Reina'),
('Hormiga Bala'),
('Hormiga de Fuego'),
('Hormiga Guerrera'),
('Hormiga Cortadora de hojas'),
('Hormiga Carpintera'),
('Hormiga Faraona'),
('Hormiga Casera olorosa'),
('Hormiga del Pavimento');

INSERT INTO FAHormiga(TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa) VALUES
(2, 4, 17, 1, 1);

-- Select queries to verify the data
SELECT 
    IdCatalogoTipo AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FACatalogoTipo
WHERE Estado = 'A';

SELECT 
    IdCatalogo AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FACatalogo
WHERE Estado = 'A';

SELECT 
    IdLocalidad AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FALocalidad
WHERE Estado = 'A';

SELECT 
    IdIngestaNativa AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FAIngestaNativa
WHERE Estado = 'A';

SELECT 
    IdGenoAlimento AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FAGenoAlimento
WHERE Estado = 'A';

SELECT 
    IdTipoHormiga AS Id,
    Nombre,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FATipoHormiga
WHERE Estado = 'A';

SELECT 
    IdHormiga AS Id,
    TipoHormiga,
    Sexo,
    Provincia,
    GenoAlimento,
    IngestaNativa,
    Estado,
    FechaCrea AS FechaCreacion,
    FechaModifica 
FROM FAHormiga
WHERE Estado = 'A';
