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
	
	//Map de <Nombre usuario <indexCluster,distance>>
	
	/**
	 * El constructor de resultado que sale de una analisis
	 * 
	 * @param clusters
	 * 		el cluster final resultado de la analisis
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
	
	public int getNbIteracion() {
		return nbIteracion;
	}
	
	
	public Date getData() {
		return data;
	}
	
	public Encuesta getEnc() {
		return enc;
	}

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
