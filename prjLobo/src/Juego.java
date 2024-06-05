import java.util.Arrays;

public class Juego {
    public Jugador usuario;
    private String[] ladoIzq;
    private String[] ladoDer;
    private boolean vikingoEstadoIzq;
    private String barca;
    private String rio;

    public Juego() {
        this.usuario = new Jugador();

        this.rio = ".".repeat(20);
        this.barca = "\\_V_,_?_/";
        this.ladoIzq = new String[] { "V", "L", "C", "U" }; // Personajes del juego: vikingo, lobo, caperucita y uvas
        this.ladoDer = new String[] { "", "", "", "" };
        this.vikingoEstadoIzq = true;
    }

    // jugarLobito
    public void jugarLobito() {
        System.out.println("Bienvenido al juego de 'El lobo y el Vikingo'");
        if (!usuario.login())
            System.exit(0);
        do {
            short opcMenu = mostrarMenu();
            String individuo = " ";

            if (vikingoEstadoIzq) {
                individuo = ladoIzq[opcMenu];
                ladoIzq[opcMenu] = " ";
            } else {
                individuo = ladoDer[opcMenu];
                ladoDer[opcMenu] = " ";
            }
            moverBarca(individuo);
            vikingoEstadoIzq = !vikingoEstadoIzq;

            if (vikingoEstadoIzq) {
                ladoIzq[opcMenu] = individuo;
                setBarcaRio(1, " ");
            } else {
                ladoDer[opcMenu] = individuo;
                setBarcaRio(rio.length(), " ");
            }
            verificarReglas();
        } while (true);
    }

    // verificarRegla
    private void verificarReglas() {
        String msg = "";

        // Reglas con las que se priede el juego
        if (vikingoEstadoIzq) {
            // R1: lobo come caperucita
            if (ladoDer[1].equals("L") && ladoDer[2].equals("C"))
                msg += "\n EL LOBO LE DEJO 7-0 A LA CAPERUCITA";
            // R2: CAPERUCITA COME UVAS
            if (ladoDer[2].equals("C") && ladoDer[3].equals("U"))
                msg += "\n LA CAPERUCITA SE COMIO LAS UVAS";
        } else {
            // lobo come caperucita
            if (ladoIzq[1].equals("L") && ladoIzq[2].equals("C"))
                msg += "\n EL LOBO LE DEJO 7-0 A LA CAPERUCITA";
            // cAPERUCITA COME UVAS
            if (ladoIzq[2].equals("C") && ladoIzq[3].equals("U"))
                msg += "\n LA CAPERUCITA SE COMIO LAS UVAS";
        }
        // Reglas con la que gano el juego
        if (ladoDer[1].equals("L") && ladoDer[2].equals("C") && ladoDer[3].equals("U"))
            msg = "\n LO LOGRASTE CRACK!!";
        if (!msg.isEmpty()) {
            System.out.println(msg);
            System.exit(0);
        }
    }

    private short mostrarMenu() {
        int opc = -1;
        System.out.print("\n 0 Vikingo va solo "
                + "\n 1 Lobo             "
                + "\n 2 Caperucita        "
                + "\n 3 Uvas             "
                + "\n 4 Salir            ");
        do {
            try {
                String personaje = "";
                System.out.print("\n[+] Ingrese una opc: ");
                opc = App.sc.nextInt();
                if (opc == 4) {
                    System.out.println("Se te moja la canoa... cierto?");
                    System.exit(0);
                }

                // verificar que exista un personaje
                personaje = (vikingoEstadoIzq)
                        ? ladoIzq[opc]
                        : ladoDer[opc];

                if (personaje.trim().isEmpty() && opc > 0) {
                    opc = -1;
                    System.out.println("No existe ese personaje en el lado que esta la barca");
                }
            } catch (Exception e) {
                App.sc.next();
            }
        } while (opc >= 4 || opc < 0);
        return (short) opc;
    }

    private void moverBarca(String individuo) {
        if (vikingoEstadoIzq)
            for (int i = 0; i < rio.length(); i++)
                setBarcaRio(i, individuo);
        else
            for (int i = rio.length(); i >= 0; i--)
                setBarcaRio(i, individuo);
    }

    private void setBarcaRio(int posicionBarca, String individuo) {
        // barca = "\\_V_,_?_/";
        String personajeIzq = Arrays.toString(ladoIzq);
        String personajeDer = Arrays.toString(ladoDer);
        String rioBarca = "\r"
                + personajeIzq
                + ".".repeat(posicionBarca)
                + barca.replace("?", individuo)
                + ".".repeat(rio.length() - posicionBarca)
                + personajeDer;
        System.out.print(rioBarca);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
