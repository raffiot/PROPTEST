package dominio.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dominio.clases.Analisis;
import dominio.clases.Encuesta;
import dominio.clases.RespuestaEncuesta;
import dominio.clases.Respuesta_Analisis;

public class Controlador_presentacion {
	
	private Controlador_dominio cd;
	
	
	public Controlador_presentacion(){
		cd = new Controlador_dominio();
	}
	
	public int entrar(String username, String password) throws Exception{
		
		/**
		 * return "NO" if not find, "USU" if usuario, "ADMIN" if admin 
		 */
		if(username == null || password == null ){
			throw new Exception("Unas de las entradas esta vacia");
		}
		
		//Salvaguardar que usuario somos
		
		 return cd.identificacion(username, password);
		
	}
	public boolean registrar(String user, String pass, boolean usu){
		return cd.registrar(user, pass, usu);
	}
	
	public void analizar(int k, double thresh, int idioma, Encuesta enc, List<RespuestaEncuesta> listRE){
		cd.analizar(k, thresh, idioma, enc, listRE);
	}
	
	public ArrayList<String> getList(){
		return cd.getList();
	}
	
	public List<RespuestaEncuesta> getListResp(int encNb){
		return cd.getListResp(encNb);
	}
	
	public void eliminarEncuesta(String s){
		cd.eliminarEncuesta(s);
	}
	
	public Encuesta selecionnarEncuesta(String s){
		return cd.selecionnarEncuesta(s);
	}
	
	public void update(){
		cd.update();
	}
	public void importar(String s){
		cd.importar(s);
	}
	public String getE (int i){
		return cd.getE(i);
		
	}
	
	public List<RespuestaEncuesta> selectedItem(int [] selected,List<RespuestaEncuesta> rEnc) {
		return cd.selectedItem(selected, rEnc);
	}
	


	

}
