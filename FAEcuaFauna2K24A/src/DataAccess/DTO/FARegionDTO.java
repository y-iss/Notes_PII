package DataAccess.DTO;

public class FARegionDTO {
    private Integer faCodigoRegion;
    private String faNombreRegion;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;
    
    public FARegionDTO(){}

    public FARegionDTO(String nombreRegion) {
        this.faNombreRegion = nombreRegion;
    }

    public FARegionDTO(int codigoRegion, String nombreRegion, String estado, String fechaCrea, String fechaModifica){
        this.faCodigoRegion = codigoRegion;
        this.faNombreRegion = nombreRegion;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public String faGetEstado() {
        return faEstado;
    }

    public void faSetEstado(String estado) {
        faEstado = estado;
    }

    public String faGetFechaCrea() {
        return faFechaCrea;
    }

    public void faSetFechaCrea(String fechaCrea) {
        faFechaCrea = fechaCrea;
    }

    public String faGetFechaModifica() {
        return faFechaModifica;
    }

    public void faSetFechaModifica(String fechaModifica) {
        faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoRegion() {
        return faCodigoRegion;
    }

    public void faSetCodigoRegion(Integer codigoRegion) {
        faCodigoRegion = codigoRegion;
    }

    public String faGetNombreRegion() {
        return faNombreRegion;
    }

    public void faSetNombreRegion(String nombreRegion) {
        faNombreRegion = nombreRegion;
    }

    @Override
    public String toString(){
        return  getClass().getName()
                + "\n CodigoRegion     " + faGetCodigoRegion()
                + "\n NombreRegion     " + faGetNombreRegion()
                + "\n Estado           " + faGetEstado()
                + "\n FechaCrea        " + faGetFechaCrea()
                + "\n FechaModifica    " + faGetFechaModifica();
    }
}

