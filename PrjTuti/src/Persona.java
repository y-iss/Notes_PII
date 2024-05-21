import java.lang.reflect.Constructor;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;

    // Constructor de la clase persona
    public Persona() {
        cedula = " ";
        nombre = " ";
        apellido = " ";
    }

    public Persona(String cedula, String nombre, String apellido) {
        setCedula(cedula); // this.cedula = cedula;
        setNombre(nombre); // this.nombre = nombre;
        setApellido(apellido); // this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 10)
            this.cedula = cedula;
        else
            this.cedula = "no valido";
    }

    public String getNombre(){

    public void setNombre(String nombre){

    public String getApellido(){

    public void setApellido(String apellido) {

    }

    }}

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
