package tuti;
public class Cliente {
    private Float dinero;

    public Float getDinero() {
        return dinero;
    }

    public void setDinero(Float dinero) {
        this.dinero = dinero;
    }
    
    public void seleccionarPrdoucto(){    }
    public String seleccionarPrdouctoOnLine(){  
        return "";
      }
    public Boolean pagarProducto(String listaProducto){
        return true;
    }
}
