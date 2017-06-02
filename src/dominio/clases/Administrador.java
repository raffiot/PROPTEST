package dominio.clases;

import java.io.Serializable;

/**
 * Clase que representa un administrador, un administrador puede gestionar encuestas y analizar las.
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Administrador extends Persona implements Serializable {

	
	/**
	 * Constructora de Administrador, el 0 del super indica que es administrador
	 * @param username
	 * @param password
	 */
	public Administrador(String username, String password){
		super(username,password,0);
	
	}

}
