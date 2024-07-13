package herenciaInterfaz;

public class ProfeFrances extends Persona implements IFrances{

    @Override
    public void ensenar(Poliglota poliglota) {
        System.out.println("Hola vamos a enseñar Frances a "+ poliglota.nombre);
    }

}
