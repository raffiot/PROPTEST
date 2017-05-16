package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dominio.clases.Cjt_users;
import dominio.clases.Persona;

public class Persistencia_User extends Persistencia<ArrayList<Persona>>{

	
	public ArrayList<Persona> leer(String path){
		ArrayList<Persona> ap =null;
		try {
			//Stream para leer archivo
	        ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            
	        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	        ap = (ArrayList<Persona>) file.readObject();
	        //se cierra archivo
	            
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return ap;
	}
	
}
