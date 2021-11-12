import java.util.ArrayList;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        Usuario2 emi = new Admin("Emiliano", 38, "Argentina");
        Usuario2 pt = new UsuarioPT( "Nahuelito", 29, "Argentina" );
        List<Usuario2> usuarios = new ArrayList<Usuario2>();
        usuarios.add(emi);
        usuarios.add(pt);
        System.out.println(usuarios.get(0).getNombre());
        System.out.println(usuarios.get(1).getNombre());

        Vehiculo auto = new Sedan("Ford");
        Vehiculo moto = new Moto("Yamaha");
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(auto);
        vehiculos.add(moto);
        for (int i = 0; i < vehiculos.size(); i++){
            Vehiculo v = vehiculos.get(i);
            System.out.println(v.mover(5));
        }
    }
}

class Usuario2 {
    private String nombre;
    private int edad;
    private String nacionalidad;

    public Usuario2(String nombre, int edad, String nacionalidad){
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }
    //getter
    public String getNombre() {
        return this.nombre;
    }
    //setter
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }
}

class Admin extends Usuario2 {

    public Admin(String nombre, int edad, String nacionalidad) {
        super(nombre + " Admin", edad, nacionalidad);
    }
}

class UsuarioPT extends Usuario2 {

    public UsuarioPT(String nombre, int edad, String nacionalidad) {
        super(nombre + " Pete", edad, nacionalidad);
    }
}

class Vehiculo {
    private int cantidadRuedas;
    private int puertas;
    private String marca;
    private int velocidad;

    public Vehiculo(int ruedas, int puertas, String marca, int velocidad){
        this.velocidad = velocidad;
    }
    public int mover(int tiempo){
        return tiempo * velocidad;
    }
}

class Sedan extends Vehiculo {

    public Sedan(String marca) {
        super(4, 4, marca, 130);
    }
}
class Moto extends Vehiculo {
    public Moto(String marca){
        super(2, 0, marca, 100);
    }
}

