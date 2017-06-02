package presentacion;
import java.awt.*;

import javax.swing.*;

/**
 * La classe SimpleBarPanel se instancia para crear un nuevo grafico, en funcion de 2 arrays de data.
 * Uno conteniendo los nombres de usuarios y el otro con las distancias entre los usuarios y sus clusters
 * 
 * @author Raphael							
 */
public class SimpleBarPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color BAR_COLOR = Color.red;
    private static final Color TEXT_COLOR = Color.black;
    private static final Color LINE_COLOR = Color.blue;

    private int[] inputData;
    private String[] inputName;

    /**
     * Este metodo permite poner tus valores para dibujar el graphico
     * 
     * @param inputData
     * 		las distancias entre los usuarios y sus clusters
     * @param inputName
     * 		los nombres de usuarios
     */
    public void setSimpleBarPanel(final double[] inputData, final String[] inputName) {
    	this.inputData = new int[inputData.length];
    	for(int i = 0; i< inputData.length; i++){
    		this.inputData[i] = (int)(inputData[i]*100);
    	}
    	this.inputName = inputName;
    }
    
    /**
     * Metodo extendido de JPanel que llama a drawBars(g) para dibujar el graphico de baras
     * 
     * @param g
     * 		el objeto Graphics para dibujar los objetos primmitivos (text,lines,rectangles)
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        drawBars(g);
    }
    
    /**
     * Metodo que se debe implementar para poder poner nuestro SimpleBarPanel dentro de un JScrollPane
     * El tamano preferido depende del numero de respuestas assignadas al cluster
     */
    @Override
	public Dimension getPreferredSize(){
		
		if(inputData != null){
    		return new Dimension(130 + 80 * inputData.length +10,250);
    	}
		else{
			return new Dimension(400,250);
		}
    }
    
    /**
     * Metodo que dibuja el graphico de baras desde zero
     * 
     * @param g
     * 		el objeto Graphics para dibujar los objetos primmitivos (text,lines,rectangles)
     */
    private void drawBars(final Graphics g) {
    	//Las contantes de dibujo
        int  OUTER_MARGIN = 50,
                WIDTH = 400 + 2 * OUTER_MARGIN,
                HEIGHT = 300 + 2 * OUTER_MARGIN,
        		BOTTOM_GRAF=230;

        final int barWidth = 20;
        
        //Dibujo del Background
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        

        //Dibujo de los axis
        g.setColor(TEXT_COLOR);
        g.drawLine(OUTER_MARGIN, BOTTOM_GRAF+10, OUTER_MARGIN, BOTTOM_GRAF-200); //y axis
        g.drawLine(OUTER_MARGIN-10, BOTTOM_GRAF,OUTER_MARGIN + 80 * inputData.length +10 , BOTTOM_GRAF); //x axis
        
        //Dibujo de las baras y de los nombres de usuarios
        g.setColor(BAR_COLOR);
        for (int itemIndex = 0; itemIndex < inputData.length; itemIndex++) {
            int x = OUTER_MARGIN+30 + 80 * itemIndex +10;
            int barHeight = 2 * inputData[itemIndex];
            int y = BOTTOM_GRAF - 2 * inputData[itemIndex];
            
            g.fillRect(x, y, barWidth, barHeight);
            
            g.setColor(TEXT_COLOR);
            g.drawString(inputName[itemIndex], OUTER_MARGIN+30 + 80 * itemIndex +10, BOTTOM_GRAF+20);
            g.setColor(BAR_COLOR);
        }
        
        //Dibujo del titulo del graphico
        g.setFont(new Font("test",Font.BOLD,15));
        g.setColor(TEXT_COLOR);
        g.drawString("Distancia entre el centroid y sus respuestas:", 10, 15);
        
        //Dibujo de las indicaciones en el axis y
        g.setFont(new Font("test",Font.PLAIN,15));
        g.drawString("0.0", OUTER_MARGIN-20, BOTTOM_GRAF+13);//FIRST INDICATION
        for(int i =1;i<11;i++){
        	//g.drawString("0."+i, OUTER_MARGIN-20, BOTTOM_GRAF+5-15*i);
    		g.setColor(LINE_COLOR);
    		g.drawLine(OUTER_MARGIN, BOTTOM_GRAF-20 * i, OUTER_MARGIN + 80 * inputData.length +10, BOTTOM_GRAF-20 * i);
    		g.setColor(TEXT_COLOR);
        	if(i == 10){
        		g.drawString("1.0", OUTER_MARGIN-20, BOTTOM_GRAF+5-20 * i);
        	}
        	else{
        		g.drawString("0."+i, OUTER_MARGIN-20, BOTTOM_GRAF+5-20 * i);
        	}
        }
    }
}
