package presentacion;
import java.awt.*;
import javax.swing.*;

public class SimpleBarPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color BAR_COLOR = Color.red;
    private static final Color TEXT_COLOR = Color.black;
    private static final Color LINE_COLOR = Color.blue;

    private int[] inputData;
    private String[] inputName;

    public void setSimpleBarPanel(final double[] inputData, final String[] inputName) {
    	this.inputData = new int[inputData.length];
    	for(int i = 0; i< inputData.length; i++){
    		this.inputData[i] = (int)(inputData[i]*100);
    	}
    	this.inputName = inputName;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        drawBars(g);
    }
    
    @Override
	public Dimension getPreferredSize(){
		return new Dimension(437,290);
    	
    }

    private void drawBars(final Graphics g) {
        int /*i,*/ OUTER_MARGIN = 50,
                WIDTH = 400 + 2 * OUTER_MARGIN,
                HEIGHT = 300 + 2 * OUTER_MARGIN,
        		BOTTOM_GRAF=230;
                /*SPACE_BETWEEN_BARS = 10, SPACE_ON_TOP_BOTTOM = 25;*/

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(BAR_COLOR);
        final int barWidth = 20;
        
        
        //g.drawLine(x1, y1, x2, y2);
        g.setColor(TEXT_COLOR);
        g.drawLine(OUTER_MARGIN, BOTTOM_GRAF+10, OUTER_MARGIN, BOTTOM_GRAF-200); //y axis
        g.drawLine(OUTER_MARGIN-10, BOTTOM_GRAF,OUTER_MARGIN + 80 * inputData.length +10 , BOTTOM_GRAF); //x axis
        g.setColor(BAR_COLOR);
        for (int itemIndex = 0; itemIndex < inputData.length; itemIndex++) {
            final int x = OUTER_MARGIN+30 + 80 * itemIndex +10;
            final int barHeight = -2 * inputData[itemIndex];
            final int y = BOTTOM_GRAF;
            //final int y = [...y is calculated using barHeight; the higher the bar, the lower y should be...];
            g.fillRect(x, y, barWidth, barHeight);
            
            g.setColor(TEXT_COLOR);
            g.drawString(inputName[itemIndex], OUTER_MARGIN+30 + 80 * itemIndex +10, BOTTOM_GRAF+20);
            g.setColor(BAR_COLOR);
        }
        
        g.setFont(new Font("test",Font.BOLD,15));
        g.setColor(TEXT_COLOR);
        g.drawString("Distancia entre el centroid y sus respuestas", 10, 10);
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