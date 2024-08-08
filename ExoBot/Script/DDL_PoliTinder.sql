-- database: ../database/POLITINDER.sqlite
/*
copyRyght 2024 ...
....
..
*/

DROP TABLE IF EXISTS Regalo;
DROP TABLE IF EXISTS RegaloTipo;
DROP TABLE IF EXISTS PersonaRol;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaSexo;
DROP TABLE IF EXISTS RelacionTipo;
DROP TABLE IF EXISTS Relacion;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS RegaloEnvio;


-- Catalogo
CREATE TABLE RegaloTipo (
    IdRegaloTipo    INTEGER  PRIMARY KEY AUTOINCREMENT
    ,Nombre         TEXT NOT NULL  UNIQUE
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica  DATETIME 
);
CREATE TABLE PersonaRol (
    IdPersonaRol        INTEGER  PRIMARY KEY AUTOINCREMENT
    ,IdPersonaRol_Padre INTEGER  REFERENCES PersonaRol (IdPersonaRol)
    ,Nombre             TEXT NOT NULL  UNIQUE
    ,Observacion        TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica      DATE 
);
CREATE TABLE PersonaSexo (
    IdPersonaSexo   INTEGER  PRIMARY KEY AUTOINCREMENT
    ,Nombre         TEXT NOT NULL  UNIQUE
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica  DATE 
);
CREATE TABLE Regalo (
    IdRegalo            INTEGER  PRIMARY KEY AUTOINCREMENT
    ,IdRegaloTipo       INTEGER     NOT NULL REFERENCES RegaloTipo (IdRegaloTipo)
    ,Nombre             TEXT        NOT NULL UNIQUE
    ,Precio             REAL
    ,Stock              INT
    ,Observacion        TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica      DATE 
);
CREATE TABLE Persona  (
    IdPersona               INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersonaRol           INTEGER     NOT NULL REFERENCES PersonaRol (IdPersonaRol)
    ,IdPersonaSexo          INTEGER     NOT NULL REFERENCES PersonaSexo (IdPersonaSexo)
    ,Cedula                 TEXT        NOT NULL UNIQUE
    ,Nombre                 TEXT        NOT NULL
    ,Observacion            TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica          DATE
);
CREATE TABLE RelacionTipo (
    IdRelacionTipo      INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             TEXT        NOT NULL  UNIQUE
    ,Observacion        TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica      DATE
);
CREATE TABLE Relacion  (
    IdRelacion              INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdRelacionTipo         INTEGER NOT NULL REFERENCES RelacionTipo (IdRelacionTipo)
    ,IdPersona1             INTEGER NOT NULL REFERENCES Persona      (IdPersona)
    ,IdPersona2             INTEGER NOT NULL REFERENCES Persona      (IdPersona)
    ,FechaInicioRelacion    DATE    NOT NULL
    ,Observacion            TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica          DATE
);

CREATE TABLE Cita (
    IdCita                  INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersona1             INTEGER NOT NULL REFERENCES Persona (IdPersona)
    ,IdPersona2             INTEGER NOT NULL REFERENCES Persona (IdPersona)
    ,Fechacita              DATE    NOT NULL
    ,Observacion            TEXT
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica          DATE
);

CREATE TABLE RegaloEnvio(
    IdRegaloEnvio           INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdRegalo               INTEGER NOT NULL REFERENCES Regalo (IdRegalo)
    ,IdPersonaEnvia         INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,IdPersonaRecibe        INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,Observacion            TEXT
    ,FechaEnvio             DATE NOT NULL
    ,FechaCrea      DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP
    ,FechaModifica          DATE
);