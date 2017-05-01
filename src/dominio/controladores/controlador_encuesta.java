package dominio.controladores;
/**
* La classe driver_encuesta es un driver que prueba el funcionamiento de la encuesta
* 
* 
* @author Miguel							
*/
import java.io.File;
import java.util.Date;
import java.util.Scanner;
import dominio.clases.*;

public class controlador_encuesta {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main (String [ ] args) {
		 
        
 
     
        
       
        texto = new Scanner(System.in);
        opcion = new Scanner(System.in);
        
        int var;
	int toLeave =1;
        int borrado = 0;
        Integer id_p = 0;
        Encuesta e = new Encuesta(0);
        
       do{
        System.out.println("1. Crear encuesta.");
        System.out.println("2. Importar encuesta.");
        System.out.println("3. Eliminar encuesta.");
        System.out.println("0. Salir");
        var = opcion.nextInt();
        
        
        
        if (var == 1){
        	int exist = 1;
        	Integer id = 1;
        	do{	
        		String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
        		File fichero = new File(sFichero);
        		if (fichero.exists()) ++id;
        		else exist = 0;
        	}while(exist != 0);
        	
        	e = new Encuesta(id);
            Date fecha = new Date();
            e.setFecha(fecha.toString());
            System.out.println("Introduzaca genero de la encuesta");
            e.setGenero(texto.nextLine());
            borrado = 1;
        }
        
        else if (var == 2){
        	System.out.println("Encuestas actuales:");
        	int exist = 1;
        	Integer id = 1;
        	do{	
        		String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
        		File fichero = new File(sFichero);
        		if (fichero.exists()){ 
        			Encuesta en = new Encuesta(id);
        			en.leer(id.toString());
        			System.out.println("Encuesta_"+id+ " Genero = "+en.getGenero());
        			++id;
        		}
        		else exist = 0;
        	}while(exist != 0);
        	System.out.println("Introduce la id de la encuesta que quieres importar");
        	var = opcion.nextInt();
        	e.leer(String.valueOf(var));
        	borrado = 1;
        	
        }
        
        else if(var == 3){
        	System.out.println("Encuestas actuales:");
        	int exist = 1;
        	Integer id = 1;
        	do{	
        		String sFichero = "Data/Encuestas/Encuesta_"+id.toString()+".txt";
        		File fichero = new File(sFichero);
        		if (fichero.exists()){ 
        			Encuesta en = new Encuesta(id);
        			en.leer(id.toString());
        			System.out.println("Encuesta_"+id+ " Genero = "+en.getGenero());
        			++id;
        		}
        		else exist = 0;
        	}while(exist != 0);
        	System.out.println("Introduce el numero de encuesta que desea borrar");
        	int toDelete = opcion.nextInt();
        	e.borrar(toDelete);
        }
        
        else if (var == 0){
		borrado =1;
		toLeave =0;
        }
       }while(borrado == 0);
          
