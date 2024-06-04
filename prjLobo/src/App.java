import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static Juego juego;

    public static void main(String[] args) throws Exception {

        Juego juego = new Juego();
        Jugador jugador = new Jugador();

        juego.mostrarMenu();

    }
}
