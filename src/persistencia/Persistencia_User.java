package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dominio.clases.Cjt_users;
import dominio.clases.Persona;

/**
 * Clase para leer o escribir en binario una lista de usuarios y administradores.
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Persistencia_User extends Persistencia<ArrayList<Persona>>{

	/**
	 * Metodo para leer la lista de persona por el camino definido per path
	 * 
	 * @param path
	 * 		el lugar donde se lea el objeto
	 */
	@Override
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
