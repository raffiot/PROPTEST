package dominio.clases;

/**
 * Classe contenedora de respuestas de usuarios a una encuesta para empezar la analisis
 * 
 * @author Raphael
 */


import java.io.Serializable;
import java.util.List;

public class Respuesta_Analisis implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	}
	
	public void addRespuestaEncuesta(RespuestaEncuesta re){
		listRP.add(re);
	}
	
}
