package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import persistencia.Persistencia;
import persistencia.Persistencia_Respuesta;
/**
 * Clase que representa un conjunto de de respuestas encuestas ordenadas que se cargan al iniciar el programa.
 * HashMap<Integer, Respuesta_Analisis> -> el Integer corresponde al index de la encuesta,
 * la Respuesta_Analisis es un conjunto de respuestas a la encuesta
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Cjt_respuestas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Integer es el index de la encuesta
	//
	private HashMap<Integer, Respuesta_Analisis> respuestas;
	final String pathRespuestas = "Data/Respuestas/respuestas.dat";
	
	/**
	 * Creadora de la classe que inicialize la estructura HAshMap
	 */
	public Cjt_respuestas(){
		respuestas = new HashMap<>();
	}
	
	/**
	 * Metodo para leer las respuestas a encuestas desde un binario
	 */
	public void leerResp(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();
		respuestas = p.leer(pathRespuestas);
	}
	
	/**
	 * Metodo para guardar las respuestas a encuestas en binario
	 */
	public void guardarResp(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();	
		p.escribir(pathRespuestas,respuestas);
	}
	

	/**
	 * Metodo para anadir una respuesta a encuesta para que se guarda en el binario despues
	 * 
	 * @param i
	 * 		el index de la encuesta
	 * @param re
	 * 		la respuesta encuesta que se quiere guardar
	 */
	public void addResp(RespuestaEncuesta re){

		int index = re.getEncuesta().getId();
		if(!respuestas.containsKey(index)){
			ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
			listRE.add(re);
			Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
			respuestas.put(index, ra);
		}
		else{
			respuestas.get(index).getListRP().removeIf(respEnc -> respEnc.getNombre().equals(re.getNombre()));
			respuestas.get(index).addRespuestaEncuesta(re);
		}
	}
	
	/**
	 * Metodo para obtenir la lista de respuesta a encuestas
	 * 
	 * @return
	 * 		la lista de respuesta a encuesta
	 */
	public HashMap<Integer, Respuesta_Analisis> getRespuestas() {
		return respuestas;
	}	
	
}
