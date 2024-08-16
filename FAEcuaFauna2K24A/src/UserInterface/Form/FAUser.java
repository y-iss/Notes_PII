package UserInterface.Form;

public class FAUser {

    // Atributos del alumno
    private String FAcedula;
    private String FAnombres;

    // Constructor
    public FAUser(String FAcedula, String FAnombres) {
        this.FAcedula = FAcedula;
        this.FAnombres = FAnombres;
    }

    // Getters y Setters
    public String getFACedula() {
        return FAcedula;
    }

    public void setFACedula(String FAcedula) {
        this.FAcedula = FAcedula;
    }

    public String getFANombres() {
        return FAnombres;
    }

    public void setFANombres(String FAnombres) {
        this.FAnombres = FAnombres;
    }

    // Método para mostrar la información del alumno
    @Override
    public String toString() {
        return "Cédula: " + FAcedula + "\nNombres: " + FAnombres;
    }
}
