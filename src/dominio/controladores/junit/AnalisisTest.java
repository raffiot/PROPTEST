package dominio.controladores.junit;

import dominio.clases.*;
import static org.junit.Assert.*;
import dominio.clases.Analisis.MinMax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;



public class AnalisisTest {
	
	/**
	 * Este metodo crea un objeto Analisis con 
	 * Una encuesta que contiene 4 preguntas, las 2 primeras de tipo 1, la tercera de tipo 2, la cuarta de tipo 3 y la quinta de tipo 1.
	 * 3 respuestas a este encuesta.
	 * 
	 * @return
	 * 		la analisis creada
	 */
	private Analisis createAnalisis(){
		
		ArrayList<Pregunta> preguntas = new ArrayList<>();
		
		Pregunta p11 = new Tipo_1(0,"Que nota sacaremos en PROP?",1,0,10);
		preguntas.add(p11);
		
		Pregunta p12 = new Tipo_1(3,"Cuantas horas has dedicado a PROP?",1,0,20);
		preguntas.add(p12);
		
		Pregunta p13 = new Tipo_1(4,"Cuantas veces vas al cine per ano?",1,3,20);
		
		ArrayList<String> respp2 = new ArrayList<String>();
		respp2.add("no es bo");
		respp2.add("medio");
		respp2.add("bo");
		respp2.add("molt bo");
		Pregunta p2 = new Tipo_2(1,"Que tal la tortilla del bar?",4,respp2);
		preguntas.add(p2);
		
		ArrayList<String> respp3 = new ArrayList<String>();
		respp3.add("nieve");
		respp3.add("lluvia");
		respp3.add("sol");
		Pregunta p3 = new Tipo_3(2,"Que tiempo hace hoy",3,respp3);
		preguntas.add(p3);

		preguntas.add(p13);

		String d = "";
		Encuesta e = new Encuesta(0,5,"",d,preguntas);
		
		List<RespuestaPregunta> list1 = new ArrayList<RespuestaPregunta>();
		RespuestaPregunta rp11 = new Respuesta_1(p11,10);
		list1.add(rp11);
		RespuestaPregunta rp112 = new Respuesta_1(p12,10);
		list1.add(rp112);
		RespuestaPregunta rp12 = new Respuesta_2(p2,2);
		list1.add(rp12);
		RespuestaPregunta rp13 = new Respuesta_3(p3,"sol");
		list1.add(rp13);
		RespuestaPregunta rp113 = new Respuesta_1(p13,15);
		list1.add(rp113);
		RespuestaEncuesta re1 = new RespuestaEncuesta(e,null,list1);
		
		List<RespuestaPregunta> list2 = new ArrayList<RespuestaPregunta>();
		RespuestaPregunta rp21 = new Respuesta_1(p11,2);
		list2.add(rp21);
		RespuestaPregunta rp212 = new Respuesta_1(p12,8);
		list2.add(rp212);
		RespuestaPregunta rp22 = new Respuesta_2(p2,3);
		list2.add(rp22);
		RespuestaPregunta rp23 = new Respuesta_3(p3,"nieve");
		list2.add(rp23);
		RespuestaPregunta rp213 = new Respuesta_1(p13,17);
		list2.add(rp213);
		RespuestaEncuesta re2 = new RespuestaEncuesta(e,null,list2);
		
		List<RespuestaPregunta> list3 = new ArrayList<RespuestaPregunta>();
		RespuestaPregunta rp31 = p11.generateAnswer();
		list3.add(rp31);
		RespuestaPregunta rp312 = p12.generateAnswer();
		list3.add(rp312);
		RespuestaPregunta rp32 = p2.generateAnswer();
		list3.add(rp32);
		RespuestaPregunta rp33 = p3.generateAnswer();
		list3.add(rp33);
		RespuestaPregunta rp313 = p13.generateAnswer();
		list3.add(rp313);
		RespuestaEncuesta re3 = new RespuestaEncuesta(e,null,list3);
		
		List<RespuestaEncuesta> listRE = new ArrayList<RespuestaEncuesta>();
		listRE.add(re1);
		listRE.add(re2);
		listRE.add(re3);
		Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
		
		double threshold = 0.2;
		return new Analisis(0,2,threshold,ra,e);
	
	}

