package dominio.clases;

import java.util.HashMap;

import persistencia.Persistencia_Respuesta_in;

public class Cjt_respuestas_in {
	
	private HashMap<Integer, RespuestaEncuesta> respuestas_in;
	private String pathRespuestas = "Data/RespuestasNoAcabadas/";
	//private String username;
	
	public Cjt_respuestas_in(String usu){
		respuestas_in = new HashMap<Integer, RespuestaEncuesta>();
		pathRespuestas += usu+".dat";
	}
	
	public HashMap<Integer, RespuestaEncuesta> getRespuestas_in() {
		return respuestas_in;
	}
	
	public void setRespuestas_in(HashMap<Integer, RespuestaEncuesta> respuestas_in) {
		this.respuestas_in = respuestas_in;
	}
	
	public void leerResp(){
		Persistencia_Respuesta_in p = new Persistencia_Respuesta_in();
		respuestas_in = p.leer(pathRespuestas);
	}
	
	public void guardarResp(){
		Persistencia_Respuesta_in p = new Persistencia_Respuesta_in();	
		p.escribir(pathRespuestas,respuestas_in);
	}
	
	public void addResp(Integer n,Integer i, RespuestaPregunta r){
		respuestas_in.get(n).anadir_respuesta(i,r);
	}
	
	public HashMap<Integer, RespuestaEncuesta> getRespuestas() {
		return respuestas_in;
	}	
	
	public void addRespEnc(Integer n, RespuestaEncuesta re){
		respuestas_in.put(n, re);
	}

}
