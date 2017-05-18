package presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controladores.Controlador_dominio;

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
	private Controlador_dominio cd;
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
	
	public Frame_admin(Controlador_dominio cd) {
		init();
		this.cd  = cd;
		
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearEncuesta = new JButton("Crear encuesta");
		btnCrearEncuesta.setBounds(14, 66, 150, 44);
		contentPane.add(btnCrearEncuesta);
		
		JButton btnBorrarEncuesta = new JButton("Borrar encuesta");
		btnBorrarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cd,"borrar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
				
			}
		});
		btnBorrarEncuesta.setBounds(14, 176, 150, 44);
		contentPane.add(btnBorrarEncuesta);
		
		JButton btnAnalizarEncuesta = new JButton("Analizar encuesta");
		btnAnalizarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnalizarEncuesta.setBounds(240, 44, 140, 55);
		contentPane.add(btnAnalizarEncuesta);
		
		JButton btnVisualizarAnalisis = new JButton("Visualizar analisis");
		btnVisualizarAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizarAnalisis.setBounds(240, 141, 140, 55);
		contentPane.add(btnVisualizarAnalisis);
		
		JButton btnVisualizarEncuestas = new JButton("Visualizar encuestas");
		btnVisualizarEncuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_encuestas ven = new Frame_encuestas(cd,"visualizar");
				ven.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		btnVisualizarEncuestas.setBounds(14, 11, 150, 44);
		contentPane.add(btnVisualizarEncuestas);
		
		JButton btnImportarEncuesta = new JButton("Importar encuesta");
		btnImportarEncuesta.setBounds(14, 121, 150, 44);
		contentPane.add(btnImportarEncuesta);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
	}
}
