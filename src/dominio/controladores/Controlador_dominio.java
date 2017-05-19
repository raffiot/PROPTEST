package dominio.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public Resultado analizar(int k, double thresh, int idioma, Encuesta enc, List<RespuestaEncuesta> listRE){
		//0 = espagnol
		//1 = catalan
		//2 = english
		Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
		try {
			currenAna = new Analisis(k, thresh, ra, enc, idioma);
		} catch (IOException e) {
			System.out.println("ne se ha cargado las palabras funcionnal");
			e.printStackTrace();
		}
		return currenAna.k_means();
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

	public Resultado getCurrenResu() {
		return currenResu;
	}

	public Analisis getCurrenAna() {
		return currenAna;
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
	
	public List<RespuestaEncuesta> getListResp(int encNb){
		/**
		ArrayList<String> list = new ArrayList<String>();
		//VERIFY AFTER SEEING WHAT THE INTEGER IS FOR
		for(RespuestaEncuesta re : respuestas.getRespuestas().get(encNb).getListRP()){
			list.add("Respuesta de "+re.getNombre());
		}*/
		if(respuestas.getRespuestas().containsKey(encNb)){
			return respuestas.getRespuestas().get(encNb).getListRP();
		}
		else{
			return null;
		}
	}
	
	
	public void eliminarEncuesta(String s){
		encuestas.eliminarE(s);
	}
	
	public Encuesta selecionnarEncuesta(String s){
		return encuestas.selecE(s);
	}
	
	public void update(){
		encuestas.guardarEncuestas();
		users.guardarUsu();
	}
	public void importar(String s){
		encuestas.importar(s);
	}
	public String getE (int i){
		return encuestas.getE(i);
		
	}


	public void anadirResuGuardar(Resultado r){
		resultados.addResu(r);
		resultados.guardarResu();
	}


	public List<RespuestaEncuesta> selectedItem(int [] selected,List<RespuestaEncuesta> rEnc) {
		List<RespuestaEncuesta> result = new ArrayList<>();
		for(int i = 0 ; i < selected.length; i++){
			if(selected[i] == 1)result.add(rEnc.get(i));
		}
		return result;
	}
	
	
}
