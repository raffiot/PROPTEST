package prop.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import prop.dominio.Analisis.MinMax;

public class AnalisisTest {
	
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
		/*
		ArrayList<String> respp4 = new ArrayList<String>();
		respp4.add("lunes");
		respp4.add("martes");
		respp4.add("miercoles");
		respp4.add("jueves");
		respp4.add("viernes");
		respp4.add("sabado");
		respp4.add("domingo");
		Pregunta p4 = new Tipo_4(3,"Que dia de la semana Miki se sale de fiesta?",7,respp4);
		preguntas.add(p4);
		
		Pregunta p5 = new Tipo_5(4,"Que tal las vacaciones?",1);
		preguntas.add(p5);*/
		preguntas.add(p13);
		Date d = new Date(2017,4,14);
		Encuesta e = new Encuesta(0,5,"",d,preguntas);
		
		//We cannot create participant, to change when it will be available
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
		/*
		 * Set<String> set14 = new HashSet<String>();
		 * set14.put("jueves");
		 * set14.put("sabado"); 
		 * RespuestaPregunta rp14 = new Respuesta_4(p4,set14);
		 * list1.add(rp14);
		 * RespuestaPregunta rp15 = new Respuesta_5(p5,"genial");
		 * list1.add(rp15);
		 */
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
		
		//add administrator when it will be available
		double threshold = 0.2;
		return new Analisis(0,2,threshold,ra);
	
	}

	@Test
	public void createClusterTest(){
		Analisis an = createAnalisis();		
		List<Cluster> list = an.createCluster(2);
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
	
	@Test
	public void minMax_Respuesta_1Test(){
		Analisis an = createAnalisis();		
		HashMap<Integer,MinMax> m = an.minMax_Respuesta_1();
		double value11 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(0).getValueR1();
		double value21 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(0).getValueR1();
		double value31 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(0).getValueR1();
		double max1 = Math.max(value11, Math.max(value21, value31));
		double min1 = Math.min(value11, Math.min(value21, value31));
		System.out.println("my max : "+max1);
		
		double value12 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(1).getValueR1();
		double value22 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(1).getValueR1();
		double value32 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(1).getValueR1();
		double max2 = Math.max(value12, Math.max(value22, value32));
		double min2 = Math.min(value12, Math.min(value22, value32));
		
		double value15 = an.getRespEncuestas().getListRP().get(0).getRespPreguntas().get(4).getValueR1();
		double value25 = an.getRespEncuestas().getListRP().get(1).getRespPreguntas().get(4).getValueR1();
		double value35 = an.getRespEncuestas().getListRP().get(2).getRespPreguntas().get(4).getValueR1();
		double max5 = Math.max(value15, Math.max(value25, value35));
		double min5 = Math.min(value15, Math.min(value25, value35));
		
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(0).getId()).getMax(),max1,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(1).getId()).getMax(),max2,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(4).getId()).getMax(),max5,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(0).getId()).getMin(),min1,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(1).getId()).getMin(),min2,0);
		assertEquals(m.get(an.getEncuesta().getPreguntas().get(4).getId()).getMin(),min5,0);
	}
}
