package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controladores.Controlador_presentacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_tipo1 extends JFrame {

	private JPanel contentPane;
	private JTextField minima;
	private JTextField maxima;
	private Controlador_presentacion cp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_tipo1 frame = new Frame_tipo1();
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
	public Frame_tipo1(Controlador_presentacion cp){
		this.cp = cp;
		init();
		
	}
	public Frame_tipo1(){
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Introduzaca un enunciado");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 429, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JEditorPane enunciado = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, enunciado, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, enunciado, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, enunciado, 94, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, enunciado, -9, SpringLayout.EAST, contentPane);
		contentPane.add(enunciado);
		
		JLabel lblOpcinMnima = new JLabel("Opci\u00F3n m\u00EDnima :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOpcinMnima, 26, SpringLayout.SOUTH, enunciado);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOpcinMnima, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOpcinMnima, 99, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblOpcinMnima);
		
		minima = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, minima, 6, SpringLayout.SOUTH, lblOpcinMnima);
		sl_contentPane.putConstraint(SpringLayout.WEST, minima, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, minima, 128, SpringLayout.WEST, contentPane);
		contentPane.add(minima);
		minima.setColumns(10);
		
		JLabel lblOpcinMxima = new JLabel("Opci\u00F3n m\u00E1xima :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOpcinMxima, 0, SpringLayout.NORTH, lblOpcinMnima);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOpcinMxima, 98, SpringLayout.EAST, lblOpcinMnima);
		contentPane.add(lblOpcinMxima);
		
		maxima = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, maxima, 0, SpringLayout.NORTH, minima);
		sl_contentPane.putConstraint(SpringLayout.WEST, maxima, 0, SpringLayout.WEST, lblOpcinMxima);
		sl_contentPane.putConstraint(SpringLayout.EAST, maxima, 197, SpringLayout.EAST, minima);
		maxima.setColumns(10);
		contentPane.add(maxima);
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir pregunta");
		btnAadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((enunciado.getText().equals("")) || (minima.getText().equals("")) || (maxima.getText().equals(""))){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos","Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					String enun = enunciado.getText();
					String min = minima.getText();
					String max = maxima.getText();
					
					cp.anadirPegunta1(enun,Integer.parseInt(min),Integer.parseInt(max));
					
					dispose();
					
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirPregunta, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirPregunta, -25, SpringLayout.EAST, contentPane);
		contentPane.add(btnAadirPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAadirPregunta);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(btnCancelar);
	}
}
