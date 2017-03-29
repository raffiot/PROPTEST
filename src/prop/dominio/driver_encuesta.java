package prop.dominio;

import java.util.Scanner;

public class driver_encuesta {
	private static Scanner texto;
	public static void main (String [ ] args) {
		 
        //Aquí las instrucciones de inicio y control del programa
 
        System.out.println ("Empezamos la ejecución del programa");
        
        Pregunta p = new Tipo_1(1,"Que nota sacaras en SOA?",10,1,10);
        Integer id = 0;
        Encuesta e = new Encuesta(++id);
        texto = new Scanner(System.in);
        Integer id_p = 0;
        while (true){
        System.out.println("Introduzca una pregunta de tipo 1");
        String enunciado = texto.nextLine();
        p = new Tipo_1(++id_p,enunciado,10,1,10);
        e.añadir_pregunta(p);
        
        System.out.println(e.getN_preguntas());
        
        e.imprimir();
        }
        
    }
	

}
