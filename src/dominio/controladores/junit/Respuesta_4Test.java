package dominio.controladores.junit;

import java.util.HashSet;
import java.util.Set;

import dominio.clases.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Respuesta_4Test {
	@Test
	public void distanceTest(){	
		Set<String> set1 =new HashSet<>();
		set1.add("haha");
		set1.add("hihi");
		set1.add("hoho");
		Set<String> set2 =new HashSet<>();
		set2.add("hyhy");
		set2.add("hihi");
		set2.add("hoho");
		set2.add("lala");
		
		RespuestaPregunta p1 = new Respuesta_4(null,set1);
		RespuestaPregunta p2 = new Respuesta_4(null,set2);
		
		double distance = p1.distance(p2, 0, 0, 0);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertTrue("the distance is inferior to 0",distance >= 0);
		assertEquals("the distance isn't well computed",1-2./5,distance,0);
	}
}
