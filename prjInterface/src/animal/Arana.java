package animal;

import clasificacionAnimal.Insectos;

public class Arana extends Insectos implements IComportamientoNatural, IComportamientoInsecto{
    public Arana(String nombre) {
        setNombre(nombre);
        nacer();
    }

    @Override
    public void nacer() {
        System.out.println("Araña naciendo..."+getNombre());
    }

    @Override
    public String comer(String comida) {
        return "Esta Araña a comido " + comida;
    }

    @Override
    public String comer() {
        return "Esta Araña ha comido hambre...!";
    }

    @Override
    public String comer(Mosca mosca) {
        return "Esta Araña esta comiendo una mosca muerta: "+ mosca.getNombre();
    }

}
