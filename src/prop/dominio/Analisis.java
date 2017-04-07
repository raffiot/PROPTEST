package prop.dominio;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class Analisis {
	
	private int id;
	private int k;
	private double threshold;
	private Administrador admin;
	private Respuesta_Analisis respEncuestas;
	private Encuesta encuesta;
	
	public Analisis(int id, int k, double threshold, Administrador admin, Respuesta_Analisis respEncuestas){
		this.id = id;
		this.k = k;
		this.threshold = threshold;
		this.admin = admin;
		this.respEncuestas = respEncuestas;
		encuesta = respEncuestas.getListRP().get(0).getEncuesta();
	}
	
	public Resultado k_means(){
		
		//variable listToAnalyse is an array containing the results we want to analyse
		//variable k is the number of centroids we want
		//variable sizeVector is the number of question of the questionnary
		//variable thresholdDist is the distance that will determine when k-mean will end
		
		//CREATION OF SEEDS
		//generar los seeds random?
		List<Cluster> centroids = createCluster();
		
		
		
		HashMap<Integer,MinMax> mapMinMax = minMax_Respuesta_1();
		
<<<<<<< Updated upstream
		boolean underThreshold = true;
		do{
			//ASSIG EACH RESPUESTA_ENCUESTA TO CLUSTER
			for(RespuestaEncuesta ra: respEncuestas.getListRP()){
				double distance_min = 1.;
				int index_centroid;
				
				for(int i = 0; i < k; i++){
					double distance = 0;
					for(int index = 0; index < encuesta.getN_preguntas(); index++){
						switch (encuesta.getPreguntas().get(index).tipo){
							case 1 :
								MinMax m = mapMinMax.get(encuesta.getPreguntas().get(index).id); 
								distance += ra.getRespPreguntas().get(index).distance(centroids.get(i).getCentroid().getRespPreguntas().get(index), m.min, m.max, 0);
								break;
							case 2 :
								int size = ((Tipo_2) encuesta.getPreguntas().get(index)).getOpciones(); //SALE !!!!
								distance +=  ra.getRespPreguntas().get(index).distance(centroids.get(i).getCentroid().getRespPreguntas().get(index), 0, 0, size);
								break;
							case 3 :
								distance += ra.getRespPreguntas().get(index).distance(centroids.get(i).getCentroid().getRespPreguntas().get(index), 0, 0, 0);
								break;
							case 4 :
								distance += ra.getRespPreguntas().get(index).distance(centroids.get(i).getCentroid().getRespPreguntas().get(index), 0, 0, 0);
								break;
							case 5 :
								break;								
						}
						
					}
					distance /= encuesta.getN_preguntas(); 
					if(distance < distance_min){
						distance_min = distance;
						index_centroid = i;
					}
=======
		
		//ASSIG EACH RESPUESTA_ENCUESTA TO CLUSTER
		for(RespuestaEncuesta ra: respEncuestas.getListRP()){
			double distance_min = 1.;
			int index_centroid;
			
			for(int i = 0; i < k; i++){
				double distance = 0;
				for(int index = 0; index < encuesta.getN_preguntas(); index++){
					distance += ra.getRespPreguntas().get(index);//...
					//Switch encuesta.get(index).type case ...
					//Compute distance between ra.get(index) and seeds.get(index)
					//Increment distance
>>>>>>> Stashed changes
				}
				
				centroids.get(index_centroid).getUsuarios().add(ra);
				if(centroids.get(index_centroid).getDistanceMax() > distance_min){
					centroids.get(index_centroid).setDistanceMax(distance_min);
				}		
				
			}
			
			underThreshold = true;
			for(Cluster cluster: centroids){
				if(cluster.getDistanceMax() > threshold){
					underThreshold = false;
				}
			}
			
			
			if(!underThreshold){
				//RECOMPUTE CENTROIDS
				for(Cluster cluster: centroids){
					for(int i = 0; i < encuesta.getN_preguntas() ; i++){
						int tipoP = encuesta.getPreguntas().get(i).tipo;
						double mediana1 = 0;
						double mediana2 = 0;
						Map<String,Integer> mediana3 = new HashMap<String,Integer>();
						if(tipoP == 3){
							for(String s :((Tipo_3)encuesta.getPreguntas().get(i)).lista_opciones){
								mediana3.put(s, 0);
							}
						}
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
								int value = mediana3.get(s);
								mediana3.put(s, value+1);
								break;
							case 4 :
								break;
							case 5 :
								break;																						
							}
							
						}
						
						switch(tipoP){
							case 1 :
								double result = mediana1/cluster.getUsuarios().size();
								cluster.getCentroid().getRespPreguntas().get(i).setValueR1(result);
								break;
							case 2 :
								int result2 = (int) ((double)(mediana2)/cluster.getUsuarios().size());
								cluster.getCentroid().getRespPreguntas().get(i).setValueR2(result2);
								break;
							case 3 :
								String resultS = "";
								int freqMax = 0;
								for(String s : mediana3.keySet()){
									int freq = mediana3.get(s);
									if(freq > freqMax){
										resultS = s;
									}
								}
								cluster.getCentroid().getRespPreguntas().get(i).setValueR3(resultS);
								break;
								
							case 4:
								break;
							case 5:
								break;					
						}
						
					}					
				}
			}
		}while(!underThreshold);
		
		return new Resultado(centroids);
	}
	

	public List<Cluster> createCluster(){
		List<Cluster> centroids = new ArrayList<Cluster>();
		List<RespuestaPregunta> listRP = new ArrayList<RespuestaPregunta>();
		RespuestaEncuesta seed;
		for(int i = 0; i < k; i++){
			for(int j = 0; j < encuesta.getN_preguntas() ; j++){
				//generate random answer "random" to the question ecuesta.get(j).type()
				//Generate particular respuestas!!!!
				RespuestaPregunta rp = encuesta.getPreguntas().get(i).generateAnswer();
				listRP.add(rp);
			}
			seed = new RespuestaEncuesta(encuesta,listRP);
			centroids.add(new Cluster(i,seed));
		}
		return centroids;
	}
	
	
	public HashMap<Integer,MinMax> minMax_Respuesta_1(){
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
			}
			map.put(encuesta.getPreguntas().get(i).getId(), minmax);
		}
		return map;
	}
	
	
	public class MinMax{
		private double min;
		private double max;
		
		public MinMax(){
			min = Double.MAX_VALUE;
			max = Double.MIN_VALUE;
		}

		public double getMin() {
			return min;
		}

		public void setMin(double min) {
			this.min = min;
		}

		public double getMax() {
			return max;
		}

		public void setMax(double max) {
			this.max = max;
		}
		
	}
	
	
	
}
