package DataAccess.DTO;

public class FAHormigaDTO {
    private Integer faCodigoHormiga;
    private String faNombreHormiga;
    private Integer faCodigoSexo;
    private Integer faCodigoTipoHormiga;
    private Integer faCodigoEstado;
    private Integer faCodigoProvincia;
    private Integer faCodigoAlimento;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAHormigaDTO() {}

    public FAHormigaDTO(Integer codigoHormiga, String nombreHormiga, Integer codigoSexo, Integer codigoTipoHormiga, Integer codigoEstado, Integer codigoProvincia, Integer codigoAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoHormiga = codigoHormiga;
        this.faNombreHormiga = nombreHormiga;
        this.faCodigoSexo = codigoSexo;
        this.faCodigoTipoHormiga = codigoTipoHormiga;
        this.faCodigoEstado = codigoEstado;
        this.faCodigoProvincia = codigoProvincia;
        this.faCodigoAlimento = codigoAlimento;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoHormiga() {
        return faCodigoHormiga;
    }

    public void faSetCodigoHormiga(Integer codigoHormiga) {
        this.faCodigoHormiga = codigoHormiga;
    }

    public String faGetNombreHormiga() {
        return faNombreHormiga;
    }

    public void faSetNombreHormiga(String nombreHormiga) {
        this.faNombreHormiga = nombreHormiga;
    }

    public Integer faGetCodigoSexo() {
        return faCodigoSexo;
    }

    public void faSetCodigoSexo(Integer codigoSexo) {
        this.faCodigoSexo = codigoSexo;
    }

    public Integer faGetCodigoTipoHormiga() {
        return faCodigoTipoHormiga;
    }

    public void faSetCodigoTipoHormiga(Integer codigoTipoHormiga) {
        this.faCodigoTipoHormiga = codigoTipoHormiga;
    }

    public Integer faGetCodigoEstado() {
        return faCodigoEstado;
    }

    public void faSetCodigoEstado(Integer codigoEstado) {
        this.faCodigoEstado = codigoEstado;
    }

    public Integer faGetCodigoProvincia() {
        return faCodigoProvincia;
    }

    public void faSetCodigoProvincia(Integer codigoProvincia) {
        this.faCodigoProvincia = codigoProvincia;
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
                + "\n CodigoHormiga      " + faGetCodigoHormiga()
                + "\n NombreHormiga      " + faGetNombreHormiga()
                + "\n CodigoSexo         " + faGetCodigoSexo()
                + "\n CodigoTipoHormiga  " + faGetCodigoTipoHormiga()
                + "\n CodigoEstado       " + faGetCodigoEstado()
                + "\n CodigoProvincia    " + faGetCodigoProvincia()
                + "\n CodigoAlimento     " + faGetCodigoAlimento()
                + "\n Estado             " + faGetEstado()
                + "\n FechaCrea          " + faGetFechaCrea()
                + "\n FechaModifica      " + faGetFechaModifica();
    }
}

