import java.util.Arrays;

public class Juego {
    public Jugador usuario;
    private String[] ladoIzq;
    private String[] ladoDer;
<<<<<<< HEAD
    private boolean vikingoEstadoIzq;
    private String barca;
    private String rio;
=======
    private boolean vikingoEstaIzq;
>>>>>>> 083305bd8dee82d35ff744f66538124317e3d395

    public Juego() {
        this.usuario = new Jugador();

        this.rio = ".".repeat(20);
        this.barca = "\\_V_,_?_/";
<<<<<<< HEAD
        this.ladoIzq = new String[] { "V", "L", "C", "U" }; // Personajes del juego: vikingo, lobo, caperucita y uvas
        this.ladoDer = new String[] { "", "", "", "" };
        this.vikingoEstadoIzq = true;
    }

    // jugarLobito
    public void jugarLobito() {
        System.out.println("Bienvenido al juego de 'El lobo y el Vikingo'");
        if(!usuario.login())
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
            //R1: lobo come caperucita
            if (ladoDer[1].equals("L") && ladoDer[2].equals("C"))
                msg += "\n 7EL LOBO LE DEJO 7-0 A LA CAPERUCITA";
            //R2: CAPERUCITA COME UVAS
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
                if(opc==4){
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
            } catch (Exception e) {App.sc.next();}
        } 
        while (opc >= 4 || opc < 0);
=======
        this.ladoIzq = new String[] { "V", "L", "C", "U" }; // Personajes del juego
        this.ladoDer = new String[] { "", "", "", "" };
        this.vikingoEstaIzq = true;
    }

    public void jugarLobito() {
        do {
            short opcMenu = mostrarMenu();
            String individuo = " ";
            individuo = (vikingoEstaIzq)
                    ? ladoIzq[opcMenu]
                    : ladoDer[opcMenu];
            if (vikingoEstaIzq) {
                individuo = ladoIzq[opcMenu];
                ladoIzq[opcMenu] = " ";
            } else {
                individuo = ladoDer[opcMenu];
                ladoDer[opcMenu] = individuo;
            }
            moverBarca(individuo);
            vikingoEstaIzq = !vikingoEstaIzq;

            if (vikingoEstaIzq) {
                ladoIzq[opcMenu] = individuo;
                setBarcaRio(1, " ");
            } else {
                ladoDer[opcMenu] = individuo;
                setBarcaRio(rio.length(), " ");
            }

        } while (true);
    }

    // *verificarRegla() : String
    private String verificarRegla() {
        String msg = "";
        // Reglas con las que pierde el juego
        if (vikingoEstaIzq) {
            // R1: lobo come caperucita
            msg = (vikingoEstaIzq) && 

            if (ladoDer[0].equals(" L ") && ladoDer[2].equals(" c "))
                msg = "Marcho la caperuita ";

            // R2: caperucita come uvas
            if (ladoDer[0].equals(" C ") && ladoDer[2].equals(" U "))
                msg = "Marcho las uvas ";
        } else {
            // R1: lobo come caperucita
            if (ladoIzq[0].equals(" L ") && ladoIzq[2].equals(" c "))
                msg = "Marcho la caperuita ";

            // R2: caperucita come uvas
            if (ladoIzq[0].equals(" C ") && ladoIzq[2].equals(" U "))
                msg = "Marcho las uvas ";
        }
        if (ladoDer[0].equals("V") && ladoDer[1].equals("L") && ladoDer[2].equals("C") && ladoDer[3].equals("U"))
            msg = "Lo haz logrado";
        if (msg.isEmpty()) {
            System.out.println(msg);
            System.exit(0);
        }

        return "";
    }

    private Short mostrarMenu() {
        int opc = -1;
        System.out.println(" ".repeat(10) + barca + rio);
        System.out.println("\n 0 Vikingo va solo "
                + "\n 1 Lobo"
                + "\n 2 Caperucita"
                + "\n 3 Uvas"
                + "\n 4 Salir  ");
        do {
            try {
                // opc = -1;
                String personaje = " ";
                System.out.print("\n[+] Ingresa una opc:");
                opc = App.sc.nextInt();
                // verificar que exista el personaje
                personaje = (vikingoEstaIzq)
                        ? ladoIzq[opc]
                        : ladoDer[opc];
                if (personaje.trim().isEmpty()) {
                    opc = -1;
                    System.out.println("No existe este personaje en el lado de la barca");
                }

                if (opc == 4) {
                    System.out.println("No huyas... cobarde..!");
                    System.exit(0);
                }
            } catch (Exception e) {
                App.sc.next();
            }
        } while (opc >= 4 || opc < 0);
>>>>>>> 083305bd8dee82d35ff744f66538124317e3d395
        return (short) opc;
    }

    private void moverBarca(String individuo) {
<<<<<<< HEAD
        if (vikingoEstadoIzq)
            for (int i = 0; i < rio.length(); i++)
                setBarcaRio(i, individuo);
        else
            for (int i = rio.length(); i >= 0; i--)
=======
        if (vikingoEstaIzq)
            for (int i = 0; i < rio.length(); i++)
                setBarcaRio(i, individuo);
        else
            for (int i = rio.length() - 1; i >= 0; i--)
>>>>>>> 083305bd8dee82d35ff744f66538124317e3d395
                setBarcaRio(i, individuo);
    }

    private void setBarcaRio(int posicionBarca, String individuo) {
        // barca = "\\_V_,_?_/";
<<<<<<< HEAD
        String personajeIzq = Arrays.toString(ladoIzq);
        String personajeDer = Arrays.toString(ladoDer);
        String rioBarca = "\r"
                + personajeIzq
                + ".".repeat(posicionBarca)
                + barca.replace("?", individuo)
                + ".".repeat(rio.length() - posicionBarca)
                + personajeDer;
=======
        String rioBarca = "\r"
                + ".".repeat(posicionBarca)
                + barca.replace("?", individuo)
                + ".".repeat(rio.length() - posicionBarca);
>>>>>>> 083305bd8dee82d35ff744f66538124317e3d395
        System.out.print(rioBarca);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
<<<<<<< HEAD
    }
}
=======
    }

    public void moverBarca() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverBarca'");
    }
}

// verificarRegla
>>>>>>> 083305bd8dee82d35ff744f66538124317e3d395
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
        if(!usuario.login())
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
            //R1: lobo come caperucita
            if (ladoDer[1].equals("L") && ladoDer[2].equals("C"))
                msg += "\n EL LOBO LE DEJO 7-0 A LA CAPERUCITA";
            //R2: CAPERUCITA COME UVAS
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
                if(opc==4){
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
            } catch (Exception e) {App.sc.next();}
        } 
        while (opc >= 4 || opc < 0);
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
