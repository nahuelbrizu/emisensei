import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double equivalencia;
        double cantidadDolares;
        double cantidadPesos;
        String compra_venta;
        int i = 0;
        System.out.println("Cuanto vale el Dolaruco en el dia hoy ? =");
        equivalencia = sc.nextDouble();
        do {
            System.out.println("Desea Comprar o Vender  ");
            compra_venta = sc.next();

            if (compra_venta.equals("comprar")) {
                System.out.println("Cuantos Pesitos queres transformar a dolarucos");
                cantidadPesos = sc.nextDouble();
                double dolar = cantidadPesos / equivalencia;
                System.out.println("Conversion " + cantidadPesos + " pesitos " + dolar + " Dolares");

            }
            if (compra_venta.equals("vender")) {
                System.out.println("Cuantos Dolarucos le interesa Vender");
                cantidadDolares = sc.nextDouble();
                double pesos = cantidadDolares * equivalencia;
                System.out.println("Conversion " + cantidadDolares + " Dolares " + pesos + " Pesos");

            }
        }
        while (!compra_venta.equals("comprar") && !compra_venta.equals("vender"));
    }
}
