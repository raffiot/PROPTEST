package prop.dominio;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Participant extends Persona{
	private Encuesta e;
	private HashMap<Integer,RespuestaEncuesta> EncuestaParticipant;
	
	
	public Participant(){
		EncuestaParticipant = new HashMap<Integer,RespuestaEncuesta>();
	}
	
	public void contestarEncuesta(){
		Integer idEncuesta = e.getId();
		EncuestaParticipant.put(idEncuesta,new RespuestaEncuesta());
		
		
	}
	
	public void rellenarInformacion(RespuestaEncuesta re){
		Integer idEncuesta = e.getId();
		EncuestaParticipant.put(idEncuesta,re);
	}
	
}