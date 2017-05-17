package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.*;

public class Cjt_encuestas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Encuesta> encuestas;
	final String pathEncuesta = "Data/Encuestas/encuestas.dat";
	
	public void leerEncuestas(){	
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		encuestas = p.leer(pathEncuesta);
		
	}
	
	
	public void guardarEncuestas(){
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		p.escribir(pathEncuesta,encuestas);
		
	}

}
