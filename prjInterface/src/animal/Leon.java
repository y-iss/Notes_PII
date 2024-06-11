package animal;

import clasificacionAnimal.Vertebrado;

public class Leon extends Vertebrado implements IComportamientoNatural {
    public Leon(Strinng nombre) {
        super(nombre);
        nacer();
    }

    @Override
    public void nacer() {

        System.out.println("Leon naciendo");
    }

    @Override
    public String comer(String comida) {
        return "El leon come " + comida;

    }

}
