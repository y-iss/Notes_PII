-- database: ../database/EXOBOT.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : pat_mic 
Fecha : 15.feb.2k24
Script: Creacion de la tabla sexo + datos
*/

DROP TABLE IF EXISTS Sexo;
CREATE TABLE Sexo (
     IdSexo         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 
--------------------------------------------------------------
INSERT INTO SEXO (NOMBRE) VALUES  
 ("Femenino")
,("Masculino")
,("Hibrido");

--UPDATE SEXO SET Nombre = "CAMBIO" WHERE IdSexo =4

SELECT * FROM SEXO;

SELECT  IdSexo, Nombre
FROM    SEXO
WHERE   Estado ='A' AND IdSexo = 2;

SELECT  count(*)
FROM    SEXO
WHERE   Estado ='A';

-- SELECT datetime('now','localtime')

