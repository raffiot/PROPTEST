package dominio.clases;

import java.util.Map;

public class Conjunto_User {
	Map<String,String> user_pass;
	Map<String,String> user_type;
	
	public void generateMaps(){
		//get from binary to fill maps
	}
	
	public boolean yaExiste(String username){
		return user_pass.containsKey(username);
	}
	
	public void addUser(String username, String password, String type){
		user_pass.put(username, password);
		user_type.put(username, type);
	}
	
	public void removeUser(String username){
		user_pass.remove(username);
		user_type.remove(username);
	}
	
	public boolean identification(String username, String password){
		return user_pass.get(username).equals(password);
	}
	
	public String getType(String username){
		return user_type.get(username);
	}
	
}
