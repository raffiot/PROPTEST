package dominio.controladores;

import java.io.IOException;
import java.util.ArrayList;

import dominio.clases.*;

public class Controlador_dominio {
		private Cjt_encuestas encuestas;
		private Cjt_users users;
		private Cjt_resultados resultados;
		private Cjt_respuestas respuestas;
		
		private Encuesta currentEnc;
		private Analisis currenAna;
		private Resultado currenResu;
		private Respuesta_Analisis currResp;
		
		
	public Controlador_dominio(){
		encuestas = new Cjt_encuestas();
		cargar_enquestas();
		users = new Cjt_users();
		cargar_usuarios();
		resultados = new Cjt_resultados();
		cargar_resultados();
		respuestas = new Cjt_respuestas();
		cargar_respuestas();
	}
		
		



	public int entrar(String username, String password) throws Exception{
		
		/**
		 * return "NO" if not find, "USU" if usuario, "ADMIN" if admin 
		 */
		if(username == null || password == null ){
			throw new Exception("Unas de las entradas esta vacia");
		}
		
		//Salvaguardar que usuario somos
		boolean find = users.identification(username, password);
		if(find){
			return users.getType(username);
		}
		return -1;
	}
	
	public boolean registrar(String user, String pass, boolean usu){
		if(users.yaExiste(user)){
			return false;
		}
		else{
			int tipo = 0;
			if(usu){
				tipo = 1;
			}
			else{
				tipo = 0;
			}
			users.addUser(user, pass, tipo);
			users.guardarUsu();
			return true;
		}
		
	}
	
	public void analizar(int k, double thresh, int idioma){
		//0 = espagnol
		//1 = catalan
		//2 = english
		try {
			currenAna = new Analisis(k, thresh, currResp, currentEnc, idioma);
		} catch (IOException e) {
			System.out.println("ne se ha cargado las palabras funcionnal");
			e.printStackTrace();
		}
		currenResu = currenAna.k_means();
	}
	
	public int getMaxK(){
		return currResp.getListRP().size();
	}
	
	private void cargar_usuarios(){
		users.leerUsu();
	}

	private void cargar_enquestas(){
		encuestas.leerEncuestas();
	}
	
	private void cargar_resultados() {
		resultados.leerResu();
		
	}
	
	private void cargar_respuestas() {
		respuestas.leerResp();
		
	}
	
	public Cjt_encuestas getEncuestas() {
		return encuestas;
	}


	public void setEncuestas(Cjt_encuestas encuestas) {
		this.encuestas = encuestas;
	}

	public Cjt_resultados getResultados() {
		return resultados;
	}
	public ArrayList<String> getList(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < encuestas.size();++i){
			String s = "";
			s = encuestas.get(i).getId()+". "+ encuestas.get(i).getGenero();
			list.add(s);
		}
		return list;
	}
	
	public void eliminarEncuesta(String s){
		encuestas.eliminarE(s);
	}
	public void update(){
		encuestas.guardarEncuestas();
		users.guardarUsu();
	}
	
	
}
