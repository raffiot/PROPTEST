package prop.dominio;

import java.util.ArrayList;
import java.util.Date;



public class Encuesta {
	
	private Integer id;
	private Integer n_preguntas;
	private String genero;
	private Date fecha;
	private ArrayList<Pregunta> preguntas;
	
	
	public Encuesta(Integer id){
		this.id = id;
		n_preguntas = 0;
		genero = null;
		fecha = null;
		preguntas = new ArrayList<>();
	}
				
	public Encuesta(Integer id, Integer n_preguntas, String genero, Date fecha,ArrayList<Pregunta>preguntas ){
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
		System.out.println("id de la encuesta: "+ id);
		System.out.println("Genero encuesta: " +genero);
		System.out.println("Fecha: " + fecha);
		System.out.println("Nº de preguntas: " +n_preguntas);;
		for(int i = 0; i < preguntas.size();++i){
			preguntas.get(i).imprimir_pregunta();
			
		}
	}

}
