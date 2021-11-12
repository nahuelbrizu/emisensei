package proceso;
import java.util.*;

public class Equipo {
	private List<Jugador> jugadores;
	private String nombre;
	private int puntos;
	private boolean[] jugado = new boolean[20];
	private boolean localia = false;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesFavor;
	private int golesContra;
	private int partidosLocal;
	/*
	 * 	Constructor. Todo equipo debe tener un nombre.
	 * 	Recibe: un String conteniendo el nombre del equipo.
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	public List getJugadores() {
		return jugadores;
	}
	/*
	 * 	Avisa al equipo que ha ganado un partido.
	 * 	Se le suman 3 puntos y un partido ganado al equipo.
	 */
	public void gana(){
		puntos=puntos+3;
		partidosGanados++;
	}
	/*
	 * 	Avisa al equipo que ha empatado un partido.
	 * 	Se le suma un punto y un partido empatado al equipo.
	 */
	public void empata(){
		puntos=puntos+1;
		partidosEmpatados++;
	}
	/*
	 * 	Avisa al equipo que ha perdido un partido.
	 * 	Se le suma un partido perdido al equipo.
	 */
	public void pierde(){
		partidosPerdidos++;
	}
	@SuppressWarnings("unchecked")
	public void setJugadores(List jugadores) {
		this.jugadores = jugadores;
	}
	public void cambiarLocalia() {
		localia = !localia;
	}
	public void setLocalia(boolean localia) {
		this.localia = localia;
	}
	public boolean getLocalia() {
		return localia;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public int getGolesContra() {
		return golesContra;
	}
	public int getGolesFavor() {
		return golesFavor;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void agregarPartidoLocal(){
		partidosLocal++;
	}
	public int getPartidosLocal(){
		return partidosLocal;
	}
	/*
	 * 	Agrega goles a favor al equipo.
	 * 	Recibe: cantidad de goles a favor a agregar en enteros.
	 */
	public void agregarGolesFavor(int n) {
		golesFavor=golesFavor+n;
	}
	/*
	 * 	Agrega goles en contra al equipo.
	 * 	Recibe: cantidad de goles en contra a agregar en enteros.
	 */
	public void agregarGolesContra(int n) {
		golesContra=golesContra+n;
	}
	/*
	 * 	Devuelve el estado del índice correspondiente en el array jugado[].
	 * 	Recibe: el índice del cual se quiere saber el estado en enteros.
	 * 	Devuelve: un booleano que representa si este equipo jugó contra el equipo
	 * 	que ocupa el índice n en la Lista de equipos del torneo. True si ya jugaron,
	 * 	false si todavía no jugaron.
	 */
	public boolean getJugado(int n) {
		return jugado[n];
	}
	/*
	 * 	Cambia el valor del índice indicado en el array jugado[].
	 * 	Recibe: el índice que se quiere cambiar en enteros y el valor booleano que
	 * 	se quiere poner en ese índice.
	 */
	public void setJugado(int n, boolean jugado) {
		this.jugado[n] = jugado;
	}
	/*
	 * 	Devuelve la diferencia de goles del equipo restando los goles en contra de
	 * 	los goles a favor.
	 * 	Devuelve: diferencia de goles en enteros.
	 */
	public int getDiferenciaDeGol(){
		int dif = golesFavor - golesContra;
		return dif;
	}
}
