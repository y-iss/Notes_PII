package BusinessLogic.Entities;

public class IABot {
    // Singleton Pattern
    private static IABot instance;
    private static String nombre;

    // hacer el constructor privado para evitar la inicializado
    private IABot() { }
    protected IABot(IABot iaBot) { 
        if (iaBot != null)
            instance = iaBot;
    }

    public static IABot getInstance(String nombre) {
        if (instance == null){
            instance = new IABot();
            instance.setNombre(nombre);
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
