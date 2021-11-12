package proceso;

import java.util.*;

public class Fecha {
	@SuppressWarnings("unchecked")
	private List<Partido> partidos = new ArrayList();
	public void agregarPartido(Partido partido){
		this.partidos.add(partido);
	}
	public List getPartidos(){
		return partidos;
	}
}
