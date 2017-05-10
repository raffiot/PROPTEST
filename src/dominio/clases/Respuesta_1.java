package dominio.clases;

import java.io.Serializable;

/**
 * Classe que representa la respuesta a una pregunta de tipo 1
 * 
 * @author Raphael
 *
 */
public class Respuesta_1 extends RespuestaPregunta implements Serializable{
	
	/**
	 * El constructor de la classe, se construye la respuesta con la pregunta y el valor de respuesta.
	 * 
	 * @param p
	 * 		La pregunta que se ha respondido
	 * @param value
	 * 		La valor que se ha respondido
	 */
	public Respuesta_1(Pregunta p, double value) {
		super(p,value,0,null,null,null);
	}
	
	/**
	 * Metodo para calcular la distancia entre nuesta respuesta y una respuesta a la misma pregunta pasado en parametro,
	 * necessiotemos tambien que especificar el minimo y el maximo a la pregunta para calcular la distancia.
	 * 
	 *  @param r
	 * 		la respuesta a la pregunta con la cual queremos calcular la distancia
	 *  @param minR1
	 *  	la respuesta minima a la pregunta
	 *  @param maxR1
	 *  	la respuesta maxima a la pregunta
	 *  @param sizeR2
	 *  	este parametro no sirve para respuesta a pregunta de tipo 1
	 *  	
	 */
	@Override
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2,String funR5){
		return Math.abs(this.getValueR1()-r.getValueR1())/(maxR1-minR1);
	}
	
	/**Metodo que hacer un Override sobre toString
	 * pasa una respuesta_1 a string
	 * 
	 * @return la string con las respuesta_1
	 */
	@Override
	public String toString(){
		String s = "";
		s += "	"+this.getValueR1()+"\n";
		return s;
	}
	
	
	
}
