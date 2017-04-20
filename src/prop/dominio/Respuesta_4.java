package prop.dominio;
/**
 * Classe que representa una respuesta a una pregunta de tipo 4
 * 
 * @author Raphael
 *
 */
import java.util.Set;

public class Respuesta_4 extends RespuestaPregunta{
	
	/**
	 * Constructor de la classe con la pregunta a la cual se responde y los valores que se ha respondido
	 * 
	 * @param p
	 * 		La pregunta que se responde
	 * @param value
	 * 		El set de valor que se ha respondido
	 */
	public Respuesta_4(Pregunta p, Set<String> value) {
		super(p,0,0,null,value,null);
	}

	/**
	 * Metodo que permite calcular la distancia entre dos respuesta a la misma pregunta de tipo 4
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
		Set<String> respuesta1 = this.getValueR4();
		Set<String> respuesta2 = r.getValueR4();
		double icounter = respuesta1.size();
		for(String s : respuesta2){
			if(!respuesta1.contains(s)){
				icounter++;
			}
		}
		
		double ucounter = respuesta1.size() + respuesta2.size() - icounter;
		
		return 1-(icounter/ucounter);
		
	}
	
}
