package dominio.controladores.drivers;

import java.util.Scanner;

import dominio.clases.*;


public class driver_encuesta {
	
	private static Scanner texto;
	private static Scanner opcion;
	public static void main (String [ ] args) {
		 
        
 
        System.out.println ("Empezamos la ejecucion del driver de encuesta");
        
        System.out.println ("Una Encuesta ha sido cargada para probar sus metodos");
        
        Encuesta e = new Encuesta(1);
        e.leer("1");
        
        int var;
        System.out.println ("Pulse 1 para visualizar la encuesta cargada");
        System.out.println ("Pulse 0 si desea salir del driver");
        
        var = opcion.nextInt();
        do{
        	if (var == 0) System.exit(0);
        	if (var == 1) System.out.println(e.toString());
        }while (var != 1);
        
        do{
        	System.out.println ("Indique que quiere hacer ahora");
        	System.out.println ("Pulse 1 si desea obtener el genero de la encuesta");
        	System.out.println ("Pulse 2 si desea modificar el genero de la encuesta");
        	System.out.println ("Pulse 3 si desea anadir una pregunta");
        	System.out.println ("Pulse 4 si desea obtener una pregunta de la encuesta");
        	System.out.println ("Pulse 5 si desea guardar la encuesta");
        	System.out.println ("Pulse 6 si desea cargar otra encuesta");
        	System.out.println ("Pulse 7 si desea borrar la encuesta");
        	
        	var = opcion.nextInt();
        	System.out.println("");
        	switch (var){
        	
        		case 1:
        			System.out.println("El genero de la encuesta es: " + e.getGenero());
        			break;
        		
        		case 2:
        			System.out.println ("Introduzca el nuevo genero de la encuesta");
        			e.setGenero(texto.nextLine());
        			break;
        		
        		case 3:
        			System.out.println ("Introduzca el tipo de la pregunta que desea anadir");
        			System.out.println("1. Variables cuantitatives o numericas,");
    				System.out.println("2. Variables cualitativas ordenadas,");
    				System.out.println("3. Variables cualitativas no ordenadas,");
    				System.out.println("4. Variables cualitativas no ordenadas donde la respuesta es un conjunto,");
    				System.out.println("5. Tipo libre,");
    				int aux = opcion.nextInt();
    				
    				
    				System.out.println("Introduzca enunciado");
    				String s = texto.nextLine();
    				
    				switch (aux){
    				
    					case 1:  
    						Tipo_1 p = new Tipo_1();
    						p.setEnunciado(s);
    						System.out.println("Introduzca la opcion minima");
    						p.setMin(opcion.nextInt());
    						System.out.println("Introduzca la opcion maxima");
    						p.setMax(opcion.nextInt());
    						p.setOpciones(p.getMax()-p.getMin()+1);
    						p.setId(e.getN_preguntas());
    						e.anadir_pregunta(p);
    						break;
    						
    					case 2:
    						Tipo_2 p2 = new Tipo_2();
    						p2.setEnunciado(s);
    						p2.setId(e.getN_preguntas());
    						System.out.println("Introduzca el numero de opciones");
    						p2.setOpciones(opcion.nextInt());
    						for (int i = 0; i < p2.getOpciones(); ++i) {
        						System.out.println("Inserte opcion");
        						p2.anadir_opcion(texto.nextLine());
        					}
    						e.anadir_pregunta(p2);
    						break;
    						
    					case 3:
    						Tipo_3 p3 = new Tipo_3();
    						p3.setEnunciado(s);
    						p3.setId(e.getN_preguntas());
    						System.out.println("Introduzca el numero de opciones");
    						p3.setOpciones(opcion.nextInt());
    						for (int i = 0; i < p3.getOpciones(); ++i) {
        						System.out.println("Inserte opcion");
        						p3.anadir_opcion(texto.nextLine());
        					}
    						e.anadir_pregunta(p3);
    						break;	
    					
    					case 4:
    						Tipo_4 p4 = new Tipo_4();
    						p4.setEnunciado(s);
    						p4.setId(e.getN_preguntas());
    						System.out.println("Introduzca el numero de opciones");
    						p4.setOpciones(opcion.nextInt());
    						for (int i = 0; i < p4.getOpciones(); ++i) {
        						System.out.println("Inserte opcion");
        						p4.anadir_opcion(texto.nextLine());
        					}
    						e.anadir_pregunta(p4);
    						break;	
    						
    					case 5:
    						Tipo_5 p5 = new Tipo_5();
    						p5.setEnunciado(s);
    						p5.setId(e.getN_preguntas());
    						e.anadir_pregunta(p5);
    						
    					case 0: 
    						var = 0;
    						break;
    				}
    			break;
    			
        		case 4: 
        			System.out.println("Introduzca el numero de pregunta que desea ver");
        			System.out.println(e.get_pre(opcion.nextInt()).toString());
        		
        		case 5:
        		
        	}
        	
        	
        }while(var != 0);
        
        
        
	}  

}
