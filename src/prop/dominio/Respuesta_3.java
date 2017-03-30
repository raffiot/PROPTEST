package prop.dominio;

public class Respuesta_3 extends RespuestaPregunta{

	private int value;
	
	
	public Respuesta_3(Pregunta p, int value) {
		super(p);
		this.value = value;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	public double distance(Respuesta_3 r){
		return (this.value==r.getValue()) ? 1 : 0;
		
	}
}
