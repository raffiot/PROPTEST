package prop.dominio;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Participant extends Persona{
	private HashMap<Integer,List<RespuestaPregunta>> EncuestaNoAcabada;
	
	
	public Participant(){
		EncuestaParticipant = new HashMap<Integer,RespuestaEncuesta>();
	}
	
	/*public void rellenarInformacion(RespuestaEncuesta re){
		Integer idEncuesta = e.getId();
		EncuestaParticipant.put(idEncuesta,re.getRespPreguntas());
	}*/
	
	public void encuestanoacabada(Integer idEncuesta, ArrayList<RespuestaPregunta> r){
		
	}
	
}