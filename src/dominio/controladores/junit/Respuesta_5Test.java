package dominio.controladores.junit;

import dominio.clases.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Respuesta_5Test {

	@Test
	public void distanceTest(){		
		RespuestaPregunta p1 = new Respuesta_5(null,"chiens");
		RespuestaPregunta p2 = new Respuesta_5(null,"niche");
		double distance = p1.distance(p2, 0, 0, 0);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",5./6,distance,0);
	}
	
	@Test
	public void distanceZeroTest(){		
		RespuestaPregunta p1 = new Respuesta_5(null,"chien");
		RespuestaPregunta p2 = new Respuesta_5(null,"chien");
		double distance = p1.distance(p2, 0, 0, 0);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",0,distance,0);
	}
	
	@Test
	public void distanceOneTest(){		
		RespuestaPregunta p1 = new Respuesta_5(null,"chien");
		RespuestaPregunta p2 = new Respuesta_5(null,"abgdx");
		double distance = p1.distance(p2, 0, 0, 0);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",1,distance,0);
	}
}
