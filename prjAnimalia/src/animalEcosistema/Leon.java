package animalEcosistema;

import animalClasificacion.Mamifero;
import animalEcosistema.comportamiento.IAccion1;
import animalEcosistema.comportamiento.IAccionCarnivora;

public class Leon extends Mamifero implements IAccion1, IAccionCarnivora {

    public Pato alimentoPatuno; 

    public Leon(String nombre) { 
        setNombre(nombre);
        alimentoPatuno = new Pato ("Lucas");

    }

    @Override
    public String toString() {
        return    "\n Clase : " + getClass().getName()
                + "\n Nombre : " + getNombre();

    }

    @Override
    public void comer() {
        System.out.println("Leon come hambre .... ");
    }

    @Override
    public void correr(Pato alimentoPatuno) {
        System.out.println("Leon come : " + alimentoPatuno.toString());
    }

    @Override
    public void correr() {
        System.out.println("Leon correr ");
    }

}