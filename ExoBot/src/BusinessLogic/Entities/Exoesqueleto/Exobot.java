package BusinessLogic.Entities.Exoesqueleto;

import BusinessLogic.Entities.IABot;
import BusinessLogic.Entities.EjercitoRuso.IHumanoExtremidad;
import BusinessLogic.Entities.EjercitoRuso.Soldado;

public class Exobot extends IABot implements IHumanoExtremidad {
    private FuentePoder     efuentePoder;
    private TurboReactor    eturboReactor;
    private BrazoDerecho    ebrazoDerecho;
    private BrazoIzquierdo  ebrazoIzquierdo;
    private Pierna          epiernaDerecha;
    private Pierna          epiernaIzquierda;

   /**
    * <b> exabot</b> exoesqueleto cyberbot
    * @param iaBot
    */
    public Exobot(IABot iaBot){
        super(iaBot);
        //fuentePoder     = new FuentePoder();
        eturboReactor    = new TurboReactor();
        ebrazoDerecho    = new BrazoDerecho();
        epiernaDerecha   = new Pierna();
        epiernaIzquierda = new Pierna();
        
        if(Exobot.brazoDerecho)
            System.out.println("brazo Derecha");
        
        if(Exobot.brazoIzquierdo)
            ebrazoIzquierdo  = new BrazoIzquierdo();
            
        System.out.println("brazo izquierdo");
        
        if(Exobot.piernaDerecho)
            System.out.println("Pierna Derecha");
        if(Exobot.cabeza)
            System.out.println("Cabeza");
        if( Exobot.piernaIzquierdo)
            System.out.println("Pierna Izquierda");
        if(Exobot.tronco)
            System.out.println("Tronco");
    }

    //El Exobot se inicializa solo cuando la IABOT le otorga un código de seguridad para una misión específica
    public Boolean inicializar(){
        return true;
    }

    public void integrarSoldado(Soldado soldado) {
        if(Exobot.brazoIzquierdo && ebrazoIzquierdo!=null){
            if(soldado.getHabilidaBrazoIzquierdo())  
                ebrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61"));
            else
                ebrazoIzquierdo.setArma(new ArmaBazuca("Bazuca antitanque"));
                ebrazoIzquierdo.arma.disparar(30);
                System.out.println( ebrazoIzquierdo.arma.toString());


            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
            // ArmaIzquierda m =new ArmaMetralleta("Metralleta MK61");
            // ArmaIzquierda b = new ArmaBazuca("Bazuca antitanque");
            // ebrazoIzquierdo.setArma(m);
            // ebrazoIzquierdo.setArma(b);

            //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
            // if(xxx){
            //     ArmaMetralleta m = new ArmaMetralleta("Metralleta MK61");
            //     ebrazoIzquierdo.setArma(m);
            // }else{
            //     ArmaBazuca b = new ArmaBazuca("Bazuca antitanque");
            //     ebrazoIzquierdo.setArma(b);
            // }
        }
    }
    
}
