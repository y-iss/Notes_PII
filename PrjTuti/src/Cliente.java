public class Cliente {

    private Float dinero;

    public Float getDinero() {
        return dinero;
    }

    public void setDinero(Float dinero) {
        this.dinero = dinero;
    }

    //Desde aqui va los metodos

    public void seleccionarProductoPerchero() {

    }

    public Boolean pagarProductoSeleccionado(String listaProducto) {
        return true;
    }

    public Boolean cancelarCompra() {
        return true;
    }

    public String seleccionarProductoOnline(String listaProducto) {
        return "";
    }

    public Boolean pagarProductoSeleccionado() {
        return true;
    }

    public Boolean pagarTC() {
        return true;
    }

    public Boolean pagarTD() {
        return true;
    }

}
