package dominio.clases;

import java.util.Scanner;

import dominio.controladores.drivers.*;

public class Main {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main(String[] args) {
		texto = new Scanner(System.in);
		opcion = new Scanner(System.in);
		System.out.println("Escribe USU si eres usuario o ADMIN si eres administrador");

		String text = texto.nextLine();

		if (text.equals("USU")){
			System.out.println ("Escribe la opcion que quieras elegir:");
			System.out.println ("0.Salir");
			System.out.println ("1.Contestar encuesta");

			int var = opcion.nextInt();
			switch (var){
				case 0:
					System.out.println ("Has salido de tu sesion");
					System.exit(0);
					break;				
				case 1:
					dominio.controladores.drivers.driver_contestar.main(null);
					break;			
			}
		}

		else if (text.equals("ADMIN")){

			do{
				System.out.println ("Escribe la opcion que quieras elegir:");
				System.out.println ("0.Salir");
				System.out.println ("1.Gestionar encuesta");
				System.out.println ("2.Analizar encuestas");


				int var = opcion.nextInt();

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
			}while(opcion.nextInt() != 0);
		}
		else{

			System.out.println ("ha fallado");
		}
		System.exit(0);
	}


}
