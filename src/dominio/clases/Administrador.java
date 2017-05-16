package dominio.clases;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {
	
	public Administrador(String username, String password){
		super(username,password,0);
	
	}

}
