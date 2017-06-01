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

public class principal {

	public JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private Controlador_presentacion cp;

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
	public principal(Controlador_presentacion cd){
		initialize();
		this.cp = cd;
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cp = new Controlador_presentacion();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JButton btnEntrar = new JButton("Registrarse");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame_resgister fr = new Frame_resgister(cp);
		        fr.setVisible(true);
		        frame.setVisible(false);
			}
		});
		btnEntrar.setBounds(106, 188, 118, 39);
		frame.getContentPane().add(btnEntrar);
		
		JButton button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = -1;
				try {
					answer = cp.entrar(userField.getText(),passwordField.getText());
				} catch (Exception e) {
					// ERROR ONE FIELD EMPTY
					e.printStackTrace();
				}
				if(answer == 1){
					Panel_usuario ven = new Panel_usuario(cp);
			        ven.setVisible(true);
			        frame.setVisible(false);
			        frame.dispose();
					
				}
				else if(answer == 0){
					Frame_admin ven = new Frame_admin(cp);
			        ven.setVisible(true);
			        frame.setVisible(false);
			        frame.dispose();
					
				}
				else{
					//NOT FIND
					JOptionPane.showMessageDialog(null, "Contrase�a o usuario incorrecto","Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button.setBounds(267, 188, 106, 39);
		frame.getContentPane().add(button);
		
		userField = new JTextField();
		userField.setBounds(207, 82, 123, 20);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(106, 88, 46, 14);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(106, 116, 78, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 113, 123, 20);
		frame.getContentPane().add(passwordField);
	}
}
