package dominio.controladores.junit;

import dominio.clases.*;
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
	@Test
	public void toString_test() {
		Tipo_1 t1 = new Tipo_1(0,"Que nota tendras en el examen de prop?",6,5,0);
		String s = t1.toString();
		assertEquals(s,"0.Que nota tendras en el examen de prop?"+"\r\n"+"- "+ "0" + "\r\n" +"- "+ "1" + "\r\n"+"- "+ "2" + "\r\n"+"- "+ "3" + "\r\n"+"- "+ "4" + "\r\n"+"- "+ "5" + "\r\n");
	}
	
	@Test
	public void guardar_test() {
		Tipo_1 t1 = new Tipo_1(0,"Que nota tendras en el examen de prop?",6,5,0);
		String s = t1.guardar();
		assertEquals(s,"1"+"\r\n"+"Que nota tendras en el examen de prop?"+"\r\n"+"0"+"\r\n"+"5"+"\r\n");
	}
	
}
