package epn;

public class Estudiante extends EPNReglamento implements IAutenticacion {

    @Override
    public boolean decirCedular() {
        System.out.println("me autentique con la cedula ...");
        return true;
    }

    @Override
    public boolean mostrarCredencial() {
        System.out.println("me autentique con la cedencial...");
        return true;
    }

}
