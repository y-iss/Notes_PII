package DataAccess.DTO;

public class FAPaisDTO {
    private Integer id;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public FAPaisDTO() {}

    public FAPaisDTO(Integer id, String nombre, String estado, String fechaCreacion, String fechaModifica) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "FAPaisDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModifica='" + fechaModifica + '\'' +
                '}';
    }
}

