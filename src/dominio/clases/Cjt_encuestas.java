package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.*;

/**
 * Clase que representa un conjunto de de encuestas que se cargan al iniciar el programa.
 * 
 * @author Miguel
 *
 */
public class Cjt_encuestas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Encuesta> encuestas;
	final String pathEncuesta = "Data/Encuestas/encuestas.dat";
	
	/**
	 * Constructora de Cjt_encuestas
	 */
	public Cjt_encuestas(){
		encuestas = new ArrayList<Encuesta>();
	}
	
	/**
	 * Lee las encuestas guardadas en disco.
	 */
	public void leerEncuestas(){	
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		encuestas = p.leer(pathEncuesta);
		
	}
	
	/**
	 * Guarda las encuestas en disco.
	 
	 */
	public void guardarEncuestas(){
		
		Persistencia_Encuesta p = new Persistencia_Encuesta();
		p.escribir(pathEncuesta,encuestas);
		
	}
	/**
	 * Devuelve el numero de encuestas que hay.
	 */
	public int size(){
		return encuestas.size();
	}
	
	
	/**
	 * Devuelve la encuesta iesima
	  * @param i
	 * 		identificador de la encuesta
	 * @return la encuesta iesima
	 */
	public Encuesta get(int i){
		return encuestas.get(i);
	}
	
	/**
	 * Anade una encuesta al conjunto
	  * @param e
	 * 		encuesta a anadir
	 */
	public void anadirEncuesta( Encuesta e){
		encuestas.add(e);
	}
	
	
	/**
	 * elimina una encuesta del conjunto
	  * @param s
	 * 		identificador de la encuesta a borrar
	 */
	public void eliminarE(String s){
		for (int i = 0; i < encuestas.size(); ++i){
			if(encuestas.get(i).getId() == Integer.parseInt(s)) encuestas.remove(i);
		}
	}
	

	/**
	 * Devuelve la encuesta iesima
	  * @param i
	 * 		identificador de la encuesta
	 * @return la encuesta iesima
	 */
	public Encuesta selecE(String s){
		for (int i = 0; i < encuestas.size(); ++i){
			if(encuestas.get(i).getId() == Integer.parseInt(s)) return encuestas.get(i);
		}
		return null;
	}
	
	
	/**
	 * Importa una encuesta al conjunto
	  * @param s
	 * 		la encuesta en formato String
	 */
	public void importar(String s){
		Encuesta e = new Encuesta(1);
		e.importar(s);
		e.setId(encuestas.size()+1);
		encuestas.add(e);

	}
	
	/**
	 * Devuelve la encuesta iesima
	  * @param i
	 * 		identificador de la encuesta
	 * @return la encuesta iesima en formato String
	 */
	public String getE(int j){
		for (int i = 0; i < encuestas.size(); ++i){
			if(encuestas.get(i).getId() == j) return encuestas.get(i).toString();
		}
		return "No esta la encuesta";
	}
}

