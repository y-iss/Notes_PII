public class App {
    public static void main(String[] args) throws Exception {
        Padre p = new Padre(" Pepe ");
        Hijo h = new Hijo(" Pepito ");
        p.saludar();
        h.saludar();
    }
}
