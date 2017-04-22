package dominio.clases;
/**
 * Classe que representa el resultado de la analisis
 * Para la primera entrega este resultado es simplemente un conjunto de cluster.
 * 
 * @author Raphael
 */
import java.util.List;

import dominio.controladores.Analisis;


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
