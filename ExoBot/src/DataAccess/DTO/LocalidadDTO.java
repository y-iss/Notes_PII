package DataAccess.DTO;

public class LocalidadDTO {
    private Integer LocalidaId;
    private String  Localida;
    private String  LocalidaTipo;
    // SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo
    public LocalidadDTO(){}
    public LocalidadDTO(Integer localidaId, String localida, String localidaTipo) {
        LocalidaId = localidaId;
        Localida = localida;
        LocalidaTipo = localidaTipo;
    }
    public Integer getLocalidaId() {
        return LocalidaId;
    }
    public void setLocalidaId(Integer localidaId) {
        LocalidaId = localidaId;
    }
    public String getLocalida() {
        return Localida;
    }
    public void setLocalida(String localida) {
        Localida = localida;
    }
    public String getLocalidaTipo() {
        return LocalidaTipo;
    }
    public void setLocalidaTipo(String localidaTipo) {
        LocalidaTipo = localidaTipo;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n LocalidaId  : " + getLocalidaId() 
        + "\n Localida    : " + getLocalida() 
        + "\n LocalidaTipo: " + getLocalidaTipo() ;
    }
}
