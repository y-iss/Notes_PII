-- database: :memory:
CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY
    ,nombre VARCHAR(100)
    ,apellido VARCHAR(100)
    ,correo VARCHAR(100)
    ,contraseña VARCHAR(100)
    ,fecha_registro DATE
);

CREATE TABLE Cursos (
    id_curso INT PRIMARY KEY
    ,titulo VARCHAR(100)
    ,descripcion TEXT
    ,fecha_creacion DATE
    ,id_instructor INT
    ,FOREIGN KEY (id_instructor) REFERENCES Usuarios(id_usuario)
);

CREATE TABLE Inscripciones (
    id_inscripcion INT PRIMARY KEY
    ,id_usuario INT
    ,id_curso INT
    ,fecha_inscripcion DATE
    ,FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
    ,FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);
