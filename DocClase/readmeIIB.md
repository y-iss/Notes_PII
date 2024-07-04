# <div align="center">**Escuela Politécnica Nacional**</div>
### <div align = "center">***Facultad de Ingeniería en Sistemas***</div>
### <div align = "center">***Ingeniería en Ciencias de la Computación***</div>
### <div align = "center">***Programación II***</div>
### <div align = "center">***BIMESTRE II***</div>
<br>
<br>
<p align = "center"><img src="logoepn.png"alt="Logo EPN" width"350"/>
</p>
</br>
</br>

----------------------------------------------------------------------------
## <div align = "center"> ===== ***TEMARIO II*** =====</div>
----------------------------------------------------------------------------

```Date: Martes 18 de junio```

# Clase 21

### Realizacion 

¿Seria posible plantear un escenario donde una clase hereda de mas de una clase (herencia multiple)?


- La herencia múltiple, de cara a la consistencia de los programas y los lenguajes tiene una relativamente alta complejidad.

- De ahí que algunos lenguajes orientados a objetos la permitan y otros no. 

- Java no permite la herencia múltiple, pero a cambio dispone de la construcción denominada “Interface” que permite una forma de simulación o implementación limitada de la herencia múltiple.

[captura](img44.png)

### Implementacion de Interfaces

- Interface construccion similar a clase abstracta en Java, diferencias: 

1. Encabezado 

- Se usa la **palabra clave ***interface***** en lugar de class o abstract class

***public interface INombreInterface {}***

2. **Todo metodo es abstracto y publico** sin necesidad de declararlo 

3. Las interfaces **no tienen constructor**

4. Una interfaz **solo admite campos/propiedades de tipo "public static final"** 

5. La **interface se implementa (implements), no se extiende (extends)** por sus subclases. Por tanto para declarar la herencia de una interface se usa la palabra clave ***implements*** en lugar de extends 


### Asociacion 

- Relaciones entre clases en un diagrama de clases UML

- Representado por una linea solida entre las clases 

- Las asociaciones se nombran usando un *verbo o frase verbal* que refleja el dominio del problema del mundo real 

#### Asociacion simple 

- Un vínculo estructural entre dos clases de pares

- Hay una asociación entre Class1 y Class2

- Hay una asociación que conecta la clase <<control>> Class1 y la clase <<boundary>> Class2

- La relación se muestra como una línea sólida que conecta las dos clases

![captura](img45.png)

### Cardinalidad 

- Cantidad de elementos incluidos en la asociacion 

![captura](img46.png)

#### UML + Asociacion (cardinalidad : 0,1,+,*)

1. Bidireccional 

![captura](img47.png)

2. Direccional 

![captura](img48.png)

#### UML + Asociacion ( multiplicidad / cardinalidad : 0,1,+,0..*)

 ![captura](img49.png)

----------------------------------------------------------------------------   

```Date: Miercoles 19 de junio```

# Clase 22 

### ASOCIACION 

Se vio herencian. paqueteria, interfaces, comportamientos 

### Continuacion de la actividad 

La mision era realizar un diagrama de clases de la clasificacion de los animales vertebrados y realizar su respectivo codigo 

![captura](img43.png)

----------------------------------------------------------------------------   
  
```Date: Lunes 24 de junio```

# Clase 23

Se continuo con el ejercicio que involucraba herencia, interface y asosiacion 

(una imagen del codigo mas la ejecucion del codigo)

---------------------------------------------------------------------------- 

 
  
```Date: Lunes 1 de Julio```

# Clase 24

## Composicion 

### UML + Composicion 

- Hay una dependencia en los ciclos de vida 
- Son partes de (componentes)
- Costructor obligatorio de la clase 

    ![captura](img50.png)


```java
public class Automovil {

    public Estereo estereo; 
    public Motor motor;
    
    public Automovil(); {
        estereo = new Estereo(); 
        motor = new Motor(); 
    }
}
```
### UML + Agregacion 

- Hay una dependencia en los ciclos de vida 

 ![captura](img51.png)


 ```java
public class Automovil {

    public Estereo estereo; 
    public Motor motor;
    
    public Automovil(); { 
    }

    public void ensamblar (Estereo e, Motor m){
        estereo = e; 
        motor = m; 
    }
}
```

### UML + Herencia

 ![captura](img52.png)

 - La interfaz hereda todas las operaciones de la interfaz extendida 

 ![captura](img53.png)


``` 
interface Player {
void play ();
void stop();
void pause ();
void reverse();
}

interface Recorder extends Player {
void record();
}

class TapePlayer implements Recorder {
public void play () { ... }
public void stop() { ... }
public void pause () { ... }
public void reverse() { ... }
public void record() { ... }
}
```

### UML + Interface 

1. 

 ![captura](img54.png)

```java
public interface Coloreable {
    public void cambiarDeColor(Color c); 
}
```

```java
public class Automovil implements Coloreable {
    public void cambiarDeColor(Color c){
        // se debe implementar 
    }
}
```

2. 

![captura](img55.png)

```java
public class Persona implements Coloreable {
     public void cambiarDeColor(Color c) {
        // se debe implementar
     }
}
```

```java
public class Animal implements Coloreable {
    public void cambiarDeColor(Color c){
        // se debe implementar 
    }
}
```
----------------------------------------------------------------------------  

```Date: Lunes 2 de Julio```

# Clase 25




----------------------------------------------------------------------------  