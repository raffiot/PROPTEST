package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;

import dominio.controladores.Controlador_dominio;

public class principal {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private Controlador_dominio cd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cd = new Controlador_dominio();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEntrar = new JButton("Registrarse");
		btnEntrar.setBounds(244, 196, 102, 23);
		frame.getContentPane().add(btnEntrar);
		
		JButton button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean b = false;
				try {
					b = cd.entrar(userField.getText(),passwordField.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(b){
					
				}
				else{
					
				}
				//if b => entrar else error
			}
		});
		button.setBounds(126, 196, 89, 23);
		frame.getContentPane().add(button);
		
		userField = new JTextField();
		userField.setBounds(207, 82, 86, 20);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(106, 88, 46, 14);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(106, 116, 78, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 113, 86, 20);
		frame.getContentPane().add(passwordField);
	}
}
