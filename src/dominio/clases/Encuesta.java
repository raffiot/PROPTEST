package dominio.clases;
/**
 * Este clase representa una encuesta que se identifica con un identificador id y que tiene un genero y fecha.
 * La encuesta esta formada por preguntas de Tipo_1, Tipo_2, Tipo_3, Tipo_4, Tipo_5.
 *
 * @author Miguel
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;



public class Encuesta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer n_preguntas;
	private String genero;
	private String fecha;
	private ArrayList<Pregunta> preguntas;
	
	/**
	 * Constructor de encuesta con su indentificador
	 * 
	 * @param id
	 * 		el identificador que tendra la encuesta
	 */
	
	public Encuesta(Integer id){
		this.id = id;
		n_preguntas = 0;
		genero = null;
		fecha = null;
		preguntas = new ArrayList<>();
	}
				
	/**
	 * Constructor de encuesta con su indentificador, el numero de preguntas, genero, fecha y su lista de preguntas
	 * 
	 * @param id
	 * 		el identificador que tendra la encuesta
	 * @param n_preguntas
	 * 		el numero de preguntas que tendra la encuesta
	 * @param genero
	 * 		el genero que tendra la encuesta
	 * @param fecha
	 * 		la fecha que representa el dia en que se creo la encuesta 
	 * @param preguntas
	 * 		la lista de preguntas que tendra la encuesta
	 */		
	
	public Encuesta(Integer id, Integer n_preguntas, String genero, String fecha,ArrayList<Pregunta>preguntas ){
		this.id = id;
		this.n_preguntas = n_preguntas;
		this.genero = genero;
		this.fecha = fecha;
		this.preguntas = preguntas;
	}
	
	/**
	 * Metodo para obtener el id de la encuesta
	 * 
	 * @return
	 * 		el id de la encuesta
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo para darle una id a la encuesta
	 * 
	 * @param id
	 * 		el id de la encuesta
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo para obtener el numero de preguntas de la encuesta
	 * 
	 * @return
	 * 		el numero de preguntas de la encuesta
	 */
	public int getN_preguntas() {
		return n_preguntas;
	}
	
	
	/**
	 * Metodo para darle el numero de preguntas a la encuesta
	 * 
	 * @param n_preguntas
	 * 		int con el numero de preguntas que tendra la encuesta
	 */
	public void setN_preguntas(int n_preguntas) {
		this.n_preguntas = n_preguntas;
	}
	
	/**
	 * Metodo para obtener el genero de la encuesta
	 * 
	 * @return
	 * 		el genero de la encuesta
	 */
	public String getGenero() {
		return genero;
	}
	
	
	/**
	 * Metodo para darle genero a la encuesta
	 * 
	 * @param genero
	 * 		una string con el genero que tendra la encuesta
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Metodo para obtener la feacha de la encuesta
	 * 
	 * @return
	 * 		la fecha de la encuesta
	 */
	
	public String getFecha() {
		return fecha;
	}
	
	/**
	 * Metodo para darle una fecha a la encuesta
	 * 
	 * @param 
	 * 		fecha de creacion que tendra la encuesta
	 * 		
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Metodo para obtener la lista de preguntas de la encuesta
	 * 
	 * @return
	 * 		el array de preguntas de la encuesta
	 */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	/**
	 * Metodo para poner las preguntas en la encuesta
	 * 
	 * @param preguntas
	 * 		array con las preguntas que tendra la encuesta
	 */
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
		this.n_preguntas = preguntas.size();
	}
	
	/**
	 * Metodo para anadir una pregunta a la encuesta
	 * 
	 * @param p
	 * 		la nueva pregunta para anadir a la encuesta
	 */
	public void anadir_pregunta(Pregunta p){
		preguntas.add(p);
		if (preguntas.size() > n_preguntas) ++n_preguntas;
	}
	
	/**
	 * Metodo para obtener la pregunta i de la encuesta
	 * 
	 * @param i
	 * 		posicion que ocupa la pregunta que deseamos obtener
	 * @return
	 * 		la pregunta que ocupa la posicion i de la encuesta
	 */
	public Pregunta get_pre(int i){
		return preguntas.get(--i);
	}
	
	
	/**
	 * Metodo para obtener la encuesta en formato String
	 * 
	 * @return
	 * 		la encuesta en formato de String
	 */
	@Override
	public String toString(){
		String s = "";
		s += "id de la encuesta: "+ id +"\r\n";
		s += "Genero encuesta: " +genero +"\r\n";
		s += "Fecha: " + fecha + "\r\n";
		s += "Numero de preguntas: " +n_preguntas +"\r\n";
		for(int i = 0; i < preguntas.size();++i){
			s += preguntas.get(i).toString();
			}
		return s;
	}
	
	/**
	 * Metodo para borrar una encuesta
	 * al borrar la encuesta todas las respuestas de esa encuesta son borradas
	 * 
	 * @param i
	 * 		la id de la encuesta que se desea borrar
	 */
	public void borrar(int i){
		File fichero = new File("Data/Encuestas/Encuesta_"+i+".txt");
		fichero.delete();
		int j = 1;
		int exist = 1;
		do{	
    		String sFichero = "Data/Respuestas/Respuesta_"+i+"_"+j+".txt";
    		File fichero1 = new File(sFichero);
    		if (fichero1.exists()){
    			fichero1.delete();
    			++j;
    		}
    		else exist = 0;
    	}while(exist != 0);
		
	}
	
	/**
	 * Metodo para guardar la encuesta en un fichero txt
	 */
	public void guardar() {
		String s = "";
		s += id +"\r\n";
		s += genero +"\r\n";
		s += fecha + "\r\n";
		s += n_preguntas +"\r\n";
		for(int i = 0; i < preguntas.size();++i){
			s += preguntas.get(i).guardar();
			}
		
		FileWriter fichero = null;
	        try
	        {
	            fichero = new FileWriter("Data/Encuestas/Encuesta_"+this.id+".txt");
	           // pw = new PrintWriter(fichero);
	            fichero.write(s);

	        } catch (Exception e) {
	            e.printStackTrace();
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
	
	/**
	 * Metodo para leer una encuesta de unt txt y cargarlo en un objeto Encuesta
	 * 
	 * @param s
	 * 		el identificador de la encuesta que se quiere leer
	 */
	public void leer(String s) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("Data/Encuestas/Encuesta_"+s+".txt"));
			try {
				this.id = Integer.valueOf(in.readLine());
				this.genero = in.readLine();
				this.fecha = in.readLine();
				this.n_preguntas = Integer.valueOf(in.readLine());
				
				for(int i = 0; i < this.n_preguntas; ++i){
					 String line = null;
					    if((line = in.readLine()) != null){
					        Integer tip = Integer.valueOf(line);
					        String aux = "";
					        aux = in.readLine();
			
					        switch(tip){
					        	case 1: 
							
					        		Integer min = Integer.valueOf(in.readLine());
					        		Integer max = Integer.valueOf(in.readLine());
					        		Tipo_1 p = new Tipo_1(i+1,aux,(max-min+1),max,min);
					        		this.anadir_pregunta(p);
					        		break;
					        		
					        	case 2:
					        		Integer opciones = Integer.valueOf(in.readLine());
					        		ArrayList <String> l = new ArrayList<String>();
					        		for (int j = 0; j < opciones; ++j){
					        			l.add(in.readLine());
					        			
					        		}
					        		Tipo_2 p1 = new Tipo_2(i+1,aux,opciones,l);
					        		this.anadir_pregunta(p1);
					        		break;
					        		
					        		
					        	case 3:
					        		Integer opciones1 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l1 = new ArrayList<String>();
					        		for (int j = 0; j < opciones1; ++j){
					        			l1.add(in.readLine());
					        			
					        		}
					        		Tipo_3 p11 = new Tipo_3(i+1,aux,opciones1,l1);
					        		this.anadir_pregunta(p11);
					        		break;
					        		
					        		
					        	case 4:
					        		Integer opciones11 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l11 = new ArrayList<String>();
					        		for (int j = 0; j < opciones11; ++j){
					        			l11.add(in.readLine());
					        			
					        		}
					        		Tipo_4 p111 = new Tipo_4(i+1,aux,opciones11,l11);
					        		this.anadir_pregunta(p111);
					        		break;
					        		
					        		
					        	case 5: 
					        		Tipo_5 p1111 = new Tipo_5(i+1,aux);
					        		this.anadir_pregunta(p1111);
					        		break;
						
					        }
					 }
				}
				
				in.close();
				
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void importar(String s) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(s));
			try {
				this.id = Integer.valueOf(in.readLine());
				this.genero = in.readLine();
				this.fecha = in.readLine();
				this.n_preguntas = Integer.valueOf(in.readLine());
				
				for(int i = 0; i < this.n_preguntas; ++i){
					 String line = null;
					    if((line = in.readLine()) != null){
					        Integer tip = Integer.valueOf(line);
					        String aux = "";
					        aux = in.readLine();
			
					        switch(tip){
					        	case 1: 
							
					        		Integer min = Integer.valueOf(in.readLine());
					        		Integer max = Integer.valueOf(in.readLine());
					        		Tipo_1 p = new Tipo_1(i+1,aux,(max-min+1),max,min);
					        		this.anadir_pregunta(p);
					        		break;
					        		
					        	case 2:
					        		Integer opciones = Integer.valueOf(in.readLine());
					        		ArrayList <String> l = new ArrayList<String>();
					        		for (int j = 0; j < opciones; ++j){
					        			l.add(in.readLine());
					        			
					        		}
					        		Tipo_2 p1 = new Tipo_2(i+1,aux,opciones,l);
					        		this.anadir_pregunta(p1);
					        		break;
					        		
					        		
					        	case 3:
					        		Integer opciones1 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l1 = new ArrayList<String>();
					        		for (int j = 0; j < opciones1; ++j){
					        			l1.add(in.readLine());
					        			
					        		}
					        		Tipo_3 p11 = new Tipo_3(i+1,aux,opciones1,l1);
					        		this.anadir_pregunta(p11);
					        		break;
					        		
					        		
					        	case 4:
					        		Integer opciones11 = Integer.valueOf(in.readLine());
					        		ArrayList <String> l11 = new ArrayList<String>();
					        		for (int j = 0; j < opciones11; ++j){
					        			l11.add(in.readLine());
					        			
					        		}
					        		Tipo_4 p111 = new Tipo_4(i+1,aux,opciones11,l11);
					        		this.anadir_pregunta(p111);
					        		break;
					        		
					        		
					        	case 5: 
					        		Tipo_5 p1111 = new Tipo_5(i+1,aux);
					        		this.anadir_pregunta(p1111);
					        		break;
						
					        }
					 }
				}
				
				in.close();
				
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
