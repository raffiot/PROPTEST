package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_tipo1 extends JFrame {

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
	public Frame_tipo1() {
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
		
		JEditorPane editorPane = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, editorPane, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, editorPane, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, editorPane, 94, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, editorPane, -9, SpringLayout.EAST, contentPane);
		contentPane.add(editorPane);
		
		JLabel lblOpcinMnima = new JLabel("Opci\u00F3n m\u00EDnima :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOpcinMnima, 26, SpringLayout.SOUTH, editorPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOpcinMnima, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOpcinMnima, 99, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblOpcinMnima);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblOpcinMnima);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 128, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOpcinMxima = new JLabel("Opci\u00F3n m\u00E1xima :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOpcinMxima, 0, SpringLayout.NORTH, lblOpcinMnima);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOpcinMxima, 98, SpringLayout.EAST, lblOpcinMnima);
		contentPane.add(lblOpcinMxima);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblOpcinMxima);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 197, SpringLayout.EAST, textField);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir pregunta");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirPregunta, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirPregunta, -25, SpringLayout.EAST, contentPane);
		contentPane.add(btnAadirPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAadirPregunta);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(btnCancelar);
	}
}
