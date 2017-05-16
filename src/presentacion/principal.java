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
import javax.swing.JOptionPane;

import dominio.controladores.Controlador_dominio;

public class principal {

	public JFrame frame;
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
	public principal(Controlador_dominio cd){
		initialize();
		this.cd = cd;
		
		
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
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame_resgister fr = new Frame_resgister(cd);
		        fr.setVisible(true);
		        frame.setVisible(false);
			}
		});
		btnEntrar.setBounds(244, 196, 102, 23);
		frame.getContentPane().add(btnEntrar);
		
		JButton button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = -1;
				try {
					answer = cd.entrar(userField.getText(),passwordField.getText());
				} catch (Exception e) {
					// ERROR ONE FIELD EMPTY
					e.printStackTrace();
				}
				if(answer == 1){
					Panel_usuario ven = new Panel_usuario(cd);
			        ven.setVisible(true);
			        frame.setVisible(false);
			        
					
				}
				else if(answer == 0){
					Frame_admin ven = new Frame_admin(cd);
			        ven.setVisible(true);
			        frame.setVisible(false);
					
				}
				else{
					//NOT FIND
					JOptionPane.showMessageDialog(null, "Contrase�a o usuario incorrecto","Error", JOptionPane.INFORMATION_MESSAGE);
				}
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
