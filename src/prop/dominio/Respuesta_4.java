package prop.dominio;

import java.util.HashSet;
import java.util.Set;

public class Respuesta_4 extends RespuestaPregunta{
	
	private Set<String> respuestas;
	
	public Respuesta_4(Pregunta p, Set<String> respuestas) {
		super(p);
		this.respuestas = respuestas;
	}

	public Set<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<String> respuestas) {
		this.respuestas = respuestas;
	}
	
	public double distance(Respuesta_4 r){
		double icounter = respuestas.size();
		for(String s : r.getRespuestas()){
			if(!respuestas.contains(s)){
				icounter++;
			}
		}
		
		double ucounter = respuestas.size() + r.getRespuestas().size() - icounter;
		
		return 1-(icounter/ucounter);
		
	}
	
}
