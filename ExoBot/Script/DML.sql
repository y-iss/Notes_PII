-- database: ../database/EXOBOT.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : pat_mic 
Fecha : 15.julio.2k24
Script: Insertando catalogo
*/

INSERT INTO CatalogoTipo
 ( Nombre,               Descripcion )  VALUES
 ( 'Tipo Persona'       ,'tipos sol, meca,...')
,( 'Sexo'               ,'mas, feme,...')
,( 'Estado Civil'       ,'sol, viu, cad,...')
,( 'Raza'               ,'Negro, blanco...');

INSERT INTO Catalogo
 ( IdCatalogoTipo ,Nombre         ,Descripcion   ) VALUES

 (  1             ,'Soldado'      ,'tipos de perso del ejercito')  -- 1
,(  1             ,'Mecanico'     ,'tipos de perso del ejercito')  -- 2
,(  1             ,'Experto Ing.' ,'tipos de perso del ejercito')  -- 3
,(  1             ,'Experto Esp.' ,'tipos de perso del ejercito')  -- 4

,(  2            ,'Masculino'   ,'tipos de sexualida')             -- 5
,(  2            ,'Femenino'    ,'tipos de sexualida')             -- 6
,(  2            ,'Hibrido'     ,'tipos de sexualida')             -- 7
,(  2            ,'Asexual'     ,'tipos de sexualida')             -- 8

,(  3            ,'Soltero'     ,'tipos de estado civil Ecu.')       -- 9
,(  3            ,'Casado'      ,'tipos de estado civil Ecu.')       -- 10
,(  3            ,'Divorsiado'  ,'tipos de estado civil Ecu.')       -- 11
,(  3            ,'Viudo'       ,'tipos de estado civil Ecu.')       -- 12

,(  4            ,'Negro'       ,'tipos de raza')
,(  4            ,'Blaco'       ,'tipos de raza')
,(  4            ,'Mestizo'     ,'tipos de raza')
,(  4            ,'Indigena'    ,'tipos de raza');

insert INTO IABot ( Nombre   ,Observacion ) 
            VALUES("IA-RUSO" ,"Inteligencia artificial" );

INSERT INTO ExaBot
  ( IdIABot      ,Nombre    ,Serie     ) VALUES
  ( 1            ,"exabot1","Sereie E1")
 ,( 1            ,"exabot2","Sereie E2");  


INSERT INTO Persona  
 ( IdCatalogoTipoPersona ,IdCatalogoSexo ,IdCatalogoEstadoCivil   ,Cedula ,Nombre   ,Apellido) VALUES
 ( 1                     , 5             , 9                      ,"11111", "pepe"  ,"putin" )
,( 2                     , 5             , 10                     ,"22222", "juan"  ,"putin" )
,( 3                     , 5             , 11                     ,"33333", "pedro" ,"putin" )
,( 4                     , 5             , 12                     ,"44444", "pablo" ,"putin" )
,( 1                     , 6             , 9                      ,"01010", "ana"   ,"putin" )
,( 2                     , 6             , 10                     ,"02020", "pepa"  ,"putin" )
,( 3                     , 6             , 11                     ,"03030", "Gelen" ,"putin" )
,( 4                     , 6             , 12                     ,"04040", "Cami"  ,"putin" );



SELECT IdCatalogo   
,IdCatalogoTipo     
,Nombre             
,Descripcion        
,Estado             
,FechaCreacion      
,FechaModifica      
FROM    Catalogo    
WHERE   Estado ='A' 
AND   IdCatalogoTipo = 2 ;

SELECT COUNT(*) TotalReg 
FROM    Catalogo         
WHERE   Estado ='A'      
AND     IdCatalogoTipo = 2;


SELECT IdCatalogo    ,IdCatalogoTipo      ,Nombre              ,Descripcion         ,Estado              ,FechaCreacion       ,FechaModifica       
FROM    Catalogo     
WHERE   Estado ='A'  
AND     IdCatalogoTipo = 2 
AND     IdCatalogo = 1


SELECT
    ROW_NUMBER () OVER ( 
        ORDER BY Country 
    ) RowNum,
    FirstName,
    LastName,
    country 
FROM
    customers;


SELECT ROW_NUMBER () OVER ( ORDER BY IdCatalogo ) RowNum
,IdCatalogo   
,IdCatalogoTipo     
,Nombre             
,Descripcion        
,Estado             
,FechaCreacion      
,FechaModifica      
FROM    Catalogo  
WHERE   Estado ='A' 
AND   IdCatalogoTipo =2;

SELECT ROW_NUMBER()  OVER ( ORDER BY IdCatalogo ) RowNum 
,IdCatalogo         
,IdCatalogoTipo     
,Nombre             
,Descripcion        
,Estado             
,FechaCreacion      
,FechaModifica      
FROM    Catalogo    
WHERE   Estado ='A' 
AND     IdCatalogoTipo = 2;
AND     RowNum = 1;  


SELECT 
     RowNum
    ,IdCatalogo
    ,IdCatalogoTipo
    ,Nombre
    ,Descripcion
    ,Estado
    ,FechaCreacion
    ,FechaModifica
FROM (
    SELECT 
        ROW_NUMBER() OVER (ORDER BY IdCatalogo) AS RowNum
        ,IdCatalogo
        ,IdCatalogoTipo
        ,Nombre
        ,Descripcion
        ,Estado
        ,FechaCreacion
        ,FechaModifica
    FROM Catalogo
    WHERE Estado = 'A' 
    AND IdCatalogoTipo = 2
) sub
WHERE RowNum = 4;
