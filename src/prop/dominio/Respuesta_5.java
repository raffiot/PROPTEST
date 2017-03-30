package prop.dominio;

public class Respuesta_5 extends RespuestaPregunta{
	
	private String value;
	
	public Respuesta_5(Pregunta p, String value) {
		super(p);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
