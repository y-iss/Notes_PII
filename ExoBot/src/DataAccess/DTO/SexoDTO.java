package DataAccess.DTO;

public class SexoDTO {
    private Integer RowNum         ;
    private Integer idCatalogo     ;           
    private Integer idCatalogoTipo ;           
    private String nombre         ;           
    private String descripcion    ;          
    private String estado         ;           
    private String fechaCreacion  ;            
    private String fechaModifica  ;            

    public SexoDTO(Integer RowNum  , Integer idCatalogo, Integer idCatalogoTipo, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModifica) {
        this.RowNum  = RowNum;
        this.idCatalogo = idCatalogo;
        this.idCatalogoTipo = idCatalogoTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }


    public SexoDTO(){}
    
     
    public SexoDTO(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRowNum() {
        return RowNum;
    }


    public void setRowNum(Integer rowNum) {
        RowNum = rowNum;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }


    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }


    public Integer getIdCatalogoTipo() {
        return idCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        this.idCatalogoTipo = idCatalogoTipo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public String toString(){
        return  getClass().getName()
                + "\n idCatalogo     "+ getIdCatalogo()
                + "\n idCatalogoTipo "+ getIdCatalogoTipo()
                + "\n nombre         "+ getNombre()
                + "\n descripcion    "+ getDescripcion()
                + "\n estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }


}
