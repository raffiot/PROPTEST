package prop.dominio;
/**
 * Classe que representa una respuesta a una pregunta de tipo 2
 * 
 * @author Raphael
 *
 */


public class Respuesta_2 extends RespuestaPregunta{
	
	/**
	 * Constructor de la classe con la pregunta a la cual se responde y el indice de la valor que se ha respondido
	 * 
	 * @param p
	 * 		La pregunta que se responde
	 * @param value
	 * 		El indice de la respuesta que se ha respondido
	 */
	public Respuesta_2(Pregunta p, int value) {
		super(p,0,value,null,null,null);
	}

	/**
	 * Metodo que permite calcular la distancia entre dos respuesta a la misma pregunta de tipo 2
	 * 
	 * @param r
	 * 		la respuesta a la pregunta con la cual queremos calcular la distancia
	 * @param minR1
	 * 		este parametro no sirve en este caso
	 * @param maxR1
	 * 		este parametro no sirve en este caso
	 * @param sizeR2
	 * 		el numero de opciones que hay en la pregunta
	 */
	@Override
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2){
		return Math.abs(this.getValueR2()-r.getValueR2())/((double)sizeR2);
		
	}

}
