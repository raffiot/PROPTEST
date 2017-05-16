package dominio.controladores.junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.clases.Conjunto_User;


public class UsuarioTest {
	@Test
	public void toString_test() {
		Conjunto_User u = new Conjunto_User();
		Conjunto_User u1 = new Conjunto_User();
		u.addUser("Pepe", "1234", 1);
		u.guardarMaps();
		u1.leerMaps();
		System.out.println(u.getUsers().size());
		System.out.println(u1.getUsers().size());
		
		assertEquals(u.getUsers().get(0).getNombre(),u1.getUsers().get(0).getNombre());
	}

}


