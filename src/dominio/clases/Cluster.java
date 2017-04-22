package dominio.clases;

/**
 * Este classe representa un representante de usuarios con sus usuarios ajuntado a el.
 * Es el resultado del algorithmo de k-means
 *
 * @author Raphael
 */

import java.util.ArrayList;
import java.util.List;

public class Cluster{

	private int index;
	private RespuestaEncuesta centroid;
	private List<RespuestaEncuesta> usuarios;
	
	/**
	 * Constructor de cluster con su index y su respuesta encuesta representante
	 * 
	 * @param i
	 * 		el index para distinguir de los otros clusters
	 * @param c
	 * 		la respuesta encuesta que respresenta el cluster
	 */
	public Cluster(int i, RespuestaEncuesta c){
		index = i;
		centroid = c;
		usuarios = new ArrayList<RespuestaEncuesta>();
	}

	/**
	 * Methodo para obtener el index del cluster
	 * 
	 * @return
	 * 		el index del cluster
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Methodo para modificar el index del cluster
	 * 
	 * @param index
	 * 		el nuevo index del cluster
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Methodo para obtener la respuesta encuesta representante del cluster
	 * 
	 * @return
	 * 		la respuesta encuesta representante del cluster
	 */
	public RespuestaEncuesta getCentroid() {
		return centroid;
	}
	
	/**
	 * Methodo para modificar la respuesta encuesta representante del cluster
	 * 
	 * @param centroid
	 * 		la nueva respuesta encuesta representante del cluster
	 */
	public void setCentroid(RespuestaEncuesta centroid) {
		this.centroid = centroid;
	}
	
	/**
	 * Methodo para obtener las respuestas encuestas ajuntado al cluster
	 * 
	 * @return
	 * 		las respuestas encuestas ajuntado al cluster
	 */
	public List<RespuestaEncuesta> getUsuarios() {
		return usuarios;
	}
	
	/**
	 * Methodo para modificar las respuestas encuestas ajuntado al cluster
	 * 
	 * @param usuarios
	 * 		las nuevas respuestas encuestas ajuntado al cluster
	 */
	public void setUsuarios(List<RespuestaEncuesta> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Metodo que crea una string que describe el cluster
	 * 
	 * @return la string que describe cluster
	 */
	public String toString(Analisis an){
		String s ="";
		s +="Cluster con index: "+index+"\n";
		s +="Centroid :\n";
		s += centroid.toString();
		if(usuarios.size() ==0){
			s+="Sin RespuestaEncuesta assignada \n";
		}
		else{
			s +="\nCon RespuestaEncuesta assignado: \n";
			

			for(RespuestaEncuesta re : usuarios){
				s+="\n";
				s+="Usuario "+(an.getRespEncuestas().getListRP().indexOf(re)+1)+":\n";
				s+="Distancia con el centroid: "+an.distanceRespEncuesta(centroid,re,an.getEncuesta(),an.getMapMinMax());
				s+="\n";
				s+=re.toString();
				s+="Distancia con los otros centroids:\n";
				for(Cluster c : an.getCentroids()){
					if(this.index != c.getIndex()){
						s+="Centroid "+c.getIndex()+" : "+an.distanceRespEncuesta(c.getCentroid(), re, an.getEncuesta(), an.getMapMinMax());
						s+="\n";
					}
				}
			}
		}

		return s;
	}
	
}
