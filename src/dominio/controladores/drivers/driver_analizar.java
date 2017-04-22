package dominio.controladores.drivers;


import dominio.clases.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class driver_analizar {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main(String[] args) {
		texto = new Scanner(System.in);
		opcion = new Scanner(System.in);
		System.out.println("LA ENCUESTA Y LA RESPUESTAS DEBEN SER EN CASTELLANO");
		System.out.println("Encuestas actuales:");
    	int exist = 1;
    	Integer id = 1;
    	do{	
    		String sFichero = "src/persistencia/Encuestas/Encuesta_"+id.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){ 
    			Encuesta en = new Encuesta(id);
    			en.leer(id.toString());
    			System.out.println("Encuesta_"+id+ " Genero = "+en.getGenero());
    			++id;
    		}
    		else exist = 0;
    	}while(exist != 0);
		System.out.println ("Escribe el numero de la encuesta que quieres analizar:");
		Integer numEncuesta = opcion.nextInt();
		Encuesta e = new Encuesta(numEncuesta);
		e.leer(numEncuesta.toString());
		
		List<RespuestaEncuesta> listRE = new ArrayList<>();
		Integer index = 1;
		String sFichero = "src/persistencia/Respuestas/Respuesta_"+numEncuesta+"_"+index+".txt";
		File fichero = new File(sFichero);
		
		while(fichero.exists()){
				RespuestaEncuesta re = new RespuestaEncuesta();
				re.leer(numEncuesta.toString(), index.toString());
				listRE.add(re);
				
				index++;
				sFichero = "src/persistencia/Respuestas/Respuesta_"+numEncuesta+"_"+index+".txt";
				fichero = new File(sFichero);
		}
		
		Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
		
		//System.out.println ("Escribe el numero de la analisis");
		//Integer idAnalisis = opcion.nextInt();
		Integer idAnalisis = 0;
		
		boolean test = false;
		Integer k;
		do{
			test = false;
			System.out.println ("Escribe el numero de cluster que quieres \n(la k, debe ser inferior o igual al numero de respuestas)");
			k = opcion.nextInt();
			if(k<=0 || k > listRE.size()){
				System.out.println("Entrada invalida");
				test =true;
			}
		}while(test);
		
		Double threshold;
		do{
			test = false;
			System.out.println ("Escribe el threshold para la distancia");
			System.out.println("(los doubles se escriben con ',' en windows, con '.' en linux)");
			threshold = opcion.nextDouble();
			if(threshold<=0 || threshold >1){
				System.out.println("Entrada invalida");
				test =true;
			}
		}while(test);
		Analisis an = new Analisis(idAnalisis, k, threshold, ra,e);
		Resultado result =null;
		try {
			result = an.k_means();
		} catch (IOException e1) {
			System.out.println("no se ha podido cargar el fichero de palabras funcional");
			e1.printStackTrace();
		}
		
		System.out.println ("Se ha acabado la analisis");
		System.out.println(result.toString(an));
	}

}
