package herenciaInterfaz;

public class ProfeIngles extends Persona implements IIngles {

    @Override
    public void ensenar(Poliglota poliglota) {
        System.out.println("Hola vamos a enseñar ingles a "+ poliglota.nombre);
    }

}
