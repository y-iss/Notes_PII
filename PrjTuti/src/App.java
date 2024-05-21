public class App {
    public static void main(String[] args) throws Exception {
        Persona oP = new Persona();
        Supervisor oS = new Supervisor();

        oP.setCedula("1243");
        oP.setNombre("Pepe");
        // oP.setApellido("Lopez");

        System.out.println(oP.getCedula());
        System.out.println(oP.getNombre());
        System.out.println(oP.getApellido());

    }

}
