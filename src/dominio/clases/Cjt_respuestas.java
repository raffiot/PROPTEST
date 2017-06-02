package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import persistencia.Persistencia;
import persistencia.Persistencia_Respuesta;

public class Cjt_respuestas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Integer es el index de la encuesta
	//
	private HashMap<Integer, Respuesta_Analisis> respuestas;
	final String pathRespuestas = "Data/Respuestas/respuestas.dat";
	
	public Cjt_respuestas(){
		respuestas = new HashMap<>();
	}
	public void leerResp(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();
		respuestas = p.leer(pathRespuestas);
	}
	
	public void guardarResp(){
		Persistencia_Respuesta p = new Persistencia_Respuesta();	
		p.escribir(pathRespuestas,respuestas);
	}
	
	public void addResp(RespuestaEncuesta re){
		int index = re.getEncuesta().getId();
		if(!respuestas.containsKey(index)){
			ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
			listRE.add(re);
			Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
			respuestas.put(index, ra);
		}
		else{
			respuestas.get(index).getListRP().removeIf(respEnc -> respEnc.getNombre().equals(re.getNombre()));
			respuestas.get(index).addRespuestaEncuesta(re);
		}
	}
	public HashMap<Integer, Respuesta_Analisis> getRespuestas() {
		return respuestas;
	}	
	
}
