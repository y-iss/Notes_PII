import animal.Arana;
import animal.Leon;

public class App {
    public static void main(String[] args) throws Exception {
        Leon l = new Leon("Mufasa");
        System.out.println(l.comer());
        System.out.println(l.comer("Filete de jirafa"));

        Arana a = new Arana("Spider");
        Mosca m = new Mosca("Zig");

        System.out.println(a.comer());
        System.out.println(a.comer("mariposa"));
        System.out.println(a.comer(m));
    }
}
