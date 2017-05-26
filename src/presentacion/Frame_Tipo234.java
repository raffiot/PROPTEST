package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class Frame_Tipo234 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField opciones;
	private boolean first;
	private int n;
	private int tipo;
	private ArrayList<String> opcs;
	private Controlador_presentacion cp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Tipo234 frame = new Frame_Tipo234();
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
	public Frame_Tipo234() {
		init();
	}
	public Frame_Tipo234(Controlador_presentacion cp, int tipo) {
		this.cp = cp;
		this.tipo = tipo;
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
		
		JEditorPane enun = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, enun, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, enun, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, enun, 79, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, enun, -9, SpringLayout.EAST, contentPane);
		contentPane.add(enun);
		
	
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir pregunta");
		btnAadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enun.getText().equals("")) JOptionPane.showMessageDialog(null, "Introduzca un enunciado.","Error", JOptionPane.ERROR_MESSAGE);
				else if(n != 0) JOptionPane.showMessageDialog(null, "Faltan opciones para a�adir. ","Error", JOptionPane.ERROR_MESSAGE);
				else {
					cp.anadirPegunta234(enun.getText(),opcs,tipo);
					dispose();
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirPregunta, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirPregunta, 0, SpringLayout.EAST, enun);
		contentPane.add(btnAadirPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAadirPregunta);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, lblNewLabel);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de opciones :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, enun);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		opciones = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, opciones, 6, SpringLayout.SOUTH, enun);
		sl_contentPane.putConstraint(SpringLayout.WEST, opciones, 20, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, opciones, -209, SpringLayout.EAST, contentPane);
		contentPane.add(opciones);
		opciones.setColumns(10);
		
		JLabel label = new JLabel("Opci\u00F3n 1:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(label);
		
		JEditorPane opcion = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, opcion, 6, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, opcion, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, opcion, -21, SpringLayout.NORTH, btnCancelar);
		contentPane.add(opcion);
		
		
		first = true;
		opcs = new ArrayList<String>();
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first){
					n = Integer.parseInt(opciones.getText());
					first = false;
					opcs.add(opcion.getText());
					--n;
					opciones.setEditable(false);
					opcion.setText("");
					label.setText("Opcion " + 2 +":" );
				}
				
				else if (n > 0){
					
					opcs.add(opcion.getText());
					--n;
					int aux = Integer.parseInt(opciones.getText()) - n +1;
					label.setText("Opci�n " + aux +":" );
					opcion.setText("");
					if (n == 0){
						opcion.setEditable(false);
						label.setText("Todas las opciones han sido introducidas, ya puede a�adir la pregunta");
					}
				}
				
				else JOptionPane.showMessageDialog(null, "Ya ha introducido todas las opciones posibles ","Error", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, opcion, -21, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 109, SpringLayout.SOUTH, enun);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 46, SpringLayout.SOUTH, enun);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -107, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
	}

}
