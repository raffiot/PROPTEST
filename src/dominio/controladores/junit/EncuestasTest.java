package dominio.controladores.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.clases.Cjt_encuestas;
import dominio.clases.Encuesta;

public class EncuestasTest {
	@Test
	public void GuardarEncuestas(){
		Cjt_encuestas e = new Cjt_encuestas();
		Encuesta e1 = new Encuesta(1);
		e1.leer("1");
		Encuesta e2 = new Encuesta(2);
		Encuesta e3 =  new Encuesta(3);
		e2.leer("2");
		e3.leer("3");
		e.anadirEncuesta(e1);
		e.anadirEncuesta(e2);
		e.anadirEncuesta(e3);
		e.guardarEncuestas();
		Cjt_encuestas es = new Cjt_encuestas();
		es.leerEncuestas();
		boolean b = e.size() == es.size();
		assertTrue(b);
		
		
		
		
	}

}
