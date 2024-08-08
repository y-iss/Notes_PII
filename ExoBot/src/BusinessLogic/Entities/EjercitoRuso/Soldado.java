package BusinessLogic.Entities.EjercitoRuso;

public class Soldado extends Humano implements IHumanoExtremidad {
    private Boolean habilidaBrazoIzquierdo;
    private Boolean habilidaBrazoDererecho;
    //private Exobot usaExoBot;


    public Soldado(String nombre) {
        super(nombre);
        
        if(Soldado.brazoDerecho)
            setHabilidaBrazoDererecho(getHabilidadRandom());
        System.out.println("Brazo Derecho  :"+ getHabilidaBrazoDererecho());
    
        if(Soldado.brazoIzquierdo)
            setHabilidaBrazoIzquierdo(getHabilidadRandom());
        System.out.println("Brazo Izquierdo: "+ getHabilidaBrazoIzquierdo());
        
        if(Soldado.piernaDerecho)
            System.out.println("Pierna Derecha");
        if(Soldado.cabeza)
            System.out.println("Cabeza");
        if( Soldado.piernaIzquierdo)
            System.out.println("Pierna Izquierda");
        if(Soldado.tronco)
            System.out.println("Tronco");

    }
    
    private boolean getHabilidadRandom(){
        int bias = 50;
        return (Math.random() * 100 < bias);
    }

    public Boolean getHabilidaBrazoIzquierdo() {
        return habilidaBrazoIzquierdo;
    }

    public void setHabilidaBrazoIzquierdo(Boolean habilidaBrazoIzquierdo) {
        this.habilidaBrazoIzquierdo = habilidaBrazoIzquierdo;
    }

    public Boolean getHabilidaBrazoDererecho() {
        return habilidaBrazoDererecho;
    }

    public void setHabilidaBrazoDererecho(Boolean habilidaBrazoDererecho) {
        this.habilidaBrazoDererecho = habilidaBrazoDererecho;
    }
    
}
