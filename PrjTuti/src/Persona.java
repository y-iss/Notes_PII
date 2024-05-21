public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 10)
            this.cedula = cedula;
        else
            this.cedula = "no valido";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toUpperCase();
    }

}
