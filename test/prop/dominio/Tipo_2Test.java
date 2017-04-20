package prop.dominio;

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
}
