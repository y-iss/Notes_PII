public class Persona {

    private String nombre;
    private String apellido;
    private String cedula;

    // Constructor de la clase persona para inicializar las variables
    public Persona() {
        cedula = "";
        nombre = "";
        apellido = "";
    }
    public Persona(String cedula, String nombre, String apellido) {
        setCedula(cedula); // this.cedula=cedula;
        setNombre(nombre); // this.nombre=nombre;
        setApellido(apellido); // this.apellido=apellido;
        ;
    }
    public void setNombre(String nombre) {

        if (nombre != null) {

            this.nombre = nombre.toUpperCase();

        } else {

            this.nombre = "";

        }

    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {

        if (apellido != null) {

            this.apellido = apellido.toUpperCase();

        } else {

            this.apellido = "";

        }
    }
    public String getApellido() {
        return apellido;
    }
    public void setCedula(String cedula) {

        if (cedula == null || cedula.length() != 10) {
            this.cedula = "No tiene la longitud";
        } else {
            this.cedula = cedula;
        }

        // if (cedula != null) {
        //     if (10 == cedula.length()) {
        //         this.cedula = cedula;
        //     } else {
        //         this.cedula = "No tiene la longitud requerida";
        //     }
        // } else {
        //     this.cedula = "No tiene la longitud requerida";
        // }
    }
    public String getCedula() {
        return cedula;
    }
}

