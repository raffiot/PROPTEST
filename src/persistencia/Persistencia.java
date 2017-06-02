package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dominio.clases.Persona;


public abstract class Persistencia<T> {
	
	public abstract T leer(String path);
	
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
