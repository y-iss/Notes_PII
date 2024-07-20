-- database: ../database/ExaBot2k24.sqlite
/*
CopyRight
autor:
fecha:
*/
 
DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;
 
CREATE TABLE IABot (
     IdIABot        INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
);
CREATE TABLE ExaBot (
     IdExaBot       INTEGER PRIMARY KEY autoincrement
    ,IdIABot        INTEGER NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
    ,CONSTRAINT     fk_IABot FOREIGN KEY (IdIABot) REFERENCES  IABot(IdIABot)
);
CREATE TABLE PersonaTipo (
     IdPersonaTipo  INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
);
CREATE TABLE Persona (
     IdPersona      INTEGER PRIMARY KEY autoincrement
    ,IdPersonaTipo  INTEGER NOT NULL REFERENCES PersonaTipo(IdPersonaTipo)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre         TEXT NOT NULL
    ,FechaCrea      datetime default current_timestamp
);