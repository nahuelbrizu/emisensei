import java.util.Scanner;

public class Moneda {
    public static void main(String[] args, BaseLocalApplicationProperties mapping) throws IOException, ParseException) {
        Scanner sc = new Scanner(System.in);
        double equivalencia;
        double cantidadDolares;
        double cantidadPesos;
        String compra_venta;
        int i = 0;

            URL url = new URL("https://www.dolarsi.com/api/api.php?type=valoresprincipales");//your url i.e fetch data from .
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
            while ((output = br.readLine())  != null) {
                    jsonStr = jsonStr + output;
            }
            JSONParser parser = new JSONParser();
            JSONArray json = (JSONArray) parser.parse(jsonStr);
            conn.disconnect();
            JSONObject dolarBlue = (JSONObject)json.get(1);
            JSONObject casaDBlue = (JSONObject)dolarBlue.get("casa");
            System.out.println("Venta : " + casaDBlue.get("venta"));
            System.out.println("Compra : " + casaDBlue.get("compra"));
            String ventaStr = (String) casaDBlue.get("venta");
            Float venta = Float.parseFloat(ventaStr.replace(",","."));
            System.out.println(venta);


        System.out.println(jsonStr);
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
