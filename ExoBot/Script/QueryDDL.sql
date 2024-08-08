CREATE TABLE Sexo(
    IDSexo          INTEGER  PRIMARY KEY AUTOINCREMENT,
    Descripcion     TEXT NOT NULL,
    Observacion     TEXT,
    FechaCrea       DATE NOT NULL,
    FechaModifica   DATE 
);

CREATE TABLE Raza(
    IDRaza          INTEGER PRIMARY KEY AUTOINCREMENT
    ,Descripcion    TEXT NOT NULL
    ,Observacion    TEXT
    ,FechaCrea      DATE NOT NULL
    ,FechaModifica  DATE 
);


CREATE TABLE Persona(
    IdPersona       INTEGER PRIMARY KEY AUTOINCREMENT
    ,IDSexo         INTEGER REFERENCES Sexo(IDSexo)
    ,Cedula         TEXT NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Apellido       TEXT NOT NULL
    ,Observacion    TEXT
    ,FechaCrea      DATE NOT NULL
    ,FechaModifica  DATE
    
    -- REFERENCES Sexo(IDSexo) 
);

INSERT INTO 
Persona(IDSexo       ,Cedula       ,Nombre       ,Apellido     ,Observacion  ,FechaCrea    ,FechaModifica
) VALUES (1,'0923456789', 'Juan','Perez','Es un buen tipo de persona' ,date('now'),null );


SELECT * FROM Persona;
SELECT * FROM Raza;

INSERT INTO Sexo(
Descripcion,
Observacion,
FechaCrea,
FechaModifica)
VALUES (
"Masculino"
,""
,"06/02/2024"
,NULL);

INSERT INTO Sexo(
Descripcion
,Observacion
,FechaCrea
,FechaModifica)
VALUES (
"Femenino"
,""
,"06/02/2024"
,NULL);

SELECT * FROM Sexo;

DELETE FROM Raza;

INSERT INTO Raza(
Descripcion
,Observacion
,FechaCrea
,FechaModifica)
VALUES(
"Doberman"
,""
,DATE("now")
,NULL);

SELECT * FROM Raza;
