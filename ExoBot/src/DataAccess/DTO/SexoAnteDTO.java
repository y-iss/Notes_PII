package DataAccess.DTO;
public class SexoAnteDTO {
    private Integer IdSexo;       
    private String  Nombre;       
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;
    
    
    public SexoAnteDTO(){ }

    public SexoAnteDTO(String nombre) {
        this.Nombre = nombre;
    }

    public SexoAnteDTO(int idSexo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdSexo = idSexo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public Integer getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        IdSexo = idSexo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
    public String toString(){
        return  getClass().getName()
                + "\n IdSexo:       "+ getIdSexo()       
                + "\n Nombre:       "+ getNombre()       
                + "\n Estado:       "+ getEstado()       
                + "\n FechaCrea:    "+ getFechaCrea()    
                + "\n FechaModifica:"+ getFechaModifica();
    }
    
}
