package DataAccess.DTO;

public class FAProvinciaDTO {
    private Integer id;
    private String nombre;
    private Integer regionId;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public FAProvinciaDTO() {}

    public FAProvinciaDTO(Integer id, String nombre, Integer regionId, String estado, String fechaCreacion, String fechaModifica) {
        this.id = id;
        this.nombre = nombre;
        this.regionId = regionId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "FAProvinciaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", regionId=" + regionId +
                ", estado='" + estado + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModifica='" + fechaModifica + '\'' +
                '}';
    }
}

