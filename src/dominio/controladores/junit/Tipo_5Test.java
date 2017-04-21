package dominio.controladores.junit;

import dominio.clases.*;
import static org.junit.Assert.*;


import org.junit.Test;
public class Tipo_5Test {
	@Test
	public void toString_test(){
		Tipo_5 t = new Tipo_5(0,"Que opinas de la madre de las bombas que EU lanzo hace unos dias?");
		assertEquals(t.toString(),"0.Que opinas de la madre de las bombas que EU lanzo hace unos dias?"+"\r\n");
	}
	@Test
	public void guardar_test(){
		Tipo_5 t = new Tipo_5(0,"Que opinas de la madre de las bombas que EU lanzo hace unos dias?");
		assertEquals(t.guardar(),"5"+"\r\n"+"Que opinas de la madre de las bombas que EU lanzo hace unos dias?"+"\r\n");
	}
}
