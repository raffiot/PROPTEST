package prop.dominio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class driver_analizar {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main(String[] args) {
		System.out.println("LA ENCUESTA Y LA RESPUESTAS DEBEN SER EN CASTELLANO");
		System.out.println ("Escribe el numero de la encuesta que quieres analizar:");
		Integer numEncuesta = opcion.nextInt();
		Encuesta e = new Encuesta(numEncuesta);
		e.leer("Encuestas/Encuesta_"+numEncuesta);
		
		List<RespuestaEncuesta> listRE = new ArrayList<>();
		Integer index = 1;
		String sFichero = "Respuestas/Respuesta_"+numEncuesta+"_"+index+".txt";
		File fichero = new File(sFichero);
		
		while(fichero.exists()){
				RespuestaEncuesta re = new RespuestaEncuesta();
				re.leer(numEncuesta.toString(), index.toString());
				listRE.add(re);
				
				index++;
				sFichero = "Respuestas/Respuesta_"+numEncuesta+"_"+index+".txt";
				fichero = new File(sFichero);
		}
		
		Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
		
		System.out.println ("Escribe el numero de la analisis");
		Integer idAnalisis = opcion.nextInt();
		System.out.println ("Escribe el cluster que quieres (la k)");
		Integer k = opcion.nextInt();
		System.out.println ("Escribe el threshold para la distancia");
		Integer threshold = opcion.nextInt();
		Analisis an = new Analisis(idAnalisis, k, threshold, ra);
		Resultado result =null;
		try {
			result = an.k_means();
		} catch (IOException e1) {
			System.out.println("no se ha podido cargar el fichero de palabras funcional");
			e1.printStackTrace();
		}
		
		System.out.println ("Se ha acabado la analisis");
		System.out.println(result.toString());
		System.exit(0);
	}

}
