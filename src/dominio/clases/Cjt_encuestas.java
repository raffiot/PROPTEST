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
	
	public Cjt_encuestas(){
		encuestas = new ArrayList<Encuesta>();
	}
	
	public void leerEncuestas(){	
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		encuestas = p.leer(pathEncuesta);
		
	}
	
	
	public void guardarEncuestas(){
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		p.escribir(pathEncuesta,encuestas);
		
	}
	
	public int size(){
		return encuestas.size();
	}
	
	public Encuesta get(int i){
		return encuestas.get(i);
	}
	
	public void anadirEncuesta( Encuesta e){
		encuestas.add(e);
	}
	public void eliminarE(String s){
		for (int i = 0; i < encuestas.size(); ++i){
			if(encuestas.get(i).getId() == Integer.parseInt(s)) encuestas.remove(i);
		}
	}
}

