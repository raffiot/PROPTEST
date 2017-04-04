package prop.dominio;

import java.util.Set;

public abstract class RespuestaPregunta {
	private Pregunta pregunta;
	private double valueR1;
	private int valueR2;
	private String valueR3;
	private Set<String> valueR4;
	
	public RespuestaPregunta(Pregunta p, double v1, int v2, String v3, Set<String> v4){
		this.pregunta = p;
		valueR1 = v1;
		valueR2 = v2;
		valueR3 = v3;
		valueR4 = v4;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	public abstract double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2);

	public double getValueR1() {
		return valueR1;
	}

	public void setValueR1(double valueR1) {
		this.valueR1 = valueR1;
	}

	public int getValueR2() {
		return valueR2;
	}

	public void setValueR2(int valueR2) {
		this.valueR2 = valueR2;
	}

	public String getValueR3() {
		return valueR3;
	}

	public void setValueR3(String valueR3) {
		this.valueR3 = valueR3;
	}

	public Set<String> getValueR4() {
		return valueR4;
	}

	public void setValueR4(Set<String> valueR4) {
		this.valueR4 = valueR4;
	}
}
