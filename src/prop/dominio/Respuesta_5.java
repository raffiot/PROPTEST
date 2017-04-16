package prop.dominio;

public class Respuesta_5 extends RespuestaPregunta{
	
	
	public Respuesta_5(Pregunta p, String value) {
		super(p,0,0,null,null,value);
	}

	@Override
	public double distance(RespuestaPregunta r, double minR1, double maxR1,	int sizeR2) {
		String lhs = this.getValueR5();
		String rhs = r.getValueR5();
		int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];        
        
        for (int i = 0; i <= lhs.length(); i++)                                 
            distance[i][0] = i;                                                  
        for (int j = 1; j <= rhs.length(); j++)                                 
            distance[0][j] = j;                                                  
                                                                                 
        for (int i = 1; i <= lhs.length(); i++)                                 
            for (int j = 1; j <= rhs.length(); j++)                             
                distance[i][j] = minimum(                                        
                        distance[i - 1][j] + 1,                                  
                        distance[i][j - 1] + 1,                                  
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));
                                                                                 
        return distance[lhs.length()][rhs.length()]; 
	}
	
	private static int minimum(int a, int b, int c) {                            
        return Math.min(Math.min(a, b), c);                                      
    }


}
