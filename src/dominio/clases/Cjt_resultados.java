package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.*;

/**
 * Clase que representa un conjunto de resultado que se cargan al iniciar el programa.
 * 
 * @author Raphael
 *
 */
public class Cjt_resultados implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Resultado> resultados;
	final String pathResultado = "Data/Resultados/resultados.dat";

	/**
	 * Creadora de la classe que inicialize la lista que contiene los resultados
	 */
	public Cjt_resultados(){
		resultados = new ArrayList<Resultado>();
	}
	
	/**
	 * Metodo para leer los resultados desde un binario
	 */
	public void leerResu(){	
		
		Persistencia_Resultado p = new Persistencia_Resultado();
		resultados = p.leer(pathResultado);	
	}
	
	/**
	 * Metodo para guardar los resultados en binario
	 */
	public void guardarResu(){
		
		Persistencia_Resultado p = new Persistencia_Resultado();
		p.escribir(pathResultado,resultados);
		
	}
	
	/**
	 * Metodo para anadir un resultado para que se guarda en el binario despues
	 * @param r
	 * 		el resultado a anadir a la lista
	 */
	public void addResu(Resultado r){
		resultados.add(r);
	}

	/**
	 * Metodo para obtenir la lista de resultados
	 * 
	 * @return
	 * 		la lista de resultados
	 */
	public ArrayList<Resultado> getResultados() {
		return resultados;
	}

	/**
	 * Metodo para obtenir un resultado en particular desde la lista
	 * 
	 * @param s
	 * 		el integer correspondiendo al index del resultado en la lista
	 * @return
	 * 		el Resultado seleccionado
	 */
	public Resultado selectR(String s) {
		return resultados.get(Integer.parseInt(s));
	}
	
	
}
