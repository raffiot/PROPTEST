package prop.dominio;
import java.util.ArrayList;

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
		this.lista_opciones.add(s);
	
	}
	
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\n";
		return s;
	}
}
