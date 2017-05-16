package dominio.clases;

import java.io.Serializable;

/**
 * La clase Usuario representa una persona que es participante, es decir, una persona que responde encuestas.
 * 
 * @author Marina				
 */


import java.util.ArrayList;
import java.util.HashMap;


public class Usuario extends Persona implements Serializable{
	private HashMap<Integer,ArrayList<RespuestaPregunta>> EncuestaNoAcabada;
	
	/**
	 * Constructor vacio de un participante
	 *
	 */
	public Usuario(String username, String password){
		super(username,password,1);
		
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
