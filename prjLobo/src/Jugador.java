public class Jugador {

    private String usuario;
    private String nombre;
    private String clave;

    public Jugador() {
        setClave("1234");
        setNombre("Xander");
        setUsuario("Xander@Half");
    }

    public boolean Login(String usuario, String clave) {
        if (this.usuario.equalsIgnoreCase(usuario) && this.clave.equalsIgnoreCase(clave))
            return true;
        return false;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre.toUpperCase();
        } else {
            this.nombre = "";
        }
    }

}
