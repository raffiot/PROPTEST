package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import persistencia.Persistencia;
import persistencia.Persistencia_User;

public class Cjt_users implements Serializable{
	private ArrayList<Persona> users;
	
	private String pathUser = "Data/Usuarios/users.dat";

	
	public ArrayList<Persona> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<Persona> users) {
		this.users = users;
	}


	public String getPathUser() {
		return pathUser;
	}


	public void setPathUser(String pathUser) {
		this.pathUser = pathUser;
	}


	public Cjt_users(){
		this.users = new ArrayList<Persona>();
		
	}
	
	
	public void leerUsu(){	
		
		//Persistencia<ArrayList<Persona>> p = new Persistencia<ArrayList<Persona>>(aux);
		Persistencia_User p = new Persistencia_User();
		users = p.leer(pathUser);
		
	}
	
	public void guardarUsu(){
		
		Persistencia_User p = new Persistencia_User();
		p.escribir(pathUser,users);
		
		
	}
	
	public boolean yaExiste(String username){
		for(Persona p : users){
			if(p.getNombre().equals(username)) return true;
		}
		return false;
	}
	
	public void addUser(String username, String password, int type){
		Persona a = null;
		if(type == 0){
			a = new Administrador(username,password);
		}
		else if (type == 1){
			a = new Usuario(username,password); 
		}
		
		users.add(a);
		
	}
	
	public void removeUser(String username){
		users.removeIf(new Predicate<Persona>() {

			@Override
			public boolean test(Persona t) {
				// TODO Auto-generated method stub
				return t.getNombre().equals(username);
			}
		});
	}
	
	public boolean identification(String username, String password){
		
		for(Persona p : users){
			if(p.getNombre().equals(username) && p.getPassword().equals(password)) return true;
		}
		return false;
	}
	
	public int getType(String username){
		for(Persona p : users){
			if(p.getNombre().equals(username)) return p.getTipo();
		}
		return -1;
	}
	
	
}
