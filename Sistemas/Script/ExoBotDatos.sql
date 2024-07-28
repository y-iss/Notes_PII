-- database: :memory:
INSERT INTO Soldados (id_soldado, nombre, rango, experiencia, id_exobot)
VALUES 
(1, 'Danny Ivanov', 'Capitan', 10, 1),
(2, 'Alex Petrov', 'Teniente', 5, 2);

INSERT INTO Exobots (id_exobot, modelo, energia_actual, estado)
VALUES 
(1, 'Modelo A1', 100, 'Operativo'),
(2, 'Modelo B2', 80, 'Mantenimiento');

INSERT INTO Instructores (id_instructor, nombre, idioma, especialidad)
VALUES 
(1, 'John Smith', 'Ingles', 'Linguistica'),
(2, 'Maria Garcia', 'Español', 'Linguistica');

INSERT INTO Transferencias (id_transferencia, id_instructor, id_exobot, fecha_transferencia, tipo_transferencia)
VALUES 
(1, 1, 1, '2023-07-01', 'Lexico'),
(2, 2, 2, '2023-07-02', 'Fonetica');