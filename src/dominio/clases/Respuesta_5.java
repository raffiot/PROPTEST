package dominio.clases;
/**
 * Classe que representa una respuesta a una pregunta de tipo 5
 * 
 * @author Raphael
 *
 */
public class Respuesta_5 extends RespuestaPregunta{
	
	/**
	 * Constructor de la classe con la pregunta a la cual se responde y la sentencia que se ha respondido
	 * 
	 * @param p
	 * 		La pregunta que se responde
	 * @param value
	 * 		La sentencia que se ha respondido
	 */
	public Respuesta_5(Pregunta p, String value) {
		super(p,0,0,null,null,value.toLowerCase());
	}
	
	/**
	 * Metodo que permite calcular la distancia entre dos respuesta a la misma pregunta de tipo 5
	 * El calculo de distancia funciona con el algoritmo de Levenshtein 
	 * 
	 * @param r
	 * 		la respuesta a la pregunta con la cual queremos calcular la distancia
	 * @param minR1
	 * 		este parametro no sirve en este caso
	 * @param maxR1
	 * 		este parametro no sirve en este caso
	 * @param sizeR2
	 * 		este parametro no sirve en este caso
	 */
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
                                                                                 
        return ((double)distance[lhs.length()][rhs.length()])/Math.max(this.getValueR5().length(),r.getValueR5().length()); 
	}
	
	private static int minimum(int a, int b, int c) {                            
        return Math.min(Math.min(a, b), c);                                      
    }
	
	public String toString() {
		String s = "";
		s += this.getValueR5()+"\n";
		return s;
	}

}
