package Framework;

public class FAException extends Exception {

    public FAException(String e, String clase, String metodo) {
        // grabar el log
        System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage() {
        return "Ups..! se presento un error..";
    }
}
