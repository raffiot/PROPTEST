package dominio.clases;
/**
 * Esta classe respresenta el conjunto de respuestas de las preguntas de una encuesta
 * 
 * @author Marina
 * @author Miguel
 * @author Raphael
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RespuestaEncuesta {
	private Encuesta encuesta;
	private Participant participant;//identificador de participante solo
	private List<RespuestaPregunta> respPreguntas;
	
	/**
	 * El constructor de la clase, con una encuesta, el participant que ha respondido y el conjunto de respuestas que ha respondido.
	 * 
	 * @param e
	 * 		La encuesta a la cual se ha ha respondido
	 * @param p
	 * 		El participant que ha respondido
	 * @param rp
	 * 		El conjunto de respuestas
	 */
	public RespuestaEncuesta(Encuesta e, Participant p, List<RespuestaPregunta> rp){
		encuesta = e;
		participant = p;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	/**
	 * El constructor vacio de la clase
	 */
	public RespuestaEncuesta(){
		respPreguntas = new ArrayList<RespuestaPregunta>();
	}
	
	/**
	 * Constructor de la clase con una encuesta y un conjunto de respuestas a esa encuesta
	 * 
	 * @param e
	 * 		La encuesta
	 * @param rp
	 * 		El conjunto de respuestas
	 */
	//Particular constructor for centroids RespuestaEncuesta
	public RespuestaEncuesta(Encuesta e, List<RespuestaPregunta> rp){
		encuesta = e;
		respPreguntas = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta r : rp){
			respPreguntas.add(r);
		}
	}
	
	/**
	 * Metodo para obtenir la encuesta que se ha respondido
	 * 
	 * @return
	 * 		la encuesta que se ha respondido
	 */
	public Encuesta getEncuesta(){
		return encuesta;		
	}
	
	/**
	 * Metodo para obtenir el conjunto de respuestas
	 * 
	 * @return
	 * 		el conjunto de respuestas
	 */
	public List<RespuestaPregunta> getRespPreguntas() {
		return respPreguntas;
	}
	
	/**
	 * Metodo para clonar el conjunto de respuestas
	 * (Con ese metodo no se clona la encuesta ni el participant)
	 * @return
	 * 		el conjunto de respuestas clonado
	 */
	@Override 
	public RespuestaEncuesta clone(){
		List<RespuestaPregunta> newList = new ArrayList<RespuestaPregunta>();
		for(RespuestaPregunta rp : respPreguntas){
			newList.add(rp.clone());
		}
		return new RespuestaEncuesta(encuesta,participant,newList);
	}
	
	/**
	 * Metodo para guardar el conjunto de respuestas en un fichero txt en el directorio persistencia
	 * Se guarda con el nombre siguiente Respuesta_num de la enquesta_identificador generado en el metodo.txt
	 * 
	 * @param rp
	 * 		el conjunto de respuestas que se quiere guardar
	 * @param numEncuesta
	 * 		el numero de la encuesta a la cual se ha respondido
	 */
	public void guardarRespuesta(List<RespuestaPregunta> rp,int numEncuesta){
		
		respPreguntas = rp;
		
		/*creem el document*/
		int exist = 1;
    	Integer id = 1;
    	
    	
    	do{	
    		String sFichero = "src/persistencia/Respuestas/Respuesta_"+numEncuesta+"_"+id+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()) ++id;
    		else exist = 0;
    	}
    	while(exist != 0);
    		//if (fichero.exists()) ++id;
       
    	
		
    	/*plenem el document*/
    	String s = "";
		
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
		
		FileWriter fichero1 = null;
	        PrintWriter pw = null;
	        try{
	        	fichero1 = new FileWriter("src/persistencia/Respuestas/Respuesta_"+numEncuesta+"_"+id+".txt");
	            fichero1.write(s);
	            

	        } 

	        catch (Exception e) {
	            e.printStackTrace();
	        } 
	        finally {
	           try {
	           if (null != fichero1)
	              fichero1.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	/**
	 * Metodo para leer una respuesta de una encuesta de unt txt y cargarlo en un objeto Encuesta
	 * 
	 * @param s
	 * 		el identificador de la encuesta
	 * @param s2
	 * 		el numero de la respuesta
	 */
	public void leer(String s,String s2) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/persistencia/Respuestas/Respuesta_"+s+"_"+s2+".txt"));
			try {
				Encuesta e = new Encuesta(1);
				e.leer(s);
				
				for(int i = 0; i < e.getN_preguntas(); ++i){
					 String line = null;
					    if((line = in.readLine()) != null){
					        Integer tip = Integer.valueOf(line);
					        
					        
			
					        switch(tip){
					        	case 1: 
					        		line = in.readLine();
					        		Respuesta_1 r = new Respuesta_1(e.getPreguntas().get(i),Double.valueOf(line));
					        		this.respPreguntas.add(r);
					        		break;
					        		
					        	case 2:
					        		line = in.readLine();
					        		Respuesta_2 r1 = new Respuesta_2(e.getPreguntas().get(i),Integer.valueOf(line));
					        		this.respPreguntas.add(r1);
					        		break;
					        		
					        		
					        	case 3:
					        		line = in.readLine();
					        		Respuesta_3 r11 = new Respuesta_3(e.getPreguntas().get(i),line);
					        		this.respPreguntas.add(r11);
					        		break;
					        		
					        		
					        	case 4:
					        		line = in.readLine();
					        		line = line.replace("[", "");
					        		line = line.replace(",", "");
					        		line = line.replace("]", "");
					        		Set<String> set = new HashSet<String>(Arrays.asList(line.split(" ")));
					        		Respuesta_4 r111 = new Respuesta_4(e.getPreguntas().get(i),set);
					        		this.respPreguntas.add(r111);
					        		break;
					        		
					    
					        		
					        		
					        	case 5: 
					        		line = in.readLine();
					        		Respuesta_5 r1111 = new Respuesta_5(e.getPreguntas().get(i),line);
					        		this.respPreguntas.add(r1111);
					        		break;
						
					        }
					 }
				}
				this.encuesta = e;
				in.close();
				
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que crea una string que describe respuestas a una encuesta
	 * 
	 * @return la string que describe respuestas a una encuesta
	 */
	@Override
	public String toString(){
		String s ="";
		for(RespuestaPregunta rp : respPreguntas) s+= rp.toString();
		return s;
	}
	
}
