package prop.dominio;

import java.util.List;

public class Respuesta_Analisis {
	
	private List<RespuestaEncuesta> listRP;
	
	public Respuesta_Analisis(List<RespuestaEncuesta> listRP){
		this.listRP = listRP;
	}

	public List<RespuestaEncuesta> getListRP() {
		return listRP;
	}

	public void setListRP(List<RespuestaEncuesta> listRP) {
		this.listRP = listRP;
	}
	
}
