package animalEcosistema;

import animalClasificacion.Mamifero;
import animalEcosistema.comportamiento.IAccion1;
import animalEcosistema.comportamiento.IAccionCarnivora;

public class Leon extends Mamifero implements IAccion1, IAccionCarnivora {

    public Leon(String nombre) {
        setNombre(nombre);

    }

    @Override
    public String toString() {
        return "\n Clase : " + getClass().getName()
                + "\n Nombre : " + getNombre();

    }

    @Override
    public void comer() {

        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }

    @Override
    public void correr(Pato alimentoPatuno) {
        
        throw new 'correr'")
    }

    @Override
    public void correr() {

        throw new UnsupportedOperationException("Unimplemented method 'correr'");
    }

}
