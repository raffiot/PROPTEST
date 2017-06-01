package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 539, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		//crear encuesta nueva
		cp.crearEncuesta();
		contentPane.setLayout(null);
		//
		JLabel lblIntroduzcaUnGenero = new JLabel("Introduzca un genero : ");
		lblIntroduzcaUnGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntroduzcaUnGenero.setBounds(13, 19, 148, 18);
		contentPane.add(lblIntroduzcaUnGenero);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 17, 342, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton tipo1 = new JRadioButton("Variables cuantitatives o numericas");
		tipo1.setBounds(20, 122, 342, 23);
		contentPane.add(tipo1);
		
		JRadioButton tipo2 = new JRadioButton("Variables cualitativas ordenadas");
		tipo2.setBounds(20, 146, 342, 23);
		contentPane.add(tipo2);
		
		JRadioButton tipo3 = new JRadioButton("Variables cualitativas no ordenadas");
		tipo3.setBounds(20, 170, 367, 23);
		contentPane.add(tipo3);
		
		JRadioButton tipo4 = new JRadioButton("Variables cualitativas no ordenadas donde la respuesta es un conjunto");
		tipo4.setBounds(20, 194, 482, 23);
		contentPane.add(tipo4);
		
		JRadioButton tipo5 = new JRadioButton("Tipo libre");
		tipo5.setBounds(20, 216, 114, 23);
		contentPane.add(tipo5);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(tipo1);
		grupo.add(tipo2);
		grupo.add(tipo3);
		grupo.add(tipo4);
		grupo.add(tipo5);
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.setBounds(354, 345, 148, 23);
		btnGuardarYSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("")) JOptionPane.showMessageDialog(null, "Introduzca un g�nero para encuesta ","Error", JOptionPane.ERROR_MESSAGE);
				else {
					cp.guardarEncuesta(textField_1.getText());
					Frame_admin ven = new Frame_admin(cp);
					ven.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnGuardarYSalir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 345, 103, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_admin ven = new Frame_admin(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de pregunta que desea insertar, y pulse insertar");
		lblNewLabel.setBounds(13, 80, 397, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(170, 262, 175, 28);
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
		contentPane.add(btnInsertar);
		
		
	}
}
