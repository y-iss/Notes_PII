package DataAccess.DTO;

public class FASexoDTO {
    private Integer id;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public FASexoDTO() {}

    public FASexoDTO(Integer id, String nombre, String estado, String fechaCreacion, String fechaModifica) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "FASexoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModifica='" + fechaModifica + '\'' +
                '}';
    }
}

