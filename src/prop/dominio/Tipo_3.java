package prop.dominio;
import java.util.ArrayList;
import java.util.Random;

public class Tipo_3 extends Pregunta {
	
	int opciones;
	ArrayList <String>lista_opciones;
	
	
	public Tipo_3(){
		super();
		tipo = 3;
		lista_opciones = new ArrayList <String>();
	}
	
	public Tipo_3(Integer id, String enunciado, Integer opciones, ArrayList <String>lista_opciones){
		super(id,enunciado);
		tipo = 3;
		this.opciones = opciones;
		this.lista_opciones = lista_opciones;
	}	
	
	
	public int getOpciones() {
		return opciones;
	}
	public void setOpciones(int opciones) {
		this.opciones = opciones;
	}
	public ArrayList<String> getLista_opciones() {
		return lista_opciones;
	}
	public void setLista_opciones(ArrayList<String> lista_opciones) {
		this.lista_opciones = lista_opciones;
	}
	
	public void anadir_opcion(String s){
		this.lista_opciones.add(s);
	
	}
	
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\r\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\r\n";
		return s;
	}
	public String guardar() {
		String s = "";
		s += tipo +"\r\n";
		s+= enunciado +"\r\n";
		s += opciones +"\r\n";
		for (int i = 0; i < opciones; ++i) s += lista_opciones.get(i)+"\r\n";
		return s;
	}
	
	public RespuestaPregunta generateAnswer(){
		Random randomGenerator = new Random();
		int value = randomGenerator.nextInt(opciones);//is it opciones-1?
		RespuestaPregunta r = new Respuesta_3(this,lista_opciones.get(value));
		return r;
	}
}