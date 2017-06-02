package dominio.clases;

import java.io.Serializable;

/**
 * La clase Usuario representa una persona que es participante, es decir, una persona que responde encuestas.
 * 
 * @author Marina				
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa un usuario, el usuario solamente puede responder a encuestas.
 * 
 * @author Miguel
 * @author Marina
 * @author Raphael
 *
 */
public class Usuario extends Persona implements Serializable{

	private HashMap<Integer,ArrayList<RespuestaPregunta>> EncuestaNoAcabada;
	
	/**
	 * Constructor de un participante
	 *
	 * @param username
	 * 		el nombre del usuario
	 * @param password
	 * 		la contrasena del usuario
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
