-- database: ../database/EXOBOT.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : pat_mic 
Fecha : 19.feb.2k24
Script: Creacion de la tabla localida + datos
*/
DROP TABLE IF EXISTS Localida;

DROP TABLE IF EXISTS LocalidaEstructura;
CREATE TABLE LocalidaEstructura (
     IdLocalidaEstructura         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidaEstructuraPadre    INTEGER     REFERENCES  LocalidaEstructura (IdLocalidaEstructura)
    ,Nombre                       VARCHAR(10) NOT NULL 
    ,Estado                       VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea                    DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica                DATETIME
); 

INSERT INTO LocalidaEstructura (IdLocalidaEstructuraPadre, Nombre) VALUES 
(NULL,"Pais"),      -- 1 (PK)
(1,"Provincia"),    -- 2    
(2,"Cantón");       -- 3

CREATE TABLE Localida (
     IdLocalida             INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidaPadre        INTEGER     REFERENCES  Localida (IdLocalida)
    ,IdLocalidaEstructura   INTEGER     REFERENCES  LocalidaEstructura (IdLocalidaEstructura)
    ,Nombre                 VARCHAR(20) NOT NULL 
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
); 
--------------------------------------------------------------
INSERT INTO Localida (IdLocalidaPadre, IdLocalidaEstructura, Nombre) VALUES 
(NULL,1,"Euador"),     -- 1  (pk)
(1,2,"Pichincha"),     -- 2
(1,2,"Loja"),          -- 3
(1,2,"Azuay"),         -- 4
(2,3,"Quito"),         -- 
(3,3,"Loja"),          -- 
(4,3,"Cuenca") ;        -- 

SELECT * FROM LocalidaEstructura WHERE Estado = "A";
SELECT * FROM localida WHERE Estado = "A";
SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo
FROM localida               lo 
JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura
WHERE   lo.Estado = "A"
AND     le.Estado = "A";

SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo
FROM localida               lo 
JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura
WHERE   lo.Estado = 'A'
AND     le.Estado = 'A'
AND     upper(le.Nombre) = upper('PROVINCIA');

SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo FROM localida               lo  JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura WHERE   lo.Estado = 'A'  AND     le.Estado = 'A'  AND     upper(le.Nombre) = 'CANT?N'