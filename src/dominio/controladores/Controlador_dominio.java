package dominio.controladores;

import dominio.clases.Conjunto_User;

public class Controlador_dominio {
	
	public String entrar(String username, String password) throws Exception{
		if(username == null || password == null ){
			throw new Exception("Unas de las entradas esta vacia");
		}
		Conjunto_User cu = new Conjunto_User();
		//Salvaguardar que usuario somos
		boolean find = cu.identification(username, password);
		if(find)
		return 
	}
}
