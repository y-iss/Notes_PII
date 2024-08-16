package DataAccess.DTO;

public class FAEstadoDTO {
    private Integer faCodigoEstado;
    private String faNombreEstado;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;

    public FAEstadoDTO() {}

    public FAEstadoDTO(String nombreEstado) {
        this.faNombreEstado = nombreEstado;
    }

    public FAEstadoDTO(Integer codigoEstado, String nombreEstado, String estado, String fechaCrea, String fechaModifica) {
        this.faCodigoEstado = codigoEstado;
        this.faNombreEstado = nombreEstado;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoEstado() {
        return faCodigoEstado;
    }

    public void faSetCodigoEstado(Integer codigoEstado) {
        this.faCodigoEstado = codigoEstado;
    }

    public String faGetNombreEstado() {
        return faNombreEstado;
    }

    public void faSetNombreEstado(String nombreEstado) {
        this.faNombreEstado = nombreEstado;
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
                + "\n CodigoEstado      " + faGetCodigoEstado()
                + "\n NombreEstado      " + faGetNombreEstado()
                + "\n Estado            " + faGetEstado()
                + "\n FechaCrea         " + faGetFechaCrea()
                + "\n FechaModifica     " + faGetFechaModifica();
    }
}

