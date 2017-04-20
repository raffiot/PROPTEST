package prop.dominio;

/**
 * La classe Pregunta representa una pregunta.
 * 
 * @author Marina
 * @author Miguel
 * @author Raphael					
 */

import java.util.HashSet;
import java.util.Set;

public abstract class RespuestaPregunta {
	private Pregunta pregunta;
	private double valueR1;
	private int valueR2;
	private String valueR3;
	private Set<String> valueR4;
	private String valueR5;
	
	/**
	 * 
	 * Constructor de respuesta pregunta con su pregunta y todos los posibles valores de cada posible respuesta
	 * 
	 * @param p
	 * 		la pregunta de la respuesta pregunta
	 * @param v1
	 * 		valor de la respuesta pregunta tipo 1
	 * @param v2
	 * 		valor de la respuesta pregunta tipo 2
	 * @param v3
	 * 		valor de la respuesta pregunta tipo 3
	 * @param v4
	 * 		valor de la respuesta pregunta tipo 4
	 * @param v5
	 * 		valor de la respuesta pregunta tipo 5
	 */
	public RespuestaPregunta(Pregunta p, double v1, int v2, String v3, Set<String> v4, String v5){
		this.pregunta = p;
		valueR1 = v1;
		valueR2 = v2;
		valueR3 = v3;
		valueR4 = v4;
		valueR5 = v5;
	}

	/**
	 * Constructor de una respuesta pregunta
	 * @param p
	 * 		pregunta que respondemos
	 */
	public RespuestaPregunta(Pregunta p){
		this.pregunta = p;
	}
	
	/**
	 * Metodo para obtener la pregunta con la que tratamos
	 * 
	 * @return
	 * 		la pregunta de esta respuesta pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * Metodo para modificar la pregunta
	 * 
	 * @param pregunta
	 * 		la nueva pregunta 
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
	public abstract double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2);

	/**
	 * Metodo para obtener el valor de la respuesta pregunta tipo 1
	 * 
	 * @return
	 * 		el valor de la respuesta tipo 1
	 */
	public double getValueR1() {
		return valueR1;
	}

	/**
	 * Metodo para modificar el valor de la respuesta pregunta tipo 1
	 * 
	 * @param
	 * 		el valor de la respuesta pregunta tipo 1
	 */
	public void setValueR1(double valueR1) {
		this.valueR1 = valueR1;
	}

	/**
	 * Metodo para obtener el valor de la respuesta pregunta tipo 2
	 * 
	 * @return
	 * 		el valor de la respuesta tipo 2
	 */
	public int getValueR2() {
		return valueR2;
	}

	/**
	 * Metodo para modificar el valor de la respuesta pregunta tipo 2
	 * 
	 * @param
	 * 		el valor de la respuesta pregunta tipo 2
	 */
	public void setValueR2(int valueR2) {
		this.valueR2 = valueR2;
	}

	/**
	 * Metodo para obtener el valor de la respuesta pregunta tipo 3
	 * 
	 * @return
	 * 		el valor de la respuesta tipo 3
	 */
	public String getValueR3() {
		return valueR3;
	}

	/**
	 * Metodo para modificar el valor de la respuesta pregunta tipo 3
	 * 
	 * @param
	 * 		el valor de la respuesta pregunta tipo 3
	 */
	public void setValueR3(String valueR3) {
		this.valueR3 = valueR3;
	}

	/**
	 * Metodo para obtener el valor de la respuesta pregunta tipo 4
	 * 
	 * @return
	 * 		el valor de la respuesta tipo 4
	 */
	public Set<String> getValueR4() {
		return valueR4;
	}

	/**
	 * Metodo para modificar el valor de la respuesta pregunta tipo 4
	 * 
	 * @param
	 * 		el valor de la respuesta pregunta tipo 4
	 */
	public void setValueR4(Set<String> valueR4) {
		this.valueR4 = valueR4;
	}
	
	/**
	 * Metodo para obtener el valor de la respuesta pregunta tipo 5
	 * 
	 * @return
	 * 		el valor de la respuesta tipo 5
	 */
	public String getValueR5() {
		return valueR5;
	}

	/**
	 * Metodo para modificar el valor de la respuesta pregunta tipo 5
	 * 
	 * @param
	 * 		el valor de la respuesta pregunta tipo 5
	 */
	public void setValueR5(String valueR5) {
		this.valueR5 = valueR5;
	}

	/**
	 * Metodo para clonar la respuesta a una pregunta
	 * 
	 * @return
	 * 		la pregunta clonado
	 */
	//The default is a type_1 answer, it only clone the answer not the pregunta
	@Override
	public RespuestaPregunta clone(){
		RespuestaPregunta r;
		switch(pregunta.tipo){
			case 1:
				r = new Respuesta_1(pregunta,valueR1);
				break;
			case 2:
				r = new Respuesta_2(pregunta,valueR2);
				break;
			case 3:
				r = new Respuesta_3(pregunta,valueR3);
				break;
			case 4:
				Set<String> s = new HashSet<String>();
				for(String str : valueR4){
					s.add(str);
				}
				r = new Respuesta_4(pregunta,s);
				break;
			case 5:
				r = new Respuesta_5(pregunta,valueR5);
				break;
			default :
				r = null;
		}
		return r;
	}
}