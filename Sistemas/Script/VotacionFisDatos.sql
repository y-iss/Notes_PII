-- database: :memory:
INSERT INTO Estudiantes (id_estudiante, nombre, apellido, correo, matricula, facultad)
VALUES 
(1, 'Juan', 'Ramos', 'juan.ramos@epn.edu.ec', '20231001', 'FIS'),
(2, 'Ana', 'Sanchez', 'ana.sanchez@epn.edu.ec', '20231002', 'FIS');

INSERT INTO Candidatas (id_candidata, nombre, apellido, curso)
VALUES 
(1, 'Valeria', 'Calo', 'Tercer Curso'),
(2, 'Laura', 'Lopez', 'Cuarto Curso');

INSERT INTO Votaciones (id_votacion, id_estudiante, id_candidata, fecha_votacion)
VALUES 
(1, 1, 1, '2024-06-17'),
(2, 2, 2, '2024-06-17');