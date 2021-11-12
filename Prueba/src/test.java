import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br;

    numero1 =Integer.parseInt(br.readLine());
    numero2 =Integer.parseInt(br.readLine());
    try{
        System.out.println("Introduce el primer número:");
        numero1 = Integer.parseInt(br.readLine());
        System.out.println("Introduce el segundo número:");
        numero2 = Integer.parseInt(br.readLine());
    } catch(
    IOException ioe)

    {
        ioe.printStackTrace();
    }

}resultado = numero1*numero2;
        System.out.println("La multiplicación es "+numero1+" x "+numero2+" = "+resultado);