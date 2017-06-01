package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controladores.Controlador_dominio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Frame_resgister extends JFrame {

	private Controlador_presentacion cp;
	private JPanel contentPane;
	private JTextField field1;
	private JPasswordField field2;
	private JLabel label_secret;
	private JRadioButton rdadmin;
	private JRadioButton rdusu;
	private JPasswordField fieldSecretPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_resgister frame = new Frame_resgister();
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
	public Frame_resgister(){
		init();
	}
	
	public Frame_resgister(Controlador_presentacion cd){
		this.cp = cd;
		init();
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(77, 27, 93, 14);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(77, 64, 93, 14);
		contentPane.add(lblContrasea);
		
		field1 = new JTextField();
		field1.setBounds(253, 24, 115, 20);
		contentPane.add(field1);
		field1.setColumns(10);
		
		field2 = new JPasswordField();
		field2.setBounds(253, 61, 115, 20);
		contentPane.add(field2);
		field2.setColumns(10);
		
		rdusu = new JRadioButton("Usuario");
		rdusu.setBounds(253, 125, 73, 23);
		contentPane.add(rdusu);
		rdusu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_secret.setVisible(false);
				fieldSecretPass.setVisible(false);
				rdadmin.setSelected(false);
			}
		});
		
		rdadmin = new JRadioButton("Administrador");
		rdadmin.setBounds(96, 125, 109, 23);
		contentPane.add(rdadmin);
		rdadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_secret.setVisible(true);
				fieldSecretPass.setVisible(true);
				rdusu.setSelected(false);
			}
		});
		
		
		label_secret = new JLabel("Contrase\u00F1a Administrador");
		label_secret.setBounds(77, 169, 166, 14);
		contentPane.add(label_secret);
		label_secret.setVisible(false);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = field1.getText();
				String pass = field2.getText();
				boolean usu = rdusu.isSelected();
				boolean admin = rdadmin.isSelected();
				
			if (user.equals("") || pass.equals(""))	JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos","Error", JOptionPane.INFORMATION_MESSAGE);
			else if (!(usu) && !(admin))	JOptionPane.showMessageDialog(null, "Por favor elija usuario o administrador","Error", JOptionPane.INFORMATION_MESSAGE);
			else {
				
				if(!usu){
					String passadmin = fieldSecretPass.getText();
					if(!passadmin.equals("Borja")){
						JOptionPane.showMessageDialog(null, "Password de administrador incorrecta","Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						boolean hasRegister = cp.registrar(user,pass,usu);
						if(!hasRegister){
							JOptionPane.showMessageDialog(null, "Nombre de administrador no disponible","Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Administrador registrado !","Success", JOptionPane.INFORMATION_MESSAGE);
							principal p = new principal(cp);
							p.frame.setVisible(true);
							dispose();
						}
					}
				
				}
				else{
					
					boolean hasRegister = cp.registrar(user,pass,usu);
					if(!hasRegister){
						JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible","Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario registrado !","Success", JOptionPane.INFORMATION_MESSAGE);
						principal p = new principal(cp);
						p.frame.setVisible(true);
						dispose();
					}
				}
					
			}
			}
		});
		btnRegistrarse.setBounds(303, 228, 121, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal p = new principal(cp);
				p.frame.setVisible(true);
				dispose();
				
			}
		});
		btnCancelar.setBounds(22, 228, 101, 23);
		contentPane.add(btnCancelar);
		
		
		fieldSecretPass = new JPasswordField();
		fieldSecretPass.setBounds(282, 166, 86, 20);
		contentPane.add(fieldSecretPass);
		fieldSecretPass.setVisible(false);
	}
}
