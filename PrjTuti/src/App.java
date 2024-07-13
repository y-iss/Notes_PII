import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import epn.Adminsitrativo;
import epn.Docente;
import epn.Estudiante;
import epn.EstudianteUPS;
import epn.Guardia;
import herenciaInterfaz.Persona;
import herenciaInterfaz.Poliglota;
import herenciaInterfaz.ProfeDanes;
import herenciaInterfaz.ProfeFrances;
import herenciaInterfaz.ProfeIngles;
import tuti.Cajero;
import tuti.Supervisor;

public class App {
    public static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // List<Persona> lstProfes = new ArrayList<>();
        // Poliglota       p  = new Poliglota();
        // p.nombre = "pepeito";
        // lstProfes.add(new ProfeDanes());
        // lstProfes.add(new ProfeFrances());
        // lstProfes.add(new ProfeIngles());
      
        ProfeDanes      pd = new ProfeDanes();
        ProfeFrances    pf = new ProfeFrances();
        ProfeIngles     pi = new ProfeIngles();
        Poliglota       p  = new Poliglota();
        p.nombre = "pepeito";
        pi.ensenar(p);
        pf.ensenar(p);
        pd.ensenar(p);

    }
    public static void interfaz(String[] args) throws Exception {
        Guardia         g = new Guardia();
        Estudiante      e = new Estudiante();
        Docente         d = new Docente();
        Adminsitrativo  a = new Adminsitrativo();
        EstudianteUPS   u = new EstudianteUPS();

        System.out.println("Interfaz");
        g.identificarseI(e);
        g.identificarseI(d);
        g.identificarseI(a);
        g.identificarseI(u);

        System.out.println("Herencia");
        g.identificarseH(e);
        g.identificarseH(d);
        g.identificarseH(a);
        //g.identificarseH(u);

    }
    public static void tpm(String[] args) throws Exception {
        //argumentoMain(args);
        // flujoTeclado();
        // flujoTeclado();
        //flujoString();

        // Persona     oP  = new Persona();
        // Persona     oP2 = new Persona(null, null, null);
        Cajero      oC =  new Cajero();
        Supervisor  oS  = new Supervisor(); 

        // oP.setCedula("1243");
        // oP.setNombre("pepe");
        // oP.setApellido(null);
        
        oC.setCedula("1243");
        oC.setNombre("pepe");
        oC.setApellido("Sanchez");

        // System.out.println(oP.getCedula());
        // System.out.println(oP.getNombre());
        // System.out.println(oP.getApellido());

        System.out.println(oC.getCedula());
        System.out.println(oC.getNombre());
        System.out.println(oC.getApellido());

    }

    private static void flujoString() {
        int total =0;
        String datos = "1-2-10";
        Scanner sc = new Scanner(datos);
        sc.useDelimiter("-");

        while (sc.hasNextInt()) {
            total+=sc.nextInt();
        }
        System.out.println("total es:" + total);
        sc.close();
    }

    private static void flujoTeclado() {
        int total     = 0;
        System.out.println("Ingresa numeros para sumar:");
        while (sc.hasNextInt()) {
            total+= sc.nextInt();
        }
        System.out.println("La suma de todos los numeros es: " +total);
        sc.next();
    }

    private static void argumentoMain(String[] args) {
        if  (   (args.length == 2) &&
                (args[0].equals("pat_mic") && args[1].equals("1234")) ) {
                    
                var entrada = Arrays.toString(args);
                System.out.println("Buen dia amo, estoy lista para trabajar...");
                System.err.println("los parametros que ingreasarte son:" + args);
                System.err.println("los parametros que ingreasarte son:" + entrada);
        }
        else{
            System.out.println("Detecto que eres un intruso...!");
            System.exit(0);
        }
    }
}