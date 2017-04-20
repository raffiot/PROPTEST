package prop.dominio;

/**
 * El driver contestar sirve para probar que se almacenan y tratan las respuestas de forma correcta
 * 
 * @author Marina				
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class driver_contestar {
	private static Scanner texto;
	private static Scanner respuesta;
	
	

	public static void main(String [ ] args){

		
        texto = new Scanner(System.in);
        respuesta = new Scanner(System.in);
        Participant a = null;
		Encuesta e = new Encuesta(1);
		List<RespuestaPregunta> rp = new ArrayList<RespuestaPregunta>();
        RespuestaEncuesta re = new RespuestaEncuesta(e,a,rp);
        boolean trobat = false;
        e.leer("1");
        System.out.println(e.toString());
		System.out.println("Responde la encuesta:");
		for(int i = 0; i < e.getN_preguntas(); ++i){
			System.out.println("Responde la pregunta "+ (i+1));
			Pregunta p = e.getPreguntas().get(i);
			Integer tipo = p.getTipo();
			RespuestaPregunta r=null;
			
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
				
				trobat = false;
				ArrayList<String> opciones = ((Tipo_2)p).getLista_opciones();
				for( int m = 0; m < ((Tipo_2)p).getOpciones(); ++m){
					if(valor.equals(opciones.get(m))) {
						trobat = true;
						break;
					}
				}
				if ( trobat) {
					int k = ((Tipo_2) p).getPosicion(valor);
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
					if ( valor.equals(opt.get(n))){
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
				String t = texto.nextLine();
				Set<String> set = new HashSet<String>(Arrays.asList(t.split(" ")));
				trobat = false;
				ArrayList<String> options = ((Tipo_4)p).getLista_opciones();
				trobat = options.containsAll(set);
				
				
				if (trobat){
					r = new Respuesta_4(p,set);
					trobat = false;
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 5){
				String valor = texto.nextLine();
				r = new Respuesta_5(p,valor);
			}
			rp.add(r);
			
		}
		re.guardarRespuesta(rp,e.getId());

	}
}
