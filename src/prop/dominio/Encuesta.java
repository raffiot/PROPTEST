package prop.dominio;

import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Encuesta {
	
	private Integer id;
	private Integer n_preguntas;
	private String genero;
	private Data fecha;
	private ArrayList<Pregunta> preguntas;
	
	
	public Encuesta(Integer id){
		this.id = id;
		n_preguntas = 0;
		genero = null;
		fecha = null;
		preguntas = new ArrayList<>();
	}
				
	public Encuesta(Integer id, Integer n_preguntas, String genero, Data fecha,ArrayList<Pregunta>preguntas ){
		this.id = id;
		this.n_preguntas = n_preguntas;
		this.genero = genero;
		this.fecha = fecha;
		this.preguntas = preguntas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getN_preguntas() {
		return n_preguntas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Data getFecha() {
		return fecha;
	}
	public void setFecha(Data fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
		this.n_preguntas = preguntas.size();
	}
	public void añadir_pregunta(Pregunta p){
		preguntas.add(p);
		++n_preguntas;
	}
	
	public void imprimir(){
		for(int i = 0; i < preguntas.size();++i){
			System.out.println(preguntas.get(i).getEnunciado());
			for(int j = preguntas.get(i).getMin(); j < preguntas.get(i).getMax(); ++j){
				System.out.println("-"+j);
			}
		}
	}

}
