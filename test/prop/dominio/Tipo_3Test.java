package prop.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tipo_3Test {
	
	@Test
	public void generateAnswerTest(){
		ArrayList<String> array = new ArrayList<>();
		array.add("verde");
		array.add("amarillo");
		array.add("rojo");
		array.add("azul");
		array.add("negro");
		
		Tipo_3 t = new Tipo_3(0,"",5,array);
		RespuestaPregunta rp = t.generateAnswer();
		assertTrue(array.contains(rp.getValueR3()));
		System.out.println(rp.getValueR3());
		System.out.println(t.generateAnswer().getValueR3());
	}

}
