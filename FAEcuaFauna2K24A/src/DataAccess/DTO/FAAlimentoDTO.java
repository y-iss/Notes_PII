package DataAccess.DTO;

public class FAAlimentoDTO {
    private Integer faCodigoAlimento;
    private String faNombreAlimento;
    private Integer faCodigoIngestaNativa;
    private Integer faCodigoGenoAlimento;
    private String faDescripcionAlimento;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAAlimentoDTO() {}

    public FAAlimentoDTO(String nombreAlimento) {
        this.faNombreAlimento = nombreAlimento;
    }

    public FAAlimentoDTO(Integer codigoAlimento, String nombreAlimento, Integer codigoIngestaNativa, Integer codigoGenoAlimento, String descripcionAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoAlimento = codigoAlimento;
        this.faNombreAlimento = nombreAlimento;
        this.faCodigoIngestaNativa = codigoIngestaNativa;
        this.faCodigoGenoAlimento = codigoGenoAlimento;
        this.faDescripcionAlimento = descripcionAlimento;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoAlimento() {
        return faCodigoAlimento;
    }

    public void faSetCodigoAlimento(Integer codigoAlimento) {
        this.faCodigoAlimento = codigoAlimento;
    }

    public String faGetNombreAlimento() {
        return faNombreAlimento;
    }

    public void faSetNombreAlimento(String nombreAlimento) {
        this.faNombreAlimento = nombreAlimento;
    }

    public Integer faGetCodigoIngestaNativa() {
        return faCodigoIngestaNativa;
    }

    public void faSetCodigoIngestaNativa(Integer codigoIngestaNativa) {
        this.faCodigoIngestaNativa = codigoIngestaNativa;
    }

    public Integer faGetCodigoGenoAlimento() {
        return faCodigoGenoAlimento;
    }

    public void faSetCodigoGenoAlimento(Integer codigoGenoAlimento) {
        this.faCodigoGenoAlimento = codigoGenoAlimento;
    }

    public String faGetDescripcionAlimento() {
        return faDescripcionAlimento;
    }

    public void faSetDescripcionAlimento(String descripcionAlimento) {
        this.faDescripcionAlimento = descripcionAlimento;
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
                + "\n CodigoAlimento      " + faGetCodigoAlimento()
                + "\n NombreAlimento      " + faGetNombreAlimento()
                + "\n CodigoIngestaNativa " + faGetCodigoIngestaNativa()
                + "\n CodigoGenoAlimento  " + faGetCodigoGenoAlimento()
                + "\n DescripcionAlimento " + faGetDescripcionAlimento()
                + "\n Estado              " + faGetEstado()
                + "\n FechaCrea           " + faGetFechaCrea()
                + "\n FechaModifica       " + faGetFechaModifica();
    }
}

