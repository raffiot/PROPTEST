package prop.dominio;

/**
 * La classe Tipo_1 representa una pregunta que se responde con un sol valor numeric o qualitativa.
 * 
 * @author Marina
 * @author Miguel
 * @author Raphael							
 */

public class Tipo_1 extends Pregunta {
	
	private Integer opciones;
	private Integer max;
	private Integer min;
	
	/**
	 * Constructor vacio de la pregunta de tipo 1
	 */
	public Tipo_1(){
		super();
		tipo = 1;
	}
	
	/**
	 * 
	 * Constructor de pregunta de tipo 1 con su identificador, su enunciado,
	 * el numero de opciones el valor maximo que se puede responder a la pregunta y
	 * el valor minimo que se puede responder a la pregunta.
	 * 
	 * @param id
	 * 		el identificador de la pregunta
	 * @param enunciado
	 * 		el enunciado de la pregunta
	 * @param opciones
	 * 		el numero de opciones que se puede eligir en una pregunta que se responde con un valor qualitativa
	 * 		sino 1.
	 * @param max
	 * 		el valor maximo que se puede responder a la pregunta
	 * @param min
	 * 		el valor minimo que se puede responder a la pregunta
	 */
	
	public Tipo_1(Integer id, String enunciado, Integer opciones, Integer max, Integer min){
		super(id,enunciado);
		tipo = 1;
		this.opciones = opciones;
		this.max = max;
		this.min = min;
	}
	
	/**
	 * Methodo para obtener el numero de opciones que se pueden eligir 
	 * 
	 * @return
	 * 		el numero de opciones
	 */
	public int getOpciones() {
		return opciones;
	}
	
	/**
	 * Metodo para modificar el numero de opciones que se pueden eligir 
	 * 
	 * @param opciones
	 * 		el nuevo numero de opciones.
	 */
	public void setOpciones(int opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Metodo para obtener el valor maximo que se puede responder a la pregunta
	 * 
	 * @return
	 * 		el valor maximo
	 */
	public int getMax() {
		return max;
	}
	
	/**
	 * Metodo para modificar el valor maximo que se puede responder a la pregunta
	 * 
	 * @param max
	 * 		el nuevo valor maximo
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * Metodo para obtener el valor minimo que se puede responder a la pregunta
	 * 
	 * @return
	 * 		el valor minimo
	 */
	public int getMin() {
		return min;
	}
	
	/**
	 * Metodo para modificar el valor minimo que se puede responder a la pregunta
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	
	//If the answer is of type numeric free it will be a long long list.
	
	/**
	 * Metodo que convierte una pregunta Tipo_1 en una string con sus opciones
	 * 
	 * @return devuelve la pregunta en formato String
	 */
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\r\n";
		for (int i = min; i < max+1; ++i) s += "- "+ i + "\r\n";
		return s;
	}
	
	/**
	 * Metodo que convierte una pregunta Tipo_1 en una string con sus opciones
	 * en el formato correspondiente para guadar la pregunta en un txt
	 * 
	 * @return devuelve una string con la pregunta en formato para guardar en txt
	 */
	public String guardar() {
		String s = "";
		s += tipo+"\r\n";
		s += enunciado +"\r\n";
		s += this.min + "\r\n";
		s += this.max + "\r\n";
		return s;
		
	}
	
	/**
	 * Metodo para generar una respuesta aleatoria (entre el maximo y el minimo) a esa pregunta
	 * 
	 * @return
	 * 		la respuesta a la pregunta
	 */
	public RespuestaPregunta generateAnswer(){
		double value = min + (max - min)*Math.random();
		RespuestaPregunta r = new Respuesta_1(this,value);
		return r;
	}
	
}