package animal;

import clasificacionAnimal.Vertebrados;

public class Leon extends Vertebrados implements IComportamientoNatural {

    public Leon(String nombre) {
        setNombre(nombre);
        nacer();
    }

    @Override
    public void nacer() {
        System.out.println("Leon naciendo..."+getNombre());
    }

    @Override
    public String comer(String comida) {
        return "Este Leon a comido " + comida;
    }

    @Override
    public String comer() {
        return "Este Leon ha comido hambre...!";
    }
}
