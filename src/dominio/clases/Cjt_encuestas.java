package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.Persistencia;

public class Cjt_encuestas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Encuesta> encuestas;
	

	public Cjt_encuestas(){
		ArrayList<Encuesta> aux = new ArrayList<Encuesta>();
		Persistencia<ArrayList<Encuesta>> p = new Persistencia<ArrayList<Encuesta>>(aux);
		p.leer("Data/Encuestas");
		this.encuestas = aux;
	}
	
	public void guardar(){
		
		Persistencia<ArrayList<Encuesta>> p = new Persistencia<ArrayList<Encuesta>>(this.encuestas);
		p.escribir("Data/Encuestas");
		
	}

}
