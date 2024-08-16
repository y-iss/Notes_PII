package DataAccess.DTO;

public class FATipoHormigaDTO {
    private Integer faCodigoTipoHormiga;
    private String faNombreTipoHormiga;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FATipoHormigaDTO() {}

    public FATipoHormigaDTO(String nombreTipoHormiga) {
        this.faNombreTipoHormiga = nombreTipoHormiga;
    }

    public FATipoHormigaDTO(Integer codigoTipoHormiga, String nombreTipoHormiga, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoTipoHormiga = codigoTipoHormiga;
        this.faNombreTipoHormiga = nombreTipoHormiga;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoTipoHormiga() {
        return faCodigoTipoHormiga;
    }

    public void faSetCodigoTipoHormiga(Integer codigoTipoHormiga) {
        this.faCodigoTipoHormiga = codigoTipoHormiga;
    }

    public String faGetNombreTipoHormiga() {
        return faNombreTipoHormiga;
    }

    public void faSetNombreTipoHormiga(String nombreTipoHormiga) {
        this.faNombreTipoHormiga = nombreTipoHormiga;
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
                + "\n CodigoTipoHormiga   " + faGetCodigoTipoHormiga()
                + "\n NombreTipoHormiga   " + faGetNombreTipoHormiga()
                + "\n Estado              " + faGetEstado()
                + "\n FechaCrea           " + faGetFechaCrea()
                + "\n FechaModifica       " + faGetFechaModifica();
    }
}

