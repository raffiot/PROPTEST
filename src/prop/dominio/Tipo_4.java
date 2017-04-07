package prop.dominio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tipo_4 extends Pregunta {
	
	int opciones;
	ArrayList <String>lista_opciones;
	
	public Tipo_4(){
		super();
		tipo = 4;
		lista_opciones = new ArrayList <String>();
	}
	
	public Tipo_4(Integer id, String enunciado, Integer opciones, ArrayList <String>lista_opciones){
		super(id,enunciado);
		tipo = 1;
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
		lista_opciones.add(s);
	
	}
	
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\n";
		return s;
	}
	
	public RespuestaPregunta generateAnswer(){
		Random randomGenerator = new Random();
		int value = randomGenerator.nextInt(opciones-1);
		Set<String> s = new HashSet<String>();
		for(int i = 0; i < value; i++){
			int toPut =randomGenerator.nextInt(opciones-1);
			s.add(lista_opciones.get(toPut));
		}
		RespuestaPregunta r = new Respuesta_4(this,s);
		return r;
	}
}