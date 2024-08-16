package DataAccess.DTO;

public class FAHormigaAlimentoDTO {
    private Integer faCodigoHormigaAlimento;
    private Integer faCodigoHormiga;
    private Integer faCodigoAlimento;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAHormigaAlimentoDTO() {}

    public FAHormigaAlimentoDTO(Integer codigoHormigaAlimento, Integer codigoHormiga, Integer codigoAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoHormigaAlimento = codigoHormigaAlimento;
        this.faCodigoHormiga = codigoHormiga;
        this.faCodigoAlimento = codigoAlimento;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoHormigaAlimento() {
        return faCodigoHormigaAlimento;
    }

    public void faSetCodigoHormigaAlimento(Integer codigoHormigaAlimento) {
        this.faCodigoHormigaAlimento = codigoHormigaAlimento;
    }

    public Integer faGetCodigoHormiga() {
        return faCodigoHormiga;
    }

    public void faSetCodigoHormiga(Integer codigoHormiga) {
        this.faCodigoHormiga = codigoHormiga;
    }

    public Integer faGetCodigoAlimento() {
        return faCodigoAlimento;
    }

    public void faSetCodigoAlimento(Integer codigoAlimento) {
        this.faCodigoAlimento = codigoAlimento;
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
                + "\n CodigoHormigaAlimento " + faGetCodigoHormigaAlimento()
                + "\n CodigoHormiga         " + faGetCodigoHormiga()
                + "\n CodigoAlimento        " + faGetCodigoAlimento()
                + "\n Estado               " + faGetEstado()
                + "\n FechaCrea            " + faGetFechaCrea()
                + "\n FechaModifica        " + faGetFechaModifica();
    }
}

