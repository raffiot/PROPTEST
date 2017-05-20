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
		private Analisis currentAna;
		private Resultado currentResu;
		private Respuesta_Analisis currentResp;
		
		
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
			currentAna = new Analisis(k, thresh, currentResp, currentEnc, idioma);
		} catch (IOException e) {
			System.out.println("ne se ha cargado las palabras funcionnal");
			e.printStackTrace();
		}
		currentResu = currentAna.k_means();
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
		return currentResu;
	}

	public Analisis getCurrenAna() {
		return currentAna;
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
	
	public ArrayList<String> getListResp(){
		
		ArrayList<String> list = new ArrayList<String>();
		//VERIFY AFTER SEEING WHAT THE INTEGER IS FOR
		for(RespuestaEncuesta re : respuestas.getRespuestas().get(currentEnc.getId()).getListRP()){
			list.add("Respuesta de "+re.getNombre());
		}
		return list;
	}
	
	
	public void eliminarEncuesta(String s){
		encuestas.eliminarE(s);
	}
	
	public void selecionnarEncuesta(String s){
		currentEnc = encuestas.selecE(s);
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


	public void selectedItem(int [] selected) {
		//HERE WE SUPPOSE LIST<RESPUESTAENCUESTA> ORDER WILL NOT CHANGE
		//MODIFICATE THIS METHOD WHEN RESPUESTAENCUESTA WILL HAVE AN ID!!!!
		List<RespuestaEncuesta> result = new ArrayList<>();
		List<RespuestaEncuesta> into = respuestas.getRespuestas().get(currentEnc.getId()).getListRP();
		for(int i = 0 ; i < selected.length; i++){
			if(selected[i] == 1)result.add(into.get(i));
		}
		
		Respuesta_Analisis ra = new Respuesta_Analisis(result);
		currentResp = ra;
	}





	public boolean encuestaWithoutRespuesta(String s) {		
		return !respuestas.getRespuestas().containsKey(Integer.parseInt(s));
	}





	public int getMaxK() {
		return currentResp.getSize();
	}





	public ArrayList<Integer> getClusterNumbers() {
		ArrayList<Integer> clusterName = new ArrayList<Integer>();
		for(Cluster c : currentResu.getClusters()){
			clusterName.add(c.getIndex());
		}
		return clusterName;
	}





	public ArrayList<String> getRespuestaDeCluster(Integer i) {
		ArrayList<String> list = new ArrayList<String>();
		for(RespuestaEncuesta re : currentResu.getClusters().get(i).getUsuarios()){
			list.add(re.getNombre()); //put id when it will be available
		}
		return list;
	}





	public void resuGuardar() {
		resultados.addResu(currentResu);
		//No se si hace falta guardar ahora
		resultados.guardarResu();
	}





	public String getClusterInfo(int i) {
		return currentResu.getClusters().get(i).getCentroid().toString();
	}





	public String getREInfo(String substring) {
		//Change when id available
		for(RespuestaEncuesta re : currentResp.getListRP()){
			if(re.getNombre().equals(substring)) return re.toString();
		}
		return null;
	}





	public ArrayList<String> getListResu() {
		ArrayList<String> result = new ArrayList<>();
		int i = 0;
		for(Resultado r : resultados.getResultados()){
			Encuesta e = r.getClusters().get(0).getCentroid().getEncuesta();
			result.add(i+". Resultado encuesta "+e.getId()+". - "+e.getGenero());
			i++;
		}
		return result;
	}





	public void selecionnarResultado(String s) {
		currentResu = resultados.selectR(s);
		
	}





	public void selecionnarREdesdeResu() {
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<RespuestaEncuesta>();
		for(Cluster c: currentResu.getClusters()){
			listRE.addAll(c.getUsuarios());
		}
		Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
		currentResp = ra;
		
	}
	
	
}
