package dominio.controladores.drivers;

import java.util.Scanner;

import dominio.clases.Tipo_1;
import dominio.clases.Tipo_2;
import dominio.clases.Tipo_3;
import dominio.clases.Tipo_4;
import dominio.clases.Tipo_5;

public class driver_pregunta {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main (String [ ] args) {
		 
        System.out.println ("Empezamos la ejecucion del driver de Pregunta");
        int id_p = 0;
        do{
        
        	System.out.println ("Introduzca el tipo de pregunta que desea crear");
        	int var = opcion.nextInt();
        	
        	switch (var){
        		
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
				
			break;
			
			case 5:
				Tipo_5 p1111 = new Tipo_5();
				System.out.println("Inserte enunciado");
				p1111.setEnunciado(texto.nextLine());
				p1111.setId(++id_p);
				
			break;
        			
        		
        	}
        			
        	do{
        		System.out.println("Indique que desea hacer ahora :");
        		System.out.println(" 1. Mostrar el enunciado de la pregunta");
        		System.out.println("2. Mostrar tipo de la pregunta");
        		System.out.println("3. Pasar la pregunta a String y imprimirla por pantalla");
        		System.out.println("3. Pasar la pregunta a String y imprimirla por pantalla");
        		System.out.println("4.Mostrar el formato en que se guarda la pregunta");
        		System.out.println("0. Salir");
        		
        		var = opcion.nextInt();
        		switch (var) {
        		
        		case 1:
        			System.out.println();
        		}
        	
        	} while (var != 0);
	
        
        
        }
	}
}
