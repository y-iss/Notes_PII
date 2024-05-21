public class App {
    public static void main(String[] args) throws Exception {
        Persona oP = new Persona();
        Persona oP2 = new Persona("1231238", "Juanca", "Leon");
        Supervisor oS = new Supervisor();

        oP.setCedula("1243");
        oP.setNombre("Pepe");
        // oP.setApellido("Lopez");

        System.out.println(oP.getCedula());
        System.out.println(oP.getNombre());
        System.out.println(oP.getApellido());

        System.out.println(oP2.getCedula());
        System.out.println(oP2.getNombre());
        System.out.println(oP2.getApellido());

    }

}
