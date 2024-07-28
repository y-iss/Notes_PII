-- database: :memory:
INSERT INTO Usuarios (id_usuario, nombre, apellido, correo, contraseña, fecha_registro)
VALUES 
(1, 'Emmanuel', 'Constante', 'ema.constante@gmail.com', 'ema123', '2024-01-12'),
(2, 'Isabel', 'Gomez', 'isa.gomez@gmail.com', 'isa456', '2024-01-16');

INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_creacion, id_instructor)
VALUES 
(1, 'Java Principiante', 'Logica en programacion', '2024-03-10', 1),
(2, 'Curso de Python', 'Aprende Python desde cero', '2024-03-08', 2);

INSERT INTO Inscripciones (id_inscripcion, id_usuario, id_curso, fecha_inscripcion)
VALUES 
(1, 1, 1, '2024-03-10'),
(2, 2, 2, '2024-03-08');