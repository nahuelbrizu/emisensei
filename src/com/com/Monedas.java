package com.com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monedas {
    private static String obtenerJson(String urlStr)throws IOException
    {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String jsonStr = "";
        String output;

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        while ((output = br.readLine()) != null) {
            jsonStr = jsonStr + output;
        }
        conn.disconnect();
        return jsonStr;
    }
    private static List generarLista(String jsonStr )throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(jsonStr);
        List lista = new ArrayList();
        int itemsValidos = 0;
        int mayorLong = 0;
        int mayonLComp = 0;
        for (int i = 0; i < json.size(); i++) {
            JSONObject obj = (JSONObject) json.get(i);
            JSONObject casa = (JSONObject) obj.get("casa");
            String nombre = (String) casa.get("nombre");
            String compraStr = (String) casa.get("compra");

            if ((compraStr).equals("No Cotiza")) {
                continue;
            }
            if (nombre.length() > mayorLong) {
                mayorLong = nombre.length();
            }
            if (compraStr.length() > mayonLComp) {
                mayonLComp = compraStr.length();
            }
        }
        for (int i = 0; i < json.size(); i++) {
            JSONObject obj = (JSONObject) json.get(i);
            JSONObject casa = (JSONObject) obj.get("casa");
            List lista1 = new ArrayList();

            String nombre = (String) casa.get("nombre");
            String compraStr = (String) casa.get("compra");
            String ventaStr = (String) casa.get("venta");

            int diff = mayorLong - nombre.length();
            String result = new String(new char[diff]).replace("\0", " ");
            String nombreConEspacios = nombre + result;

            int diffCompra = mayonLComp - compraStr.length();
            String resulta2 = new String(new char[diffCompra]).replace("\0", " ");
            String compraConEspacios = compraStr + resulta2;


            if ((compraStr).equals("No Cotiza")) {
                continue;
            }
            itemsValidos++;

            Float venta = Float.parseFloat(ventaStr.replace(".", "").replace(",", "."));
            Float compra = Float.parseFloat((compraStr).replace(".", "").replace(",", "."));
            lista1.add(nombre);
            lista1.add(compra);
            lista1.add(venta);
            lista.add(lista1);
            System.out.println(itemsValidos + " - " + nombreConEspacios +
                    " | " + " Compra : $ " + compraConEspacios + " | " + " Venta : $ " + ventaStr);
        }
        return lista;

    }
    private static int cambio(List lista, Scanner sc){

        boolean isInvalid;
        int cambio1 = 0;
        do {
            System.out.print(" Seleccione el cambio : ");
            String cambioStr = (String) sc.next();
            try {
                cambio1 = new Integer(cambioStr);
                isInvalid = cambio1 < 1 || cambio1 > lista.size();
            } catch (NumberFormatException e) {
                isInvalid = true;
                System.out.println("Eso no es un cambio");
            }
        } while (isInvalid);

        return cambio1;
    }

    private static void seleccion(List seleccion, Scanner sc){
        double cantidadDolares;
        double cantidadPesos;
        String compra_venta;
        String nombresSeleccion = (String) seleccion.get(0);
        Float compraSeleccion = (Float) seleccion.get(1);
        Float ventaSeleccion = (Float) seleccion.get(2);
        System.out.println(" Ha Seleccionado " + ": " + nombresSeleccion +
                " | " + " Valor Compra : " + compraSeleccion + " | " + " Valor Compra : " + ventaSeleccion);

        do
        {;
            System.out.print("Desea Comprar o Vender  ");
            compra_venta = sc.next();

            if (compra_venta.equals("comprar")) {
                System.out.print("Cuantos Pesitos queres transformar a dolarucos : ");
                cantidadPesos = sc.nextDouble();
                double dolar = cantidadPesos / compraSeleccion;
                System.out.println("Conversion " + cantidadPesos + " pesitos " + dolar + " Dolares");

            }
            if (compra_venta.equals("vender")) {
                System.out.print("Cuantos Dolarucos le interesa Vender : ");
                cantidadDolares = sc.nextDouble();
                double pesos = cantidadDolares * ventaSeleccion;
                System.out.println("Conversion " + cantidadDolares + " Dolares " + pesos + " Pesos");
            }
        }
        while(!compra_venta.equals("comprar")&&!compra_venta.equals("vender"));


    }



    public static void main(String[] args) throws IOException, ParseException  {
        String jsonStr = obtenerJson("https://www.dolarsi.com/api/api.php?type=valoresprincipales");
        List lista = generarLista(jsonStr);
        Scanner sc = new Scanner(System.in);
        int cambio = cambio(lista, sc);
        List seleccion = (List) lista.get(cambio - 1);
        seleccion(seleccion, sc);

    }
}
