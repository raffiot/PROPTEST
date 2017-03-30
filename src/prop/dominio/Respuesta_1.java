package prop.dominio;

public class Respuesta_1 extends RespuestaPregunta{

	
	private double value;
	
	public Respuesta_1(Pregunta p, int value) {
		super(p);
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public double distance(Respuesta_1 r, double min, double max){
		return Math.abs(this.value-r.getValue())/(max-min);
	}
	

}
