import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NetClientGet {
    public static void main(String[] args) throws IOException, ParseException {

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
    }
}