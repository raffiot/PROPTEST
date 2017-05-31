package presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JDesktopPane;

public class Frame_admin extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_admin frame = new Frame_admin();
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
	public Frame_admin() {
		init();
	}
	
	public Frame_admin(Controlador_presentacion cd) {
		init();
		this.cp  = cd;
		
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearEncuesta = new JButton("Crear encuesta");
		btnCrearEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_crear ven = new Frame_crear(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnCrearEncuesta.setBounds(14, 66, 150, 44);
		contentPane.add(btnCrearEncuesta);
		
		JButton btnBorrarEncuesta = new JButton("Borrar encuesta");
		btnBorrarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cp,"borrar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
				
			}
		});
		btnBorrarEncuesta.setBounds(14, 233, 150, 44);
		contentPane.add(btnBorrarEncuesta);
		
		JButton btnAnalizarEncuesta = new JButton("Analizar encuesta");
		btnAnalizarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cp,"analizar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		btnAnalizarEncuesta.setBounds(240, 44, 140, 55);
		contentPane.add(btnAnalizarEncuesta);
		
		JButton btnVisualizarAnalisis = new JButton("Visualizar analisis");
		btnVisualizarAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_resultado ven = new Frame_resultado(cp);
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		btnVisualizarAnalisis.setBounds(240, 141, 140, 55);
		contentPane.add(btnVisualizarAnalisis);
		
		JButton btnVisualizarEncuestas = new JButton("Visualizar encuestas");
		btnVisualizarEncuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cp,"visualizar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		btnVisualizarEncuestas.setBounds(14, 11, 150, 44);
		contentPane.add(btnVisualizarEncuestas);
		
		JButton btnImportarEncuesta = new JButton("Importar encuesta");
		btnImportarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_importar ven = new Frame_importar(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnImportarEncuesta.setBounds(14, 121, 150, 44);
		contentPane.add(btnImportarEncuesta);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.update();
				principal p = new principal();
				p.frame.setVisible(true);
				dispose();
				
			}
		});
		btnSalir.setBounds(335, 281, 89, 23);
		contentPane.add(btnSalir);
		
		JButton button = new JButton("Modificar encuesta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cp,"modificar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		button.setBounds(14, 176, 150, 44);
		contentPane.add(button);
	}
}
