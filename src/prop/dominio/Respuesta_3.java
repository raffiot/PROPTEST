package prop.dominio;

import java.util.Set;

public class Respuesta_3 extends RespuestaPregunta{

	
	
	public Respuesta_3(Pregunta p, String value) {
		super(p,0,0,value,null);
	}
	
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2, String valueR3, Set<String> valueR4){
		return (this.getValueR3().equals(r.getValueR3())) ? 1 : 0;
		
	}
}
