-- database: ../DataBase/EXOBOT.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : pat_mic 
Fecha : 15.julio.2k24
Script: Creacion de la estructura de datos para Exabot
*/

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS IABot; 

CREATE TABLE CatalogoTipo (
     IdCatalogoTipo INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)  

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 

CREATE TABLE Catalogo (
     IdCatalogo     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo INTEGER     NOT NULL REFERENCES CatalogoTipo (IdCatalogoTipo)
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)   

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 

CREATE TABLE IABot (
     IdIABot        integer primary key autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,FechaCrea      datetime default current_timestamp
);
CREATE TABLE ExaBot (
     IdExaBot       integer primary key autoincrement
    ,IdIABot        integer NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,CONSTRAINT  fk_IABot     FOREIGN KEY (IdIABot)    REFERENCES  IABot(IdIABot)
);

-- CREATE TABLE PersonaTipo (
--      IdPersonaTipo  INTEGER primary key autoincrement
--     ,Descripcion    TEXT NOT NULL UNIQUE
--     ,FechaCrea      datetime default current_timestamp
-- );
CREATE TABLE Persona (
     IdPersona                INTEGER primary key autoincrement
    ,IdCatalogoTipoPersona    INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,IdCatalogoSexo           INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,IdCatalogoEstadoCivil    INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,Cedula                   VARCHAR(10) NOT NULL UNIQUE
    ,Nombre                   VARCHAR(50) NOT NULL 
    ,Apellido                 VARCHAR(50) NOT NULL 
    
    ,Estado                   VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion            DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica            DATETIME
);

