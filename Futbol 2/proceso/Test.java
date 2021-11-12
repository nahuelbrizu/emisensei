package proceso;

import data.Carga;
import java.io.*;
import java.util.*;
public class Test {
	/**
	 * @param args
	 */
	/*	
	 *	Imprime tabla de posiciones en la pantalla.
	 * 	Recibe: Torneo.
	 */
	@SuppressWarnings("unchecked")
	public static void printTablaDePosiciones(Torneo torneo){
		List<Equipo> posiciones = torneo.getPosiciones();
		System.out.println("CAMPEON: "+(posiciones.get(0)).getNombre());
		System.out.println("POSICIONES FINALES:");
		System.out.println(" _____________________________________________");
		System.out.println("|POS|EQUIPO____________|PG|PE|PP|GF|GC| DG|Pts|");
		for (int i=0;i<posiciones.size();i++){
			Equipo equipo = posiciones.get(i);
			pipe();
			underScore();
			if (i+1<10){
				underScore();
				System.out.print(i+1);
			}else {
				System.out.print(i+1);
			}
			pipe();
			System.out.print(equipo.getNombre());
			int a=18-equipo.getNombre().length();
			for (int c=0;c<a;c++){
				underScore();
			}
			pipe();
			if (equipo.getPartidosGanados()<10){
				underScore();
			}
			System.out.print(equipo.getPartidosGanados());
			pipe();
			if (equipo.getPartidosEmpatados()<10){
				underScore();
			}
			System.out.print(equipo.getPartidosEmpatados());
			pipe();
			if (equipo.getPartidosPerdidos()<10){
				underScore();
			}
			System.out.print(equipo.getPartidosPerdidos());
			pipe();
			if (equipo.getGolesFavor()<10){
				underScore();
			}
			System.out.print(equipo.getGolesFavor());
			pipe();
			if (equipo.getGolesContra()<10){
				underScore();
			}
			System.out.print(equipo.getGolesContra());
			pipe();
			if ((equipo.getDiferenciaDeGol()>=0) && (equipo.getDiferenciaDeGol()<10)){
				underScore();
				underScore();
				System.out.print(equipo.getDiferenciaDeGol());
			}
			if (((equipo.getDiferenciaDeGol()>-10) && (equipo.getDiferenciaDeGol()<0)) || (equipo.getDiferenciaDeGol()>=10)){
				underScore();
				System.out.print(equipo.getDiferenciaDeGol());
			}
			if (equipo.getDiferenciaDeGol()<=-10){
				System.out.print(equipo.getDiferenciaDeGol());
			}
			pipe();
			underScore();
			System.out.print(equipo.getPuntos());
			pipe();
			System.out.println();
		}
	}
	/*
	 * 	Imprime en pantalla los goleadores de un torneo.
	 * 	Recibe: un Torneo y la cantidad de goleadores que se quiere
	 * 	mostrar en enteros. 
	 */
	@SuppressWarnings("unchecked")
	public static void printGoleadores(int a, Torneo torneo){
		List<Jugador> goleadores = torneo.getGoleadores();
		System.out.println("GOLEADORES:");
		System.out.println(" _____________________________________________");
		System.out.println("|Goles|Jugador________________________________|");
		for (int i=0;i<a;i++){
			Jugador jugador = goleadores.get(i);
			int goles = jugador.getGoles();
			pipe();
			underScore();
			underScore();
			underScore();
			if (goles<10){
				underScore();
			}
			System.out.print(jugador.getGoles());
			pipe();
			int b = 39 - jugador.getNombre().length();
			System.out.print(jugador.getNombre());
			for (int c=0;c<b;c++){
				underScore();
			}
			pipe();
			System.out.println();
		}
	}
	/*
	 * 	Imprime en pantalla todos los partidos jugados en un determinado Torneo.
	 * 	Recibe: Torneo.
	 */
	@SuppressWarnings("unchecked")
	public static void printPartidos(Torneo torneo){
		List<Fecha> fechas = torneo.getFechas();
		System.out.println("Cantidad de fechas: "+ fechas.size());
		for (int i=0;i<fechas.size();i++){
			Fecha fecha = fechas.get(i);
			System.out.println("Fecha Numero "+(i+1));
			List<Partido> partidos = fecha.getPartidos();
			//System.out.println(partidos.size());
			for (int a=0;a<partidos.size();a++){
				Partido partido = partidos.get(a);
				Equipo local = partido.getLocal();
				Equipo visitante = partido.getVisitante();
				System.out.println("Partido Numero "+(a+1)+": "+local.getNombre()+ " vs "+ visitante.getNombre());
				System.out.println("Resultado: "+ partido.getGolesLocal()+ " - "+ partido.getGolesVisitante());
				System.out.println("GOLES:");
				List<Jugador> marcadores = partido.getMarcadores();
				for (int b=0;b<marcadores.size();b++){
					Jugador marcador = marcadores.get(b);
					System.out.println(marcador.getNombre());
				}
			System.out.println();
			}
		}
	}
	/*
	 * 	Imprime en pantalla los planteles de todos los equipos que participan en un torneo.
	 * 	Recibe: Torneo.
	 */
	@SuppressWarnings("unchecked")
	
	public static void printPlanteles(Torneo torneo){
		List<Equipo> equipos = torneo.getEquipos();
		for (int i=0;i<equipos.size();i++){
			Equipo equipo = equipos.get(i);
			System.out.println(equipo.getNombre());
			System.out.println(equipo.getPuntos());
			List<Jugador> jugadores = equipo.getJugadores();
			for (int a=0;a<jugadores.size();a++){
				Jugador jugador = jugadores.get(a); 
				System.out.print(jugador.getGoles()+" ");
				System.out.println(jugador.getNombre());
			}
		}
	}
	/*
	 * 	Imprime un espacio.
	 */
	public static void espacio(){
		System.out.print(" ");
	}
	public static void pipe(){
		System.out.print("|");
	}
	public static void underScore(){
		System.out.print("_");
	}
	/*
	 * 	M�todo main de la clase Test. Crea un torneo y hace una llamada a la clase Carga
	 *  para cargarle una lista de equipos con sus respectivos jugadores. Luego llama
	 *  a jugarTorneo() e imprime los resultados del torneo.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		File archivoEquipos = new File("equipos.txt");
		List<Equipo> equipos = Carga.cargarEquipos(archivoEquipos);
		Torneo torneo=new Torneo(equipos);
		printPlanteles(torneo);
		printPartidos(torneo);
		printGoleadores(5, torneo);
		printTablaDePosiciones(torneo);
	}
}
