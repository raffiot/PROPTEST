package prop.dominio;

import java.util.Date;
import java.util.Scanner;

public class driver_encuesta {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main (String [ ] args) {
		 
        //Aquí las instrucciones de inicio y control del programa
 
        System.out.println ("Empezamos la ejecución del programa");
        
        Integer id = 0;
        Encuesta e = new Encuesta(++id);
        texto = new Scanner(System.in);
        opcion = new Scanner(System.in);
        Integer id_p = 0;
        int var;
        Date fecha = new Date();
        e.setFecha(fecha);
        
        System.out.println("Introduzaca genero de la encuesta");
        e.setGenero(texto.nextLine());
        
        
        
       do{
    	    System.out.println("1. Añadir Pregunta.");
			System.out.println("2. Guardar y salir.");
			System.out.println("3. Imprimir encuesta");
			System.out.println("0. Salir del driver.");
			
			var = opcion.nextInt();
    		switch(var){
    		
    		case 1:
    			System.out.println("Qué tipo de pregunta desea añadir?");
    			System.out.println("1. Variables cuantitatives o numéricas,");
    			System.out.println("2. Variables cualitativas ordenadas,");
    			System.out.println("3. Variables cualitativas no ordenadas,");
    			System.out.println("4. Variables cualitativas no ordenadas donde la respuesta es un conjunto,");
    			System.out.println("5. Tipo libre,");
    			
    			int aux = 0;
    			aux = opcion.nextInt();
    			switch(aux) {
    				case 1:
    				
    					Tipo_1 p = new Tipo_1();
    					System.out.println("Inserte enunciado");
    					p.setEnunciado(texto.nextLine());
    					System.out.println("Inserte la opcion numerica minima");
    					p.setMin(opcion.nextInt());
    					System.out.println("Inserte la opcion numerica máxima");
    					p.setMax(opcion.nextInt());
    					p.setOpciones(p.getMax()-p.getMin());
    					 p.setId(++id_p); 
    					e.añadir_pregunta(p);
    					System.out.println("Pregunta añadida");
    					break;
    					
    				case 2:
    					Tipo_2 p1 = new Tipo_2();
    					System.out.println("Inserte enunciado");
    					p1.setEnunciado(texto.nextLine());
    					System.out.println("Inserte el numero de opciones");
    					p1.setOpciones(opcion.nextInt());
    					for (int i = 0; i < p1.getOpciones(); ++i) {
    						System.out.println("Inserte opcion");
    						p1.añadir_opcion(texto.nextLine());
    					}
    					p1.setId(++id_p);
    					e.añadir_pregunta(p1);
    					System.out.println("Pregunta añadida");
    					break;
    					
    				case 3:
    					Tipo_3 p11 = new Tipo_3();
    					System.out.println("Inserte enunciado");
    					p11.setEnunciado(texto.nextLine());
    					System.out.println("Inserte el numero de opciones");
    					p11.setOpciones(opcion.nextInt());
    					for (int i = 0; i < p11.getOpciones(); ++i) {
    						System.out.println("Inserte opcion");
    						String s = null; 
    						s = texto.nextLine();
    						p11.añadir_opcion(s);
    					}
    					p11.setId(++id_p);
    					e.añadir_pregunta(p11);
    					System.out.println("Pregunta añadida");
    					break;
    					
    				case 4:
    					Tipo_4 p111 = new Tipo_4();
    					System.out.println("Inserte enunciado");
    					p111.setEnunciado(texto.nextLine());
    					System.out.println("Inserte el numero de opciones");
    					p111.setOpciones(opcion.nextInt());
    					for (int i = 0; i < p111.getOpciones(); ++i) {
    						System.out.println("Inserte opcion");
    						p111.añadir_opcion(texto.nextLine());
    					}
    					p111.setId(++id_p);
    					e.añadir_pregunta(p111);
    					System.out.println("Pregunta añadida");
    					break;
    					
    				case 5:
    					Tipo_5 p1111 = new Tipo_5();
    					System.out.println("Inserte enunciado");
    					p1111.setEnunciado(texto.nextLine());
    					p1111.setId(++id_p);
    					e.añadir_pregunta(p1111);
    					System.out.println("Pregunta añadida");
    					break;
    					
    			}
    			break;
    		case 3: 
    			e.imprimir();
    			break;
    		
    	}
        
        }while (var != 0);
	

	}
}
