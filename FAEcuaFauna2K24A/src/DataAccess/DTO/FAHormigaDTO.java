package DataAccess.DTO;

public class FAHormigaDTO {
    private Integer id             ;           
    private String tipoHormiga     ;           
    private Integer sexoId         ;           
    private Integer provinciaId    ;           
    private Integer genoAlimentoId ;           
    private Integer ingestaNativaId;           
    private String estado          ;           
    private String estadoRegistro  ;           
    private String fechaCreacion   ;           
    private String fechaModifica   ;           

    public FAHormigaDTO() {}

    public FAHormigaDTO(Integer id, String tipoHormiga, Integer sexoId, Integer provinciaId, 
                        Integer genoAlimentoId, Integer ingestaNativaId, String estado, 
                        String estadoRegistro, String fechaCreacion, String fechaModifica) {
                            
        this.id = id;
        this.tipoHormiga = tipoHormiga;
        this.sexoId = sexoId;
        this.provinciaId = provinciaId;
        this.genoAlimentoId = genoAlimentoId;
        this.ingestaNativaId = ingestaNativaId;
        this.estado = estado;
        this.estadoRegistro = estadoRegistro;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    public Integer getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public Integer getGenoAlimentoId() {
        return genoAlimentoId;
    }

    public void setGenoAlimentoId(Integer genoAlimentoId) {
        this.genoAlimentoId = genoAlimentoId;
    }

    public Integer getIngestaNativaId() {
        return ingestaNativaId;
    }

    public void setIngestaNativaId(Integer ingestaNativaId) {
        this.ingestaNativaId = ingestaNativaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
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
        return  "  \n" + getClass().getName()
                + "\n id             " + getId()
                + "\n tipoHormiga    " + getTipoHormiga()
                + "\n sexoId         " + getSexoId()
                + "\n provinciaId    " + getProvinciaId()
                + "\n genoAlimentoId " + getGenoAlimentoId()
                + "\n ingestaNativaId" + getIngestaNativaId()
                + "\n estado         " + getEstado()
                + "\n estadoRegistro " + getEstadoRegistro()
                + "\n fechaCreacion  " + getFechaCreacion()
                + "\n fechaModifica  " + getFechaModifica();
    }

}
