package proceso;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private List<proceso.Equipo> equipos;
	@SuppressWarnings("unchecked")
	private List<Fecha> fechas = new ArrayList();
	@SuppressWarnings("unchecked")
	private List<Partido> todosLosPartidos = new ArrayList();
	/*
	 * 	Constructor. Llama a los m�todos para jugar los partidos de un torneo y
	 * 	generar sus fechas.
	 * 
	 * 	Recibe: un objeto List en el que cada uno de los �ndices contiene un objeto
	 * 	Equipo.
	 */

	@SuppressWarnings("unchecked")
	public Torneo(List equipos){
		setEquipos(equipos);
		jugarPartidos();
		generarFechas();
	}
	/*
	 * 	Juega los partidos de un torneo. Primero recursa todos los equipos del torneo,
	 * 	asign�ndole la condici�n de local a los equipos que se encuentran bajo �ndices
	 * 	pares y el cero. Luego por cada equipo recursa todos los equipos, y si el �ndice
	 * 	del array jugado[] del primer equipo correspondiente al segundo equipo contiene
	 * 	true, resuelve la local�a. Si no hay conflictos, crea un nuevo Objeto partido con
	 * 	ambos equipos como par�metros. Si las local�as son iguales, es local el equipo que
	 * 	menos veces jug� de local hasta el momento.
	 */
	@SuppressWarnings("unchecked")
	public void jugarPartidos(){
		List<Partido> todosLosPartidos = getTodosLosPartidos();
		List<Equipo> equipos = getEquipos();
		for (int i=0; i<equipos.size();i=i+2){
			equipos.get(i).setLocalia(true);
		}
		for (int i=0; i<equipos.size();i++){
			Equipo equipo1 = equipos.get(i);
			for (int a=0; a<equipos.size();a++){
				Equipo equipo2 = equipos.get(a);
				if (!equipo1.getJugado(a)){
					if ((equipo1.getLocalia()) && (!equipo2.getLocalia())){
						Partido partido = new Partido(equipo1,equipo2);
						equipo1.setJugado(a,true);
						equipo2.setJugado(i,true);
						todosLosPartidos.add(partido);
					}
					else if ((!equipo1.getLocalia()) && (equipo2.getLocalia())){
						Partido partido = new Partido(equipo2,equipo1);
						equipo1.setJugado(a,true);
						equipo2.setJugado(i,true);
						todosLosPartidos.add(partido);
					}
					else if (equipo1.getLocalia() == equipo2.getLocalia()){
						if (equipo1.getPartidosLocal()>equipo2.getPartidosLocal()){
							Partido partido = new Partido(equipo2,equipo1);
							equipo1.setJugado(a,true);
							equipo2.setJugado(i,true);
							todosLosPartidos.add(partido);
						} else {
							Partido partido = new Partido(equipo1,equipo2);
							equipo1.setJugado(a,true);
							equipo2.setJugado(i,true);
							todosLosPartidos.add(partido);
						}
					}
				}
			}
		}
	}
	/*
	 * 	Genera las fechas del torneo. 
	 * 	Se empieza con el primer partido y la primer fecha, se van poniendo
	 * 	los partidos en las sucesivas fechas. Cuando llega al pr�ximo equipo (esto
	 * 	se determina por el �ndice partidosAAgregar, que es decreciente desde
	 * 	cantidadDeFechas -para el primer equipo hay cantidadDeFechas partidos,
	 * 	para el segundo cantidadDeFechas-1, para el tercero cantidadDeFechas-2 y as�
	 * 	sucesivamente),	se empieza desde dos fechas m�s adelante que el equipo anterior.
	 * 	Se repite el proceso, fij�ndose en cada fecha que ninguno de los dos equipos haya
	 * 	jugado ya en esa fecha.
	 * 	Si jugaron ya, se pasa a la pr�xima fecha. Si la pr�xima fecha excede el l�mite de
	 * 	fechas cantidadDeFechas, se vuelve a la primer fecha
	 * 	(if (inicio+inc>cantidadDeFechas-1{inc=-inicio;}).
	 * 	Cuando la posici�n en la que se va a empezar a poner equipos es mayor al l�mite de 
	 * 	fechas,	a esa posici�n se le resta la cantidad de fechas para que empiece desde el
	 * 	principio en el pr�ximo ciclo,
	 * 	(if (inicio>cantidadDeFechas-1){inicio=inicio-cantidadDeFechas;}).
	 * 	Ejemplo con 8 equipos y 7 fechas:
	 *  (Primer equipo, Segundo equipo)
	 *   1	 2	 3	 4	 5	 6	 7	(Fechas)
	 *  1,2 1,3 1,4 1,5	1,6	1,7	1,8 (Primer partido de cada fecha)
	 *  3,7	2,8*2,3	2,4	2,5	2,6	2,7	(Segundo partido de cada fecha)
	 *  4,6	4,7	5,7	3,8*3,4	3,5	3,6	(Tercer partido de cada fecha)
	 *  5,8*5,6	6,8*6,7	7,8	4,8*4,5	(Cuarto partido de cada fecha)
	 */
	@SuppressWarnings("unchecked")
	public void generarFechas(){
		List<Fecha> fechas = getFechas();
		List<Partido> todosLosPartidos = getTodosLosPartidos();
		/*
		 * 	int cantidadDeFechas = la cantidad total de fechas a jugar(igual a la cantidad
		 * 	de equipos del torneo menos 1, ya que los equipos no juegan contra s� mismos.
		 */
		int cantidadDeFechas = getEquipos().size()-1;
		/*
		 * 	Inicializa todas las fechas.
		 */
		for (int i=0;i<cantidadDeFechas;i++){
			fechas.add(new Fecha());
		}
		/*
		 *	int inicio = Fecha en la que se empiezan a poner los partidos del equipo actual.
		 *	Empieza en 0 para el primer equipo, y se incrementa en 2 por cada ciclo
		 *	del while (!todosLosPartidos.isEmpty).
		 */
		int inicio=0;
		/*
		 *  int partidosAAgregar = la cantidad de partidos a agregar en cada ciclo del
		 *  while. Inicia en cantidadDeFechas para el primer equipo, decrece en 1 por cada
		 *  ciclo del while (!todosLosPartidos.isEmpty). 
		 */
		int partidosAAgregar=cantidadDeFechas;
		/*
		 * 	Ciclo principal que se repite hasta que la lista todosLosPartidos, que contiene
		 * 	todos los partidos jugados, est� vac�o.
		 */
		while (!todosLosPartidos.isEmpty()){
			/*
			 * 	int inc = incremento de las fechas. Este n�mero se incrementa en cada
			 * 	ciclo del while (partidosAgregados<partidosAAgregar). Se le suma a inicio
			 *  para determinar la fecha en la que se intentar� agregar el pr�ximo partido.
			 */
			int inc=0;
			/*
			 * 	int partidosAgregados = partidos ya agregados. Incrementa en 1 en los
			 * 	ciclos del while (partidosAgregados<partidosAAgregar) en los que se agreg�
			 * 	un partido a la fecha actual.
			 */
			int partidosAgregados=0;
			/*
			 * 	Ciclo en el que se agregan los partidos a las fechas. Se agregan partidos
			 * 	hasta que la cantidad de partidos agregados sea igual a la cantidad de
			 * 	partidos a agregar.
			 */
			while (partidosAgregados<partidosAAgregar){
				/*
				 * 	Si la posici�n en la que se va a intentar agregar el pr�ximo partido
				 * 	es mayor que el �ndice de la �ltima fecha, el incremento se setea en
				 * 	-inicio para que inicio+inc sea igual a 0 (se vuelve a la fecha en el
				 * 	�ndice 0).
				 */
				if (inicio+inc>cantidadDeFechas-1){
					inc = -inicio;
				}
				/*
				 * 	Se toma el partido ubicado en el �ndice 0 de la lista de todos los
				 * 	partidos, y sus equipos local y visitante se asignan a variables.
				 */
				Partido partido = todosLosPartidos.get(0);
				Equipo local = partido.getLocal();
				Equipo visitante = partido.getVisitante();
				/*
				 * 	Se toma la fecha actual en la que se va a intentar agregar este partido.
				 * 	Se hace una lista de partidos con los partidos que ya tiene esta fecha.
				 */
				Fecha fecha = fechas.get(inicio+inc);
				List<Partido> partidos = fecha.getPartidos();
				/*
				 * 	boolean saltear = booleano que determina si se saltea esta fecha sin
				 * 	agregar este partido.
				 */
				boolean saltear = false;
				/*
				 *  For que cicla por todos los partidos que ya tiene esta fecha, comparando
				 *  los equipos local y visitante del partido actual con las variables
				 *  correspondientes al partido en el �ndice 0. Si alguno de los equipos
				 *  ya jug� en esta fecha, se setea el valor de saltear a true.
				 */
				for (int b=0; b<partidos.size();b++){
					Partido partido2 = partidos.get(b);
					Equipo local2 = partido2.getLocal();
					Equipo visitante2 = partido2.getVisitante();
					if ((local2.equals(local)) || (local2.equals(visitante)) || (visitante2.equals(local)) || (visitante2.equals(visitante))){
						saltear=true;
					}
				}
				/*
				 * 	Si el valor de saltear es false, agrega el partido en el �ndice 0 de la
				 * 	lista todosLosPartidos a la fecha actual e incrementa el n�mero de
				 * 	partidos agregados. El m�todo remove(int n) de la clase List saca el
				 * 	objeto del �ndice n de la lista, y corre todos los dem�s �ndices hacia
				 * 	la izquierda (el objeto del �ndice 1 pasa a ser el del �ndice 0, el del
				 * 	2 pasa a estar en el 1, y as� sucesivamente). Por lo tanto, adem�s de
				 * 	agregar el partido a la fecha, lo saca de la lista de todos los partidos.
				 */
				if (!saltear){
				fecha.agregarPartido(todosLosPartidos.remove(0));
				partidosAgregados++;
				}
				/*
				 * 	Incrementa en 1 la variable inc para que en el pr�ximo ciclo del while
				 * 	se intente agregar el partido a la pr�xima fecha.
				 */
				inc++;	
			}
			/*
			 * 	Decrece la cantidad de partidos a agregar, para que en el pr�ximo ciclo
			 * 	se agregue un partido menos. Esto es porque en la lista de todos los partidos
			 * 	el primer equipo tiene cantidadDeFechas partidos, el segundo uno menos, el
			 * 	tercero dos menos, y as� sucesivamente. 
			 */
			partidosAAgregar--;
			/*
			 * 	Se incrementa en 2 el inicio para que en el pr�ximo ciclo se empiece a
			 * 	agregar partidos desde dos fechas m�s adelante. El if asegura que no se
			 * 	intentar� meter equipos en una fecha que no existe (mayor que la cantidad
			 * 	total de fechas -1).
			 */
			inicio=inicio+2;
			if (inicio>cantidadDeFechas-1){
				inicio = inicio-cantidadDeFechas;
			}
		}
	}
	/*
	 * 	Resuelve las posiciones finales de un torneo a partir de su atributo equipos. 
	 * 	Por cada equipo en la lista chequea si el pr�ximo equipo en la lista tiene
	 * 	un puntaje mayor, y si es as�, intercambia sus posiciones en la lista. Si los
	 * 	puntajes son iguales, chequea si el pr�ximo equipo tiene una diferencia de goles
	 * 	mayor, y si es as�, intercambia sus posiciones en la lista. Repite este proceso
	 * 	tantas veces como equipos hay en la lista, dando como resultado	final un objeto
	 *  List con los mismos equipos ordenados por puntaje en el que el primero es el que
	 *  m�s puntos y mejor diferencia de gol tiene y el �ltimo el que menos.
	 * 	Devuelve: un objeto List ordenado por puntaje y diferencia de goles en el que
	 *  cada �ndice contiene un objeto equipo.
	 */
	@SuppressWarnings("unchecked")
	public List getPosiciones(){
		List<Equipo> posiciones = new ArrayList();
		List<Equipo> equipos = getEquipos();
		for (int i=0;i<equipos.size();i++){
			posiciones.add(i, equipos.get(i));
		}
		for (int i=0;i<posiciones.size()-1;i++){
			for (int a=0;a<(posiciones.size()-1);a++){
				for(int b=0;b<(posiciones.size()-1);b++){
					Equipo equipo1=(posiciones.get(b));
					Equipo equipo2=(posiciones.get(b+1));
					if(equipo1.getPuntos()<equipo2.getPuntos()){
						Equipo temp = equipo1;
						posiciones.remove(b);
						posiciones.add(b,equipo2);
						posiciones.remove(b+1);
						posiciones.add(b+1, temp);
					}
					if (equipo1.getPuntos()==equipo2.getPuntos()){
						if (equipo1.getDiferenciaDeGol()<equipo2.getDiferenciaDeGol()){
							Equipo temp = equipo1;
							posiciones.remove(b);
							posiciones.add(b,equipo2);
							posiciones.remove(b+1);
							posiciones.add(b+1, temp);
						}
					}
				}
			}
		}
			return posiciones;
	}
	/*
	 * 	M�todo auxiliar que recibe una lista de equipos y devuelve una lista con todos los
	 * 	jugadores de esos equipos.
	 * 	Recibe: un objeto List en el que cada �ndice contiene un objeto Equipo.
	 * 	Devuelve: un objeto List en el que cada �ndice contiene un objeto Jugador. 
	 */
	@SuppressWarnings("unchecked")
	protected List getTodosLosJugadores(){
		List<Jugador> todosLosJugadores = new ArrayList();
		List<Equipo> equipos = getEquipos();
		int b = 0;
		for (int i=0;i<equipos.size();i++){
			Equipo equipo = equipos.get(i);
			List<Jugador> jugadores = equipo.getJugadores();
			for (int a=0;a<jugadores.size();a++){
				Jugador jugador = jugadores.get(a);
				todosLosJugadores.add(b,jugador);
				b++;
			}
		}
		return todosLosJugadores;
	}
	/*
	 * 	Determina los goleadores del torneo.
	 * 	Devuelve: un objeto List en el que cada �ndice contiene un jugador ordenado
	 * 	por cantidad de goles en la que el primer jugador es el que m�s goles tiene
	 * 	y el �ltimo el que menos.
	 */
	@SuppressWarnings("unchecked")
	public List getGoleadores(){
		List<Jugador> todosLosJugadores = getTodosLosJugadores();
		for (int a=0;a<(todosLosJugadores.size()-1);a++){
			for (int i=0;i<(todosLosJugadores.size()-1);i++){
				Jugador jugador1 = todosLosJugadores.get(i);
				Jugador jugador2 = todosLosJugadores.get(i+1);
				if (jugador1.getGoles()<jugador2.getGoles()){
					Jugador temp = jugador1;
					todosLosJugadores.remove(i);
					todosLosJugadores.add(i,jugador2);
					todosLosJugadores.remove(i+1);
					todosLosJugadores.add(i+1,temp);
				}
			}
		}
		List goleadores = todosLosJugadores;
		return goleadores;
	}
	public List getTodosLosPartidos(){
		return todosLosPartidos;
	}
	
	public List getFechas() {
		return fechas;
	}
	public List getEquipos() {
		return equipos;
	}
	@SuppressWarnings("unchecked")
	public void setEquipos(List equipos) {
		this.equipos=equipos;
	}
}
