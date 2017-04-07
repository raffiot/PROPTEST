package prop.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class driver_contestar {
	private static Scanner texto;
	private static Scanner respuesta;
	
	
	public void contestar(){
		
        texto = new Scanner(System.in);
        respuesta = new Scanner(System.in);
        Participant a;
		Encuesta e;
		List<RespuestaPregunta> rp;
        RespuestaEncuesta re = new RespuestaEncuesta(e,a,rp);
        
		e.imprimir();
		System.out.println("Responde la encuesta:");
		for(int i = 1; i <= e.getN_preguntas(); ++i){
			System.out.println("Responde la pregunta"+ i);
			Pregunta p = e.getPreguntas().get(i);
			Integer tipo = p.getTipo();
			RespuestaPregunta r;
			
			if (tipo == 1){
				int valor = respuesta.nextInt();
				r = new Respuesta_1(p,(double)valor);
			}
			else if (tipo == 2){
				String valor = texto.nextLine();
				int k = ((Tipo_2) p).getPosicion(valor);
				r = new Respuesta_2(p,k);
			}
			else if(tipo== 3){
				String valor = texto.nextLine();
				r = new Respuesta_3(p,valor);
			}
			else if(tipo== 4){
				Set<String> valor = new Set<String>(); //coger valor 
				r = new Respuesta_4(p,valor);
			}
			else if(tipo== 5){
				String valor = texto.nextLine();
				r = new Respuesta_5(p,valor);
			}
			rp.add(r);
			a.rellenarInformacion(re);
			escribir_en_fichero();
		}
		
	}
	
	public void escribir_en_fichero(){
		
	}

	
}
