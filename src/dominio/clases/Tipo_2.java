package dominio.clases;

import java.io.Serializable;

/**
 * La classe Tipo_2 representa una pregunta que se responde con 1 opcion qualitativa.
 * Las diferentes modalidades son ordenadas.
 * @author Miguel
 */

import java.util.ArrayList;
import java.util.Random;

public class Tipo_2 extends Pregunta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer opciones;
	private ArrayList <String>lista_opciones;
	
	/**
	 * Constructor vacio de la pregunta de tipo 2
	 */
	public Tipo_2(){
		super();
		tipo = 2;
		lista_opciones = new ArrayList <String>();
	}
	
	/**
	 * Constructor de pregunta de tipo 2 con su identificador, su enunciado,
	 * el numero de opciones diferentes que se puede responder y
	 * el nombre de estas opciones.
	 * 
	 * @param id
	 * 		el identificador de la pregunta
	 * @param enunciado
	 * 		el enunciado de la pregunta
	 * @param opciones
	 * 		el numero de opciones diferentes que hay en la pregunta (el tamano de lista_opciones)
	 * @param lista_opciones
	 * 		la lista que contiene las differentes opciones de respuesta.
	 */
	public Tipo_2(Integer id, String enunciado, Integer opciones, ArrayList <String>lista_opciones){
		super(id,enunciado);
		tipo = 2;
		this.opciones = opciones;
		this.lista_opciones = lista_opciones;
	}
	
	/**
	 * Metodo para obtener el numero de opciones differentes que hay para responder a la pregunta.
	 * 
	 * @return
	 * 		el numero de opciones
	 */
	public int getOpciones() {
		return opciones;
	}
	
	/**
	 * Metodo para poner el numero de opciones diferentes que hay para responder a la pregunta.
	 * 
	 * @param opciones
	 * 		el numero de opciones
	 */
	public void setOpciones(int opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Metodo para obtener una lista con el nombre de todas las opciones posibles para respoder
	 * esta pregunta.
	 * 
	 * @return
	 * 		la lista de estas opciones
	 */
	public ArrayList<String> getLista_opciones() {
		return lista_opciones;
	}
	
	/**
	 * Metodo para modificar el nombre de todas las opciones que se pueden eligir para esta pregunta.
	 * 
	 * @param lista_opciones
	 * 		la nueva lista de opciones
	 */
	public void setLista_opciones(ArrayList<String> lista_opciones) {
		this.lista_opciones = lista_opciones;
	}

	/**
	 * Metodo para anadir una opcion a la lista de opciones elegible para responder
	 * 
	 * @param s
	 * 		la opcion a anadir a la lista de opciones
	 */
	public void anadir_opcion(String s){
		lista_opciones.add(s);
	
	}
	
	/**
	 * Metodo para pasar la pregunta de tipo 2 en una string
	 * que contiene su identificador,su enunciado, y cada una de las opciones.
	 * 
	 * @return
	 * 		la nueva string creada.
	 */
	@Override
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\r\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\r\n";
		return s;
	}
	
	
	/**
	 * Metodo para pasar la pregunta de tipo 2 en una string
	 * que contiene su identificador,su enunciado, y cada una de las opciones
	 * y en un formato especial para guardar en un txt.
	 * 
	 * @return
	 * 		la nueva string creada.
	 */
	public String guardar() {
		String s = "";
		s += tipo +"\r\n";
		s+= enunciado +"\r\n";
		s += opciones +"\r\n";
		for (int i = 0; i < opciones; ++i) s += lista_opciones.get(i)+"\r\n";
		return s;
	}
	
	/**
	 * Metodo para generar una respuesta aleatoria a esa pregunta.
	 * 
	 * @return
	 * 		la respuesta aleatoria a la pregunta de tipo 2
	 */	
	public RespuestaPregunta generateAnswer(){
		Random randomGenerator = new Random();
		int value = randomGenerator.nextInt(opciones);
		RespuestaPregunta r = new Respuesta_2(this,value);
		return r;
	}
	

	public int getPosicion(String pos){
		for (int i = 0; i < opciones; ++i){
			if (lista_opciones.get(i).equals(pos)) return i;
			
		}
		return -1;
	}
}
	

