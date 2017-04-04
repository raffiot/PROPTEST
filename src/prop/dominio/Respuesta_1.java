package prop.dominio;

public class Respuesta_1 extends RespuestaPregunta{
	
	public Respuesta_1(Pregunta p, double value) {
		super(p,value,0,null,null);
	}
	
	@Override
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2){
		return Math.abs(this.getValueR1()-r.getValueR1())/(maxR1-minR1);
	}
	
	
}
