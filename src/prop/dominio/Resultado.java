package prop.dominio;
import java.util.List;


public class Resultado {	
	private List<Cluster> clusters;
	
	public Resultado(List<Cluster> clusters){
		this.clusters = clusters;
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	
}
