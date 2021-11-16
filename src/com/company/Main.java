package com.company;
import javax.naming.NameNotFoundException;
import javax.swing.plaf.synth.SynthInternalFrameUI;
import java.nio.channels.Selector;
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

//    }
//}       public class elegir {
//            public static void main(String[] args){
//            String opcion, dolar, peso;
//            String moneda;
//
//            Scanner teclado = new Scanner(System.in);
//            moneda = teclado.next();
//            System.out.println("ingrese la moneda a cambiar  : ");
//            System.out.println("__Dolar__");
//            dolar = teclado.next();
//            System.out.println("__Peso__");
//            peso = teclado.next();
//
//    }
//        public static String cambio(String camb){
//            int dolar, peso, opcion;
//            Scanner teclado = new Scanner(System.in);
//
//    }
