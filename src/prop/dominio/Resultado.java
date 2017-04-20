package prop.dominio;
/**
 * Classe que representa el resultado de la analisis
 * Para la primera entrega este resultado es simplemente un conjunto de cluster.
 * 
 * @author Raphael
 */
import java.util.List;


public class Resultado {	
	private List<Cluster> clusters;
	
	/**
	 * El constructor de resultado que sale de una analisis
	 * 
	 * @param clusters
	 * 		el cluster final resultado de la analisis
	 */
	public Resultado(List<Cluster> clusters){
		this.clusters = clusters;
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
	 * Methodo para modificar el cluster resultado
	 * 
	 * @param clusters
	 * 		el nuevo cluster resultado
	 */
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	
	@Override
	public String toString(){
		String s ="";
		s +="Resultado de la analisis de la encuesta "+ clusters.get(0).getCentroid().getEncuesta().getId();
		for(Cluster c: clusters){
			s+=c.toString();
			s+="\n";
		}
		return s;
	}
	
}
