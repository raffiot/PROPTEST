package prop.dominio;


public class Respuesta_2 extends RespuestaPregunta{

	private int value;
	
	
	public Respuesta_2(Pregunta p, int value) {
		super(p);
		this.value = value;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	public double distance(Respuesta_2 r, int size){
		return Math.abs(this.value-r.getValue())/((double)size);
		
	}

}
