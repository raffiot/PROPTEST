package prop.dominio;
public class Tipo_5 extends Pregunta {
	
	public Tipo_5(){
		super();
		tipo = 5;
	}
	
	public Tipo_5(Integer id,String enunciado){
		super(id,enunciado);
		tipo = 5;
	}
	
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado + "\r\n";
		return s;
	}
	
	public String guardar(){
		String s = "";
		s += tipo +"\r\n";
		s += enunciado + "\r\n";
		return s;
	}
	
	public RespuestaPregunta generateAnswer(){
		//TO BE COMPLETE
		return null;
	}
}