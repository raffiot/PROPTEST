package persistencia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import dominio.clases.Resultado;

public class Persistencia_Resultado extends Persistencia<ArrayList<Resultado>>{

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
