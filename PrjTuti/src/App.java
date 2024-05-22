import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class App {
    public static void main(String[] args) throws Exception {
        // argumentosMain(args);
        // FlujoDatoTeclado();

        int total = 0;
        String datos = "12-34-56";
        Scanner sc = new Scanner(datos);
        sc.useDelimiter("-");

        while (sc.hasNextInt()) {
            total += sc.nextInt();
        }
        System.out.println("total es: " + total);
        sc.close();

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

    private static void FlujoDatoTeclado() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa numeros para sumar");
        while (sc.hasNextInt()) {
            total += sc.nextInt();
        }
        System.out.println("La suma de los numeros es: " + total);
        sc.close();
    }

    private static void argumentosMain(String[] args) {
        if ((args.length == 2) &&
                (args[0].equals("y-iss") && args[1].equals("1234"))) {

            var entrada = Arrays.toString(args);

            System.out.println("Buen dia amo, estoy lista para trabajar");
            System.out.println("Los parametros que ingresaste son: " + args);
            System.out.println("Los parametros que ingresaste son: " + entrada);
        }

        else {
            System.out.println("Detecto que eres un intruso...");
            System.exit(0);
        }
    }

}
