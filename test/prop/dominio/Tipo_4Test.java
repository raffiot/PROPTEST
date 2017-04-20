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
	@Test
	public void toString_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("PAR");
		array.add("AC");
		array.add("PROP");
		array.add("IES");
		array.add("SOA");
		Tipo_4 t = new Tipo_4(0,"Indica que asignaturas cursas de las mostradas a continuacion",5,array);
		assertEquals(t.toString(),"0.Indica que asignaturas cursas de las mostradas a continuacion"+"\r\n"+"- "+"PAR"+"\r\n"+"- "+"AC"+"\r\n"+"- "+"PROP"+"\r\n"+"- "+"IES"+"\r\n"+"- "+"SOA"+"\r\n");
	}
	@Test
	public void guardar_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("PAR");
		array.add("AC");
		array.add("PROP");
		array.add("IES");
		array.add("SOA");
		Tipo_4 t = new Tipo_4(0,"Indica que asignaturas cursas de las mostradas a continuacion",5,array);
		assertEquals(t.guardar(),"4"+"\r\n"+"Indica que asignaturas cursas de las mostradas a continuacion"+"\r\n"+"5"+"\r\n"+"PAR"+"\r\n"+"AC"+"\r\n"+"PROP"+"\r\n"+"IES"+"\r\n"+"SOA"+"\r\n");
	}
}
