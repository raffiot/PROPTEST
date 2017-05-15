package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Persistencia<T> {
	T obj;
	
	public Persistencia(T obj){
		this.obj = obj;
	}
	
	public T leer(String path){
		 
		try {
	            //Stream para leer archivo
	            ObjectInputStream file = new ObjectInputStream(new FileInputStream( path));
	            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
	            obj = (T) file.readObject();
	            //se cierra archivo
	            file.close();
	            //Se utilizan metodos de la clase asi como variables guardados en el objeto
	           
	        } catch (ClassNotFoundException ex) {
	             System.out.println(ex);
	        } catch (IOException ex) {
	             System.out.println(ex);
	       }
		
		return this.obj;
		
	}
	
	public void escribir(String path){
		try {
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( path ));
            //Se escribe el objeto en archivo
            file.writeObject(this.obj);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
		
		
		
	}
	
	

}
