package prop.dominio;


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
	//private Administrador admin;
	private Respuesta_Analisis respEncuestas;
	private Encuesta encuesta;
	
	public Analisis(int id, int k, double threshold, Respuesta_Analisis respEncuestas){//Administrador admin,
		this.id = id;
		this.k = k;
		this.threshold = threshold;
		//this.admin = admin;
		this.respEncuestas = respEncuestas;
		encuesta = respEncuestas.getListRP().get(0).getEncuesta();
	}
	
	public Resultado k_means(){
		
		//variable listToAnalyse is an array containing the results we want to analyse
		//variable k is the number of centroids we want
		//variable sizeVector is the number of question of the questionnary
		//variable thresholdDist is the distance that will determine when k-mean will end
		
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
			centroids = recomputeCentroids(centroids,encuesta);
			
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
	
	public List<Cluster> recomputeCentroids(List<Cluster> centroids, Encuesta encuesta){
		
		
		for(Cluster cluster: centroids){
			for(int i = 0; i < encuesta.getN_preguntas() ; i++){
				int tipoP = encuesta.getPreguntas().get(i).tipo;
				double mediana1 = 0;
				double mediana2 = 0;
				Map<String,Integer> mediana3 = new HashMap<String,Integer>();
				Map<Set<String>,Integer> mediana4 = new HashMap<Set<String>,Integer>();
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
						Set<String> set = cluster.getUsuarios().get(j).getRespPreguntas().get(i).getValueR4();
						int value2 = mediana4.get(set);
						if(mediana4.containsKey(set)){
							mediana4.put(set,value2+1);
						}
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
						break;					
				}
				
			}
			
			
		}
		return centroids;
		
	}
	
	public double distanceRespEncuesta(RespuestaEncuesta r1,RespuestaEncuesta r2, Encuesta e,HashMap<Integer,MinMax> mapMinMax ){
		double distance = 0;
		for(int index = 0; index < e.getN_preguntas(); index++){
			switch (e.getPreguntas().get(index).tipo){
				case 1 :
					MinMax m = mapMinMax.get(e.getPreguntas().get(index).id); 
					distance += r1.getRespPreguntas().get(index).distance(r2.getRespPreguntas().get(index), m.min, m.max, 0);
					break;
				case 2 :
					int size = ((Tipo_2) e.getPreguntas().get(index)).getOpciones(); //SALE !!!!
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


	public Respuesta_Analisis getRespEncuestas() {
		return respEncuestas;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	
	
	
	
	
}