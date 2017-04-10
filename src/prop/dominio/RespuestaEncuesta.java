package prop.dominio;

import java.util.ArrayList;
import java.util.List;

public class RespuestaEncuesta {
	private Encuesta encuesta;
	private Participant participant;//identificador de participante solo
	private List<RespuestaPregunta> respPreguntas;
	
	public RespuestaEncuesta(Encuesta e, Participant p, List<RespuestaPregunta> rp){
		encuesta = e;
		participant = p;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	public RespuestaEncuesta(){
		
	}
	
	//Particular constructor for centroids RespuestaEncuesta
	public RespuestaEncuesta(Encuesta e, List<RespuestaPregunta> rp){
		encuesta = e;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	public Encuesta getEncuesta(){
		return encuesta;		
	}

	public List<RespuestaPregunta> getRespPreguntas() {
		return respPreguntas;
	}
	
}
