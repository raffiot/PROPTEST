package dominio.controladores.junit;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dominio.clases.Cjt_users;
import dominio.clases.Persona;


public class UsuarioTest {
	@Test
	public void toString_test() throws ClassNotFoundException {
		Cjt_users u = new Cjt_users();
		Cjt_users u1 = new Cjt_users();
		u.addUser("Pepe", "1234", 1);
		u.guardarMaps();
		u1.leerMaps();
		
		assertEquals(u.getUsers().get(0).getNombre(),u1.getUsers().get(0).getNombre());
	}

}


