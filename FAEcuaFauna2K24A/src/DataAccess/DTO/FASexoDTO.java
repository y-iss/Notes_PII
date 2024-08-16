package DataAccess.DTO;

public class FASexoDTO {
    private Integer faCodigoSexo;
    private String faNombreSexo;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FASexoDTO() {}

    public FASexoDTO(String nombreSexo) {
        this.faNombreSexo = nombreSexo;
    }

    public FASexoDTO(Integer codigoSexo, String nombreSexo, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoSexo = codigoSexo;
        this.faNombreSexo = nombreSexo;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoSexo() {
        return faCodigoSexo;
    }

    public void faSetCodigoSexo(Integer codigoSexo) {
        this.faCodigoSexo = codigoSexo;
    }

    public String faGetNombreSexo() {
        return faNombreSexo;
    }

    public void faSetNombreSexo(String nombreSexo) {
        this.faNombreSexo = nombreSexo;
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
                + "\n CodigoSexo        " + faGetCodigoSexo()
                + "\n NombreSexo        " + faGetNombreSexo()
                + "\n Estado            " + faGetEstado()
                + "\n FechaCrea         " + faGetFechaCrea()
                + "\n FechaModifica     " + faGetFechaModifica();
    }
}

