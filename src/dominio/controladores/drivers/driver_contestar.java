package dominio.controladores.drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.clases.*;


public class driver_contestar {
	private static Scanner texto;
	private static Scanner opcion;

	public static void main (String [ ] args) {

	    System.out.println ("Empezamos la ejecucion del driver de para responder encuestas");
        System.out.println("Las encuestas disponibles son las siguientes: ");

    	texto = new Scanner(System.in);
        respuesta = new Scanner(System.in);
        
        boolean trobat = false;
        Integer numEnquesta;
        do{
        	System.out.println("Encuestas actuales:");
        	int exist = 1;
        	Integer id = 1;
        	do{	 //imprimimos todas las encuestas actuales
        		String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
        		File fichero = new File(sFichero);
        		if (fichero.exists()){ 
        			Encuesta en = new Encuesta(id);
        			en.leer(id.toString());
        			System.out.println("Encuesta_"+id+ " Genero = "+en.getGenero());
        			++id;
        		}
        		else exist = 0;
        	}
        	while(exist != 0);

        	System.out.println("Escribe el numero de la encuesta que quieres responder");
        	numEnquesta = respuesta.nextInt();
        	String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
    		File fichero = new File(sFichero);
    		trobat = fichero.exists();
    		if(!trobat) 
    			System.out.println("no se ha encontrado la encuesta");
        }
        while(!trobat);

    	System.out.println("Introduce la id de la encuesta que quieres responder");
    	int var2 = opcion.nextInt();
        
        int var;
        System.out.println ("Pulse 1 para visualizar la encuesta que quiere responder");
        System.out.println ("Pulse 0 si desea salir del driver");

        var = opcion.nextInt();

        Encuesta e = new Encuesta(var2);
		List<RespuestaPregunta> rp = new ArrayList<RespuestaPregunta>();
        
        e.leer(var2.toString());

        do{
        	if (var == 0) System.exit(0);
        	if (var == 1) System.out.println(e.toString());
        }
        while (var != 1);

        for(int i = 0; i < e.getN_preguntas(); ++i){
			do{
			trobat = false;	
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
					trobat = true;
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
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 3){
				String valor = texto.nextLine();
				ArrayList<String> opt = ((Tipo_3)p).getLista_opciones();
				for ( int n = 0; n < ((Tipo_3) p).getOpciones();++n){
					if ( valor.equals(opt.get(n))){
						trobat = true;
						break;
					}
				}
				if (trobat) {
					r = new Respuesta_3(p,valor);
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 4){
				String t = texto.nextLine();
				Set<String> set = new HashSet<String>(Arrays.asList(t.split(" ")));
				ArrayList<String> options = ((Tipo_4)p).getLista_opciones();
				trobat = options.containsAll(set);
				
				
				if (trobat){
					r = new Respuesta_4(p,set);
				}
				else System.out.println("Respuesta incorrecta");
			}
			else if(tipo== 5){
				String valor = texto.nextLine();
				r = new Respuesta_5(p,valor);
				trobat = true;
			}
			if(trobat) rp.add(r);
			}while(!trobat);	
		}
		guardar(rp,e.getId());
		System.out.println("Encuesta finalizada. Gracias por particpar!");

    }

    public void guardar(List<RespuestaPregunta> rp,int numEncuesta){
		
		respPreguntas = rp;
		
		/*creem el document*/
		int exist = 1;
    	Integer id = 1;
    	
    	
    	do{	
    		String sFichero = "Data/Drivers/Respuestas/Respuesta_"+numEncuesta+"_"+id+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()) ++id;
    		else exist = 0;
    	}
    	while(exist != 0);
		
    	/*plenem el document*/
    	String s = "";
    	s += this.nombre+"\r\n";
		
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
	        	fichero1 = new FileWriter("Data/Drivers/Respuestas/Respuesta_"+numEncuesta+"_"+id+".txt");
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
}