package dominio.clases;

/**
 * La classe Analisis se instancia para empezar una nueva analisis sobre las respuestas de usuarios
 * a una encuesta.
 * 
 * @author Raphael							
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
public class Analisis {
	
	
	private int id;
	private int k;
	private double threshold;
	private Respuesta_Analisis respEncuestas;
	private Encuesta encuesta;
	
	/**
	 * Constructor de la classe Analisis.
	 * Una analisis contiene un identificador,
	 * un numero k que representa el numero de Cluster(representante) que queremos crear en la analisis
	 * un numero threshold que representa a partir de que distancia acabamos la analisis
	 * una Respuesta_Analisis que respresenta las respuestas de los usuarios a la encuesta.
	 * 
	 * @param id
	 * 		el identificador de la analisis
	 * @param k
	 * 		el numero de cluster que se crea en la analisis
	 * @param threshold
	 * 		el parametro que define cuando se para el algorithmo de k-means
	 * @param respEncuestas
	 * 		las respuestas de los usuarios a la encuesta
	 * @param
	 * 		la encuesta que se analitza
	 */
	public Analisis(int id, int k, double threshold, Respuesta_Analisis respEncuestas,Encuesta e){
		this.id = id;
		this.k = k;
		this.threshold = threshold;
		this.respEncuestas = respEncuestas;
		encuesta = e;
	}
	
	/**
	 * El metodo principal de la classe analisis, que se hace en pasos:
	 * 1.Se crea la sentencia que contiene las palabras funcional a la cual no hacemos caso en las respuestas
	 * a preguntas de tipo 5
	 * 2.Se crean los clusters con centroids(RespuestaEncuesta) de manera aleatoria.
	 * 3.Se calcula el minimo y el maximo para cada respuesta a pregunta de tipo 1.
	 * 4.Se assignan los usuarios a clusters
	 * 5.Se guardan los centroids de los clusters en una variable oldCluster
	 * 6.Se recalculan los centroids en funcion de los usuarios que han sido assignado a su cluster
	 * 7.Se prueba si las distancias entre los nuevos clusters y oldCluster estant inferior al threshold
	 * Si no es el caso se vuelve al paso 3.
	 *  
	 * @return
	 * 		el Resultado de la analisis
	 * @throws IOException
	 * 		se lanza una excepcion cuando no se carga el fichero con las palabras funcionnal.
	 */
	public Resultado k_means() throws IOException{
		
		
		String funcWord = funcionnalString("empty.cat");

		
		//CREATION OF SEEDS
		List<Cluster> centroids = createCluster(k);
		
		
		
		
		
		boolean underThreshold = true;
		do{
			HashMap<Integer,MinMax> mapMinMax = minMax_Respuesta_1(encuesta,centroids,respEncuestas);
			
			//ASSIG EACH RESPUESTA_ENCUESTA TO CLUSTER
			centroids = assignacioRespuestaEncuesta(encuesta, mapMinMax, respEncuestas, centroids);
			
			
			//Save old centroids before modificate
			Map<Integer,RespuestaEncuesta> oldCentroids = new HashMap<Integer,RespuestaEncuesta>();
			for(Cluster c : centroids){
				oldCentroids.put(c.getIndex(),c.getCentroid().clone());
			}
			
			//recompute centroids
			centroids = recomputeCentroids(centroids,encuesta,funcWord);
			
			//check if we are under threshold
			underThreshold = true;
			for(Cluster cluster: centroids){
				double d = distanceRespEncuesta(cluster.getCentroid(), oldCentroids.get(cluster.getIndex()), encuesta, mapMinMax);
				if(d > threshold){
					underThreshold = false;
				}
			}
			
			
		}while(!underThreshold);
		
		return new Resultado(centroids);
	}
	
	/**
	 * Este metodo crea k cluster de manera aleatoria
	 * 
	 * @param k
	 * 		el numero de cluster que se crean
	 * @return
	 * 		la lista de Cluster creado
	 */
	public List<Cluster> createCluster(int k){
		List<Cluster> centroids = new ArrayList<Cluster>();
		RespuestaEncuesta seed;
		for(int i = 0; i < k; i++){
			List<RespuestaPregunta> listRP = new ArrayList<RespuestaPregunta>();
			for(int j = 0; j < encuesta.getN_preguntas() ; j++){
				RespuestaPregunta rp = encuesta.getPreguntas().get(j).generateAnswer();
				listRP.add(rp);
			}
			seed = new RespuestaEncuesta(encuesta,listRP);
			centroids.add(new Cluster(i,seed));
		}
		return centroids;
	}
	
	/**
	 * Este metodo genera un objeto MinMax que contiene el minimo y el maximo para cada pregunta de tipo 1
	 * 
	 * @param encuesta
	 * 		la encuesta que contiene las preguntas
	 * @param centroids
	 * 		los centroids que contiene respuestas a pregunta de tipo 1 que analizamos
	 * @param respEncuestas
	 * 		las respuestas de los usuarios que contiene respuestas a pregunta de tipo 1 que analizamos.
	 * @return
	 * 		Una Map con el identificador y el objeto MinMax de cada pregunta de tipo 1.
	 */
	public HashMap<Integer,MinMax> minMax_Respuesta_1(Encuesta encuesta,List<Cluster> centroids,Respuesta_Analisis respEncuestas){
		//MIN MAX FOR EACH TYPE 1 QUESTION
		HashMap<Integer,MinMax> map = new HashMap<Integer,MinMax>();
		for(int i =0; i< encuesta.getN_preguntas(); i++){
			MinMax minmax = new MinMax();
			if(encuesta.getPreguntas().get(i).tipo == 1){
				for(RespuestaEncuesta re : respEncuestas.getListRP()){
					double res = re.getRespPreguntas().get(i).getValueR1();//We want value of the answer
					if(res < minmax.getMin()){
						minmax.setMin(res);
					}
					if(res > minmax.getMax()){
						minmax.setMax(res);
					}
				}
				for(Cluster c : centroids){
					double res = c.getCentroid().getRespPreguntas().get(i).getValueR1();
					if(res < minmax.getMin()){
						minmax.setMin(res);
					}
					if(res > minmax.getMax()){
						minmax.setMax(res);
					}
				}
			}
			map.put(encuesta.getPreguntas().get(i).getId(), minmax);
		}
		return map;
	}
	
	/**
	 * Este metodo assigna a cada cluster los usuarios que estan el mas cerca.
	 * 
	 * @param encuesta
	 * 		La encuesta que se analiza
	 * @param mapMinMax
	 * 		Los minimo y maximo para cada pregunta de tipo 1
	 * @param respEncuestas
	 * 		Las respuestas de los usuarios a la encuesta
	 * @param centroids
	 * 		La lista de cluster a la cual se assignan los usuarios
	 * @return
	 * 		La lista de cluster con los usuarios assignados
	 */
	public List<Cluster> assignacioRespuestaEncuesta(Encuesta encuesta, HashMap<Integer,MinMax> mapMinMax, Respuesta_Analisis respEncuestas, List<Cluster> centroids){
		
		
		for(RespuestaEncuesta ra: respEncuestas.getListRP()){
			double distance_min = 1.;
			int index_centroid=0;
			
			for(int i = 0; i < k; i++){
				double distance = distanceRespEncuesta(ra,centroids.get(i).getCentroid(),encuesta,mapMinMax);
				if(distance < distance_min){
					distance_min = distance;
					index_centroid = i;
				}
			}
			
			centroids.get(index_centroid).getUsuarios().add(ra);	
			
		}
		
		return centroids;
	}
	
	/**
	 * Este metodo recalcula los centroids de los cluster en funcion de los usuarios que han sido assignado al cluster.
	 * Funciona en 2 pasos:
	 * 1.Para cada cluster, un bucle sobre los usuarios que han sido assignado para calcular las "medianas" para cada pregunta
	 * 2.Para cada cluster, el centroid coge como nuevo valor cada mediana a cada pregunta
	 * 
	 * @param centroids
	 * 		La lista de cluster que contiene los centroids que recalculamos
	 * @param encuesta
	 * 		La encuesta que se analiza
	 * @param funcWord
	 * 		Las palabras funcional que se ignoran para calcular las distancias de las respuestas a pregunta de tipo 5
	 * @return
	 * 		La lista de Cluster con los centroids (RespuestaEncuesta) recalculados
	 */
	public List<Cluster> recomputeCentroids(List<Cluster> centroids, Encuesta encuesta, String funcWord){
		
		
		for(Cluster cluster: centroids){
			for(int i = 0; i < encuesta.getN_preguntas() ; i++){
				int tipoP = encuesta.getPreguntas().get(i).tipo;
				double mediana1 = 0;
				double mediana2 = 0;
				Map<String,Integer> mediana3 = new HashMap<String,Integer>();
				Map<Set<String>,Integer> mediana4 = new HashMap<Set<String>,Integer>();
				Map<String,Integer> mediana5 = new HashMap<String,Integer>();

				for(int j = 0; j < cluster.getUsuarios().size() ; j++){
					switch (tipoP){
					case 1 :
						mediana1 += cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR1();
						break;
					case 2 :
						mediana2 += cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR2();
						break;
					case 3 :
						String s = cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR3();
						int value = mediana3.getOrDefault(s,0);
						mediana3.put(s, value+1);
						break;
					case 4 :
						Set<String> set = cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR4();
						int value2 = mediana4.getOrDefault(set, 0);
						mediana4.put(set,value2+1);
						break;
					case 5 :
						String respString = cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR5();
						Set<String> set2 = new HashSet<String>(Arrays.asList(respString.split(" ")));
						set2.removeIf(word -> funcWord.contains(word));
						for(String word : set2){
							int value3 = mediana5.getOrDefault(word, 0);
							mediana5.put(word, value3+1);
						}
						break;																						
					}
					
				}
				if(cluster.getUsuarios().size() != 0){
					switch(tipoP){
						case 1 :
							double result = mediana1/cluster.getUsuarios().size();
							cluster.getCentroid().getRespPreguntas().get(i).setValueR1(result);
							break;
						case 2 :
							int result2 = (int) (mediana2/cluster.getUsuarios().size());
							cluster.getCentroid().getRespPreguntas().get(i).setValueR2(result2);
							break;
						case 3 :
							String resultS = "";
							int freqMax = 0;
							for(String s : mediana3.keySet()){
								int freq = mediana3.get(s);
								if(freq > freqMax){
									resultS = s;
									freqMax = freq;
								}
							}
							cluster.getCentroid().getRespPreguntas().get(i).setValueR3(resultS);
							break;
							
						case 4:
							Set<String> result4 = new HashSet<String>();
							int freqMax4 = 0;
							for(Set<String> set : mediana4.keySet()){
								int f = mediana4.get(set);
								if(f > freqMax4){
									result4 = set;
									freqMax4=f;
								}
							}
							cluster.getCentroid().getRespPreguntas().get(i).setValueR4(result4);
							break;
						case 5:
							String result5 = "";
							int max = Collections.max(mediana5.values());
							for(String word : mediana5.keySet()){
								if(mediana5.get(word) == max){
									result5 += word + " ";
								}
							}
							cluster.getCentroid().getRespPreguntas().get(i).setValueR5(result5);
							break;					
					}
				}
				
			}
			
			
		}
		return centroids;
		
	}
	
	/**
	 * Este metodo calcula la distancia entre dos respuestas a una misma encuesta.
	 * Hace un loop sobre todas las preguntas y segun de que tipo esta llama a la funcion distancia con los buenos parametros.
	 * 
	 * @param r1
	 * 		las respuestas a la encuesta 
	 * @param r2
	 * 		otra respuestas a la encuesta
	 * @param e
	 * 		La encuesta a la cual se ha respondido
	 * @param mapMinMax
	 * 		Los minimos y maximos a las preguntas de tipo 1 de la encuesta
	 * @return
	 * 		La distancia entre las dos respuestas a encuesta, que es un double que pertenece al intervalo [0,1]
	 */
	public double distanceRespEncuesta(RespuestaEncuesta r1,RespuestaEncuesta r2, Encuesta e,HashMap<Integer,MinMax> mapMinMax ){
		double distance = 0;
		for(int index = 0; index < e.getN_preguntas(); index++){
			switch (e.getPreguntas().get(index).tipo){
				case 1 :
					MinMax m = mapMinMax.get(e.getPreguntas().get(index).id); 
					distance += r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), m.min, m.max, 0);
					break;
				case 2 :
					int size = ((Tipo_2) e.getPreguntas().get(index)).getOpciones(); 
					distance +=  r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), 0, 0, size);
					break;
				case 3 :
					distance += r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), 0, 0, 0);
					break;
				case 4 :
					distance += r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), 0, 0, 0);
					break;
				case 5 :
					distance += r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), 0, 0, 0);
					break;								
			}
			
		}
		distance /= encuesta.getN_preguntas();
		return distance;
	}
	
	/**
	 * Classe que sirve para guardar los minimos y maximos a pregunta de tipo 1
	 * 
	 * @author Raphael
	 *
	 */
	public class MinMax{
		private double min;
		private double max;
		
		/**
		 * El constructor de la classe,
		 * initialitza el maximo con la menor valor possible y el minimo con la mayor valor possible.
		 */
		public MinMax(){
			min = Double.MAX_VALUE;
			max = Double.MIN_VALUE;
		}
		
		/**
		 * Metodo para obtenir el minimo
		 * 
		 * @return
		 * 		el minimo
		 */
		public double getMin() {
			return min;
		}
		
		/**
		 * Metodo para modificar el minimo
		 * 
		 * @param min
		 * 		el nuevo minimo
		 */
		public void setMin(double min) {
			this.min = min;
		}
		
		/**
		 * Metodo para obtenir el maximo
		 * 
		 * @return
		 * 		el maximo
		 */
		public double getMax() {
			return max;
		}

		/**
		 * Metodo para modificar el maximo
		 * 
		 * @param max
		 * 		el nuevo maximo
		 */
		public void setMax(double max) {
			this.max = max;
		}
		
	}
	
	
	/**
	 * Metodo para obtenir las respuestas  de usuarios a una encuesta que se analizan
	 * 
	 * @return
	 * 		las respuestas a una encuesta de usuarios
	 */
	public Respuesta_Analisis getRespEncuestas() {
		return respEncuestas;
	}
	
	/**
	 * Metodo para obtenir la encuesta  que se analizan
	 * 
	 * @return
	 */
	public Encuesta getEncuesta() {
		return encuesta;
	}

	/**
	 * Metodo para cargar en una String el fichero que contiene las palabras funcionals.
	 * Eso sirve para analizar preguntas 5.
	 * 
	 * @param filename
	 * 		El path hasta el fichero 
	 * @return
	 * 		La String que contiene las palabras funcionals
	 * @throws IOException
	 * 		Se lanza una exception si no se ha encontrado el fichero
	 */
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
	
}