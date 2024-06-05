public class Padre {

    private String nombre;

    public Padre() {
        setNombre(" Soy tu padre :p");
    }

    public Padre(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = " ";
        if (nombre != null)
            this.nombre = nombre.toUpperCase();
    }

    public void saludar() {
        System.out.println(" Buen dia, soy " + this.nombre);
    }

}
