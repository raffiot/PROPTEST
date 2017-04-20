package prop.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class Tipo_4Test {

	@Test
	public void generateAnswerTest(){
		ArrayList<String> array = new ArrayList<>();
		array.add("verde");
		array.add("amarillo");
		array.add("rojo");
		array.add("azul");
		array.add("negro");
		
		Tipo_4 t = new Tipo_4(0,"",5,array);
		RespuestaPregunta rp = t.generateAnswer();
		
		HashSet<String> set = new HashSet<String>(array);
		assertTrue(set.containsAll(rp.getValueR4()));
		
	}
	
}
