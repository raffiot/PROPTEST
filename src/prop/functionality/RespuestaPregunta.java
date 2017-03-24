
public class RespuestaPregunta {
	private Pregunta pregunta;
	
	public RespuestaPregunta(Pregunta p){
		this.pregunta = p;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
