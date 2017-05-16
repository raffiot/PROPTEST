package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import dominio.clases.Persona;
import dominio.clases.RespuestaEncuesta;

public class Persistencia_Respuesta extends Persistencia<HashMap<Integer,RespuestaEncuesta>>{

	@Override
	public HashMap<Integer, RespuestaEncuesta> leer(String path) {
		HashMap<Integer, RespuestaEncuesta> hm =null;
		try {
			//Stream para leer archivo
	        ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            
	        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	        hm = (HashMap<Integer, RespuestaEncuesta>) file.readObject();
	        //se cierra archivo
	            
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return hm;
	}


}
