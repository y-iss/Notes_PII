public class App {
    public static void main(String[] args) throws Exception {

        // argumentosMain(args);

        Persona oP = new Persona();
        Persona oP2 = new Persona(null, null, null);
        Supervisor oS = new Supervisor();

        oP.setCedula("1234");
        oP.setNombre("Isa");
        oP.setApellido(null);

        System.out.println(oP.getCedula());
        System.out.println(oP.getNombre());
        System.out.println(oP.getApellido());

        System.out.println(oP2.getCedula());
        System.out.println(oP2.getNombre());
        System.out.println(oP2.getApellido());

    }

    private static void argumentosMain(String[] args) {
        if ((args.length == 2) &&
                (args[0].equals("y-iss") && args[1].equals("1234")))
            System.out.println("Buen dia amo, estoy lista para trabajar");

        else {
            System.out.println("Detecto que eres un intruso...");
            System.exit(0);
        }
    }

}
