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

    // Getters and setters

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

