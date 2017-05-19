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
import dominio.clases.Respuesta_Analisis;

public class Persistencia_Respuesta extends Persistencia<HashMap<Integer, Respuesta_Analisis>>{

	@Override
	public HashMap<Integer, Respuesta_Analisis> leer(String path) {
		HashMap<Integer, Respuesta_Analisis> hm =null;
		try {
			//Stream para leer archivo
	        ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            
	        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	        hm = (HashMap<Integer, Respuesta_Analisis>) file.readObject();
	        //se cierra archivo
	            
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return hm;
	}


}
