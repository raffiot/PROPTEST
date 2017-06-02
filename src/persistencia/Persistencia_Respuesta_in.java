package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.HashMap;

import dominio.clases.RespuestaEncuesta;

public class Persistencia_Respuesta_in extends Persistencia<HashMap<Integer, RespuestaEncuesta>> {

	@Override
	public HashMap<Integer, RespuestaEncuesta> leer(String path) {
		HashMap<Integer, RespuestaEncuesta> hm =null;
		try {
			
			File aux = new File(path);
			if (aux.exists()){
				
				//Stream para leer archivo
				ObjectInputStream file = new ObjectInputStream(new FileInputStream(path));
		            
		        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
		         
		        hm = (HashMap<Integer, RespuestaEncuesta>) file.readObject();
		        //se cierra archivo
		        file.close();
			}
			else{
				FileWriter fichero = null;
			    fichero = new FileWriter(path);
			    super.escribir(path, hm);
			}
	            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return hm;
	}
}
