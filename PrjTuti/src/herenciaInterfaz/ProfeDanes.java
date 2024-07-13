package herenciaInterfaz;

public class ProfeDanes extends Persona implements IDanes {

    @Override
    public void ensenar(Poliglota poliglota) {
        System.out.println("Hola vamos a enseñar Danes a "+ poliglota.nombre);
    }

}
