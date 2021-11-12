package proceso;

import java.util.*;

public class Partido {
	private Equipo local;
	private Equipo visitante;
	private int golesLocal;
	private int golesVisitante;
	@SuppressWarnings("unchecked")
	private List<Jugador> marcadores = new ArrayList();
	
	/*
	 * 	Constructor: Juega un partido entre los dos equipos que recibe. Resuelve quién ganó o si hubo
	 * 	empate. Cambia la localía de los equipos que juegan.
	 * 	Recibe: dos objetos Equipo: el primero local, el segundo visitante.
	 * 	Devuelve: un objeto partido con los resultados.
	 */
	public Partido(Equipo local, Equipo visitante){
		Random r = new Random(System.nanoTime());
		setGolesLocal(r.nextInt(100));
		setGolesVisitante(r.nextInt(100));
		int golesLocal = getGolesLocal();
		int golesVisitante = getGolesVisitante();
		calcularMarcadores(golesLocal, local);
		calcularMarcadores(golesVisitante, visitante);
		local.agregarPartidoLocal();
		local.agregarGolesFavor(golesLocal);
		local.agregarGolesContra(golesVisitante);
		visitante.agregarGolesFavor(golesVisitante);
		visitante.agregarGolesContra(golesVisitante);
		local.cambiarLocalia();
		visitante.cambiarLocalia();
		if (golesLocal>golesVisitante){
			local.gana();
			visitante.pierde();
		} if (golesLocal<golesVisitante){
			visitante.gana();
			local.pierde();
		} if (golesLocal==golesVisitante){
			local.empata();
			visitante.empata();
		}
		setLocal(local);
		setVisitante(visitante);
	}
	/*
	 * 	Determina qué jugadores anotaron los goles de un equipo.
	 * 	Por cada gol marcado genera un número al azar del 0 al 100. A partir de ese número
	 * 	determina si el gol fue marcado por el arquero (índice 0 del objeto List jugadores
	 * 	del equipo), un defensor (índices del 1 al 4), un volante (índices del 5 al 7) o un
	 * 	delantero (índices del 8 al 10) de acuerdo a probabilidades fijas.
	 * 	Luego genera un número al azar que determina qué jugador lo marcó. Finalmente agrega
	 * 	ese jugador a la lista de jugadores que marcaron goles en este partido.
	 * 	Recibe: la cantidad de goles marcados por el equipo en enteros, el objeto
	 * 	Equipo que marcó los goles.
	 */
	@SuppressWarnings("unchecked")
	public void calcularMarcadores(int goles, Equipo equipo){
		for (int i=0; i<goles;i++){
			Random q = new Random(System.nanoTime());
			int s = q.nextInt(1000);
			List<Jugador> jugadores = equipo.getJugadores();
			List<Jugador> marcadores = getMarcadores();
			if (s<=5){
				Jugador arquero = jugadores.get(0);
				arquero.anotarGol();
				marcadores.add(arquero);
			}if ((s>=6) && (s<150)){
				int temp = q.nextInt(5);
				while (temp==0){
					temp = q.nextInt(5); 
				}
				Jugador defensor = jugadores.get(temp);
				defensor.anotarGol();
				marcadores.add(defensor);
			}if ((s>=150) && (s<350)){
				int temp = q.nextInt(8);
				while (temp<=4){
					temp = q.nextInt(8);
				}
				Jugador volante = jugadores.get(temp);
				volante.anotarGol();
				marcadores.add(volante);
			}if (s>=350){
				int temp = q.nextInt(11);
				while (temp<=7){
					temp = q.nextInt(11);
				}
				Jugador delantero = jugadores.get(temp);
				delantero.anotarGol();
				marcadores.add(delantero);
			}
		}
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	/*
	 * 	Determina la cantidad de goles que marcó el equipo local. Recibe un entero
	 * 	del 0 al 100 y setea los goles de acuerdo a probabilidades fijas.
	 * 	Recibe: entero del 0 al 100.
	 */
	public void setGolesLocal(int goles) {
		if (goles<5){
			golesLocal=5;
		} if ((goles>=5) && (goles<10)){
			golesLocal=4;
		} if ((goles>=10) && (goles<25)){
			golesLocal=3;
		} if ((goles>=25) && (goles<45)){
			golesLocal=2;
		} if ((goles>=45) && (goles<70)){
			golesLocal=1;
		} if ((goles>=70) && (goles<100)){
			golesLocal=0;
		}
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	/*
	 * 	Determina la cantidad de goles que marcó el equipo visitante. Recibe un entero
	 * 	del 0 al 100 y setea los goles de acuerdo a probabilidades fijas. El equipo
	 * 	visitante tiene desventaja probabilística.
	 * 	Recibe: entero del 0 al 100.
	 */
	public void setGolesVisitante(int goles) {
		if (goles<=1){
			golesVisitante=5;
		} if ((goles>=2) && (goles<8)){
			golesVisitante=4;
		} if ((goles>=8) && (goles<20)){
			golesVisitante=3;
		} if ((goles>=20) && (goles<38)){
			golesVisitante=2;
		} if ((goles>=38) && (goles<60)){
			golesVisitante=1;
		} if ((goles>=60) && (goles<100)){
			golesVisitante=0;
		}
	}
	public List getMarcadores() {
		return marcadores;
	}
	@SuppressWarnings("unchecked")
	public void setMarcadores(List jugadoresQueAnotaron) {
		this.marcadores = jugadoresQueAnotaron;
	}
	public void setLocal(Equipo local){
		this.local = local;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setVisitante(Equipo visitante){
		this.visitante = visitante;
	}
	public Equipo getVisitante() {
		return visitante;
	}
}
