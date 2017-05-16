package persistencia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import dominio.clases.Encuesta;
import dominio.clases.RespuestaEncuesta;

public class Persistencia_Encuesta extends Persistencia<ArrayList<Encuesta>>{

	@Override
	public ArrayList<Encuesta> leer(String path) {
		ArrayList<Encuesta> ap =null;
		try {
			//Stream para leer archivo
	        ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            
	        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	        ap = (ArrayList<Encuesta>) file.readObject();
	        //se cierra archivo
	            
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return ap;
	}

}
