package prop.dominio;
import java.util.ArrayList;
import java.util.Random;

public class Tipo_2 extends Pregunta {
	
	Integer opciones;
	ArrayList <String>lista_opciones;
	
	public Tipo_2(){
		super();
		tipo = 2;
		lista_opciones = new ArrayList <String>();
	}
	
	public Tipo_2(Integer id, String enunciado, Integer opciones, ArrayList <String>lista_opciones){
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
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\n";
		return s;
	}
	
	public RespuestaPregunta generateAnswer(){
		Random randomGenerator = new Random();
		int value = randomGenerator.nextInt(opciones-1);
		RespuestaPregunta r = new Respuesta_2(this,value);
		return r;
	}
	

	public int getPosicion(String pos){
		for (int i = 0; i < opciones; ++i){
			if (lista_opciones.get(i) == pos) return i;
			
		}
		return -1;
	}
}
	

