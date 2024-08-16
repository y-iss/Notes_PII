-- database: :memory:
-- DDL: Eliminacion y creacion de tablas

DROP TABLE IF EXISTS FAHormiga;
DROP TABLE IF EXISTS FASexo;
DROP TABLE IF EXISTS FAProvincia;
DROP TABLE IF EXISTS FAAlimento;
DROP TABLE IF EXISTS FARegion;
DROP TABLE IF EXISTS FAPais;

CREATE TABLE FAPais (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre VARCHAR(50) NOT NULL UNIQUE,

    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE FARegion (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre VARCHAR(50) NOT NULL UNIQUE

    ,Estado VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE FAProvincia (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre VARCHAR(50) NOT NULL
    ,RegionId INTEGER NOT NULL REFERENCES FARegion(Id)

    ,Estado VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE FAAlimento (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Tipo VARCHAR(50) NOT NULL
    ,Categoria VARCHAR(50) NOT NULL

    ,Estado VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE FASexo (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre VARCHAR(50) NOT NULL UNIQUE

    ,Estado VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

CREATE TABLE FAHormiga (
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga VARCHAR(50) NOT NULL
    ,SexoId INTEGER NOT NULL REFERENCES FASexo(Id)
    ,ProvinciaId INTEGER NOT NULL REFERENCES FAProvincia(Id)
    ,GenoAlimentoId INTEGER NOT NULL REFERENCES FAAlimento(Id)
    ,IngestaNativaId INTEGER NOT NULL REFERENCES FAAlimento(Id)
    ,Estado VARCHAR(50) NOT NULL

    ,EstadoRegistro VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

-- DML: Insercion de datos iniciales

INSERT INTO FAPais (Nombre) VALUES ('Ecuador');

INSERT INTO FARegion (Nombre) VALUES 
('Costa'),
('Sierra'),
('Oriente'),
('Galapagos');

INSERT INTO FAProvincia (Nombre, RegionId) VALUES 
('Guayas', 1),  
('Manabi', 1),  
('Esmeraldas', 1);

INSERT INTO FAAlimento (Tipo, Categoria) VALUES 
('Carnivoro', 'IngestaNativa'),
('Herbivoro', 'IngestaNativa'),
('Omnivoro', 'IngestaNativa'),
('Insectivoros', 'IngestaNativa');

INSERT INTO FAAlimento (Tipo, Categoria) VALUES 
('X', 'GenoAlimento'),
('XX', 'GenoAlimento'),
('XY', 'GenoAlimento');

INSERT INTO FASexo (Nombre) VALUES 
('Macho'),
('Hembra'),
('Asexual');

INSERT INTO FAHormiga (TipoHormiga, SexoId, ProvinciaId, GenoAlimentoId, IngestaNativaId, Estado) VALUES 
('HormigaSoldado', 1, 1, 5, 1, 'Activa'),  
('HormigaReina', 2, 2, 6, 2, 'Inactiva');  

-- SELECT: Consultar los datos insertados en cada tabla

SELECT Id
    ,Nombre
    ,Estado
    ,FechaCreacion
    ,FechaModifica 
FROM FAPais
WHERE Estado = 'A';

SELECT Id 
    ,Nombre 
    ,Estado
    ,FechaCreacion 
    ,FechaModifica 
FROM FARegion
WHERE Estado = 'A';

SELECT Id
    ,Nombre
    ,RegionId
    ,Estado
    ,FechaCreacion
    ,FechaModifica 
FROM FAProvincia
WHERE Estado = 'A';

SELECT Id
    ,Tipo
    ,Categoria
    ,Estado
    ,FechaCreacion
    ,FechaModifica 
FROM FAAlimento
WHERE Estado = 'A';

SELECT Id 
    ,Nombre
    ,Estado
    ,FechaCreacion
    ,FechaModifica 
FROM FASexo
WHERE Estado = 'A';

SELECT Id 
    ,TipoHormiga
    ,SexoId
    ,ProvinciaId
    ,GenoAlimentoId
    ,IngestaNativaId
    ,Estado 
    ,EstadoRegistro
    ,FechaCreacion 
    ,FechaModifica 
FROM FAHormiga
WHERE EstadoRegistro = 'A';
