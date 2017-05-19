package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Frame_crear extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	public Frame_crear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tipo 1");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 41, SpringLayout.WEST, contentPane);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTipo = new JRadioButton("Tipo 2");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTipo, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton, -89, SpringLayout.WEST, rdbtnTipo);
		contentPane.add(rdbtnTipo);
		
		JRadioButton rdbtnTipo_1 = new JRadioButton("Tipo 3");
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnTipo, -89, SpringLayout.WEST, rdbtnTipo_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnTipo_1, 384, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTipo_1, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTipo_1, 329, SpringLayout.WEST, contentPane);
		contentPane.add(rdbtnTipo_1);
		
		JRadioButton rdbtnTipo_2 = new JRadioButton("Tipo 4");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTipo_2, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnTipo_2, -265, SpringLayout.EAST, contentPane);
		contentPane.add(rdbtnTipo_2);
		
		JRadioButton rdbtnTipo_3 = new JRadioButton("Tipo 5");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTipo_3, 100, SpringLayout.EAST, rdbtnTipo_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnTipo_3, -110, SpringLayout.EAST, contentPane);
		contentPane.add(rdbtnTipo_3);
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnTipo_3, -49, SpringLayout.NORTH, btnGuardarYSalir);
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTipo_2, 71, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTipo, 20, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 20, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -17, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -166, SpringLayout.SOUTH, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnInsertar = new JButton("Insertar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInsertar, 0, SpringLayout.NORTH, btnGuardarYSalir);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInsertar, 79, SpringLayout.EAST, btnCancelar);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnInsertar, 150, SpringLayout.EAST, btnCancelar);
		contentPane.add(btnInsertar);
		
		
	}
}
