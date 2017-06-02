package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.SpringLayout;

public class Panel_usuario extends JFrame {

	private JPanel contentPane;
	private static Controlador_presentacion cp;
	private JList<String> list;
	private String s;
	private JButton btnSalir;
	private JButton btnAtras;
	private JButton btnResponderEncuesta;
	private JButton CACA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_usuario frame = new Panel_usuario(cp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Panel_usuario(Controlador_presentacion cp) {
		this.cp = cp;
		init();
	}

	/**
	 * init the frame.
	 */
	public void init() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setLocationRelativeTo(null);

		
		btnSalir = new JButton("Salir");
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 4;
		gbc_btnSalir.gridy = 6;
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.update();
				principal p = new principal();
				p.frame.setVisible(true);
				dispose();
				//TODO FALTA CERRAR SESION
			}
		});
		
		btnAtras = new JButton("Atras");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSalir, 6, SpringLayout.SOUTH, btnAtras);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, 0, SpringLayout.EAST, btnAtras);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAtras, 169, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAtras, -196, SpringLayout.EAST, contentPane);
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 6;
		gbc_btnAtras.gridy = 6;
		btnAtras.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
        		principal p = new principal(cp);
				p.frame.setVisible(true);
				dispose();
        	}
		});
		contentPane.add(btnAtras);
		
		btnResponderEncuesta = new JButton("Responder encuesta");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnResponderEncuesta, 50, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnResponderEncuesta, 78, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnResponderEncuesta, 325, SpringLayout.WEST, contentPane);
		btnResponderEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_listaEnc mostrar = new Frame_listaEnc(cp);
				mostrar.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnResponderEncuesta);
		
		CACA = new JButton("Acabar de responder encuesta");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAtras, 6, SpringLayout.SOUTH, CACA);
		sl_contentPane.putConstraint(SpringLayout.NORTH, CACA, 6, SpringLayout.SOUTH, btnResponderEncuesta);
		sl_contentPane.putConstraint(SpringLayout.EAST, CACA, -10, SpringLayout.EAST, btnResponderEncuesta);
		CACA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("ME VOY DE AQUI");
				Frame_listaEncNoAcabadas p = new Frame_listaEncNoAcabadas(cp);
				p.setVisible(true);
				dispose();
			}
		});
		contentPane.add(CACA);
		
	}

}
