package dominio.clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * Classe que representa el resultado de la analisis
 * Para la primera entrega este resultado es simplemente un conjunto de cluster.
 * 
 * @author Raphael
 */
import java.util.List;

/**
 * Clase que respresenta el resultado de una analisis.
 * 
 * @author Raphael
 *
 */
public class Resultado implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cluster> clusters;
	private HashMap<String,ArrayList<Double>> mapDistance;
	private int nbIteracion;
	private Date data;
	private Encuesta enc;
	private Respuesta_Analisis ra;
	
	/**
	 * El constructor de resultado que sale de una analisis
	 * 
	 * @param clusters
	 * 		las lista de clusters resultado de la analisis
	 * @param mapDistance
	 * 		estructura que contiene las distancias entre cada respuesta encuesta y cada centroids
	 * 		HashMap<String,ArrayList<Double>> -> la String es el nombre del usuario al cual partenece la respuesta encuesta
	 * 		los doubles estan a la posicion especificada per el numero del cluster y el double es la distancia
	 * @param nbIteracion
	 * 		el numero de veces que se ha echo el pipline de analisis
	 * @param data
	 * 		la fecha en la cual se ha echo la analisis
	 * @param enc
	 * 		la encuesta que se ha analizado
	 * @param ra
	 * 		la lista de respuesta a la encuesta que se ha analizado.
	 */
	public Resultado(List<Cluster> clusters,HashMap<String,ArrayList<Double>> mapDistance, int nbIteracion, Date data, Encuesta enc, Respuesta_Analisis ra){
		this.clusters = clusters;
		this.mapDistance = mapDistance;
		this.nbIteracion = nbIteracion;
		this.data=data;
		this.enc = enc;
		this.ra = ra;
		
	}
	
	/**
	 * Methodo para obtener el cluster resultado
	 * 
	 * @return
	 * 		el cluster 
	 */
	public List<Cluster> getClusters() {
		return clusters;
	}
	
	/**
	 * Methodo para obtener el numero de iteracion
	 * 
	 * @return
	 * 		el numero de iteracion
	 */
	public int getNbIteracion() {
		return nbIteracion;
	}
	
	/**
	 * Methodo para obtener la fecha a la cual se ha echo la analisis
	 * 
	 * @return
	 * 		la fecha
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * Methodo para obtener la encuesta que se ha analizado
	 * 
	 * @return
	 * 		la encuesta
	 */
	public Encuesta getEnc() {
		return enc;
	}
	
	/**
	 * Methodo para obtener la lista de respuesta encuesta
	 * 
	 * @return
	 * 		la lista de respuesta encuesta
	 */
	public Respuesta_Analisis getRa() {
		return ra;
	}

	/**
	 * Methodo para modificar el cluster resultado
	 * 
	 * @param clusters
	 * 		el nuevo cluster resultado
	 */
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	
	/**
	 * Methodo para obtenir la estructura que contiene las distancias entre cada respuesta encuesta y cada centroids
	 * 
	 * @param clusters
	 * 		la estrucutra especificada
	 */
	public HashMap<String,ArrayList<Double>> getMapDistance() {
		return mapDistance;
	}

	/**
	 * Metodo que crea una string que describe el resultado
	 * 
	 * @param an
	 * 		la analisis que a producido el resultado
	 * @return la string que describe resultado
	 */
	public String toString(Analisis an){
		String s ="";
		s +="Resultado de la analisis de la encuesta "+ clusters.get(0).getCentroid().getEncuesta().getId()+ "\n";
		for(Cluster c: clusters){
			s+="----------------------------------------\n";
			s+=c.toString(an);
			s+="\n";
		}
		return s;
	}
	
}
