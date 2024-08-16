package DataAccess.DTO;

public class FAPaisDTO {
    private Integer faCodigoPais;
    private String faNombrePais;
    private String faEstado;
    private String faFechaCrea;
    private String faFechaModifica;
    
    public FAPaisDTO(){}

    public FAPaisDTO(String nombrePais) {
        this.faNombrePais = nombrePais;
    }

    public FAPaisDTO(int codigoPais, String nombrePais, String estado, String fechaCrea, String fechaModifica){
        this.faCodigoPais = codigoPais;
        this.faNombrePais = nombrePais;
        this.faEstado = estado;
        this.faFechaCrea = fechaCrea;
        this.faFechaModifica = fechaModifica;
    }

    public String faGetEstado() {
        return faEstado;
    }

    public void faSetEstado(String estado) {
        faEstado = estado;
    }

    public String faGetFechaCrea() {
        return faFechaCrea;
    }

    public void faSetFechaCrea(String fechaCrea) {
        faFechaCrea = fechaCrea;
    }

    public String faGetFechaModifica() {
        return faFechaModifica;
    }

    public void faSetFechaModifica(String fechaModifica) {
        faFechaModifica = fechaModifica;
    }

    public Integer faGetCodigoPais() {
        return faCodigoPais;
    }

    public void faSetCodigoPais(Integer codigoPais) {
        faCodigoPais = codigoPais;
    }

    public String faGetNombrePais() {
        return faNombrePais;
    }

    public void faSetNombrePais(String nombrePais) {
        faNombrePais = nombrePais;
    }

    @Override
    public String toString(){
        return  getClass().getName()
                + "\n CodigoPais       " + faGetCodigoPais()
                + "\n NombrePais       " + faGetNombrePais()
                + "\n Estado           " + faGetEstado()
                + "\n FechaCrea        " + faGetFechaCrea()
                + "\n FechaModifica    " + faGetFechaModifica();
    }
}

