package dominio.controladores;

import dominio.clases.Cjt_encuestas;
import dominio.clases.Conjunto_User;

public class Controlador_dominio {
		private Cjt_encuestas encuestas;
		private Conjunto_User users;
		
	public Controlador_dominio(){
		Cjt_encuestas e = new Cjt_encuestas();
		this.setEncuestas(e);
		Conjunto_User u = new Conjunto_User();
		this.users = u;
		cargar_usuarios();
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
	
	private void cargar_usuarios(){
		users.leerMaps();
	}


	public Cjt_encuestas getEncuestas() {
		return encuestas;
	}


	public void setEncuestas(Cjt_encuestas encuestas) {
		this.encuestas = encuestas;
	}
}
