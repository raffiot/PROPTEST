package dominio.clases;

import java.io.Serializable;
import java.util.HashMap;

import persistencia.Persistencia;

public class Respuestas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer,RespuestaEncuesta> respuestas;
	final String pathRespuestas = "Data/Respuestas";
	
	public Respuestas(){
		HashMap<Integer,RespuestaEncuesta> aux = new HashMap<Integer,RespuestaEncuesta>();
		Persistencia<HashMap<Integer,RespuestaEncuesta>> p = new Persistencia<HashMap<Integer,RespuestaEncuesta>>(aux);
		p.leer(pathRespuestas);
		respuestas = aux;
	}
	
	public void guardar(){
		HashMap<Integer,RespuestaEncuesta> aux = respuestas;
		Persistencia<HashMap<Integer,RespuestaEncuesta>> p = new Persistencia<HashMap<Integer,RespuestaEncuesta>>(aux);		
		p.escribir(pathRespuestas);
	}
		
}
