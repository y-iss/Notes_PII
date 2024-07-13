package morthalClasificacion;

public abstract class Animal {
    private String nombre;

    public Animal() {
        nombre = " ";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

}
