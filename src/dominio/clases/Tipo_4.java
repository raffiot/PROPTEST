package dominio.clases;

import java.io.Serializable;

/**
 * La classe Tipo_4 representa una pregunta que se responde con 1 o mas opciones qualitativas.
 * Las differentes modalidades no son ordenadas.
 * @author Miguel						
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tipo_4 extends Pregunta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int opciones;
	ArrayList <String>lista_opciones;
	
	/**
	 * Constructor vacio de la pregunta de tipo 4
	 */
	public Tipo_4(){
		super();
		tipo = 4;
		lista_opciones = new ArrayList <String>();
	}
	
	/**
	 * Constructor de pregunta de tipo 4 con su identificador, su enunciado,
	 * el numero de opciones differentes que se pueden eligir en una respuesta y
	 * el nombre de estas opciones.
	 * 
	 * @param id
	 * 		el identifacador de la pregunta
	 * @param enunciado
	 * 		el enunciado de la pregunta
	 * @param opciones
	 * 		el numero de opciones differentes que se pueden responder
	 * @param lista_opciones
	 * 		el nombre de cada una de la opciones
	 */
	
	public Tipo_4(Integer id, String enunciado, Integer opciones, ArrayList <String>lista_opciones){
		super(id,enunciado);
		tipo = 4;
		this.opciones = opciones;
		this.lista_opciones = lista_opciones;
	}	
	
	/**
	 * Metodo para obtener el numero de opciones diferentes que hay para responder a la pregunta.
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
	 * Metodo para obtener el nombre de todas las opciones que se pueden eligir para esa pregunta.
	 * 
	 * @return
	 * 		la lista de estas opciones
	 */
	public ArrayList<String> getLista_opciones() {
		return lista_opciones;
	}
	
	/**
	 * Metodo para modificar el nombre de todas las opciones que se pueden eligir para esa pregunta.
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
	 * Metodo para pasar la pregunta de tipo 4 en una string
	 * que contiene su identificador,su enunciado, y cada una de las opciones.
	 * 
	 * @return
	 * 		la nueva string creada.
	 */
	public String toString(){
		String s = "";
		s += id+"."+enunciado +"\r\n";
		for (int i = 0; i < opciones; ++i) s +="- "+ lista_opciones.get(i)+"\r\n";
		return s;
	}
	
	/**
	 * Metodo para pasar la pregunta de tipo 4 en una string
	 * que contiene su identificador,su enunciado, y cada una de las opciones
	 * y en un formato especial para guardar en un txt.
	 * 
	 * @return
	 * 		la nueva string creada.
	 */
	public String guardar(){
		String s = "";
		s += tipo +"\r\n";
		s+= enunciado +"\r\n";
		s += opciones +"\r\n";
		for (int i = 0; i < opciones; ++i) s += lista_opciones.get(i)+"\r\n";
		return s;
	}
	
	/**
	 * Metodo para generar una respuesta aleatoria a esa pregunta.
	 * Se genera primero el nombre de veces que se va a intentar anadir una opcion
	 * Se genera secundo el numero de la opcion que se va a poner al set de respuesta.
	 * Ademas no podran ser ninguna respuesta repetida porque trabajamos con un set.
	 * 
	 * @return
	 * 		la respuesta aleatoria a la pregunta de tipo 4
	 */
	public RespuestaPregunta generateAnswer(){
		Random randomGenerator = new Random();
		int value = randomGenerator.nextInt(opciones-1);
		Set<String> s = new HashSet<String>();
		for(int i = 0; i < value; i++){
			int toPut =randomGenerator.nextInt(opciones-1);
			s.add(lista_opciones.get(toPut));
		}
		RespuestaPregunta r = new Respuesta_4(this,s);
		return r;
	}
}