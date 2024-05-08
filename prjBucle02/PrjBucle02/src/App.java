public class App {
    public static void main(String[] args) throws Exception 
    {
        // Declarar
        BucleFor bf;     
        BucleWhile bw;    

        //Instanciar
        bf = new BucleFor();
        bw = new BucleWhile();
        //Llamar al método
        bf.signoAlterno();    
        bf.signoAlternoGenerativo();
        bf.signoAlternoGenerativoMejora();  
        bf.escalera();

        bw.signoAlterno();
    }
}
