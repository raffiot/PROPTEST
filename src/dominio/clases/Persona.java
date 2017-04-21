package prop.dominio;

/**
 * La classe Pregunta representa una pregunta.
 * 
 * @author Marina
 * 				
 */

public class Persona {
	Integer id;
	String nombre;
	String password;
	
	/**
	 * Constructor vacio de una persona
	 * 
	 */
	
	public Persona(){
		id = 0;
		nombre= "";
		password = "";
	}
	
	/**
	 * Constructor de una persona con diferentes parametros
	 * 
	 * @param nombre
	 * 		el nombre que identifica una persona/usuario
	 * @password
	 * 		la contrasenya de ese nombre/usuario
	 * 
	 */
	public Persona(String nombre, String password){
		this.nombre = nombre;
		this.password = password;
	}
	
	/**
	 * Metodo para obtener el nombre de la persona con la que tratamos
	 * 
	 * @return
	 * 		el nombre de la persona tratada
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Metodo para modificar el nombre de la persona con la que tratamos
	 * 
	 * @param nombre
	 * 		el nombre de la persona
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	/**
	 * Metodo para obtener el password de la persona con la que tratamos
	 * 
	 * @return
	 * 		el password de la persona tratada
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * Metodo para modificar el password de la persona con la que tratamos
	 * 
	 * @param nombre
	 * 		el password de la persona tratada
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
}
