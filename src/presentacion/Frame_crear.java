package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controladores.Controlador_presentacion;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Frame_crear extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Controlador_presentacion cp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_crear frame = new Frame_crear();
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
	public Frame_crear(){
		init();
	}
	
	public Frame_crear(Controlador_presentacion cp){
		this.cp = cp;
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
		
		//crear encuesta nueva
		cp.crearEncuesta();
		//
		JLabel lblIntroduzcaUnGenero = new JLabel("Introduzca un genero : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIntroduzcaUnGenero, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIntroduzcaUnGenero, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIntroduzcaUnGenero, 141, SpringLayout.WEST, contentPane);
		contentPane.add(lblIntroduzcaUnGenero);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblIntroduzcaUnGenero);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblIntroduzcaUnGenero);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -19, SpringLayout.EAST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton tipo1 = new JRadioButton("Tipo 1");
		sl_contentPane.putConstraint(SpringLayout.WEST, tipo1, 41, SpringLayout.WEST, contentPane);
		contentPane.add(tipo1);
		
		JRadioButton tipo2 = new JRadioButton("Tipo 2");
		sl_contentPane.putConstraint(SpringLayout.WEST, tipo2, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST,tipo1, -89, SpringLayout.WEST, tipo2);
		contentPane.add(tipo2);
		
		JRadioButton tipo3 = new JRadioButton("Tipo 3");
		sl_contentPane.putConstraint(SpringLayout.EAST, tipo2, -89, SpringLayout.WEST, tipo3);
		sl_contentPane.putConstraint(SpringLayout.EAST, tipo3, 384, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tipo3, 0, SpringLayout.NORTH, tipo1);
		sl_contentPane.putConstraint(SpringLayout.WEST, tipo3, 329, SpringLayout.WEST, contentPane);
		contentPane.add(tipo3);
		
		JRadioButton tipo4 = new JRadioButton("Tipo 4");
		sl_contentPane.putConstraint(SpringLayout.WEST, tipo4, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tipo4, -265, SpringLayout.EAST, contentPane);
		contentPane.add(tipo4);
		
		JRadioButton tipo5 = new JRadioButton("Tipo 5");
		sl_contentPane.putConstraint(SpringLayout.WEST, tipo5, 100, SpringLayout.EAST, tipo4);
		sl_contentPane.putConstraint(SpringLayout.EAST, tipo5, -110, SpringLayout.EAST, contentPane);
		contentPane.add(tipo5);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(tipo1);
		grupo.add(tipo2);
		grupo.add(tipo3);
		grupo.add(tipo4);
		grupo.add(tipo5);
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("")) JOptionPane.showMessageDialog(null, "Introduzca un género para encuesta ","Error", JOptionPane.ERROR_MESSAGE);
				else {
					cp.guardarEncuesta(textField_1.getText());
					Frame_admin ven = new Frame_admin(cp);
					ven.setVisible(true);
					dispose();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tipo5, -49, SpringLayout.NORTH, btnGuardarYSalir);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGuardarYSalir, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGuardarYSalir, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGuardarYSalir);
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnGuardarYSalir);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, lblIntroduzcaUnGenero);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de pregunta que desea insertar, y pulse insertar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, tipo4, 71, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tipo2, 20, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tipo1, 20, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -17, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -166, SpringLayout.SOUTH, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipo1.isSelected()){
					Frame_tipo1 ven = new Frame_tipo1(cp);
					ven.setVisible(true);
					
				}
				else if(tipo2.isSelected()){
					Frame_Tipo234 ven = new Frame_Tipo234(cp,2);
					ven.setVisible(true);
				}
				else if(tipo3.isSelected()){
					Frame_Tipo234 ven = new Frame_Tipo234(cp,3);
					ven.setVisible(true);
				}
				else if(tipo4.isSelected()){
					Frame_Tipo234 ven = new Frame_Tipo234(cp,4);
					ven.setVisible(true);
				}
				else if(tipo5.isSelected()){
					Frame_tipo5 ven = new Frame_tipo5(cp);
					ven.setVisible(true);
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInsertar, 0, SpringLayout.NORTH, btnGuardarYSalir);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInsertar, 79, SpringLayout.EAST, btnCancelar);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnInsertar, 150, SpringLayout.EAST, btnCancelar);
		contentPane.add(btnInsertar);
		
		
	}
}
