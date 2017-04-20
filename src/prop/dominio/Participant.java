package prop.dominio;

/**
 * La classe Pregunta representa una persona que es participante, es decir, uan persona que responde encuestas.
 * 
 * @author Marina				
 */

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Participant extends Persona{
	private HashMap<Integer,List<RespuestaPregunta>> EncuestaNoAcabada;
	
	/**
	 * Constructor vacio de un participante
	 *
	 */
	public Participant(){
		EncuestaParticipant = new HashMap<Integer,RespuestaEncuesta>();
	}
	
	/**
	 * Metodo para guardar una encuesta que el participante no ha acabado de responder
	 * 
	 *
	 *@param idEncuesta
	 *		el identificador de la encuesta 
	 *@param r
	 *		array en la que se almacenan las respuestas que el participante ha respondido hasta el momento
	 */
	public void encuestanoacabada(Integer idEncuesta, ArrayList<RespuestaPregunta> r){
		
	}
	
	
}