package dominio.clases;

/**
 * La clase Pregunta representa una persona que es participante, es decir, uan persona que responde encuestas.
 * 
 * @author Marina				
 */

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.List;

public class Participant extends Persona{
	private HashMap<Integer,ArrayList<RespuestaPregunta>> EncuestaNoAcabada;
	
	/**
	 * Constructor vacio de un participante
	 *
	 */
	public Participant(){
		EncuestaNoAcabada = new HashMap<Integer,ArrayList<RespuestaPregunta>>();
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
