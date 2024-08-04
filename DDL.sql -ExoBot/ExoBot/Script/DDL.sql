-- database: ../database/ExaBot2k24.sqlite


DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;
DROP TABLE IF EXISTS Enseñar;
DROP TABLE IF EXISTS Armamento;
DROP TABLE IF EXISTS Ensamblar;

CREATE TABLE IABot (
    IdIABot        INTEGER PRIMARY KEY AUTOINCREMENT    
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);

CREATE TABLE Armamento (
    IdArmamento     INTEGER PRIMARY KEY AUTOINCREMENT
    ,Arma           VARCHAR (15) NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);

CREATE TABLE ExaBot (
    IdExaBot       INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdIABot        INTEGER NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,CONSTRAINT     fk_IABot FOREIGN KEY (IdIABot) REFERENCES  IABot(IdIABot)
);

CREATE TABLE Ensamblar (
    IdEnsamblar     INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersona 'Encargado' INTEGER  NOT NULL REFERENCES Persona(IdPersona)
    ,IdExaBot       INTEGER NOT NULL REFERENCES ExaBot(IdExaBot)
    ,IdArmamento    INTEGER NOT NULL REFERENCES Armamento(IdArmamento)
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);

CREATE TABLE PersonaTipo (
    IdPersonaTipo  INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) --current_timestamp
);
CREATE TABLE Persona (
    IdPersona      INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersonaTipo  INTEGER NOT NULL REFERENCES PersonaTipo(IdPersonaTipo)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre         TEXT NOT NULL
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
);

CREATE TABLE Enseñar (
    IdEnseñar       INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,IdExaBot       INTEGER NOT NULL REFERENCES ExaBot(IdExaBot)
    ,FechaCrea      DATETIME DEFAULT (datetime('now', 'localtime')) 
    ,FechaModifica  DATE    
);


