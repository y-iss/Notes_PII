package BusinessLogic.Entities.Exoesqueleto;

public abstract class ArmaIzquierda {
    private String Tipo;

    public ArmaIzquierda(String tipo){
        this.Tipo = tipo;
        System.out.println(tipo);
    }
    
    public String getTipo() {
        return Tipo;
    }
    public void disparar(int cantidadBalas){
        for (int i = 0; i < cantidadBalas; i++) 
            System.out.print(" * ");
    }
    @Override
    public String toString(){
        
    return  "Esta es una "
            +this.getClass().getName()
            +" de tipo: "+this.Tipo+".\n";
    }
}
