package prop.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tipo_1Test {
	
	@Test
	public void generateAnswerTest(){
		Tipo_1 t1 = new Tipo_1(0,"",1,2000,0);
		RespuestaPregunta rp = t1.generateAnswer();
		boolean b = rp.getValueR1() <= 2000 && rp.getValueR1() >= 0;
		assertTrue(b);
		
		Tipo_1 t2 = new Tipo_1(1,"",1,200,-200);
		RespuestaPregunta rp2 = t2.generateAnswer();
		boolean b2 = rp2.getValueR1() <= 200 && rp2.getValueR1() >= -200;
		assertTrue(b2);
	}
	
}
