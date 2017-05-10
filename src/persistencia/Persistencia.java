package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Persistencia {
	
	public static Object leer(String path){
		Object o = null; 
		try {
	            //Stream para leer archivo
	            ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	            o = file.readObject();
	            //se cierra archivo
	            file.close();
	            //Se utilizan metodos de la clase asi como variables guardados en el objeto
	           
	        } catch (ClassNotFoundException ex) {
	             System.out.println(ex);
	        } catch (IOException ex) {
	             System.out.println(ex);
	       }
		
		return o;
		
	}
	
	public static void escribir(Object o, String path){
		try {
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( path ));
            //Se escribe el objeto en archivo
            file.writeObject(o);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
		
		
		
	}
	
	

}
