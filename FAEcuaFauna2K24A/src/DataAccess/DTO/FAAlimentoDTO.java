package DataAccess.DTO;

public class FAAlimentoDTO {
    private Integer id;
    private String tipo;
    private String categoria;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public FAAlimentoDTO() {}

    public FAAlimentoDTO(Integer id, String tipo, String categoria, String estado, String fechaCreacion, String fechaModifica) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    
    @Override
    public String toString() {
        return "FAAlimentoDTO{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModifica='" + fechaModifica + '\'' +
                '}';
    }


}

