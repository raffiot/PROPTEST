package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import dominio.controladores.Controlador_presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame_tipo5 extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_tipo5 frame = new Frame_tipo5();
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
	public Frame_tipo5() {
		init();
	}
	
	public Frame_tipo5(Controlador_presentacion cp) {
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
		
		JLabel lblNewLabel = new JLabel("Introduzaca un enunciado");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -181, SpringLayout.SOUTH, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 429, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, editorPane, 76, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, editorPane, -72, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, editorPane, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, editorPane, -9, SpringLayout.EAST, contentPane);
		contentPane.add(editorPane);
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir pregunta");
		btnAadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = editorPane.getText();
				if (s.equals(""))JOptionPane.showMessageDialog(null, "Introduzca un enunciado por favor ","Error", JOptionPane.ERROR_MESSAGE);
				else {
					cp.anadirTipo5(s);
					dispose();
				}
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirPregunta, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirPregunta, 0, SpringLayout.EAST, editorPane);
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
	}

}
