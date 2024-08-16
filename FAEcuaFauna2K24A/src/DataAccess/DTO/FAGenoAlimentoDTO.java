package DataAccess.DTO;

public class FAGenoAlimentoDTO {
    private Integer CodigoGenoAlimento;
    private String NombreGenoAlimento;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public FAGenoAlimentoDTO() {}

    public FAGenoAlimentoDTO(String nombreGenoAlimento) {
        this.NombreGenoAlimento = nombreGenoAlimento;
    }

    public FAGenoAlimentoDTO(Integer codigoGenoAlimento, String nombreGenoAlimento, String estado, String fechaCrea, String fechaModifica) {
        this.CodigoGenoAlimento = codigoGenoAlimento;
        this.NombreGenoAlimento = nombreGenoAlimento;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public Integer getCodigoGenoAlimento() {
        return CodigoGenoAlimento;
    }

    public void setCodigoGenoAlimento(Integer codigoGenoAlimento) {
        CodigoGenoAlimento = codigoGenoAlimento;
    }

    public String getNombreGenoAlimento() {
        return NombreGenoAlimento;
    }

    public void setNombreGenoAlimento(String nombreGenoAlimento) {
        NombreGenoAlimento = nombreGenoAlimento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n CodigoGenoAlimento  " + getCodigoGenoAlimento()
                + "\n NombreGenoAlimento  " + getNombreGenoAlimento()
                + "\n Estado              " + getEstado()
                + "\n FechaCrea           " + getFechaCrea()
                + "\n FechaModifica       " + getFechaModifica();
    }
}

