package prop.dominio;

import java.util.Scanner;

public class Main {
	private static Scanner texto;
	private static Scanner opcion;
	public static void main(String[] args) {
		System.out.println("Escribe USU si eres usuario o ADMIN si eres administrador");

		String text = texto.nextLine();

		if (text == "USU"){
			System.out.println ("Escribe la opcion que quieras elegir:");
			System.out.println ("0.Salir");
			System.out.println ("1.Contestar encuesta");

			while(opcion.nextInt() != 0){
				int var = opcion.nextInt();
				switch (var){
					case 0:{
						System.out.println ("Has salido de tu sesion");
						System.exit(0);
						break;
						}
					case 1:{
						driver_contestar.main(null);
						break;
					}
					

				}
				System.exit(0);
			}
		}

		else if (text == "ADMIN"){

			while(opcion.nextInt() != 0){
				System.out.println ("Escribe la opcion que quieras elegir:");
				System.out.println ("0.Salir");
				System.out.println ("1.Gestionar encuesta");
				System.out.println ("2.Analizar encuestas");


				int var = opcion.nextInt();

				switch(var){
					case 0:{
						System.out.println ("Has salido de tu sesion");
						System.exit(0);
						break;
					}
					case 1:{
						driver_encuesta.main(null);
						break;
					}
					case 2:{
						driver_analizar.main(null);
						break;
					}

				}
				System.exit(0);
			}
		}
		else{

			System.out.println ("Escribe USU si eres usuario o ADMIN si eres administrador");
		}
		System.exit(0);
	}


}
