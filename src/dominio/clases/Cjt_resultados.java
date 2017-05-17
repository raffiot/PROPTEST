package dominio.clases;

import java.io.Serializable;
import java.util.ArrayList;

import persistencia.*;

public class Cjt_resultados implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Resultado> resultados;
	final String pathResultado = "Data/Resultados/resultados.dat";

	
	public void leerResu(){	
		
		Persistencia_Resultado p = new Persistencia_Resultado();
		resultados = p.leer(pathResultado);	
	}
	
	
	public void guardarResu(){
		
		Persistencia_Resultado p = new Persistencia_Resultado();
		p.escribir(pathResultado,resultados);
		
	}
}
