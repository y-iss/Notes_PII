package clasificacionAnimal;

public class Invertebrado extends ReinoAnimal {
    private Integer nroHueso;

    public Invertebrado() {
        nroHueso = 0;
    }

    public void getNroHueso(Integer nroHueso) {
        this.nroHueso = nroHueso;
    }

}
