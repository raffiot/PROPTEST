package prop.dominio;

/**
 * El driver contestar sirve para probar que se almacenan y tratan las respuestas de forma correcta
 * 
 * @author Marina				
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class driver_contestar {
	private static Scanner texto;
	private static Scanner respuesta;
	
	
	public void contestar(){
		
        texto = new Scanner(System.in);
        respuesta = new Scanner(System.in);
        Participant a = null;
		Encuesta e = null;
		List<RespuestaPregunta> rp = new ArrayList<RespuestaPregunta>();
        RespuestaEncuesta re = new RespuestaEncuesta(e,a,rp);
        boolean trobat = false;
        
		System.out.println("Responde la encuesta:");
		for(int i = 1; i <= e.getN_preguntas(); ++i){
			System.out.println("Responde la pregunta"+ i);
			Pregunta p = e.getPreguntas().get(i);
			Integer tipo = p.getTipo();
			RespuestaPregunta r = new RespuestaPregunta(p);
			
			if (tipo == 1){
				int valor = respuesta.nextInt();
				int max = ((Tipo_1)p).getMax();
				int min = ((Tipo_1)p).getMin();
				if(valor <= max && valor >= min){
					r = new Respuesta_1(p,(double)valor);
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if (tipo == 2){
				String valor = texto.nextLine();
				int k = ((Tipo_2) p).getPosicion(valor);
				trobat = false;
				ArrayList<String> opciones = ((Tipo_2)p).getLista_opciones();
				for( int m = 0; m < ((Tipo_2)p).getOpciones(); ++m){
					if(valor == opciones.get(i)) {
						trobat = true;
						break;
					}
				}
				if ( trobat) {
					r = new Respuesta_2(p,k);
					trobat = false;
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 3){
				String valor = texto.nextLine();
				trobat = false;
				ArrayList<String> opt = ((Tipo_3)p).getLista_opciones();
				for ( int n = 0; n < ((Tipo_3) p).getOpciones();++n){
					if ( valor == opt.get(i)){
						trobat = true;
						break;
					}
				}
				if (trobat) {
					r = new Respuesta_3(p,valor);
					trobat = false;
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 4){
				trobat = false;
				ArrayList<String> options = ((Tipo_4)p).getLista_opciones();
				Set<String> valor = new HashSet<String>(); 
				int num = ((Tipo_4)p).getOpciones();
				for (String s:valor){
					if(options.contains(s)){
						trobat = true;
					}
				}
				if (trobat){
					r = new Respuesta_4(p,valor);
					trobat = false;
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 5){
				String valor = texto.nextLine();
				r = new Respuesta_5(p,valor);
			}
			rp.add(r);
			re.guardarRespuesta();
		}
		
	}
}
