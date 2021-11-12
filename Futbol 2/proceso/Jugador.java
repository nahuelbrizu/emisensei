package proceso;

public class Jugador {
	private int goles;
	private int numero;
	private String nombre;
	public Jugador(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
	}
	public void anotarGol(){
		this.goles++;
	}
	public int getGoles() {
		return goles;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumero() {
		return numero;
	}
}
