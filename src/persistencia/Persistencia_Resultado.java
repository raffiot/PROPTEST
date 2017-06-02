package persistencia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import dominio.clases.Resultado;

/**
 * Clase para leer o escribir en binario una lista de rustado de analisis
 * 
 * @author Raphael
 *
 */
public class Persistencia_Resultado extends Persistencia<ArrayList<Resultado>>{
	
	/**
	 * Metodo para leer la lista de resultado por el camino definido per path
	 * 
	 * @param path
	 * 		el lugar donde se lea el objeto
	 */
	@Override
	public ArrayList<Resultado> leer(String path) {
		ArrayList<Resultado> ap =null;
		try {
			//Stream para leer archivo
	        ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            
	        //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	        ap = (ArrayList<Resultado>) file.readObject();
	        //se cierra archivo
	            
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
		return ap;
	}

}
