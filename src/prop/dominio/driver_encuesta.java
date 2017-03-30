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
    					
    			}
    			break;
    		case 3: 
    			e.imprimir();
    			break;
    		
    	}
        
        }while (var != 0);
	

	}
}
