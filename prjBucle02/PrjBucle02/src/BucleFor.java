public class BucleFor {
    // método : +-+-+-+-+-
    public void signoAlterno (){
        System.out.println("FOR:");
        
        for (int i = 1; i < 10; i++) {
            if (i%2==0)
                System.out.print("-");
            else
                System.out.print("+");
        }
        System.out.println();
    }

        public void signoAlternoGenerativo(){

            System.out.println("FOR:");
             for (int i = 1; i < 10; i++) {
                if (i%2==0)
                    for (int sn = 1; sn < i; sn++)
                    System.out.print("-");
                else
                    for (int sp = 1; sp < i; sp++)
                    System.out.print("+");
            }
            System.out.println(" ");
    }

        public void signoAlternoGenerativoMejora(){
            System.out.println("FOR:");
             for (int i = 1; i < 10; i++) {
                for (int s = 1; s < i; s++)  
                  System.out.print((i%2==0)?"-":"+");
                  System.out.print(" ");
        }
        System.out.println("");
    }

        //Crear escalera por niveles
        public void escalera(){
            int nivel = 10;
            String escalon= "|_";
            for (int i=1; i< nivel; i++){
                for (int s = 1; s<i; s++ )
                System.out.print("   ");
                System.out.println(escalon);
            }
        }
}











