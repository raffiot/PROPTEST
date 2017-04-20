package prop.dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RespuestaEncuesta {
	private Encuesta encuesta;
	private Participant participant;//identificador de participante solo
	private List<RespuestaPregunta> respPreguntas;
	
	public RespuestaEncuesta(Encuesta e, Participant p, List<RespuestaPregunta> rp){
		encuesta = e;
		participant = p;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	public RespuestaEncuesta(){
		
	}
	
	//Particular constructor for centroids RespuestaEncuesta
	public RespuestaEncuesta(Encuesta e, List<RespuestaPregunta> rp){
		encuesta = e;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	public Encuesta getEncuesta(){
		return encuesta;		
	}

	public List<RespuestaPregunta> getRespPreguntas() {
		return respPreguntas;
	}
	
	//It doesn't clone encuesta neither participant
	@Override 
	public RespuestaEncuesta clone(){
		List<RespuestaPregunta> newList = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta rp : respPreguntas){
			newList.add(rp.clone());
		}
		return new RespuestaEncuesta(encuesta,participant,newList);
	}
	
	public void guardarRespuesta(){
		
		/*creem el document*/
		int exist = 1;
    	Integer id = 1;
    	do{	
    		String sFichero = "Respuestas/Respuesta_"+id.toString()+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()) ++id;
    		else exist = 0;
    	}
    	while(exist != 0);
		
    	/*plenem el document*/
    	String s = "";
		s += id +"\r\n";
		for(int i = 0; i < respPreguntas.size();++i){
			int tipo = respPreguntas.get(i).getPregunta().getTipo();
			s += tipo +"\r\n";
			if ( tipo == 1){
				double valor = respPreguntas.get(i).getValueR1();
				s += valor + "\r\n";
			}
			else if ( tipo == 2){
				int valor = respPreguntas.get(i).getValueR2();
				s += valor + "\r\n";
			}
			else if ( tipo == 3){
				String valor = respPreguntas.get(i).getValueR3();
				s += valor + "\r\n";
			}
			else if ( tipo == 4){
				Set<String> valor = respPreguntas.get(i).getValueR4();
				s += valor + "\r\n";
			}
			else if ( tipo == 5){
				String valor = respPreguntas.get(i).getValueR5();
				s += valor + "\r\n";	
			}
		}
		
		FileWriter fichero = null;
	        PrintWriter pw = null;
	        try{
	            fichero = new FileWriter("Respuestas/Respuesta_"+id+".txt");
	            fichero.write(s);

	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        } 
	        finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
}
