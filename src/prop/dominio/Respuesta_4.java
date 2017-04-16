package prop.dominio;

import java.util.Set;

public class Respuesta_4 extends RespuestaPregunta{
	
	
	public Respuesta_4(Pregunta p, Set<String> value) {
		super(p,0,0,null,value,null);
	}

	
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
