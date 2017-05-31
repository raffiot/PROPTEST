package dominio.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		String s = "";
		for(RespuestaEncuesta re : currentResp.getListRP()){
			if(re.getNombre().equals(substring)){
				s = re.toString();
				s+="Distancia con los centroids :\n";
				ArrayList<Double> distances = currentResu.getMapDistance().get(substring);
				for(int i=0; i<distances.size(); i++){
					s+="	Centroid del cluster "+i+": "+distances.get(i)+"\n";
				}
			}
		}
		return s;
	}





	public ArrayList<String> getListResu() {
		ArrayList<String> result = new ArrayList<>();
		int i =0;
		for(Resultado r : resultados.getResultados()){
			Encuesta e = r.getClusters().get(0).getCentroid().getEncuesta();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			result.add(i+". "+dateFormat.format(r.getData())+", Resultado encuesta "+e.getId()+". - "+e.getGenero());
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
	
	public void crearEncuesta(){
		currentEnc = new Encuesta(0);
		currentEnc.setId(encuestas.size()+1);
		
	}
	public void guardarEncuesta(String s) {
		currentEnc.setGenero(s);
		Date fecha = new Date();
		currentEnc.setFecha(fecha.toString());
		encuestas.anadirEncuesta(currentEnc);
	}
	
	public void anadirPegunta1(String en, int min, int max){
		Tipo_1 p = new Tipo_1();
		p.setEnunciado(en);
		p.setMin(min);
		p.setMax(max);
		p.setOpciones(max-min+1);
		p.setId(currentEnc.getN_preguntas()+1); 
		currentEnc.anadir_pregunta(p);
		
	}





	public void anadirPegunta234(String text, ArrayList<String> opcs, int tipo) {
	if (tipo == 2 ){
		Tipo_2 p1 = new Tipo_2();
		p1.setEnunciado(text);
		p1.setOpciones(opcs.size());
		for (int i = 0; i < p1.getOpciones(); ++i) {
			p1.anadir_opcion(opcs.get(i));
		}
		p1.setId(currentEnc.getN_preguntas()+1);
		currentEnc.anadir_pregunta(p1);
	}
	
	if (tipo == 3){
		Tipo_3 p1 = new Tipo_3();
		p1.setEnunciado(text);
		p1.setOpciones(opcs.size());
		for (int i = 0; i < p1.getOpciones(); ++i) {
			p1.anadir_opcion(opcs.get(i));
		}
		p1.setId(currentEnc.getN_preguntas()+1);
		currentEnc.anadir_pregunta(p1);
	}
	
	if (tipo == 4){
		Tipo_4 p1 = new Tipo_4();
		p1.setEnunciado(text);
		p1.setOpciones(opcs.size());
		for (int i = 0; i < p1.getOpciones(); ++i) {
			p1.anadir_opcion(opcs.get(i));
		}
		p1.setId(currentEnc.getN_preguntas()+1);
		currentEnc.anadir_pregunta(p1);
	}
		
}


	public void anadirPegunta5(String s) {
		Tipo_5 p = new Tipo_5();
		p.setEnunciado(s);
		p.setId(currentEnc.getN_preguntas()+1);
		currentEnc.anadir_pregunta(p);
	
		
	}
	
	public int getnpreguntas(){
		//System.out.println(currentEnc);
		//System.out.println(currentEnc.getN_preguntas());
		return currentEnc.getN_preguntas();
	}
	
	public int gettipo(Integer index){
		int res=0;
		ArrayList<Pregunta> llista = currentEnc.getPreguntas();
		for (int i = 0; i < currentEnc.getN_preguntas(); ++i){
			if ( i == index){
				Pregunta p = llista.get(i);//la pregunta i
				res = p.getTipo();
			}
		}
		return res;
	}

	public int getminOpt1(Integer index){
		int res=0;
		ArrayList<Pregunta> llista = currentEnc.getPreguntas();
		for (int i = 0; i < currentEnc.getN_preguntas(); ++i){
			if ( i == index){
				Pregunta p = (Tipo_1) llista.get(i);//la pregunta i
				res = ((Tipo_1) p).getMin();
			}
		}
		return res;
	}
	
	public int getmaxOpt1(Integer index){
		int res=0;
		ArrayList<Pregunta> llista = currentEnc.getPreguntas();
		for (int i = 0; i < currentEnc.getN_preguntas(); ++i){
			if ( i == index){
				Pregunta p = (Tipo_1) llista.get(i);//la pregunta i
				res = ((Tipo_1) p).getMax();
			}
		}
		return res;
	}
	
	public ArrayList<String> getopcionest2(Integer index){
		ArrayList<String> opciones = new ArrayList<String>();
		ArrayList<Pregunta> llista = currentEnc.getPreguntas();
		for (int i = 0; i < currentEnc.getN_preguntas(); ++i){
			if ( i == index){
				Pregunta p = (Tipo_2) llista.get(i);//la pregunta i
				opciones = ((Tipo_2) p).getLista_opciones();
			}
		}
		return opciones;
	}
	
	public ArrayList<String> getopcionest3(Integer index){
		ArrayList<String> opciones = new ArrayList<String>();
		ArrayList<Pregunta> llista = currentEnc.getPreguntas();
		for (int i = 0; i < currentEnc.getN_preguntas(); ++i){
			if ( i == index){
				Pregunta p = (Tipo_3) llista.get(i);//la pregunta i
				opciones = ((Tipo_3) p).getLista_opciones();
			}
		}
		return opciones;
	}
}
