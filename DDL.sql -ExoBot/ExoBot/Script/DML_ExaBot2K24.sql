-- database: ../database/ExaBot2k24.sqlite


INSERT INTO PersonaTipo
(Nombre) VALUES
('Soldado')
,('Mecanico')
,('Experto Ingles')
,('Expero Espanol');
INSERT INTO Persona
(IdPersonaTipo,     Cedula,     Nombre) VALUES
(3, '1738495768', 'Yuki') 
,(4, '1748375846', 'Isa') 
,(1, '1710293847', 'Ale');

INSERT INTO IABot
(Nombre, Observacion) VALUES
('Correr','Potencia la accion de correr')
,('Caminar','Potencia la accion de caminar')
,('Volar','Potencia la accion de volar')
,('Saltar','Potencia la accion de saltar')
,('Disparar','Potencia la accion de disparar')
,('Aprender','Potencia la accion de aprender');

INSERT INTO ExaBot
(IdIABot, Nombre , Serie ) VALUES
('4', 'Evangelion', '1829390')
,('1','Optimus Prime', '9172548')
,('5','Iron High', '9103649')
,('3','Megatron', '1638495');

INSERT INTO Enseñar
(IdPersona, IdExaBot, FechaModifica ) VALUES
('2', '1','2024-07')
,('2', '2','2024-07')
,('3', '3','2024-07')
,('3', '4','2024-07')
,('2', '3','2024-07')
,('2', '4','2024-07')
,('3', '1','2024-07')
,('3', '2','2024-07');

INSERT INTO Armamento
(Arma) VALUES
('Metralleta')
,('Laser');

INSERT INTO Ensamblar
(IdPersona, IdExaBot, IdArmamento ) VALUES
('1', '1', '2')
,('1', '2', '1')
,('1', '2', '2')
,('1', '3', '1')
,('1', '4', '2');

UPDATE  Persona
SET     Nombre      = 'Yuki'
WHERE   IdPersona   = '3';

SELECT tp.Nombre 'Cargo' , p.Nombre 'Nombres'
FROM PersonaTipo tp
JOIN Persona p ON tp.IdPersonaTipo = p.IdPersonaTipo;

SELECT * FROM Persona;
SELECT count(*) 'Nro Tipo Persona' FROM PersonaTipo;
SELECT * FROM PersonaTipo WHERE IdPersonaTipo = 2;
SELECT * FROM PersonaTipo WHERE IdPersonaTipo < 4;
SELECT Nombre FROM PersonaTipo WHERE IdPersonaTipo < 4;
SELECT Nombre FROM PersonaTipo WHERE Nombre like "e%";
SELECT Nombre FROM PersonaTipo WHERE Nombre like "%o";
SELECT Nombre FROM PersonaTipo WHERE Nombre like "%o%";