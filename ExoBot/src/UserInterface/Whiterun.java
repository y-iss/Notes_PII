package UserInterface;
import BusinessLogic.Entities.IABot;
import BusinessLogic.Entities.EjercitoRuso.Mecatronico;
import BusinessLogic.Entities.EjercitoRuso.Soldado;
import BusinessLogic.Entities.Exoesqueleto.Exobot;

public class Whiterun {
    public void iniciar() {
            IABot iaBot = IABot.getInstance("IA-RUSA");
            Exobot e1 = new Exobot(iaBot);
            Soldado s1 = new Soldado("javier");
            Mecatronico mecatronico= new Mecatronico("Mecatronico");
            mecatronico.ensamblar(s1, e1, iaBot);
            
        }

        // Soldado s2 = new Soldado("Pepe");
        // Soldado s3 = new Soldado("Pepe");

        // System.out.println(e2.getNombre());
        // System.out.println(e3.getNombre());
}
