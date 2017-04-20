package prop.dominio;

import java.util.HashSet;
import java.util.Set;

public abstract class RespuestaPregunta {
	private Pregunta pregunta;
	private double valueR1;
	private int valueR2;
	private String valueR3;
	private Set<String> valueR4;
	private String valueR5;
	
	public RespuestaPregunta(Pregunta p, double v1, int v2, String v3, Set<String> v4, String v5){
		this.pregunta = p;
		valueR1 = v1;
		valueR2 = v2;
		valueR3 = v3;
		valueR4 = v4;
		valueR5 = v5;
	}

	public RespuestaPregunta(){
		
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
	
	public String getValueR5() {
		return valueR5;
	}

	public void setValueR5(String valueR5) {
		this.valueR5 = valueR5;
	}

	//The default is a type_1 answer, it only cone the answer not the pregunta
	@Override
	public RespuestaPregunta clone(){
		RespuestaPregunta r;
		switch(pregunta.tipo){
			case 1:
				r = new Respuesta_1(pregunta,valueR1);
				break;
			case 2:
				r = new Respuesta_2(pregunta,valueR2);
				break;
			case 3:
				r = new Respuesta_3(pregunta,valueR3);
				break;
			case 4:
				Set<String> s = new HashSet<String>();
				for(String str : valueR4){
					s.add(str);
				}
				r = new Respuesta_4(pregunta,s);
				break;
				/*
			case 5:
				RespuestaPregunta r5 = new Respuesta_5(pregunta,valueR5);
				return r3;
				break;*/
			default :
				r = new Respuesta_1(pregunta,0); //TO BE CHANGED?
		}
		return r;
	}
}