	/**
	 * Este metodo prueba que se han creado los clusters con el metodo createCluster
	 * y muestra por pantalla las respuestas.
	 */
	
	@Test
	public void createClusterTest(){
		Analisis an = createAnalisis();		
		List<Cluster> list = an.createCluster(2,an.getRespEncuestas());
		assertNotNull(list.get(0));
		assertNotNull(list.get(1));
		Pregunta p1 = list.get(0).getCentroid().getEncuesta().getPreguntas().get(0);
		System.out.println("Pregunta 1: "+p1.getEnunciado()+" Type: "+p1.getTipo());
		System.out.println("Answer of seed 1 to pregunta 1 : "+list.get(0).getCentroid().getRespPreguntas().get(0).getValueR1());
		System.out.println("Answer of seed 2 to pregunta 1 : "+list.get(1).getCentroid().getRespPreguntas().get(0).getValueR1());
		
		Pregunta p11 = list.get(0).getCentroid().getEncuesta().getPreguntas().get(1);
		System.out.println("Pregunta 11: "+p11.getEnunciado()+" Type: "+p11.getTipo());
		System.out.println("Answer of seed 1 to pregunta 11 : "+list.get(0).getCentroid().getRespPreguntas().get(1).getValueR1());
		System.out.println("Answer of seed 2 to pregunta 11 : "+list.get(1).getCentroid().getRespPreguntas().get(1).getValueR1());
		
		
		Tipo_2 p2 = (Tipo_2)list.get(0).getCentroid().getEncuesta().getPreguntas().get(2);
		System.out.println("Pregunta 2: "+p2.getEnunciado()+" Type: "+p2.getTipo());		
		System.out.println("Answer of seed 1 to pregunta 2 : "+p2.getLista_opciones().get(list.get(0).getCentroid().getRespPreguntas().get(2).getValueR2()));
		System.out.println("Answer of seed 2 to pregunta 2 : "+p2.getLista_opciones().get(list.get(1).getCentroid().getRespPreguntas().get(2).getValueR2()));
		
		Pregunta p3 = list.get(0).getCentroid().getEncuesta().getPreguntas().get(3);
		System.out.println("Pregunta 3: "+p3.getEnunciado()+" Type: "+p3.getTipo());
		System.out.println("Answer of seed 1 to pregunta 3 : "+list.get(0).getCentroid().getRespPreguntas().get(3).getValueR3());
		System.out.println("Answer of seed 2 to pregunta 3 : "+list.get(1).getCentroid().getRespPreguntas().get(3).getValueR3());

		Pregunta p13 = list.get(0).getCentroid().getEncuesta().getPreguntas().get(4);
		System.out.println("Pregunta 13: "+p13.getEnunciado()+" Type: "+p13.getTipo());
		System.out.println("Answer of seed 1 to pregunta 13 : "+list.get(0).getCentroid().getRespPreguntas().get(4).getValueR1());
		System.out.println("Answer of seed 2 to pregunta 13 : "+list.get(1).getCentroid().getRespPreguntas().get(4).getValueR1());
		
	}
	
