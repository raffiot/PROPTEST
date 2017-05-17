package dominio.controladores.drivers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dominio.clases.*;
import dominio.clases.Analisis.MinMax;

public class driver_analisis {
	private static Scanner opcion;
	public static void main (String [ ] args) throws IOException {
		
		opcion = new Scanner(System.in);
		
		System.out.println ("Empezamos la ejecucion del driver de analisis");
		
		System.out.println("Introduce el numero de la encuesta que quieres analizar:");
		
		Encuesta e = null;
		
		Integer idEncuesta;
		Integer var ;
		//SHOW ALL ENCUESTAS
		int exist = 1;
		Integer id = 1;
		do{	
    		String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){ 
    			Encuesta en = new Encuesta(id);
    			en.leer(id.toString());
    			System.out.println("Encuesta_"+id+ " Genero = "+en.getGenero());
    			++id;
    		}
    		else exist = 0;
    	}while(exist != 0);
		
		
		boolean badAnswer = true;
		do{
			var = opcion.nextInt();
			String sFichero = "Data/Encuestas/Encuesta_"+var.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){
    			badAnswer = false;
    			e = new Encuesta(var);
    			e.leer(var.toString());
    		}
    		else{
    			System.out.println("Respuesta invalida");
    		}
		}while(badAnswer);
		idEncuesta = var;
		
		
		exist = 1;
		id =1;
		do{	
    		String sFichero = "Data/Respuestas/Respuesta_"+idEncuesta.toString()+"_"+id.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){ 
    			RespuestaEncuesta re = new RespuestaEncuesta();
    			re.leer(var.toString(),id.toString());
    			System.out.println("Respuesta_"+id+ "_"+id.toString()+" de "+re.getNombre());
    			++id;
    		}
    		else exist = 0;
    	}while(exist != 0);
		
		
		List<RespuestaEncuesta> listRE = new ArrayList<>();
		
		do{
			System.out.println("Introduce el numero de la respuesta que quieres analizar");
			System.out.println("O -1 si has elegido todas las respuestas que querias");
			var = opcion.nextInt();
			String sFichero = "Data/Respuestas/Respuesta_"+idEncuesta.toString()+"_"+var.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){
    			RespuestaEncuesta re = new RespuestaEncuesta();
    			re.leer(idEncuesta.toString(),var.toString());
    			listRE.add(re);
    		}
    		else{
    			if(var !=-1)
    			System.out.println("Respuesta invalida");
    		}
		}while(var != -1);
		
		System.out.println("Pulse 0 si quieres salir del driver");
		System.out.println("Pulse 1 si quieres probar los metodos de analisis en particular");
		System.out.println("Pulse 2 si quieres probar la analisis en entero");
		badAnswer =true;
		do{
			var = opcion.nextInt();
			badAnswer = var != 1 && var != 2 && var !=0;
			if(badAnswer){
				System.out.println("Respuesta invalida");
			}
		}while(badAnswer);
			
		if(var == 0) System.exit(0);
		
		else if(var == 1){
			System.out.println("Pulse 0 si quieres salir del driver");
			System.out.println("Pulse 1 si quieres probar la creacion de los cluster");
			System.out.println("Pulse 2 si quieres probar el metodo que busca los minimo y maximo para pregunta de tipo 1");
			System.out.println("Pulse 3 si quieres probar el metodo de assignacion de las respuestas a encuesta");
			System.out.println("Pulse 4 si quieres probar el metodo de recalculation de los cluster");
			System.out.println("Pulse 5 si quieres hacer el pipline entero");
			badAnswer = true;
			do{
				var = opcion.nextInt();
				badAnswer = var != 1 && var != 2 && var !=3 && var!=4 && var !=5 && var != 0;
				if(badAnswer){
					System.out.println("Respuesta invalida");
				}
			}while(badAnswer);
			
			
			int k;
			System.out.println ("Escribe el numero de cluster que quieres \n(la k, debe ser inferior o igual al numero de respuestas)");
			badAnswer = true;
			do{
				k = opcion.nextInt();
				badAnswer = k > listRE.size();
				if(badAnswer){
					System.out.println("Respuesta invalida");
				}
			}while(badAnswer);
			
			double threshold = 0; //No nos sirve aqui
			Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
			Analisis analisis = new Analisis(k,threshold,ra,e,0);
			List<Cluster> clusters = new ArrayList<Cluster>();
			
			String funcWord = analisis.getFuncWord();
			
			clusters = analisis.createCluster(k, ra);
			analisis.setCentroids(clusters);
			
			if(var == 1){
				for(Cluster c : clusters){
					System.out.println(c.toString(analisis));
				}
				System.out.println("");
				System.out.println("Pulse 0 para salir del driver");
				System.out.println("Pulse 1 para continuar el pipeline y monstrar la assignacio de los minimo y maximo");
				badAnswer =true;
				do{
					var = opcion.nextInt();
					badAnswer = var != 1 && var != 0;
					if(badAnswer){
						System.out.println("Respuesta invalida");
					}
				}while(badAnswer);
				if(var == 0) System.exit(0);
				var = 2;
			}
			
			Map<Integer,MinMax> mapMinMax = analisis.minMax_Respuesta_1(e, clusters, ra);
			analisis.setMapMinMax(mapMinMax);
			if(var == 2){
				for(int i = 0; i < e.getN_preguntas(); i++){
					Pregunta p = e.getPreguntas().get(i);
					if(p.tipo == 1){						
						System.out.println("Pregunta "+p.getId());
						System.out.println("Enunciado :"+p.getEnunciado());
						for(RespuestaEncuesta re : ra.getListRP()){
							double resp = re.getRespPreguntas().get(i).getValueR1();
							System.out.println("Respuesta usuario "+re.getNombre()+": "+resp);
						}
						System.out.println("Maximo en MinMax : "+mapMinMax.get(p.getId()).getMax());
						System.out.println("Minimo en MinMax : "+mapMinMax.get(p.getId()).getMin());
					}
					System.out.println("");
				}
				
				System.out.println("Pulse 0 para salir del driver");
				System.out.println("Pulse 1 para continuar el pipeline y monstrar la assignacio de las respuestas");
				badAnswer = true;
				do{
					var = opcion.nextInt();
					badAnswer = var != 1 && var != 0;
					if(badAnswer){
						System.out.println("Respuesta invalida");
					}
				}while(badAnswer);
				if(var == 0) System.exit(0);
				var = 3;
			}
			
			do{
				clusters = analisis.assignacioRespuestaEncuesta(e, mapMinMax, ra, clusters, funcWord);
				analisis.setCentroids(clusters);
				if(var == 3){
					for(Cluster c : clusters){
						System.out.println(c.toString(analisis));
					}
					System.out.println("");
					System.out.println("Pulse 0 para salir del driver");
					System.out.println("Pulse 1 para continuar el pipeline y monstrar la recalculacion de los clusters");
					badAnswer = true;
					do{
						var = opcion.nextInt();
						badAnswer = var != 1 && var != 0;
						if(badAnswer){
							System.out.println("Respuesta invalida");
						}
					}while(badAnswer);
					if(var == 0) System.exit(0);
					var = 4;
				}
				
				Map<Integer,RespuestaEncuesta> oldCentroids = new HashMap<Integer,RespuestaEncuesta>();
				for(Cluster c : clusters){
					oldCentroids.put(c.getIndex(),c.getCentroid().clone());
				}
				
				clusters = analisis.recomputeCentroids(clusters, e, funcWord);
				if(var == 4){
					for(int i = 0; i<clusters.size(); i++ ){
						int index = clusters.get(i).getIndex();
						System.out.println("----------------------------");
						System.out.println("Cluster con index: "+index);
						
						RespuestaEncuesta centroid_1 = oldCentroids.get(index);
						RespuestaEncuesta centroid_2 = clusters.get(i).getCentroid();
						System.out.println("Old centroid :");
						for(int j = 0; j<e.getN_preguntas(); j++){
							System.out.print(centroid_1.getRespPreguntas().get(j).toString());
						}
						System.out.println("New centroid :");
						for(int j = 0; j<e.getN_preguntas(); j++){
							System.out.print(centroid_2.getRespPreguntas().get(j).toString());
						}
						System.out.println("");
						System.out.println("Con respuestas assignadas en el nuevo cluster");
						System.out.println("");
						for(RespuestaEncuesta re : clusters.get(i).getUsuarios()){
							System.out.println("Usuario "+re.getNombre()+" respuesta "+(analisis.getRespEncuestas().getListRP().indexOf(re)+1)+":");
							System.out.println(re.toString());
							System.out.println("Distancia con el antiguo centroid: "+analisis.distanceRespEncuesta(centroid_1,re,e,mapMinMax,funcWord));
							System.out.println("Distancia con el nuevo centroid: "+analisis.distanceRespEncuesta(centroid_2,re,e,mapMinMax,funcWord));
							System.out.println("Distancia con los otros centroids:");
							for(Cluster c : clusters){
								if(clusters.get(i).getIndex() != c.getIndex()){
									System.out.println("Centroid "+c.getIndex()+" : "+analisis.distanceRespEncuesta(c.getCentroid(), re, e, mapMinMax, funcWord));
								}
							}
							System.out.println("");
						}
						System.out.println("");
					}
					System.out.println("");
					System.out.println("Pulse 0 para salir del driver");
					System.out.println("Pulse 1 para continuar y hacer otra ves el pipeline ");
					badAnswer = true;
					do{
						var = opcion.nextInt();
						badAnswer = var != 1 && var != 0;
						if(badAnswer){
							System.out.println("Respuesta invalida");
						}
					}while(badAnswer);
					if(var == 0) System.exit(0);
					
				}
				var = 3;
				System.out.println("seguimos por la etapa de assignacion de las respuestas de nuevo");
			}while(true);
		}
		
		else{
			int k;
			System.out.println ("Escribe el numero de cluster que quieres \n(la k, debe ser inferior o igual al numero de respuestas)");
			badAnswer = true;
			do{
				k = opcion.nextInt();
				badAnswer = k > listRE.size();
				if(badAnswer){
					System.out.println("Respuesta invalida");
				}
			}while(badAnswer);
			
			double threshold;
			badAnswer = true;
			do{
				System.out.println ("Escribe el threshold para la distancia");
				System.out.println("(los doubles se escriben con ',' en windows, con '.' en linux)");
				threshold = opcion.nextDouble();
				if(threshold<=0 || threshold >1){
					System.out.println("Entrada invalida");
				}
				else{
					badAnswer = false;
				}
			}while(badAnswer);
			
			Respuesta_Analisis ra = new Respuesta_Analisis(listRE);
			Analisis analisis = new Analisis(k,threshold,ra,e,0);
			
			Resultado result =null;
			
			result = analisis.k_means();

			
			System.out.println ("Se ha acabado la analisis");
			System.out.println(result.toString(analisis));
			System.exit(0);
		}
		
	}
}
