package dominio.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import persistencia.Persistencia;

public class Conjunto_User {
	List<String> users;
	List<String> passwords;
	List<String> type;
	final String pathUser = "Data/user";
	final String pathPass = "Data/path";
	final String pathType = "Data/type";
	
	
	@SuppressWarnings("unchecked")
	public void leerMaps(){	
		users = (ArrayList<String>) Persistencia.leer(pathUser);
		passwords = (ArrayList<String>) Persistencia.leer(pathPass);
		type = (ArrayList<String>) Persistencia.leer(pathType);
	}
	
	public void guardarMaps(){
		
		Persistencia.escribir(users, pathUser);
		Persistencia.escribir(users, pathPass);
		Persistencia.escribir(users, pathType);
	}
	
	public boolean yaExiste(String username){
		return users.contains(username);
	}
	
	public void addUser(String username, String password, String type){
		users.add(username);
		passwords.add(password);
		this.type.add(type);
	}
	
	public void removeUser(String username){
		int index = users.indexOf(username);
		users.remove(index);
		passwords.remove(index);
		type.remove(index);
	}
	
	public boolean identification(String username, String password){
		int index = users.indexOf(username);
		return passwords.get(index).equals(password);
	}
	
	public String getType(String username){
		int index = users.indexOf(username);
		return type.get(index);
	}
	
}
