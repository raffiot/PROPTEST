package prop.dominio;
public class Tipo_5 extends Pregunta {
	
	public Tipo_5(){
		super();
		tipo = 5;
	}
	
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado + "\n";
		return s;
	}
	
	public RespuestaPregunta generateAnswer(){
		//TO BE COMPLETE
		return null;
	}
}