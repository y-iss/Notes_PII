package BusinessLogic.Entities.EjercitoRuso;

import BusinessLogic.Entities.Exoesqueleto.ITecnicoIngles;

public class ExpertoIngles extends Humano{

    public ExpertoIngles(String nombre) {
        super(nombre);
    }

    public void ensenarIngles(ITecnicoIngles exobot){
        //Para aprender el idioma técnico se requiere de expertos en inglés y español técnico que le transfieran léxico, gramática y fonética para entender a otros soldados
        System.out.println("ensenarIngles");
    }
    
}
