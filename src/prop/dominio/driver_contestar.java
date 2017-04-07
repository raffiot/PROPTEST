package prop.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class driver_contestar {
	private static Scanner texto;
	private static Scanner respuesta;
	public List<RespuestaPregunta> rp;
	
	public void contestar(){
		
        texto = new Scanner(System.in);
        respuesta = new Scanner(System.in);
        
		rp = new ArrayList<RespuestaPregunta>();
		Encuesta e;
		e.imprimir();
		System.out.println("Responde la encuesta:");
		for(int i = 0; i < e.getN_preguntas(); ++i){
			System.out.println("Responde la pregunta"+ i);
			Pregunta p = e.getPreguntas().get(i);
			Integer tipo = p.getTipo();
			RespuestaPregunta r;
			
			if (tipo == 1){
				double valor = 0;//coger valor 
				r = new Respuesta_1(p,valor);
			}
			if(tipo== 2){
				int valor = 0;//coger valor 
				r = new Respuesta_2(p,valor);
			}
			if(tipo== 3){
				String valor = ""; //coger valor 
				r = new Respuesta_3(p,valor);
			}
			if(tipo== 4){
				Set<String> valor = new Set<String>(); //coger valor 
				r = new Respuesta_4(p,valor);
			}
			if(tipo== 5){
				String valor =""; //coger valor 
				r = new Respuesta_5(p,valor);
			}
			rp.add(r);
			escribir_en_fichero();
		}
		
	}
	
	public void escribir_en_fichero(){
		
	}

	
}
