package prop.dominio;

import java.util.HashMap;
import java.util.List;

public class Respuesta_Analisis {
	
	private HashMap<Integer,List<RespuestaEncuesta>> listRE;

	public HashMap<Integer, List<RespuestaEncuesta>> getListRE() {
		return listRE;
	}

	public void setListRE(HashMap<Integer, List<RespuestaEncuesta>> listRE) {
		this.listRE = listRE;
	}
	
	public Respuesta_Analisis(HashMap<Integer,List<RespuestaEncuesta>> listRE){
		this.listRE= listRE;
	}
	
}
