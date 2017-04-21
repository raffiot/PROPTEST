package dominio.controladores.junit;

import dominio.clases.*;
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
	@Test
	public void toString_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("rojo");
		array.add("negro");
		array.add("azul");
		array.add("amarillo");
		array.add("rosa");
		Tipo_3 t = new Tipo_3(0,"Cual es tu color favorito?",5,array);
		assertEquals(t.toString(),"0.Cual es tu color favorito?"+"\r\n"+"- "+"rojo"+"\r\n"+"- "+"negro"+"\r\n"+"- "+"azul"+"\r\n"+"- "+"amarillo"+"\r\n"+"- "+"rosa"+"\r\n");
	}
	@Test
	public void guardar_test(){
		ArrayList<String> array = new ArrayList<>();
		array.add("rojo");
		array.add("negro");
		array.add("azul");
		array.add("amarillo");
		array.add("rosa");
		Tipo_3 t = new Tipo_3(0,"Cual es tu color favorito?",5,array);
		assertEquals(t.guardar(),"3"+"\r\n"+"Cual es tu color favorito?"+"\r\n"+"5"+"\r\n"+"rojo"+"\r\n"+"negro"+"\r\n"+"azul"+"\r\n"+"amarillo"+"\r\n"+"rosa"+"\r\n");
	}

}
