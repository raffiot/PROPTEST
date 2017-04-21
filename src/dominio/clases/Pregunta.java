package dominio.clases;

/**
 * La classe Pregunta representa una pregunta.
 * 
 * @author Miguel					
 */

public abstract class  Pregunta {
	public Integer id;
	public String enunciado;
	public Integer tipo;
	
	/**
	 * Constructor vacio de una pregunta
	 * 
	 */
	public Pregunta(){
		this.id = null;
		this.enunciado = null;
		this.tipo = null;
	}
	
	/**
	 * Constructor de una pregunta
	 * 
	 * @param  id
	 * 		el identificador de la pregunta
	 * @param enunciado
	 * 		el enunciado de la pregunta
	 */
	public Pregunta(Integer id, String enunciado) {
		this.id = id;
		this.enunciado = enunciado;
	}
	
	/**
	 * Metodo para obtener el identificador de la pregunta con la que tratamos
	 * 
	 * @return
	 * 		el identificador de la pregunta
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo para modificar el identificador de la pregunta
	 * 
	 * @param id
	 * 		el identificador de la pregunta 
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo para obtener el enunciado de la pregunta con la que tratamos
	 * 
	 * @return
	 * 		el enunciado de la pregunta
	 */
	public String getEnunciado() {
		return enunciado;
	}
	
	/**
	 * Metodo para modificar el enunciado de la pregunta
	 * 
	 * @param enunciado
	 * 		el enunciado de la pregunta 
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	/**
	 * Metodo para obtener el tipo de la pregunta con la que tratamos
	 * 
	 * @return
	 * 		el tipo de la pregunta
	 */
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * Metodo para modificar el tipo de la pregunta
	 * 
	 * @param tipo
	 * 		el tipo de la pregunta 
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public abstract String toString();
	
	public abstract String guardar();
	
	public abstract RespuestaPregunta generateAnswer();
	

}
