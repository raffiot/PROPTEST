package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;

import dominio.clases.*;
import dominio.controladores.Controlador_dominio;

import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_analisis extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;
	private JSlider sliderk;
	private JSlider sliderthresh;
	private JComboBox<String> comboBoxIdioma;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_analisis frame = new Frame_analisis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_analisis(){
		init();
	}
	
	public Frame_analisis(Controlador_presentacion cp){
		this.cp = cp;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
	
		
		int min = 1;
		int max = cp.getMaxK();
		int middle = (1+max)/2;
		sliderk = new JSlider(min,max,middle);
		sliderk.setBounds(132, 31, 280, 52);
		sliderk.setMajorTickSpacing(1);
		sliderk.setMinorTickSpacing(1);
		sliderk.setPaintTicks(true);
		sliderk.setPaintLabels(true);
		sliderk.setSnapToTicks(true);
		getContentPane().add(sliderk);
		
		JLabel lblK = new JLabel("k:");
		lblK.setBounds(24, 43, 54, 14);
		getContentPane().add(lblK);
		
		sliderthresh = new JSlider(0,10);
		sliderthresh.setBounds(132, 94, 280, 48);
		Hashtable<Integer,JLabel> labelTable = new Hashtable<>();
		labelTable.put( new Integer( 0 ), new JLabel("0.0") );
		labelTable.put( new Integer( 2 ), new JLabel("0.2") );
		labelTable.put( new Integer( 4 ), new JLabel("0.4") );
		labelTable.put( new Integer( 6 ), new JLabel("0.6") );
		labelTable.put( new Integer( 8 ), new JLabel("0.8") );
		labelTable.put( new Integer( 10 ), new JLabel("1.0") );
		sliderthresh.setLabelTable( labelTable );
		sliderthresh.setMinorTickSpacing(1);
		sliderthresh.setPaintTicks(true);
		sliderthresh.setPaintLabels(true);
		sliderthresh.setSnapToTicks(false);
		getContentPane().add(sliderthresh);
		
		JLabel lblThreshold = new JLabel("threshold:");
		lblThreshold.setBounds(24, 106, 75, 14);
		getContentPane().add(lblThreshold);
		
		String[] idiomaStrings = { "Espanol", "Catalan", "English"};
		comboBoxIdioma = new JComboBox<String>(idiomaStrings);
		comboBoxIdioma.setBounds(231, 153, 89, 20);
		comboBoxIdioma.setSelectedIndex(0);
		getContentPane().add(comboBoxIdioma);
		
		JLabel lblIdioma = new JLabel("idioma:");
		lblIdioma.setBounds(24, 156, 54, 14);
		getContentPane().add(lblIdioma);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int k = sliderk.getValue();
				double thresh = sliderthresh.getValue()/10.0;
				int idioma = comboBoxIdioma.getSelectedIndex();
				cp.analizar(k, thresh, idioma);
				Frame_MonstrarResultado ven = new Frame_MonstrarResultado(cp,"from_analizar");
				ven.setVisible(true);
				dispose();
			}
		});
		btnAnalizar.setBounds(335, 227, 89, 23);
		getContentPane().add(btnAnalizar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame_respuestas ven = new Frame_respuestas(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		getContentPane().add(btnAtras);
		
		
		
		
		
	}
}
