package Granja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
//import java.lang.*;

public class Test {
    private static ResourceBundle rb = ResourceBundle.getBundle("Granja.Pepe");
    private static List<Animal> animales= new ArrayList<Animal>();
    private static int incorrectas;
    private static String getString(String key){
        return rb.getString(key);
    }
    private static int getInt(String key){
        String value = rb.getString(key);
        return Integer.valueOf(value).intValue();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    	
    	InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Ingrese la cantidad de ciclos: ");
        String s = new String();
        try{
        s = br.readLine();
        }catch (Exception e){
        e.printStackTrace();
        }
        
        int ciclos = 0;
        if (!(s.equals(""))){
        	s = s.trim();
        	ciclos = Integer.parseInt(s);
        }else{
        	ciclos = getInt("ciclos");
        }
            for (int i=1; i<=getInt("animal.count");i++){
            try {
                Animal a = (Animal)Class.forName(getString("animal."+i+".class")).newInstance();
                a.setNombre(getString("animal."+i+".nombre"));
                String isMale = getString("animal."+i+".isMale");
                if (isMale.equals("true")){
                	a.setMale(true);
                }else{
                	a.setMale(false);
                }
                animales.add(a);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Random r = new Random(System.nanoTime());
        for (int i=0; i<ciclos; i++){
            int uno=0;
            int dos=0;
            while (uno==dos){
            uno = r.nextInt(animales.size());
            dos = r.nextInt(animales.size());
        }
            Animal a = animales.get(uno);
            Animal b = animales.get(dos);
            Animal c = (a.reproducir(b));
            if (c==null){
            incorrectas++;
            } else {
                animales.add(c);
            }
            Orden o = new Orden();
            Collections.sort(animales, o);
            Collections.reverse(animales);
        }
        for (int i=1; i<=animales.size();i++){
            Animal a = animales.get(i-1);
            System.out.println(a.getNombre()+" "+a.getEdad());
        }
        System.out.println("Cantidad inicial:"+getInt("animal.count"));
        System.out.println("Cantidad final:"+animales.size());
        System.out.println("Cantidad incorrectas:"+incorrectas);
        int exitosas = ciclos - incorrectas;
        double porcentaje = ((double)exitosas/ciclos)*100;
        
        System.out.println("Porcentaje de apareamientos exitosos: "+ porcentaje+"%");
    }

}
