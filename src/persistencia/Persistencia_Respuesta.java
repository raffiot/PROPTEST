package persistencia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

import dominio.clases.Respuesta_Analisis;

/**
 * Clase para leer o escribir en binario una lista de respuestas a encuestas organizadas per encuestas
 * 
 * HashMap<Integer, Respuesta_Analisis> -> el Integer corresponde al index de la encuesta,
 * la Respuesta_Analisis es un conjunto de respuestas a la encuesta
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Persistencia_Respuesta extends Persistencia<HashMap<Integer, Respuesta_Analisis>>{

	/**
	 * Metodo para leer la lista de respuestas a encuesta ordenadas por el camino definido per path
	 * 
	 * @param path
	 * 		el lugar donde se lea el objeto
	 */
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
