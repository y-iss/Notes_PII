package epn;

public class Guardia {

        private String nombre;

        // + identificarse(individuo: IAutenticacion): void
        public void identificarseI (IAutenticacion individuo){
            if(individuo.decirCedular())
                System.out.println("pase....");
        }
        
        // + identificarse(epn: EPNReglamento): void
        public void identificarseH (EPNReglamento epn){
            if(epn instanceof EPNReglamento )
                System.out.println("eres de la epn");
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
}
