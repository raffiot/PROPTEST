package prop.dominio;
<<<<<<< HEAD

import java.util.HashMap;
=======
/**
 * Classe que respresenta un conjunto de respuestas a una misma encuesta
 * Se cree un objecto de ese classe para hacer la analisis.
 * 
 * @author Raphael
 */
>>>>>>> origin/master
import java.util.List;

public class Respuesta_Analisis {
	
<<<<<<< HEAD
	private HashMap<Integer,List<RespuestaEncuesta>> listRE;

	public HashMap<Integer, List<RespuestaEncuesta>> getListRE() {
		return listRE;
	}

	public void setListRE(HashMap<Integer, List<RespuestaEncuesta>> listRE) {
		this.listRE = listRE;
	}
	
	public Respuesta_Analisis(HashMap<Integer,List<RespuestaEncuesta>> listRE){
		this.listRE= listRE;
=======
	private List<RespuestaEncuesta> listRP;
	/**
	 * Constructor para crear un objecto con una lista de respuestas a una encuesta.
	 * 
	 * @param listRP
	 * 		El conjunto de respuestas
	 */
	public Respuesta_Analisis(List<RespuestaEncuesta> listRP){
		this.listRP = listRP;
	}
	
	/**
	 * Methodo para obtener el conjunto de respuestas a una encuesta.
	 * 
	 * @return
	 * 		El conjunto de respuestas
	 */
	public List<RespuestaEncuesta> getListRP() {
		return listRP;
	}

	/**
	 * Methodo para modificar el conjunto de respuestas a una encuesta.
	 * 
	 * @param listRP
	 * 		El nuevo conjunto de respuestas
	 */
	public void setListRP(List<RespuestaEncuesta> listRP) {
		this.listRP = listRP;
>>>>>>> origin/master
	}
	
}
