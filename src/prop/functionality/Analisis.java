package prop.functionality;


import java.util.List;
import java.util.ArrayList;
public class Analisis {
	
	private int id;
	private int k;
	private double threshold;
	private Administrador admin;
	private List<RespuestaEncuesta> respEncuesta;
	private Encuesta encuesta;
	
	public Analisis(int id, int k, double threshold, Administrador admin, List<RespuestaEncuesta> respEncuesta){
		this.id = id;
		this.k = k;
		this.threshold = threshold;
		this.admin = admin;
		this.respEncuesta = new ArrayList<RespuestaEncuesta>();
		for(RespuestaEncuesta r : respEncuesta){
			this.respEncuesta.add(r);
		}
		encuesta = respEncuesta.get(0).getEncuesta();
	}
	
	public Resultado k_means(){
		
		//variable listToAnalyse is an array containing the results we want to analyse
		//variable k is the number of centroids we want
		//variable sizeVector is the number of question of the questionnary
		//variable thresholdDist is the distance that will determine when k-mean will end
		
		//CREATION OF SEEDS
		//generar los seeds random?
		RespuestaEncuesta seed = new RespuestaEncuesta();
		for(int i = 0; i < k; i++){
			for(int j = 0; j < encuesta.getN_preguntas() ; j++){
				//generate random answer "random" to the question ecuesta.get(j).type()
				RespuestaPregunta rp = new RespuestaPregunta(random);
				seed.add(rp);
			}			
		}
		
		//ASSIG EACH RESPUESTA_ENCUESTA TO CLUSTER
		for(Respuesta_encuesta ra: listToAnalyse){
			double distance_min = Double.POSITIVE_INFINITY;
			int index_centroid = 0;
			
			for(int i = 0; i < k; i++){
				double distance = 0;
				for(int index = 0; index < encuesta.size(); index++){
					//Switch encuesta.get(index).type case ...
					//Compute distance between ra.get(index) and seeds.get(index)
					//Increment distance
				}
				if(distance < distance_min){
					distance_min = distance;
					index_centroid = k;
				}
			}
			
			//Store the result of assignation
			
			
		}
		
		
		
	}
	
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
				
			break;	
			case 5 :
				
			break;	
		}
				
	}
	
	
	
}
