import java.util.ArrayList;
import java.util.List;

public class Prueba2 {
    public static void main(String[] args){
        Usuario romualdo = new Usuario("romualdo", 45, "india", new Address("taj majal", 233, "gandhi"));
        Usuario  ramon = new Usuario("Ramon", 76, "Espaniaa", new Address("messi", 10, "Barcelona"));
        Usuario jorgito = new Usuario("Jorgito", 19, "Mexico", new  Address("panchito Villa", 1914, "Nuevo Mexico"));
        Usuario miguelito = new Usuario( "miguel ", 13, "Argentino" , new Address("dsa", 12, "sad"));
        Usuario sarampion = new Usuario( "San", 29, "peru" , new Address("wea", 12, "awd"));
        Usuario rampiosan = new Usuario( "Ahazam ", 39, "turkia" , new Address("sdsddsdsds", 12, "awefsaz"));

        List<Usuario> usuarios =  new ArrayList<Usuario>();
        usuarios.add(romualdo);
        usuarios.add(ramon);
        usuarios.add(jorgito);
        usuarios.add(miguelito);
        usuarios.add(sarampion);
        usuarios.add(rampiosan);
        System.out.println(usuarios.get(0).getNombre());
        System.out.println(usuarios.get(0).getEdad());
        System.out.println(usuarios.get(0).getNacionalidad());
        System.out.println(usuarios.get(0).getDireccion().toString());
        System.out.println(usuarios.get(1).getNombre());
        System.out.println(usuarios.get(1).getEdad());
        System.out.println(usuarios.get(1).getNacionalidad());
        System.out.println(usuarios.get(1).getDireccion().toString());
        System.out.println(usuarios.get(2).getNombre());
        System.out.println(usuarios.get(2).getEdad());
        System.out.println(usuarios.get(2).getNacionalidad());
        System.out.println(usuarios.get(2).getDireccion().toString());
        System.out.println(usuarios.get(3).getNombre());
        System.out.println(usuarios.get(3).getEdad());
        System.out.println(usuarios.get(3).getNacionalidad());
        System.out.println(usuarios.get(3).getDireccion().toString());
        System.out.println(usuarios.get(4).getNombre());
        System.out.println(usuarios.get(4).getEdad());
        System.out.println(usuarios.get(4).getNacionalidad());
        System.out.println(usuarios.get(4).getDireccion().toString());
        System.out.println(usuarios.get(5).getNombre());
        System.out.println(usuarios.get(5).getEdad());
        System.out.println(usuarios.get(5).getNacionalidad());
        System.out.println(usuarios.get(5).getDireccion().toString());


    }
}

class Usuario {
    private String nombre;
    private int edad;
    private String nacionalidad;
    private Address direccion;

    public Usuario(String nombre, int edad, String nacionalidad, Address direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }
    public String getNombre() {
        return this.nombre;
    }

    public String toString(){
        return this.nombre + " : " + this.edad + " , " + this.nacionalidad + " " + this.direccion;
    }
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public Address getDireccion() {
        return direccion;
    }

    public void setDireccion(Address direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
 class Address {
    private String calle;
    private int altura;
    private String barrio;

    public Address(String calle, int altura, String barrio){
        this.calle = calle;
        this.altura = altura;
        this.barrio = barrio;
    }
    public String toString(){
        return this.calle + " " + this.altura + " , " + this.barrio;
    }

     public String getCalle() {
         return calle;
     }

     public void setCalle(String calle) {
         this.calle = calle;
     }

     public int getAltura() {
         return altura;
     }

     public void setAltura(int altura) {
         this.altura = altura;
     }

     public String getBarrio() {
         return barrio;
     }

     public void setBarrio(String barrio) {
         this.barrio = barrio;
     }
 }
