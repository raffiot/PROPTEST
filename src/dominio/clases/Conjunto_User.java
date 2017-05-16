package dominio.clases;

import java.util.ArrayList;

import persistencia.Persistencia;

public class Conjunto_User {
	ArrayList<String> users;
	ArrayList<String> passwords;
	ArrayList<String> type;
	final String pathUser = "Data/user";
	final String pathPass = "Data/path";
	final String pathType = "Data/type";
	
	
	public void leerMaps(){	
		
		ArrayList<String> aux = new ArrayList<String>();
		Persistencia<ArrayList<String>> p = new Persistencia<ArrayList<String>>(aux);
		p.leer(pathUser);
		users = aux;
		
		aux = new ArrayList<String>();
		p.leer(pathPass);
		passwords = aux;
		
		aux = new ArrayList<String>();
		p.leer(pathType);
		type = aux;
	}
	
	public void guardarMaps(){
		ArrayList<String> aux = new ArrayList<String>();
		Persistencia<ArrayList<String>> p = new Persistencia<ArrayList<String>>(aux);
		
		aux = users;
		p.escribir(pathUser);
		
		aux = passwords;
		p.escribir(pathPass);
		
		aux = type;
		p.escribir(pathType);
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
