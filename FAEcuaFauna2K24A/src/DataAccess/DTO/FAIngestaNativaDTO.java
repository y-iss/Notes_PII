package DataAccess.DTO;

public class FAIngestaNativaDTO {
    private Integer faCodigoIngestaNativa;
    private String faNombreIngestaNativa;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAIngestaNativaDTO() {}

    public FAIngestaNativaDTO(String nombreIngestaNativa) {
        this.faNombreIngestaNativa = nombreIngestaNativa;
    }

    public FAIngestaNativaDTO(Integer codigoIngestaNativa, String nombreIngestaNativa, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoIngestaNativa = codigoIngestaNativa;
        this.faNombreIngestaNativa = nombreIngestaNativa;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoIngestaNativa() {
        return faCodigoIngestaNativa;
    }

    public void faSetCodigoIngestaNativa(Integer codigoIngestaNativa) {
        this.faCodigoIngestaNativa = codigoIngestaNativa;
    }

    public String faGetNombreIngestaNativa() {
        return faNombreIngestaNativa;
    }

    public void faSetNombreIngestaNativa(String nombreIngestaNativa) {
        this.faNombreIngestaNativa = nombreIngestaNativa;
    }

    public String faGetEstado() {
        return faEstado;
    }

    public void faSetEstado(String estado) {
        this.faEstado = estado;
    }

    public String faGetFechaCrea() {
        return faFechaCrea;
    }

    public void faSetFechaCrea(String fechaCrea) {
        this.faFechaCrea = fechaCrea;
    }

    public String faGetFechaModifica() {
        return faFechaModifica;
    }

    public void faSetFechaModifica(String fechaModifica) {
        this.faFechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n CodigoIngestaNativa " + faGetCodigoIngestaNativa()
                + "\n NombreIngestaNativa " + faGetNombreIngestaNativa()
                + "\n Estado              " + faGetEstado()
                + "\n FechaCrea           " + faGetFechaCrea()
                + "\n FechaModifica       " + faGetFechaModifica();
    }
}