	/**
	 * Este metodo prueba la creacion del objeto MinMax sobre las respuestas que se han creado en createAnalisis.
	 * Es decir que este metodo proba que el minimum y el maximum para cada pregunta de tipo 1 estan en el objeto MinMax.
	 */
	@Test
	public void minMax_Respuesta_1Test(){
		Analisis an = createAnalisis();
		List<Cluster> list = an.createCluster(2,an.getRespEncuestas());
		HashMap<Integer,MinMax> m = an.minMax_Respuesta_1(an.getEncuesta(),list,an.getRespEncuestas());
		double value11 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(0).getValueR1();
		double value21 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(0).getValueR1();
		double value31 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(0).getValueR1();
		double value4c1 = list.get(0).getCentroid().getRespPreguntas().get(0).getValueR1();
		double value5c1 = list.get(1).getCentroid().getRespPreguntas().get(0).getValueR1();
		double max1 = Math.max(value11, Math.max(Math.max(value21, value31),Math.max(value4c1,value5c1)));
		double min1 = Math.min(value11, Math.min(Math.min(value21, value31),Math.min(value4c1,value5c1)));
		
		
		double value12 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(1).getValueR1();
		double value22 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(1).getValueR1();
		double value32 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(1).getValueR1();
		double value4c2 = list.get(0).getCentroid().getRespPreguntas().get(1).getValueR1();
		double value5c2 = list.get(1).getCentroid().getRespPreguntas().get(1).getValueR1();
		double max2 = Math.max(value12, Math.max(Math.max(value22, value32),Math.max(value4c2,value5c2)));
		double min2 = Math.min(value12, Math.min(Math.min(value22, value32),Math.min(value4c2,value5c2)));
		
		double value15 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(4).getValueR1();
		double value25 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(4).getValueR1();
		double value35 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(4).getValueR1();
		double value4c5 = list.get(0).getCentroid().getRespPreguntas().get(4).getValueR1();
		double value5c5 = list.get(1).getCentroid().getRespPreguntas().get(4).getValueR1();
		double max5 = Math.max(value15, Math.max(Math.max(value25, value35),Math.max(value4c5,value5c5)));
		double min5 = Math.min(value15, Math.min(Math.min(value25, value35),Math.min(value4c5,value5c5)));
		
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(0).getId()).getMax(),max1,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(1).getId()).getMax(),max2,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(4).getId()).getMax(),max5,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(0).getId()).getMin(),min1,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(1).getId()).getMin(),min2,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(4).getId()).getMin(),min5,0);
	}
	
	/**
	 * Este metodo prueba que cada usuario (su RespuestaEncuesta) a sido assignado al cluster con lo cual tiene minima distancia.
	 * Prueba tambien que todos los usuarios an sido assignado y que las distancias son inferior a 1.
	 */
	
	@Test
	public void assignacioRespuestaEncuestaTest(){
		Analisis an = createAnalisis();
		List<Cluster> list = an.createCluster(2,an.getRespEncuestas());
		HashMap<Integer,MinMax> m = an.minMax_Respuesta_1(an.getEncuesta(),list,an.getRespEncuestas());
		an.assignacioRespuestaEncuesta(an.getEncuesta(), m, an.getRespEncuestas(), list);
		
		RespuestaEncuesta re1 = an.getRespEncuestas().getListRP().get(0);	
		RespuestaEncuesta re2 = an.getRespEncuestas().getListRP().get(1);	
		RespuestaEncuesta re3 = an.getRespEncuestas().getListRP().get(2);	
		RespuestaEncuesta rec1 = list.get(0).getCentroid();
		RespuestaEncuesta rec2 = list.get(1).getCentroid();
		
		assertEquals(3,list.get(0).getUsuarios().size()+list.get(1).getUsuarios().size());
		
		double d1 = an.distanceRespEncuesta(re1, rec1, an.getEncuesta(), m);
		double d2 = an.distanceRespEncuesta(re2, rec1, an.getEncuesta(), m);
		double d3 = an.distanceRespEncuesta(re3, rec1, an.getEncuesta(), m);
		double d4 = an.distanceRespEncuesta(re1, rec2, an.getEncuesta(), m);
		double d5 = an.distanceRespEncuesta(re2, rec2, an.getEncuesta(), m);
		double d6 = an.distanceRespEncuesta(re3, rec2, an.getEncuesta(), m);
		if(d1 < d4){
			assertTrue(list.get(0).getUsuarios().contains(re1));
		}
		else{
			assertTrue(list.get(1).getUsuarios().contains(re1));
		}
		
		if(d2 < d5){
			assertTrue(list.get(0).getUsuarios().contains(re2));
		}
		else{
			assertTrue(list.get(1).getUsuarios().contains(re2));
		}
		
		if(d3 < d6){
			assertTrue(list.get(0).getUsuarios().contains(re3));
		}
		else{
			assertTrue(list.get(1).getUsuarios().contains(re3));
		}
		assertTrue(d1 <= 1 && d2 <= 1 && d3 <= 1 && d4 <= 1 && d5 <= 1 && d6 <= 1);

	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 1
	 * y que hay un unico usuario que ha respondido, el centroid del cluster cuando se recalcula
	 * tiene la misma respuesta que el usuario.
	 */
	@Test
	public void recomputeCentroidsTest_Tipo1(){
		
		double expectedValue = 5;
		
		
		
		Pregunta tipo_1P = new Tipo_1(0,"",1,0,20);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_1P);
		Encuesta tipo_1E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_1R = new Respuesta_1(tipo_1P, expectedValue);
		ArrayList<RespuestaPregunta> listR = new ArrayList<>();
		listR.add(tipo_1R);
		RespuestaEncuesta tipo_1RE = new RespuestaEncuesta(tipo_1E,listR);
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_1RE);
		Respuesta_Analisis tipo_1RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_1A = new Analisis(0, 1, 1, tipo_1RA,tipo_1E);
		List<Cluster> tipo_1C = tipo_1A.createCluster(1,tipo_1A.getRespEncuestas());
		
		double generatedValue = tipo_1C.get(0).getCentroid().getRespPreguntas().get(0).getValueR1();
		assertTrue("Method createCluster failled",generatedValue <= 20 && generatedValue >= 0);
		
		HashMap<Integer,MinMax> tipo_1M = tipo_1A.minMax_Respuesta_1(tipo_1E,tipo_1C,tipo_1RA);
		tipo_1A.assignacioRespuestaEncuesta(tipo_1E, tipo_1M, tipo_1RA, tipo_1C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_1A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_1A.recomputeCentroids(tipo_1C, tipo_1E, funcWord);
		double recomputedValue = tipo_1C.get(0).getCentroid().getRespPreguntas().get(0).getValueR1();
		assertEquals("recomputeCentroids failled on type 1 question",expectedValue,recomputedValue,0);
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 1
	 * y que hay dos usuario que han respondido, el centroid del cluster cuando se recalcula
	 * tiene la mediana entre las respuestas de los usuarios.
	 */
	
	
	@Test
	public void recomputeCentroidsTest_Tipo1bis(){
		
		double expectedValue = 5;
		
		
		
		Pregunta tipo_1P = new Tipo_1(0,"",1,0,20);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_1P);
		Encuesta tipo_1E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_1R1 = new Respuesta_1(tipo_1P, expectedValue-2);
		RespuestaPregunta tipo_1R2 = new Respuesta_1(tipo_1P, expectedValue+2);
		ArrayList<RespuestaPregunta> listR1 = new ArrayList<>();
		listR1.add(tipo_1R1);
		ArrayList<RespuestaPregunta> listR2 = new ArrayList<>();
		listR2.add(tipo_1R2);
		RespuestaEncuesta tipo_1RE1 = new RespuestaEncuesta(tipo_1E,listR1);
		RespuestaEncuesta tipo_1RE2 = new RespuestaEncuesta(tipo_1E,listR2);
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_1RE1);
		listRE.add(tipo_1RE2);
		Respuesta_Analisis tipo_1RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_1A = new Analisis(0, 1, 1, tipo_1RA,tipo_1E);
		List<Cluster> tipo_1C = tipo_1A.createCluster(1,tipo_1A.getRespEncuestas());
		
		double generatedValue = tipo_1C.get(0).getCentroid().getRespPreguntas().get(0).getValueR1();
		assertTrue("Method createCluster failled",generatedValue <= 20 && generatedValue >= 0);
		
		HashMap<Integer,MinMax> tipo_1M = tipo_1A.minMax_Respuesta_1(tipo_1E,tipo_1C,tipo_1RA);
		tipo_1A.assignacioRespuestaEncuesta(tipo_1E, tipo_1M, tipo_1RA, tipo_1C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_1A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_1A.recomputeCentroids(tipo_1C, tipo_1E, funcWord);
		double recomputedValue = tipo_1C.get(0).getCentroid().getRespPreguntas().get(0).getValueR1();
		assertEquals("recomputeCentroids failled on type 1 question",expectedValue,recomputedValue,0);
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 2
	 * y que hay un unico usuario que ha respondido, el centroid del cluster cuando se recalcula
	 * tiene la misma respuesta que el usuario.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo2(){
		
		int expectedValue = 3;
		
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_2P = new Tipo_2(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_2P);
		Encuesta tipo_2E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_2R = new Respuesta_2(tipo_2P, expectedValue);
		ArrayList<RespuestaPregunta> listR = new ArrayList<>();
		listR.add(tipo_2R);
		RespuestaEncuesta tipo_2RE = new RespuestaEncuesta(tipo_2E,listR);
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_2RE);
		Respuesta_Analisis tipo_2RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_2A = new Analisis(0, 1, 1, tipo_2RA,tipo_2E);
		List<Cluster> tipo_2C = tipo_2A.createCluster(1,tipo_2A.getRespEncuestas());
		
		double generatedValue = tipo_2C.get(0).getCentroid().getRespPreguntas().get(0).getValueR2();
		assertTrue("Method createCluster failled",generatedValue <= 4 && generatedValue >= 0);
		
		HashMap<Integer,MinMax> tipo_2M = tipo_2A.minMax_Respuesta_1(tipo_2E,tipo_2C,tipo_2RA);
		tipo_2A.assignacioRespuestaEncuesta(tipo_2E, tipo_2M, tipo_2RA, tipo_2C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_2A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_2A.recomputeCentroids(tipo_2C, tipo_2E, funcWord);
		int recomputedValue = tipo_2C.get(0).getCentroid().getRespPreguntas().get(0).getValueR2();
		assertEquals("recomputeCentroids failled on type 2 question",expectedValue,recomputedValue,0);
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 2
	 * y que hay dos usuario que han respondido, el centroid del cluster cuando se recalcula
	 * tiene la mediana entre las respuestas de los usuarios.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo2bis(){
		
		int expectedValue = 3;
		
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_2P = new Tipo_2(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_2P);
		Encuesta tipo_2E = new Encuesta(0,1,null,null,listP);
		
		//respuesta1
		RespuestaPregunta tipo_2R1 = new Respuesta_2(tipo_2P, expectedValue-2);
		ArrayList<RespuestaPregunta> listR1 = new ArrayList<>();
		listR1.add(tipo_2R1);
		RespuestaEncuesta tipo_2RE1 = new RespuestaEncuesta(tipo_2E,listR1);
		//respuesta2
		RespuestaPregunta tipo_2R2 = new Respuesta_2(tipo_2P, expectedValue+2);
		ArrayList<RespuestaPregunta> listR2 = new ArrayList<>();
		listR2.add(tipo_2R2);
		RespuestaEncuesta tipo_2RE2 = new RespuestaEncuesta(tipo_2E,listR2);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_2RE1);
		listRE.add(tipo_2RE2);
		Respuesta_Analisis tipo_2RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_2A = new Analisis(0, 1, 1, tipo_2RA,tipo_2E);
		List<Cluster> tipo_2C = tipo_2A.createCluster(1,tipo_2A.getRespEncuestas());
		
		HashMap<Integer,MinMax> tipo_2M = tipo_2A.minMax_Respuesta_1(tipo_2E,tipo_2C,tipo_2RA);
		tipo_2A.assignacioRespuestaEncuesta(tipo_2E, tipo_2M, tipo_2RA, tipo_2C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_2A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_2A.recomputeCentroids(tipo_2C, tipo_2E, funcWord);
		int recomputedValue = tipo_2C.get(0).getCentroid().getRespPreguntas().get(0).getValueR2();
		assertEquals("recomputeCentroids failled on type 2 question",expectedValue,recomputedValue,0);
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 3
	 * y que hay un unico usuario que ha respondido, el centroid del cluster cuando se recalcula
	 * tiene la misma respuesta que el usuario.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo3(){
		
		String expectedValue = "op2"; 
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_3P = new Tipo_3(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_3P);
		Encuesta tipo_3E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_3R = new Respuesta_3(tipo_3P, expectedValue);
		ArrayList<RespuestaPregunta> listR = new ArrayList<>();
		listR.add(tipo_3R);
		RespuestaEncuesta tipo_3RE = new RespuestaEncuesta(tipo_3E,listR);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_3RE);
		Respuesta_Analisis tipo_3RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_3A = new Analisis(0, 1, 1, tipo_3RA, tipo_3E);
		List<Cluster> tipo_3C = tipo_3A.createCluster(1,tipo_3A.getRespEncuestas());
		
		String generatedValue = tipo_3C.get(0).getCentroid().getRespPreguntas().get(0).getValueR3();
		assertTrue("Method createCluster failled",lista_opciones.contains(generatedValue));
		
		HashMap<Integer,MinMax> tipo_3M = tipo_3A.minMax_Respuesta_1(tipo_3E,tipo_3C,tipo_3RA);
		tipo_3A.assignacioRespuestaEncuesta(tipo_3E, tipo_3M, tipo_3RA, tipo_3C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_3A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_3A.recomputeCentroids(tipo_3C, tipo_3E, funcWord);
		String recomputedValue = tipo_3C.get(0).getCentroid().getRespPreguntas().get(0).getValueR3();
		assertTrue("recomputeCentroids failled on type 3 question",expectedValue.equals(recomputedValue));
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 3
	 * y que hay dos usuario que han respondido, el centroid del cluster cuando se recalcula
	 * tiene la mediana entre las respuestas de los usuarios.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo3bis(){
		
		String expectedValue = "op2"; 
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_3P = new Tipo_3(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_3P);
		Encuesta tipo_3E = new Encuesta(0,1,null,null,listP);
		
		//respuesta1
		RespuestaPregunta tipo_3R1 = new Respuesta_3(tipo_3P, expectedValue);
		ArrayList<RespuestaPregunta> listR1 = new ArrayList<>();
		listR1.add(tipo_3R1);
		RespuestaEncuesta tipo_3RE1 = new RespuestaEncuesta(tipo_3E,listR1);
		//respuesta2
		RespuestaPregunta tipo_3R2 = new Respuesta_3(tipo_3P, "op4");
		ArrayList<RespuestaPregunta> listR2 = new ArrayList<>();
		listR2.add(tipo_3R2);
		RespuestaEncuesta tipo_3RE2 = new RespuestaEncuesta(tipo_3E,listR2);
		//respuesta3
		RespuestaPregunta tipo_3R3 = new Respuesta_3(tipo_3P, expectedValue);
		ArrayList<RespuestaPregunta> listR3 = new ArrayList<>();
		listR3.add(tipo_3R3);
		RespuestaEncuesta tipo_3RE3 = new RespuestaEncuesta(tipo_3E,listR3);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_3RE1);
		listRE.add(tipo_3RE2);
		listRE.add(tipo_3RE3);
		Respuesta_Analisis tipo_3RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_3A = new Analisis(0, 1, 1, tipo_3RA,tipo_3E);
		List<Cluster> tipo_3C = tipo_3A.createCluster(1,tipo_3A.getRespEncuestas());
		
		HashMap<Integer,MinMax> tipo_3M = tipo_3A.minMax_Respuesta_1(tipo_3E,tipo_3C,tipo_3RA);
		tipo_3A.assignacioRespuestaEncuesta(tipo_3E, tipo_3M, tipo_3RA, tipo_3C);
		String funcWord;
		funcWord ="";
		try {
			funcWord = tipo_3A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_3A.recomputeCentroids(tipo_3C, tipo_3E, funcWord);
		String recomputedValue = tipo_3C.get(0).getCentroid().getRespPreguntas().get(0).getValueR3();
		assertTrue("recomputeCentroids failled on type 3 question",expectedValue.equals(recomputedValue));
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 4
	 * y que hay un unico usuario que ha respondido, el centroid del cluster cuando se recalcula
	 * tiene la misma respuesta que el usuario.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo4(){
		
		Set<String> expectedValue = new HashSet<>();
		expectedValue.add("op2");
		expectedValue.add("op3");
		expectedValue.add("op4");
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_4P = new Tipo_4(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_4P);
		Encuesta tipo_4E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_4R = new Respuesta_4(tipo_4P, expectedValue);
		ArrayList<RespuestaPregunta> listR = new ArrayList<>();
		listR.add(tipo_4R);
		RespuestaEncuesta tipo_4RE = new RespuestaEncuesta(tipo_4E,listR);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_4RE);
		Respuesta_Analisis tipo_4RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_4A = new Analisis(0, 1, 1, tipo_4RA,tipo_4E);
		List<Cluster> tipo_4C = tipo_4A.createCluster(1,tipo_4A.getRespEncuestas());
		
		Set<String> generatedValue = tipo_4C.get(0).getCentroid().getRespPreguntas().get(0).getValueR4();
		assertTrue("Method createCluster failled",lista_opciones.containsAll(generatedValue));
		
		HashMap<Integer,MinMax> tipo_4M = tipo_4A.minMax_Respuesta_1(tipo_4E,tipo_4C,tipo_4RA);
		tipo_4A.assignacioRespuestaEncuesta(tipo_4E, tipo_4M, tipo_4RA, tipo_4C);
		
		String funcWord ="";
		try {
			funcWord = tipo_4A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_4A.recomputeCentroids(tipo_4C, tipo_4E, funcWord);
		Set<String> recomputedValue = tipo_4C.get(0).getCentroid().getRespPreguntas().get(0).getValueR4();

		assertTrue("recomputeCentroids failled on type 4 question",expectedValue.containsAll(recomputedValue) && recomputedValue.containsAll(expectedValue));
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 4
	 * y que hay tres usuario que han respondido, el centroid del cluster cuando se recalcula
	 * tiene la respuesta con mas frequencia de los usuarios.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo4bis(){
		
		Set<String> expectedValue = new HashSet<>();
		expectedValue.add("op2");
		expectedValue.add("op3");
		expectedValue.add("op4");
		
		Set<String> otherset = new HashSet<>();
		otherset.add("op2");
		
		ArrayList<String> lista_opciones = new ArrayList<>();
		lista_opciones.add("op1");
		lista_opciones.add("op2");
		lista_opciones.add("op3");
		lista_opciones.add("op4");
		lista_opciones.add("op5");
		
		Pregunta tipo_4P = new Tipo_4(0, "", 5, lista_opciones);
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_4P);
		Encuesta tipo_4E = new Encuesta(0,1,null,null,listP);
		
		//respuesta1
		RespuestaPregunta tipo_4R1 = new Respuesta_4(tipo_4P, expectedValue);
		ArrayList<RespuestaPregunta> listR1 = new ArrayList<>();
		listR1.add(tipo_4R1);
		RespuestaEncuesta tipo_4RE1 = new RespuestaEncuesta(tipo_4E,listR1);
		
		//respuesta2
		RespuestaPregunta tipo_4R2 = new Respuesta_4(tipo_4P, otherset);
		ArrayList<RespuestaPregunta> listR2 = new ArrayList<>();
		listR2.add(tipo_4R2);
		RespuestaEncuesta tipo_4RE2 = new RespuestaEncuesta(tipo_4E,listR2);
		
		//respuesta3
		RespuestaPregunta tipo_4R3 = new Respuesta_4(tipo_4P, expectedValue);
		ArrayList<RespuestaPregunta> listR3 = new ArrayList<>();
		listR3.add(tipo_4R3);
		RespuestaEncuesta tipo_4RE3 = new RespuestaEncuesta(tipo_4E,listR3);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_4RE1);
		listRE.add(tipo_4RE2);
		listRE.add(tipo_4RE3);
		Respuesta_Analisis tipo_4RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_4A = new Analisis(0, 1, 1, tipo_4RA,tipo_4E);
		List<Cluster> tipo_4C = tipo_4A.createCluster(1,tipo_4A.getRespEncuestas());
		
		HashMap<Integer,MinMax> tipo_4M = tipo_4A.minMax_Respuesta_1(tipo_4E,tipo_4C,tipo_4RA);
		tipo_4A.assignacioRespuestaEncuesta(tipo_4E, tipo_4M, tipo_4RA, tipo_4C);
		
		String funcWord ="";
		try {
			funcWord = tipo_4A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_4A.recomputeCentroids(tipo_4C, tipo_4E, funcWord);
		Set<String> recomputedValue = tipo_4C.get(0).getCentroid().getRespPreguntas().get(0).getValueR4();

		assertTrue("recomputeCentroids failled on type 4 question",expectedValue.containsAll(recomputedValue) && recomputedValue.containsAll(expectedValue));
	}
	
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 5
	 * y que hay un unico usuario que ha respondido, el centroid del cluster cuando se recalcula
	 * tiene la misma respuesta que el usuario.
	 */
	
	
	@Test
	public void recomputeCentroidsTest_Tipo5(){
		
		Pregunta tipo_5P = new Tipo_5(0, "");
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_5P);
		Encuesta tipo_5E = new Encuesta(0,1,null,null,listP);
		
		RespuestaPregunta tipo_5R = new Respuesta_5(tipo_5P,"Me gusta cookies");
		ArrayList<RespuestaPregunta> listR = new ArrayList<>();
		listR.add(tipo_5R);
		RespuestaEncuesta tipo_5RE = new RespuestaEncuesta(tipo_5E,listR);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_5RE);
		Respuesta_Analisis tipo_5RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_5A = new Analisis(0, 1, 1, tipo_5RA,tipo_5E);
		List<Cluster> tipo_5C = tipo_5A.createCluster(1,tipo_5A.getRespEncuestas());
		
		HashMap<Integer,MinMax> tipo_5M = tipo_5A.minMax_Respuesta_1(tipo_5E,tipo_5C,tipo_5RA);
		tipo_5A.assignacioRespuestaEncuesta(tipo_5E, tipo_5M, tipo_5RA, tipo_5C);
		
		String funcWord ="";
		try {
			funcWord = tipo_5A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_5A.recomputeCentroids(tipo_5C, tipo_5E, funcWord);
		String recomputedValue = tipo_5C.get(0).getCentroid().getRespPreguntas().get(0).getValueR5();
		
		assertTrue("recomputeCentroids failled on type 5 question",recomputedValue.contains("gusta") && recomputedValue.contains("cookies"));
	}
	
	/**
	 * Este metodo prueba que cuando la encuesta tiene una unica pregunta de tipo 5
	 * y que hay tres usuario que han respondido, el centroid del cluster cuando se recalcula
	 * tiene las palabras con mas frequencia en las respuestas de los usuarios.
	 */
	
	@Test
	public void recomputeCentroidsTest_Tipo5bis(){
		
		Pregunta tipo_5P = new Tipo_5(0, "");
		ArrayList<Pregunta> listP = new ArrayList<>();
		listP.add(tipo_5P);
		Encuesta tipo_5E = new Encuesta(0,1,null,null,listP);
		
		//respuesta1
		RespuestaPregunta tipo_5R1 = new Respuesta_5(tipo_5P,"Me gusta cookies");
		ArrayList<RespuestaPregunta> listR1 = new ArrayList<>();
		listR1.add(tipo_5R1);
		RespuestaEncuesta tipo_5RE1 = new RespuestaEncuesta(tipo_5E,listR1);
		
		//respuesta2
		RespuestaPregunta tipo_5R2 = new Respuesta_5(tipo_5P,"No me gusta cookies");
		ArrayList<RespuestaPregunta> listR2 = new ArrayList<>();
		listR2.add(tipo_5R2);
		RespuestaEncuesta tipo_5RE2 = new RespuestaEncuesta(tipo_5E,listR2);
		
		//respuesta3
		RespuestaPregunta tipo_5R3 = new Respuesta_5(tipo_5P,"No me milk");
		ArrayList<RespuestaPregunta> listR3 = new ArrayList<>();
		listR3.add(tipo_5R3);
		RespuestaEncuesta tipo_5RE3 = new RespuestaEncuesta(tipo_5E,listR3);
		
		ArrayList<RespuestaEncuesta> listRE = new ArrayList<>();
		listRE.add(tipo_5RE1);
		listRE.add(tipo_5RE2);
		listRE.add(tipo_5RE3);
		Respuesta_Analisis tipo_5RA = new Respuesta_Analisis(listRE);
		
		Analisis tipo_5A = new Analisis(0, 1, 1, tipo_5RA,tipo_5E);
		List<Cluster> tipo_5C = tipo_5A.createCluster(1,tipo_5A.getRespEncuestas());
		
		HashMap<Integer,MinMax> tipo_5M = tipo_5A.minMax_Respuesta_1(tipo_5E,tipo_5C,tipo_5RA);
		tipo_5A.assignacioRespuestaEncuesta(tipo_5E, tipo_5M, tipo_5RA, tipo_5C);
		
		String funcWord ="";
		try {
			funcWord = tipo_5A.funcionnalString("empty.sp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tipo_5A.recomputeCentroids(tipo_5C, tipo_5E, funcWord);
		String recomputedValue = tipo_5C.get(0).getCentroid().getRespPreguntas().get(0).getValueR5();
		System.out.println(recomputedValue);
		assertTrue("recomputeCentroids failled on type 5 question",recomputedValue.contains("cookies") && recomputedValue.contains("gusta"));
	}
}
