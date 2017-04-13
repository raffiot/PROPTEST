package prop.dominio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;



public class Encuesta {
	
	private Integer id;
	private Integer n_preguntas;
	private String genero;
	private Date fecha;
	private ArrayList<Pregunta> preguntas;
	
	
	public Encuesta(Integer id){
		this.id = id;
		n_preguntas = 0;
		genero = null;
		fecha = null;
		preguntas = new ArrayList<>();
	}
				
	public Encuesta(Integer id, Integer n_preguntas, String genero, Date fecha,ArrayList<Pregunta>preguntas ){
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
		++n_preguntas;
	}
	
	public Pregunta get_pre(int i){
		return preguntas.get(--i);
	}
	
	@Override
	public String toString(){
		String s = "";
		s += "id de la encuesta: "+ id +"\n";
		s += "Genero encuesta: " +genero +"\n";
		s += "Fecha: " + fecha + "\n";
		s += "Numero de preguntas: " +n_preguntas +"\n";
		for(int i = 0; i < preguntas.size();++i){
			s += preguntas.get(i).toString();
			}
		return s;
	}
	
	public void guardar() {
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("C:/Users/1192790/git/PROPTEST/Enquestas/prueba.txt");
	            pw = new PrintWriter(fichero);
	            pw.println(this.toString());

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
	
	

}
