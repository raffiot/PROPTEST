import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Encuesta {
	
	int id;
	int n_preguntas;
	String genero;
	Data fecha;
	
	ArrayList<Pregunta> preguntas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getN_preguntas() {
		return n_preguntas;
	}
	public void setN_preguntas(int n_preguntas) {
		this.n_preguntas = n_preguntas;
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
	}
	

}
