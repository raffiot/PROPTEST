package prop.dominio;
public class Tipo_1 extends Pregunta {
	
	private Integer opciones;
	private Integer max;
	private Integer min;
	
	public Tipo_1(){
		super();
		tipo = 1;
	}
	
	public Tipo_1(Integer id, String enunciado, Integer opciones, Integer max, Integer min){
		super(id,enunciado);
		tipo = 1;
		this.opciones = opciones;
		this.max = max;
		this.min = min;
	}
	
	public int getOpciones() {
		return opciones;
	}
	public void setOpciones(int opciones) {
		this.opciones = opciones;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}

}
