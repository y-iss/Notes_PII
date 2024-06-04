public class Juego {
    public Jugador usuario;
    private String barca;
    private String rio;
    private String[] laasoIzquierdo;
    private String[] laasoDerecho;
    private boolean vikingoEstadoIzquierso;

    public Juego() {

        this.usuario = new Jugador();
        this.rio = "_".repeat(20);
        this.barca = "\\_V_;_?_//";
        this.vikingoEstadoIzquierso = true;
        this.laasoIzquierdo = new String[] { "Vikingo", "Lobo", "Cape", "Uvas" };
        this.laasoDerecho = new String[] { "", "", "", "" };
    }

    int opSeleccionada;

    public short mostrarMenu() {

        System.out.println(" ".repeat(10) + barca + rio);
        System.out.println(
                "\n 0 Vkingo va solo        "
                        + "\n 1 Lobo        "
                        + "\n 2 Caperuzita  "
                        + "\n 3 Uvas        "
                        + "\n 4 Salir       ");

        do {
            try {
                opSeleccionada = -1;
                System.out.print("\n [+] Ingrese una opcion masthash: ");
                opSeleccionada = App.sc.nextInt();
                if (opSeleccionada == 4) {
                    System.out.println("The vere pronto cobarde xd ");
                    System.exit(0);
                }
            } catch (Exception e) {
                // System.out.print("[+] Ingrese una opcion");
                App.sc.next();
            }
        } 

        while (opSeleccionada >= 4 || opSeleccionada < 0);
        return (short) opSeleccionada;
    }

    // jugarLobo:Bool
    // jugarLobo:Bool

}
