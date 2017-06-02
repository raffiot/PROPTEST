package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import persistencia.Persistencia_User;

/**
 * Clase que representa la lista de usuario que se cargan al iniciar el programa.
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Cjt_users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Persona> users;
	
	private String pathUser = "Data/Usuarios/users.dat";

	/**
	 * Metodo para obtenir la lista de persona
	 * 
	 * @return
	 * 		la lista de persona (participante y administradores)
	 */
	public ArrayList<Persona> getUsers() {
		return users;
	}
	
	/**
	 * Constructora de la clase que crea una lista de persona vacia
	 */
	public Cjt_users(){
		this.users = new ArrayList<Persona>();
		
	}
	
	/**
	 * Metodo para leer los usuarios desde un binario
	 */
	public void leerUsu(){	
		
		//Persistencia<ArrayList<Persona>> p = new Persistencia<ArrayList<Persona>>(aux);
		Persistencia_User p = new Persistencia_User();
		users = p.leer(pathUser);
		
	}
	
	/**
	 * Metodo para guardar los usuarios en binario
	 */
	public void guardarUsu(){
		
		Persistencia_User p = new Persistencia_User();
		p.escribir(pathUser,users);
		
		
	}
	
	/**
	 * Metodo para comprobar si un usuario ya existe segun su username
	 * 
	 * @param username
	 * 		el username que queremos verificar si existe
	 * @return
	 * 		un boolean que esta true si el username esta utilisado y falso sino
	 */
	public boolean yaExiste(String username){
		for(Persona p : users){
			if(p.getNombre().equals(username)) return true;
		}
		return false;
	}
	
	/**
	 * Metodo para anadir un usuario para que se guarda en el binario despues
	 * 
	 * @param username
	 * 		el nombre del nuevo usuario
	 * @param password
	 * 		la contresena del nuevo usuario
	 * @param type
	 * 		el typo de usuario, 0 si es un admin, 1 si es un usuario
	 */
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
	
	/**
	 * Metodo para quitar un usuario segun su username
	 * 
	 * @param username
	 * 		el nombre del usuario que se quiere quitar
	 */
	public void removeUser(String username){
		users.removeIf(new Predicate<Persona>() {

			@Override
			public boolean test(Persona t) {
				// TODO Auto-generated method stub
				return t.getNombre().equals(username);
			}
		});
	}
	
	/**
	 * Metodo para comprobar si el usuario se a identificado bien
	 * 
	 * @param username
	 * 		el nombre del usuario que se intenta identificar
	 * @param password
	 * 		la contrasena de la persona que se intenta identificar
	 * @return
	 * 		true si la identificacion a funcionnado falso sino
	 */
	public boolean identification(String username, String password){
		
		for(Persona p : users){
			if(p.getNombre().equals(username) && p.getPassword().equals(password)) return true;
		}
		return false;
	}
	
	/**
	 * Metodo para obtenir el tipo de usuario (admin o participant)
	 * 
	 * @param username
	 * 		el nombre del usuario que se quiere comprobar
	 * @return
	 * 		el tipo de usuario en un entero
	 */
	public int getType(String username){
		for(Persona p : users){
			if(p.getNombre().equals(username)) return p.getTipo();
		}
		return -1;
	}
	
	
}
