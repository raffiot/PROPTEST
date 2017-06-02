package persistencia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Classe abstracta que define el escribir el objeto T en binario y el metodo leer como abstracta para que se redefine.
 * 
 * @author Miguel
 * @author Raphael
 *
 * @param <T>
 * 		el objeto que se guarda y que se lee en binario.
 */
public abstract class Persistencia<T> {
	
	/**
	 * Metodo para leer que se debe redefinir en la subclasses.
	 * Este metodo esta abstracta para no tener problemas de casting con el typo generico T
	 * 
	 * @param path
	 * 		el camino de donde se lea el objeto
	 * @return
	 * 		el objeto leido
	 */
	public abstract T leer(String path);
	
	/**
	 * Metodo para escribir el objeto obj al sitio definido per path
	 * 
	 * @param path
	 * 		el lugar donde se guarda el objeto
	 * @param obj
	 * 		el objeto de typo T que se guarda
	 */
	public void escribir(String path,T obj){
		try {
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( path ));
            //Se escribe el objeto en archivo
            file.writeObject(obj);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }	
	}
		
}
