package prop.dominio;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
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
		encuesta = respEncuesta.getListRP().get(0).getEncuesta();
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
		
		
		//ASSIG EACH RESPUESTA_ENCUESTA TO CLUSTER
		for(RespuestaEncuesta ra: respEncuestas.getListRP()){
			double distance_min = 1.;
			int index_centroid;
			
			for(int i = 0; i < k; i++){
				double distance = 0;
				for(int index = 0; index < encuesta.getN_preguntas(); index++){
					distance += ra.getRespPreguntas().get(index)//...
					//Switch encuesta.get(index).type case ...
					//Compute distance between ra.get(index) and seeds.get(index)
					//Increment distance
				}
				distance /= encuesta.getN_preguntas(); 
				if(distance < distance_min){
					distance_min = distance;
					index_centroid = i;
				}
			}
			
			centroids.get(index_centroid).getUsuarios().add(ra);
			if(centroids.get(index_centroid).getDistanceMax() > distance_min){
				centroids.get(index_centroid).setDistanceMax(distance_min);
			}		
			
		}
		
		
		
	}
	
	public List<Cluster> createCluster(){
		List<Cluster> centroids = new ArrayList<Cluster>();
		List<RespuestaPregunta> listRP = new ArrayList<RespuestaPregunta>();
		RespuestaEncuesta seed;
		for(int i = 0; i < k; i++){
			for(int j = 0; j < encuesta.getN_preguntas() ; j++){
				//generate random answer "random" to the question ecuesta.get(j).type()
				//Generate particular respuestas!!!!
				RespuestaPregunta rp = new RespuestaPregunta(random);
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
					double res = re.getRespPreguntas().get(i);//We want value of the answer
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
	
	/*
	public static double distance(RespuestaPregunta rp1, RespuestaPregunta rp2, int tipo){
		switch (tipo){
			case 1 :
				
			break;	
			case 2 :
			
			break;	
			case 3 :
				//Change getString methode by the getter implemented in Respuesta_2
				if(rp1.getString().equals(rp2.getString())) return 0; else return 1;					
			break;	
			case 4 :
				for(int i =0; i < rp1.getPregunta().)
			break;	
			case 5 :
				
			break;	
		}
				
	}*/
	
	
	
}
