package dominio.controladores.junit;

import dominio.clases.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tipo_2Test {

	@Test
	public void generateAnswerTest(){
		ArrayList<String> array = new ArrayList<>();
		array.add("molt-poc");
		array.add("poc");
		array.add("normal");
		array.add("força");
		array.add("molt");
		Tipo_2 t = new Tipo_2(0,"",5,array);
		RespuestaPregunta rp = t.generateAnswer();
		assertTrue(rp.getValueR2() >= 0 && rp.getValueR2() < 5);
		System.out.println(array.get(rp.getValueR2()));
		
		
	}
	
	@Test
	public void toString_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("muy mal");
		array.add("mal");
		array.add("regular");
		array.add("bien");
		array.add("muy bien");
		Tipo_2 t = new Tipo_2(0,"Como estas?",5,array);
		assertEquals(t.toString(),"0.Como estas?"+"\r\n"+"- "+"muy mal"+"\r\n"+"- "+"mal"+"\r\n"+"- "+"regular"+"\r\n"+"- "+"bien"+"\r\n"+"- "+"muy bien"+"\r\n");
	}
	@Test
	public void guardar_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("muy mal");
		array.add("mal");
		array.add("regular");
		array.add("bien");
		array.add("muy bien");
		Tipo_2 t = new Tipo_2(0,"Como estas?",5,array);
		assertEquals(t.guardar(),"2"+"\r\n"+"Como estas?"+"\r\n"+"5"+"\r\n"+"muy mal"+"\r\n"+"mal"+"\r\n"+"regular"+"\r\n"+"bien"+"\r\n"+"muy bien"+"\r\n");
	}
}
