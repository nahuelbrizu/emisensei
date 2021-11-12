package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import proceso.Equipo;
import proceso.Jugador;


public class Carga {
	
	/*
	 * 	Lee una lista de jugadores de un archivo de texto.
	 * 	Recibe: un archivo de texto con una lista de 11 jugadores, un jugador por línea.
	 * 	Devuelve: un objeto List en el que cada índice contiene un objeto Jugador.
	 */
	@SuppressWarnings("unchecked")
	protected static List cargarJugadores(File archivo){
		List<Jugador> jugadores = new ArrayList();
		int i=0;
		try{
			BufferedReader lectorJugadores = new BufferedReader(new FileReader(archivo));
			String temp = lectorJugadores.readLine();
			while (temp != null){
			Jugador jugador = new Jugador(temp,i+1);
			jugadores.add(i,jugador);
			temp = lectorJugadores.readLine();
			i++;					
			}
			lectorJugadores.close();
		} 
        catch (Exception e){
			System.err.println("Error al cargar archivo.");
        }
        return jugadores;
	}
	/*
	 * 	Lee una lista de equipos desde un archivo de texto. Haciendo una llamada a la función
	 * 	cargarJudadores, inicializa cada equipo con los jugadores correspondientes al archivo
	 * 	de texto con el mismo nombre del equipo.
	 * 	Recibe: un archivo de texto conteniendo una lista de equipos, un equipo por línea.
	 * 	Devuelve: un objeto List en el que cada índice contiene un objeto Equipo.
	 */
	@SuppressWarnings("unchecked")
	public static List cargarEquipos(File archivoEquipos) {
		List<Equipo> equipos = new ArrayList();
		int i = 0;
		try{
			BufferedReader lectorEquipos = new BufferedReader(new FileReader(archivoEquipos));
			String temp = lectorEquipos.readLine();
			while (temp != null){
				Equipo equipo = new Equipo(temp);
				/*
				 *	Setea a true el índice correspondiente a sí mismo en el array Jugado[] 
				 *	del equipo para que el equipo no juegue contra sí mismo.
				 */
				equipo.setJugado(i,true);
				File archivoJugadores = new File(equipo.getNombre() +".txt");
				equipos.add(i, equipo);
				equipos.get(i).setJugadores(cargarJugadores(archivoJugadores));
		        temp = lectorEquipos.readLine();
		        i++;		        
			}
			lectorEquipos.close();
		}
		catch (Exception e){
			System.err.println("Error al cargar archivo.");
		}
		return equipos;
	}
}
