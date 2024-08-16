--database: ../DataBase/FAEcuaFauna.sqlite

/* Eliminación de tablas si existen */
DROP TABLE IF EXISTS FAHormigaAlimento;
DROP TABLE IF EXISTS FAHormiga;
DROP TABLE IF EXISTS FAAlimento;
DROP TABLE IF EXISTS FAGenoAlimento;
DROP TABLE IF EXISTS FAIngestaNativa;
DROP TABLE IF EXISTS FAEstado;
DROP TABLE IF EXISTS FASexo;
DROP TABLE IF EXISTS FATipoHormiga;
DROP TABLE IF EXISTS FAProvincia;
DROP TABLE IF EXISTS FAPais;
DROP TABLE IF EXISTS FARegion;

/* Creación de tablas */
CREATE TABLE FARegion (
        CodigoRegion      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreRegion      VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAPais (
        CodigoPais        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombrePais        VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAProvincia (
        CodigoProvincia   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreProvincia   VARCHAR(30) NOT NULL UNIQUE,
        CodigoPais        INTEGER     NOT NULL,
        CodigoRegion      INTEGER     NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FATipoHormiga (
        CodigoTipoHormiga INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreTipoHormiga VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FASexo (
        CodigoSexo        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreSexo        VARCHAR(15) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAEstado (
        CodigoEstado      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreEstado      VARCHAR(20) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAIngestaNativa (
        CodigoIngestaNativa INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreIngestaNativa VARCHAR(20) NOT NULL UNIQUE,
        Estado              VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea           DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica       DATETIME
);

CREATE TABLE FAGenoAlimento (
        CodigoGenoAlimento INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreGenoAlimento VARCHAR(20) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAAlimento (
        CodigoAlimento     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreAlimento     VARCHAR(20) NOT NULL UNIQUE,
        CodigoIngestaNativa INTEGER    NOT NULL,
        CodigoGenoAlimento INTEGER     NOT NULL,
        DescripcionAlimento VARCHAR(500) NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE FAHormigaAlimento (
        CodigoHormigaAlimento INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
        CodigoHormiga        INTEGER   NOT NULL,
        CodigoAlimento       INTEGER   NOT NULL,
        Estado              VARCHAR(1) NOT NULL DEFAULT 'A',
        FechaCrea           DATETIME   DEFAULT(datetime('now','localtime')),
        FechaModifica       DATETIME
);

CREATE TABLE FAHormiga (
        CodigoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreHormiga      VARCHAR(30) NOT NULL UNIQUE,
        CodigoSexo         INTEGER     NOT NULL,
        CodigoTipoHormiga  INTEGER     NOT NULL,
        CodigoEstado       INTEGER     NOT NULL,
        CodigoProvincia    INTEGER     NOT NULL,
        CodigoAlimento     INTEGER     NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

/* Inserción de datos */
INSERT INTO FARegion 
( NombreRegion   ) VALUES 
( "Costa"        ),
( "Sierra"       ),
( "Oriente"      ),
( "Galapagos"    );

INSERT INTO FAPais 
( NombrePais     ) VALUES 
( "Ecuador"      );

INSERT INTO FAProvincia 
( NombreProvincia                   , CodigoPais , CodigoRegion ) VALUES 
( "El Oro"                          , 1          , 1            ),
( "Esmeraldas"                      , 1          , 1            ),
( "Guayas"                          , 1          , 1            ),
( "Los Rios"                        , 1          , 1            ),
( "Manabí"                          , 1          , 1            ),
( "Santa Elena"                     , 1          , 1            ),
( "Santo Domingo de los Tsachilas"  , 1          , 1            ),
( "Azuay"                           , 1          , 2            ),
( "Bolivar"                         , 1          , 2            ),
( "Cañar"                           , 1          , 2            ),
( "Carchi"                          , 1          , 2            ),
( "Chimborazo"                      , 1          , 2            ),
( "Cotopaxi"                        , 1          , 2            ),
( "Imbabura"                        , 1          , 2            ),
( "Loja"                            , 1          , 2            ),
( "Pichincha"                       , 1          , 2            ),
( "Tungurahua"                      , 1          , 2            ),
( "Morona Santiago"                 , 1          , 3            ),
( "Napo"                            , 1          , 3            ),
( "Orellana"                        , 1          , 3            ),
( "Pastaza"                         , 1          , 3            ),
( "Sucumbios"                       , 1          , 3            ),
( "Zamora Chinchipe"                , 1          , 3            ),
( "Galapagos"                       , 1          , 4            );

INSERT INTO FATipoHormiga 
( NombreTipoHormiga ) VALUES 
( "Larva"           ),
( "Soldado"         ),
( "Rastrera"        ),
( "Reina"           );

INSERT INTO FASexo 
( NombreSexo       ) VALUES 
( "Macho"          ),
( "Hembra"         ),
( "Asexual"        );

INSERT INTO FAEstado 
( NombreEstado     ) VALUES 
( "Huevo"          ),
( "Larva"          ),
( "Pupa"           ),
( "Adulta"         );

INSERT INTO FAIngestaNativa 
( NombreIngestaNativa  ) VALUES 
( "Carnivoro"          ),
( "Herbivoro"          ),
( "Omnivoro"           ),
( "Insectivoro"        );

INSERT INTO FAGenoAlimento 
( NombreGenoAlimento   ) VALUES 
( "X"                  ),
( "XX"                 ),
( "XY"                 );

/* Consultas SELECT para verificar datos */
SELECT * FROM FARegion;
SELECT * FROM FAPais;
SELECT * FROM FAProvincia;
SELECT * FROM FATipoHormiga;
SELECT * FROM FASexo;
SELECT * FROM FAEstado;
SELECT * FROM FAIngestaNativa;
SELECT * FROM FAGenoAlimento;
SELECT * FROM FAAlimento;
SELECT * FROM FAHormigaAlimento;
SELECT * FROM FAHormiga;



