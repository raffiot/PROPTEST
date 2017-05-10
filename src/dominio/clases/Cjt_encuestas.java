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
	
	@SuppressWarnings("unchecked")
	public Cjt_encuestas(){
		this.encuestas = (ArrayList<Encuesta>)Persistencia.leer("Data/Encuestas");
	}
	
	public void guardar(){
		Persistencia.escribir(this.encuestas,"Data/Encuestas");
		
	}

}
