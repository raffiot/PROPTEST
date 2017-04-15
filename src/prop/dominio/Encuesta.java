package prop.dominio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class Encuesta {
	
	private Integer id;
	private Integer n_preguntas;
	private String genero;
	private String fecha;
	private ArrayList<Pregunta> preguntas;
	
	
	public Encuesta(Integer id){
		this.id = id;
		n_preguntas = 0;
		genero = null;
		fecha = null;
		preguntas = new ArrayList<>();
	}
				
	public Encuesta(Integer id, Integer n_preguntas, String genero, String fecha,ArrayList<Pregunta>preguntas ){
		this.id = id;
		this.n_preguntas = n_preguntas;
		this.genero = genero;
		this.fecha = fecha;
		this.preguntas = preguntas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getN_preguntas() {
		return n_preguntas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
		this.n_preguntas = preguntas.size();
	}
	public void anadir_pregunta(Pregunta p){
		preguntas.add(p);
		if (preguntas.size() > n_preguntas) ++n_preguntas;
	}
	
	public Pregunta get_pre(int i){
		return preguntas.get(--i);
	}
	
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
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("Encuestas/Encuesta_"+this.id+".txt");
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
	
	public void leer(String s) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("Encuestas/Encuesta_"+s+".txt"));
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
			System.out.println("Documento no encontrado");
			e.printStackTrace();
		}
		
	}
	
	

}
