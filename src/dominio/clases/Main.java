package dominio.clases;

import java.util.Scanner;

import dominio.controladores.drivers.*;


public class Main {
	private static Scanner texto;
	private static Scanner opcion;
	static String user;
	public static void main(String[] args) {
		texto = new Scanner(System.in);
		opcion = new Scanner(System.in);
		System.out.println("Escribe USU si eres usuario o ADMIN si eres administrador");
		
		String text = texto.nextLine();
		int var;
		if (text.equals("USU")){
			System.out.println ("Por favor, introduc tu nombre de usuario:");
			user = texto.nextLine();
			System.out.println("");
			System.out.println ("Escribe la opcion que quieras elegir:");
			System.out.println ("0.Salir");
			System.out.println ("1.Contestar encuesta");
			do{	
			

				var = opcion.nextInt();
				switch (var){
					case 0:
						System.out.println ("Has salido de tu sesion");
						System.exit(0);
						break;				
					case 1:
						dominio.controladores.drivers.driver_contestar.main(null);
						break;			
				}
				System.out.println ("Vuelta al menu principal!");
				System.out.println ("Escribe la opcion que quieras elegir:");
				System.out.println ("0.Salir");
				System.out.println ("1.Contestar encuesta");
			
			}while(var != 0);
		}

		else if (text.equals("ADMIN")){
			System.out.println ("Escribe la opcion que quieras elegir:");
			System.out.println ("0.Salir");
			System.out.println ("1.Gestionar encuesta");
			System.out.println ("2.Analizar encuestas");

			do{
				

				var = opcion.nextInt();

				switch(var){
					case 0:
						System.out.println ("Has salido de tu sesion");
						System.exit(0);
						break;
					
					case 1:
						dominio.controladores.drivers.driver_encuesta.main(null);
						break;
					
					case 2:
						dominio.controladores.drivers.driver_analizar.main(null);
						break;
						
						
						
				}
				System.out.println ("Vuelta al menu principal!");
				System.out.println ("Escribe la opcion que quieras elegir:");
				System.out.println ("0.Salir");
				System.out.println ("1.Gestionar encuesta");
				System.out.println ("2.Analizar encuestas");
			}while(var != 0);
		}
		else{

			System.out.println ("ha fallado");
		}
		System.exit(0);
	}


}
