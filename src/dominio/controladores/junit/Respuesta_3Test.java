package dominio.controladores.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.clases.*;

public class Respuesta_3Test {
	@Test
	public void distanceTestequal0(){	
		RespuestaPregunta p1 = new Respuesta_3(null,"test");
		RespuestaPregunta p2 = new Respuesta_3(null,"test");
		
		double distance = p1.distance(p2, 0, 0, 0,null);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertTrue("the distance is inferior to 0",distance >= 0);
		assertEquals("the distance isn't well computed",0,distance,0);
	}
}
