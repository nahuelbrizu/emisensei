package Granja;

import java.util.Random;

public class Burro extends Animal{
    public Animal reproducir(Animal a){
        int edad = this.getEdad();
        edad++;
        this.setEdad(edad);
        if ((a instanceof Burro)&&(this.isMale()!=a.isMale())){
            Burro hijo = new Burro();
            String padre = this.getNombre();
            String madre = ((Burro) a).getNombre();
            String nombreHijo = padre+madre;
            hijo.setNombre(nombreHijo);
            Random r = new Random(System.nanoTime());
            int genero = r.nextInt(2);
            if (genero == 0){
            	hijo.setMale(true);
            }else{
            	hijo.setMale(false);
            }
            return hijo;
        } else if ((a instanceof Equino)&&(this.isMale()!=a.isMale())){
        	Mula hijo = new Mula();
        	String padre = this.getNombre();
        	String madre = ((Equino) a).getNombre();
        	String nombreHijo = padre+madre;
        	hijo.setNombre(nombreHijo);
        	 Random r = new Random(System.nanoTime());
             int genero = r.nextInt(2);
             if (genero == 0){
             	hijo.setMale(true);
             }else{
             	hijo.setMale(false);
             }
        	return hijo;
        }
        return null;
    }
}
