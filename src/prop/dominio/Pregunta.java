package prop.dominio;


public abstract class  Pregunta {
	Integer id;
	String enunciado;
	Integer tipo;
	
	public Pregunta(){
		this.id = null;
		this.enunciado = null;
		this.tipo = null;
	}
	
	public Pregunta(Integer id, String enunciado) {
		this.id = id;
		this.enunciado = enunciado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public abstract String toString();
	
	public abstract RespuestaPregunta generateAnswer();
	

}
