public class Jugador {
    // atributos
    private String usuario;
    private String nombre;
    private String clave;

    public Jugador(){
        setUsuario("Keyaru");
        setNombre("Keyaru");
        setClave("Shinigami20o4");
    }

    public boolean login() {
        String usuario  = "";
        String clave    = "";
        boolean sinLogeo = true;

        do{
            System.out.print("Ingresa tu usuario: ");
            usuario = App.sc.nextLine();
            System.out.print("Ingresa tu clave: ");
            clave = App.sc.nextLine();

            if (this.usuario.equalsIgnoreCase(usuario)
                && this.clave.equalsIgnoreCase(clave))
                return true;

            System.out.print("Para salir (s): ");
            if(App.sc.nextLine().toUpperCase().equals("S"))
                sinLogeo = false;
        }while(sinLogeo);
        return false;
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}