import java.util.List;
import java.util.Map;

public class Divisor  {
    public static void main (String[] args) {
        Moneda Moneda = new Moneda("usd", " $ ");
        Conversion C
    }

}
    class ConversorMoneda {
        Map<List<Moneda>, Integer> tipoDeCambio;

}

    class Conversion {
        Moneda origen;
        Moneda destino;

        public Conversion(Moneda origen, Moneda destino) {
            this.origen = origen;
            this.destino = destino;
        }
    }

    class Moneda {
        private String sDolar;
        private String sPeso;


        public Moneda(String sDolar,String sPeso) {
            this.sDolar = sDolar;
            this.sPeso = sPeso;
        }


        public String getsDolar() {
            return sDolar;
        }

        public void setsDolar(String sDolar) {
            this.sDolar = sDolar;
        }
        public String getsPeso() {
            return sPeso;
        }

        public void setsPeso(String sPeso) {
            this.sPeso = sPeso;}
    }
class Div {
    private int d;
    private int p;
    public  Div(int d, int p) {
        this.d = d;
        this.p = p;
        return d * p;
    }
}



//
//Tipo de dato  de valores
//    int      myNum = 9;
//    float myFloatNum = 8.99f;
//    char myLetter = 'A';
//    boolean myBool = false;
//    String myText = "Hello World";
//     Double numYtex =  00j;
//
