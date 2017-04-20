package prop.dominio;
/**
 * La classe Tipo_5 representa una pregunta que se responde con una(s) palabra(s) de format libre.
 * 
 * 
 * @author Miguel
 * @author Marina
 * @author Raphael 								
 */
public class Tipo_5 extends Pregunta {
	
	/**
	 * Constructor vacio de la pregunta de tipo 5
	 */
	public Tipo_5(){
		super();
		tipo = 5;
	}
	
	/**
	 * Constructor de una pregunta de tipo 5 con su identificador y su enunciado
	 * 
	 * @param id
	 * 		el identifacador de la pregunta
	 * @param enunciado
	 * 		el enunciado de la pregunta
	 */
	public Tipo_5(Integer id,String enunciado){
		super(id,enunciado);
		tipo = 5;
	}
	
	/**
	 * Methodo para passar la pregunta de tipo 5 en una string
	 * que contiene su identificador y su enunciado
	 * 
	 * @return
	 * 		la nueva string creada
	 */
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado + "\r\n";
		return s;
	}
	
	/**
	 * 
	 */
	public String guardar(){
		String s = "";
		s += tipo +"\r\n";
		s += enunciado + "\r\n";
		return s;
	}
	
	/**
	 * Methodo para generar una respuesta a la pregunta de tipo 5,
	 * se genera una respuesta vacia para las preguntas de format libre.
	 * 
	 * @return
	 * 		la respuesta generada para esa pregunta.
	 */
	public RespuestaPregunta generateAnswer(){
		return new Respuesta_5(this,"");
	}
}