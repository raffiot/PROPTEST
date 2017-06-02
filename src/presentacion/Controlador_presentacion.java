package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JEditorPane;

import dominio.clases.Analisis;
import dominio.clases.Encuesta;
import dominio.clases.Pregunta;
import dominio.clases.RespuestaEncuesta;
import dominio.clases.RespuestaPregunta;
import dominio.clases.Respuesta_Analisis;
import dominio.controladores.Controlador_dominio;

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
	
	public void crearEncuesta(){
		cd.crearEncuesta();
	}
	
	public void anadirPegunta1(String en, int min, int max){
		
		cd.anadirPegunta1(en,min,max);
	
		
	}
	
	public void guardarEncuesta(String s) {
		cd.guardarEncuesta(s);
	}

	public void anadirPegunta234(String text, ArrayList<String> opcs, int tipo) {
		cd.anadirPegunta234(text,opcs,tipo);
		
	}

	public void anadirTipo5(String s) {
		cd.anadirPegunta5(s);
		
	}

	public int getnpreguntas(){
		 return cd.getnpreguntas();
	}
	
	public int gettipo(Integer i){
		return cd.gettipo(i);
	}

	public int getminOpt1(Integer i){
		return cd.getminOpt1(i);
	}
	
	public int getmaxOpt1(Integer i){
		return cd.getmaxOpt1(i);
	}
	
	public ArrayList<String> getopcionest2(Integer i){
		return cd.getopcionest2(i);
	}
	
	public ArrayList<String> getopcionest3(Integer i){
		return cd.getopcionest3(i);
	}
	
	public ArrayList<String> getopcionest4(Integer i){
		return cd.getopcionest4(i);
	}

	public ArrayList<String> getPre() {
		return cd.getPre();
	}

	public void guardarPre(String text, int i) {
		cd.guardarPre(text,i);
		
	}

	public void setGenero(String s) {
		cd.setGenero(s);
		
	}

	

	public String getRespuestasDistrib() {
		return cd.getRespuestasDistrib();
	}
	
	public Pregunta getPreguntaiessima(Integer i){
		return cd.getPreguntaiessima(i);
	}
	
	public int getPosicion(Pregunta p,String q,Integer i){
		return cd.getPosicion(p,q,i);
	}
	
	public void guardarRespuestaEnc(List<RespuestaPregunta> rp){
		cd.guardarRespuestaEnc(rp);
	}


	public HashMap<String, Double> getDistanceDistribClus(String substring) {
		return cd.getDistanceDistribClus(substring);
	}
	
	public void guardarRespuestaEncNoAcabada(List<RespuestaPregunta> rp){
		cd.guardarRespuestaEncNoAcabada(rp);
	}
	
	public ArrayList<String> getListNoAcabadas(){
		return cd.getListNoAcabadas();
	}
	
	public void guardarResT1(Integer value,Integer numPreg){
		cd.guardarResT1(value,numPreg);
	}
	
	public void guardarResT2(String value,Integer numPreg){
		cd.guardarResT2(value,numPreg);
	}
	
	public void guardarResT3(String value,Integer numPreg){
		cd.guardarResT2(value,numPreg);
	}
}
