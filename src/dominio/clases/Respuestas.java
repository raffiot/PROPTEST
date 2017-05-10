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
	
	@SuppressWarnings("unchecked")
	public Respuestas(){
		this.respuestas = (HashMap<Integer, RespuestaEncuesta>) Persistencia.leer("Data/Respuestas"); 
	}
	
	public void guardar(){
		Persistencia.escribir(respuestas, "Data/Respuestas");
	}
		
}
