package prop.dominio;
/**
 * Classe que representa una respuesta a una pregunta de tipo 3
 * 
 * @author Raphael
 *
 */

public class Respuesta_3 extends RespuestaPregunta{

	
	/**
	 * Constructor de la classe con la pregunta a la cual se responde y el valor que se ha respondido
	 * 
	 * @param p
	 * 		La pregunta que se responde
	 * @param value
	 * 		El valor que se ha respondido
	 */	
	public Respuesta_3(Pregunta p, String value) {
		super(p,0,0,value,null,null);
	}
	
	/**
	 * Metodo que permite calcular la distancia entre dos respuesta a la misma pregunta de tipo 3
	 * 
	 * @param r
	 * 		la respuesta a la pregunta con la cual queremos calcular la distancia
	 * @param minR1
	 * 		este parametro no sirve en este caso
	 * @param maxR1
	 * 		este parametro no sirve en este caso
	 * @param sizeR2
	 * 		este parametro no sirve en este caso
	 */
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2){
		return (this.getValueR3().equals(r.getValueR3())) ? 1 : 0;
		
	}
	public String toString(){
		String s = "";
		s += this.getPregunta().getEnunciado()+"\n";
		s += this.getValueR3()+"\n";
		return s;
	}
	
}
