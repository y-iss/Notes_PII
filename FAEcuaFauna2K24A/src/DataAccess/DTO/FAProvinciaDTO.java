package DataAccess.DTO;

public class FAProvinciaDTO {
    private Integer faCodigoProvincia;
    private String faNombreProvincia;
    private Integer faCodigoPais;
    private Integer faCodigoRegion;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAProvinciaDTO() {}

    public FAProvinciaDTO(String nombreProvincia, Integer codigoPais, Integer codigoRegion) {
        this.faNombreProvincia = nombreProvincia;
        this.faCodigoPais = codigoPais;
        this.faCodigoRegion = codigoRegion;
    }

    public FAProvinciaDTO(Integer codigoProvincia, String nombreProvincia, Integer codigoPais, Integer codigoRegion, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoProvincia = codigoProvincia;
        this.faNombreProvincia = nombreProvincia;
        this.faCodigoPais = codigoPais;
        this.faCodigoRegion = codigoRegion;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoProvincia() {
        return faCodigoProvincia;
    }

    public void faSetCodigoProvincia(Integer codigoProvincia) {
        this.faCodigoProvincia = codigoProvincia;
    }

    public String faGetNombreProvincia() {
        return faNombreProvincia;
    }

    public void faSetNombreProvincia(String nombreProvincia) {
        this.faNombreProvincia = nombreProvincia;
    }

    public Integer faGetCodigoPais() {
        return faCodigoPais;
    }

    public void faSetCodigoPais(Integer codigoPais) {
        this.faCodigoPais = codigoPais;
    }

    public Integer faGetCodigoRegion() {
        return faCodigoRegion;
    }

    public void faSetCodigoRegion(Integer codigoRegion) {
        this.faCodigoRegion = codigoRegion;
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
                + "\n CodigoProvincia   " + faGetCodigoProvincia()
                + "\n NombreProvincia   " + faGetNombreProvincia()
                + "\n CodigoPais        " + faGetCodigoPais()
                + "\n CodigoRegion      " + faGetCodigoRegion()
                + "\n Estado            " + faGetEstado()
                + "\n FechaCrea         " + faGetFechaCrea()
                + "\n FechaModifica     " + faGetFechaModifica();
    }
}

