package prop.dominio;



public class Respuesta_2 extends RespuestaPregunta{
	
	
	public Respuesta_2(Pregunta p, int value) {
		super(p,0,value,null,null,null);
	}

	
	@Override
	public double distance(RespuestaPregunta r, double minR1, double maxR1, int sizeR2){
		return Math.abs(this.getValueR2()-r.getValueR2())/((double)sizeR2);
		
	}

}
