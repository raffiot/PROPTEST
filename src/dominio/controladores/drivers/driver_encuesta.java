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


public class driver_encuesta {
	
	private static Scanner texto;
	private static Scanner opcion;
	public static void main (String [ ] args) {
		 
	      texto = new Scanner(System.in);
	        opcion = new Scanner(System.in);
 
        System.out.println ("Empezamos la ejecucion del driver de encuesta");
        
       
        System.out.println("Las encuestas disponibles son las siguientes: ");
		
    	for (int id1 = 1; id1 < 100; ++id1){
    		String sFichero = "Data/Drivers/Encuestas/Encuesta_"+id1+".txt";
    		File fichero = new File(sFichero);
    		if (fichero.exists()){ 
    			Encuesta en = new Encuesta(id1);
    			leer(id1,en);
    			System.out.println("Encuesta_"+id1+ " Genero = "+en.getGenero());
    			
    		}
    		
    	}
    	System.out.println("Introduce la id de la encuesta que quieres importar");
    	int var2 = opcion.nextInt();
    	Encuesta e = new Encuesta(1);
    	leer(var2,e);
        
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
        	System.out.println ("Pulse 8 si desea mostrar en terminal la encuesta en formato String");
        	System.out.println ("Pulse 0 si desea salir");
        	
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
    				System.out.println("0. Salir");
    				int aux = opcion.nextInt();
    				
    				
    				System.out.println("Introduzca enunciado");
    				String s = texto.nextLine();
    				
    				switch (aux){
    					case 0: break;
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
    						break;
    					
    				}
    			break;
    			
        		case 4: 
        			System.out.println("Introduzca el numero de pregunta que desea ver");
        			System.out.println(e.get_pre(opcion.nextInt()));
        			System.out.println();
        			break;
        		
        		case 5:
        			guardar(e);
        			System.out.println("Las encuesta ha sido guardada \n");
        			break;
        		case 6:
        			System.out.println("Las encuestas disponibles son las siguientes: ");
        			
                	for (int id1 = 1; id1 < 100; ++id1){
                		String sFichero = "Data/Drivers/Encuestas/Encuesta_"+id1+".txt";
                		File fichero = new File(sFichero);
                		if (fichero.exists()){ 
                			Encuesta en = new Encuesta(id1);
                			leer(id1,en);
                			System.out.println("Encuesta_"+id1+ " Genero = "+en.getGenero());
                			
                		}
                		
                	}
                	System.out.println("Introduce la id de la encuesta que quieres importar");
                	var = opcion.nextInt();
                	leer(var,e);
                	break;
                	
        		case 7:
        			borrar(e);
        			System.out.println("La encuesta ha sido borrada.");
        			System.out.println("Pulse 1 si desea cargar otra encuesta");
        			System.out.println("Pulse 0 si desea salir del driver");
        			var = opcion.nextInt();
        			if (var == 1){
        				System.out.println("Las encuestas disponibles son las siguientes: ");
            			
                    	
                    	for (int id1 = 1; id1 < 100; ++id1){
                    		String sFichero = "Data/Drivers/Encuestas/Encuesta_"+id1+".txt";
                    		File fichero = new File(sFichero);
                    		if (fichero.exists()){ 
                    			Encuesta en = new Encuesta(id1);
                    			leer(id1,en);
                    			System.out.println("Encuesta_"+id1+ " Genero = "+en.getGenero());
                    			
                    		}
                    		
                    	}
                    	System.out.println("Introduce la id de la encuesta que quieres importar");
                    	var = opcion.nextInt();
                    	leer(var,e);
        			}
        			
        			else if(var == 0){
        				System.exit(0);
        			}
        			break;
        			
        		case 0: System.exit(0);
        		
        		case 8: 
        			System.out.println(e.toString());
                	break;
        	}
        	
        	
        }while(var != 0);
        
        
        
	}
	
	public static void leer(int i, Encuesta e) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("Data/Drivers/Encuestas/Encuesta_"+i+".txt"));
			try {
				e.setId(Integer.valueOf(in.readLine()));
				e.setGenero(in.readLine());
				e.setFecha(in.readLine());
				e.setN_preguntas(Integer.valueOf(in.readLine()));
				
				for(int i1 = 0; i1 <e.getN_preguntas(); ++i1){
					 String line = null;
					    if((line = in.readLine()) != null){
					        Integer tip = Integer.valueOf(line);
					        String aux = "";
					        aux = in.readLine();
			
					        switch(tip){
					        	case 1: 
							
					        		Integer min = Integer.valueOf(in.readLine());
					        		Integer max = Integer.valueOf(in.readLine());
					        		Tipo_1 p = new Tipo_1(i1+1,aux,(max-min+1),max,min);
					        		e.anadir_pregunta(p);
					        		break;
					        		
					        	case 2:
					        		Integer opciones = Integer.valueOf(in.readLine());
					        		ArrayList <String> l = new ArrayList<String>();
					        		for (int j = 0; j < opciones; ++j){
					        			l.add(in.readLine());
					        			
					        		}
					        		Tipo_2 p1 = new Tipo_2(i1+1,aux,opciones,l);
					        		e.anadir_pregunta(p1);
					        		break;
					        		
					        		
					        	case 3:
					        		Integer opciones1 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l1 = new ArrayList<String>();
					        		for (int j = 0; j < opciones1; ++j){
					        			l1.add(in.readLine());
					        			
					        		}
					        		Tipo_3 p11 = new Tipo_3(i1+1,aux,opciones1,l1);
					        		e.anadir_pregunta(p11);
					        		break;
					        		
					        		
					        	case 4:
					        		Integer opciones11 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l11 = new ArrayList<String>();
					        		for (int j = 0; j < opciones11; ++j){
					        			l11.add(in.readLine());
					        			
					        		}
					        		Tipo_4 p111 = new Tipo_4(i1+1,aux,opciones11,l11);
					        		e.anadir_pregunta(p111);
					        		break;
					        		
					        		
					        	case 5: 
					        		Tipo_5 p1111 = new Tipo_5(i1+1,aux);
					        		e.anadir_pregunta(p1111);
					        		break;
						
					        }
					 }
				}
				
				in.close();
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void guardar(Encuesta e) {
		String s = "";
		s += e.getId() +"\r\n";
		s += e.getGenero() +"\r\n";
		s += e.getFecha()+ "\r\n";
		s += e.getN_preguntas() +"\r\n";
		for(int i = 0; i < e.getN_preguntas();++i){
			s += e.getPreguntas().get(i).guardar();
			}
		
		FileWriter fichero = null;
	        try
	        {
	            fichero = new FileWriter("Data/Drivers/Encuestas/Encuesta_"+e.getId()+".txt");
	           // pw = new PrintWriter(fichero);
	            fichero.write(s);

	        } catch (Exception e1) {
	            e1.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	public static void borrar(Encuesta e){
		File fichero = new File("Data/Drivers/Encuestas/Encuesta_"+e.getId()+".txt");
		fichero.delete();
		
	}

}
