package dominio.clases;

import java.io.Serializable;
import java.util.HashMap;

import persistencia.Persistencia;
import persistencia.Persistencia_Respuesta;

public class Cjt_respuestas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer,RespuestaEncuesta> respuestas;
	final String pathRespuestas = "Data/Respuestas/respuestas.dat";
	
	public Cjt_respuestas(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();
		respuestas = p.leer(pathRespuestas);
	}
	
	public void guardar(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();	
		p.escribir(pathRespuestas,respuestas);
	}
		
}
