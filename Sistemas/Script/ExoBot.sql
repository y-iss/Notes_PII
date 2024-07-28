-- database: :memory:
CREATE TABLE Soldados (
    id_soldado INT PRIMARY KEY
    ,nombre VARCHAR(100)
    ,rango VARCHAR(50)
    ,experiencia INT
    ,id_exobot INT
    ,FOREIGN KEY (id_exobot) REFERENCES Exobots(id_exobot)
);

CREATE TABLE Exobots (
    id_exobot INT PRIMARY KEY
    ,modelo VARCHAR(100)
    ,energia_actual INT
    ,estado VARCHAR(50)
);

CREATE TABLE Instructores (
    id_instructor INT PRIMARY KEY
    ,nombre VARCHAR(100)
    ,idioma VARCHAR(50)
    ,especialidad VARCHAR(100)
);

CREATE TABLE Transferencias (
    id_transferencia INT PRIMARY KEY
    ,id_instructor INT
    ,id_exobot INT
    ,fecha_transferencia DATE
    ,tipo_transferencia VARCHAR(50)
    ,FOREIGN KEY (id_instructor) REFERENCES Instructores(id_instructor)
    ,FOREIGN KEY (id_exobot) REFERENCES Exobots(id_exobot)
);