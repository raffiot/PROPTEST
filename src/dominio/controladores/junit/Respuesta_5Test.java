package dominio.controladores.junit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dominio.clases.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Respuesta_5Test {
	
	public String funcionnalString(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	
	@Test
	public void distanceTest(){	
		String funWord="";
		try {
			funWord = funcionnalString("empty.sp");
		} catch (IOException e) {
			System.out.println("failled to get funcionnal String");
			e.printStackTrace();
		}
		RespuestaPregunta p1 = new Respuesta_5(null,"chiens");
		RespuestaPregunta p2 = new Respuesta_5(null,"niche");
		double distance = p1.distance(p2, 0, 0, 0,funWord);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",5./6,distance,0);
	}
	
	//Test with sentences
	@Test
	public void distanceTest2(){	
		String funWord="";
		try {
			funWord = funcionnalString("empty.sp");
		} catch (IOException e) {
			System.out.println("failled to get funcionnal String");
			e.printStackTrace();
		}
		RespuestaPregunta p1 = new Respuesta_5(null,"todo Genial");
		RespuestaPregunta p2 = new Respuesta_5(null,"genial");
		double distance = p1.distance(p2, 0, 0, 0,funWord);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",0,distance,0);
	}
	
	@Test
	public void distanceZeroTest(){
		String funWord="";
		try {
			funWord = funcionnalString("empty.sp");
		} catch (IOException e) {
			System.out.println("failled to get funcionnal String");
			e.printStackTrace();
		}
		RespuestaPregunta p1 = new Respuesta_5(null,"chien");
		RespuestaPregunta p2 = new Respuesta_5(null,"chien");
		double distance = p1.distance(p2, 0, 0, 0, funWord);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",0,distance,0);
	}
	
	@Test
	public void distanceOneTest(){
		String funWord="";
		try {
			funWord = funcionnalString("empty.sp");
		} catch (IOException e) {
			System.out.println("failled to get funcionnal String");
			e.printStackTrace();
		}
		RespuestaPregunta p1 = new Respuesta_5(null,"chien");
		RespuestaPregunta p2 = new Respuesta_5(null,"abgdx");
		double distance = p1.distance(p2, 0, 0, 0,funWord);
		assertTrue("the distance is superior to 1",distance <= 1);
		assertEquals("the distance is not the one expected",1,distance,0);
	}
}
