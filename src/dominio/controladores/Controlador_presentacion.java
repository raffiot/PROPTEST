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
		
		 return cd.entrar(username, password);
		
	}
	public boolean registrar(String user, String pass, boolean usu){
		return cd.registrar(user, pass, usu);
	}
	
	public void analizar(int k, double thresh, int idioma){
		cd.analizar(k, thresh, idioma);
	}
	
	public ArrayList<String> getList(){
		return cd.getList();
	}
	
	public ArrayList<String> getListResp(){
		return cd.getListResp();
	}
	
	public void eliminarEncuesta(String s){
		cd.eliminarEncuesta(s);
	}
	
	public void selecionnarEncuesta(String s){
		cd.selecionnarEncuesta(s);
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
	
	public void selectedItem(int [] selected) {
		//HERE WE SUPPOSE LIST<RESPUESTAENCUESTA> ORDER WILL NOT CHANGE
		//MODIFICATE THIS METHOD WHEN RESPUESTAENCUESTA WILL HAVE AN ID!!!!
		cd.selectedItem(selected);
	}

	public boolean encuestaWithoutRespuesta(String s) {
		return cd.encuestaWithoutRespuesta(s);
	}

	public int getMaxK() {
		return cd.getMaxK();
	}

	public ArrayList<Integer> getClusterNumbers() {
		return cd.getClusterNumbers();
	}

	public ArrayList<String> getRespuestaDeCluster(Integer i) {
		return cd.getRespuestaDeCluster(i);
	}

	public void resuGuardar() {
		cd.resuGuardar();
		
	}

	public String getREinfo(String type, String substring) {
		if(type.equals("c")){
			//Cluster Case
			return cd.getClusterInfo(Integer.parseInt(substring));
		}
		else if(type.equals("re")){
			return cd.getREInfo(substring);
		}
		return null;
	}

	public ArrayList<String> getListResu() {
		return cd.getListResu();
	}

	public void selecionnarResultado(String s) {
		cd.selecionnarResultado(s);
		
	}

	public void selecionnarREdesdeResu() {
		cd.selecionnarREdesdeResu();
		
	}
	


	

}
