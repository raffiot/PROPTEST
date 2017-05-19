package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class Frame_Tipo234 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		sl_contentPane.putConstraint(SpringLayout.SOUTH, editorPane, 79, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, editorPane, -9, SpringLayout.EAST, contentPane);
		contentPane.add(editorPane);
		
	
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir pregunta");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirPregunta, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirPregunta, 0, SpringLayout.EAST, editorPane);
		contentPane.add(btnAadirPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAadirPregunta);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, lblNewLabel);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de opciones :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, editorPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, editorPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 20, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, -209, SpringLayout.EAST, contentPane);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Opci\u00F3n 1:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		JEditorPane editorPane_1 = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, editorPane_1, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, editorPane_1, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, editorPane_1, -21, SpringLayout.NORTH, btnCancelar);
		contentPane.add(editorPane_1);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		sl_contentPane.putConstraint(SpringLayout.EAST, editorPane_1, -21, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 109, SpringLayout.SOUTH, editorPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 46, SpringLayout.SOUTH, editorPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -107, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
	}

}