  		if(toLeave ==1){
        	do{
    	    
        	
        		System.out.println("1. Insertar Pregunta.");
        		System.out.println("2. Modificar encuesta");
        		System.out.println("3. Imprimir encuesta");
        		System.out.println("4. Guardar.");
        		System.out.println("0. Salir del driver.");
			
        		var = opcion.nextInt();
        		switch(var){
    			
        			case 1:
        				System.out.println("Que tipo de pregunta desea insertar?");
        				System.out.println("1. Variables cuantitatives o numericas,");
        				System.out.println("2. Variables cualitativas ordenadas,");
        				System.out.println("3. Variables cualitativas no ordenadas,");
        				System.out.println("4. Variables cualitativas no ordenadas donde la respuesta es un conjunto,");
        				System.out.println("5. Tipo libre,");
        				System.out.println("0. Salir");
    			
        				int aux = 0;
        				aux = opcion.nextInt();
        				switch(aux) {
        				
        				case 1:
        					Tipo_1 p = new Tipo_1();
        					System.out.println("Inserte enunciado");
        					p.setEnunciado(texto.nextLine());
        					System.out.println("Inserte la opcion numerica minima");
        					p.setMin(opcion.nextInt());
        					System.out.println("Inserte la opcion numerica maxima");
        					p.setMax(opcion.nextInt());
        					p.setOpciones(p.getMax()-p.getMin());
        					p.setId(++id_p); 
        					e.anadir_pregunta(p);
        					System.out.println("Pregunta insertada");
    					break;
    					
        				case 2:
        					Tipo_2 p1 = new Tipo_2();
        					System.out.println("Inserte enunciado");
        					p1.setEnunciado(texto.nextLine());
        					System.out.println("Inserte el numero de opciones");
        					p1.setOpciones(opcion.nextInt());
        					for (int i = 0; i < p1.getOpciones(); ++i) {
        						System.out.println("Inserte opcion");
        						p1.anadir_opcion(texto.nextLine());
        					}
        					p1.setId(++id_p);
        					e.anadir_pregunta(p1);
        					System.out.println("Pregunta insertada");
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
        						p11.anadir_opcion(s);
        					}
        					p11.setId(++id_p);
        					e.anadir_pregunta(p11);
        					System.out.println("Pregunta insertada");
    					break;
    					
        				case 4:
        					Tipo_4 p111 = new Tipo_4();
        					System.out.println("Inserte enunciado");
        					p111.setEnunciado(texto.nextLine());
        					System.out.println("Inserte el numero de opciones");
        					p111.setOpciones(opcion.nextInt());
        					for (int i = 0; i < p111.getOpciones(); ++i) {
        						System.out.println("Inserte opcion");
        						p111.anadir_opcion(texto.nextLine());
        					}
        					p111.setId(++id_p);
        					e.anadir_pregunta(p111);
        					System.out.println("Pregunta insertada");
    					break;
    					
        				case 5:
        					Tipo_5 p1111 = new Tipo_5();
        					System.out.println("Inserte enunciado");
        					p1111.setEnunciado(texto.nextLine());
        					p1111.setId(++id_p);
        					e.anadir_pregunta(p1111);
        					System.out.println("Pregunta insertada");
    					break;
    					
        				case 0:
        					break;
    					
        				}
    			break;
    		
        		case 4:
    			e.guardar();
        		break;
    		
    		
        		case 3: 
        			System.out.println(e.toString());
    			break;
    			
    		
        		case 2:
        			System.out.println("Seleccione la pregunta a modificar");
        			int aux2 = 0;
        			aux2 = opcion.nextInt();
        			int tipo = e.get_pre(aux2).getTipo();
    			
        			System.out.println("pulse 1 si desea modificar el enunciado");
        			System.out.println("pulse 2 si desea modificar las opciones");
        			System.out.println("pulse 0 si desea salir");
    			
        			int aux3 = 0;
        			aux3 = opcion.nextInt();
    			
        			if (aux3 == 1) {
        				System.out.println("Introduzca nuevo enunciado");
        				String s = null;
        				s = texto.nextLine();
        				e.get_pre(aux2).setEnunciado(s);
        				System.out.println("Enunciado modificado");
    				}
    			
        			if (aux3 == 2){
        				switch(tipo){
    						case 1: 
    							Tipo_1 p = new Tipo_1();
    							p = (Tipo_1) e.get_pre(aux2);
    							System.out.println("Inserte la opcion numerica minima");
    							p.setMin(opcion.nextInt());
    							System.out.println("Inserte la opcion numerica maxima");
    							p.setMax(opcion.nextInt());
    							p.setOpciones(p.getMax()-p.getMin());
        					break;
        					
    						case 2:
    							Tipo_2 p1 = new Tipo_2();
    							p1 = (Tipo_2) e.get_pre(aux2);
    							System.out.println("Inserte el numero de opciones");
    							p1.setOpciones(opcion.nextInt());
    							for (int i = 0; i < p1.getOpciones(); ++i) {
    								System.out.println("Inserte opcion");
    								p1.anadir_opcion(texto.nextLine());
    							}	
        					break;
        				
    						case 3: 	
    							Tipo_3 p11 = new Tipo_3();
    							p11 = (Tipo_3) e.get_pre(aux2);
    							System.out.println("Inserte el numero de opciones");
    							p11.setOpciones(opcion.nextInt());
    							for (int i = 0; i < p11.getOpciones(); ++i) {
    								System.out.println("Inserte opcion");
    								String s = null; 
    								s = texto.nextLine();
    								p11.anadir_opcion(s);
    							}
        					break;
        					
    						case 4:
    							Tipo_4 p111 = new Tipo_4();
    							p111 = (Tipo_4) e.get_pre(aux2);
    							System.out.println("Inserte el numero de opciones");
    							p111.setOpciones(opcion.nextInt());
    							for (int i = 0; i < p111.getOpciones(); ++i) {
    								System.out.println("Inserte opcion");
    								p111.anadir_opcion(texto.nextLine());
    							}
        					break;
        					
    						case 5:
    							System.out.println("Este tipo de pregunta es de respuesta libre, no tiene opciones");
        					break;
    					
    				}
    				
    			}
        			else if (aux3 == 3) break;
    		
        		}
        
        	}while (var != 0);
		}

	}
}
