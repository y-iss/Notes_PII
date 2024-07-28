-- database: :memory:
CREATE TABLE Estudiantes (
    id_estudiante INT PRIMARY KEY
    ,nombre VARCHAR(100)
    ,apellido VARCHAR(100)
    ,correo VARCHAR(100)
    ,matricula VARCHAR(50)
    ,facultad VARCHAR(100)
);

CREATE TABLE Candidatas (
    id_candidata INT PRIMARY KEY
    ,nombre VARCHAR(100)
    ,apellido VARCHAR(100)
    ,curso VARCHAR(100)
);

CREATE TABLE Votaciones (
    id_votacion INT PRIMARY KEY
    ,id_estudiante INT
    ,id_candidata INT
    ,fecha_votacion DATE
    ,FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante)
    ,FOREIGN KEY (id_candidata) REFERENCES Candidatas(id_candidata)
);