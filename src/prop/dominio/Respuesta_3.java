package prop.dominio;


public class Respuesta_3 extends RespuestaPregunta{

	
	
	public Respuesta_3(Pregunta p, String value) {
		super(p,0,0,value,null,null);
	}
	
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2){
		return (this.getValueR3().equals(r.getValueR3())) ? 1 : 0;
		
	}
}
