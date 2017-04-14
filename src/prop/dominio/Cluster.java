package prop.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cluster{

	private int index;
	private RespuestaEncuesta centroid;
	private List<RespuestaEncuesta> usuarios;
	
	public Cluster(int i, RespuestaEncuesta c){
		index = i;
		centroid = c;
		usuarios = new ArrayList<RespuestaEncuesta>();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public RespuestaEncuesta getCentroid() {
		return centroid;
	}

	public void setCentroid(RespuestaEncuesta centroid) {
		this.centroid = centroid;
	}

	public List<RespuestaEncuesta> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<RespuestaEncuesta> usuarios) {
		this.usuarios = usuarios;
	}
	
}
