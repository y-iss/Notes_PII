public class Juego {
    Jugador usuario;
    private String rio;
    private String barca;
    private String[] ladoIzq;
    private String[] ladoDer;
    private boolean vikingoEstaIzq;

    public Juego() {
        this.usuario = new Jugador();

        this.rio = ".".repeat(20);
        this.barca = "\\_V_,_?_/";
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
            individuo       = ladoIzq[opcMenu];
            ladoIzq[opcMenu] = " "; 
        }
        else{
            individuo      = ladoDer[opcMenu];
            ladoDer[opcMenu]; 
        }
        moverBarca(individuo);
        vikingoEstaIzq = !vikingoEstaIzq;

        if(vikingoEstaIzq){
            ladoIzq[opcMenu]   =  individuo;
            setBarcaRio(1, " ");
        }
        else {
            ladoDer[opcMenu] = individuo;
            setBarcaRio(rio.length(), " ");
        }

    } while (true);
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
                opc = -1;
                String personaje = " ";
                System.out.print("\n[+] Ingresa una opc:");
                opc = App.sc.nextInt();
                // validar la opcion selecionada
                if (opc == 4) {
                    System.out.println("No huyas... cobarde..!");
                    System.exit(0);
                }
            } catch (Exception e) {
                App.sc.next();
            }
        } while (opc >= 4 || opc < 0);
        return (short) opc;
    }

    private void moverBarca(String individuo) {
        if (vikingoEstaIzq)
            for (int i = 0; i < rio.length(); i++)
                setBarcaRio(i, individuo);
        else
            for (int i = rio.length() - 1; i >= 0; i--)
                setBarcaRio(i, individuo);
    }

    private void setBarcaRio(int posicionBarca, String individuo) {
        // barca = "\\_V_,_?_/";
        String rioBarca = "\r"
                + ".".repeat(posicionBarca)
                + barca.replace("?", individuo)
                + ".".repeat(rio.length() - posicionBarca);
        System.out.print(rioBarca);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

// verificarRegla
