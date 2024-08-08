package BusinessLogic.Entities.EjercitoRuso;

import BusinessLogic.Entities.IABot;
import BusinessLogic.Entities.Exoesqueleto.Exobot;

public class Mecatronico extends Humano{

    public Mecatronico(String nombre) {
        super(nombre);
    }
    public void ensamblar(Soldado soldado, Exobot exobot, IABot iaBot){
        System.out.println("testing: soldado.ensambla");
        System.out.println(soldado.getHabilidaBrazoIzquierdo() );
        System.out.println("testing: exobot.ensambla");
        //exobot.unirseSoldado(soldado);


    }
}