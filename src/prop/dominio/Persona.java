package prop.dominio;

public class Persona {
	Integer id;
	String nombre;
	String password;
	
	public Persona(){
		id = 0;
		nombre= "";
		password = "";
	}
	
	public Persona(String nombre, String password){
		this.nombre = nombre;
		this.password = password;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getNombre(){
		return nombre;
	} 
	
	public Integer getId(){
		return id;
	}
	
	public String Password(){
		return password;
	}
	
}
