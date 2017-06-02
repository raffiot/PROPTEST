package presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * Frame menu de operacion del administrador, puede eligir entre analizar y gestionnar las encuestas.
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Frame_admin extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador_presentacion cp;

	/**
	 * Create the frame.
	 */
	public Frame_admin() {
		init();
	}
	
	/**
	 * Creadora con el Controlador_presentacion para utilizar sus funcionnes
	 * 
	 * @param cp
	 * 		el controlador presentacion para la applicacion
	 */
	public Frame_admin(Controlador_presentacion cd) {
		init();
		this.cp  = cd;
		
	}
	
	/**
	 * Metodo que dibuja la frame con sus buttones y sus ActionListener
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnCrearEncuesta = new JButton("Crear encuesta");
		btnCrearEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_crear ven = new Frame_crear(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnCrearEncuesta.setBounds(220, 83, 150, 44);
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
		btnBorrarEncuesta.setBounds(301, 164, 150, 44);
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
		btnAnalizarEncuesta.setBounds(327, 300, 140, 55);
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
		btnVisualizarAnalisis.setBounds(98, 300, 140, 55);
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
		btnVisualizarEncuestas.setBounds(22, 83, 163, 44);
		contentPane.add(btnVisualizarEncuestas);
		
		JButton btnImportarEncuesta = new JButton("Importar encuesta");
		btnImportarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_importar ven = new Frame_importar(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnImportarEncuesta.setBounds(407, 83, 150, 44);
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
		btnSalir.setBounds(468, 387, 89, 23);
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
		button.setBounds(99, 164, 150, 44);
		contentPane.add(button);
		
		JLabel lblGestionDeEncuestas = new JLabel("Gestion de Encuestas");
		lblGestionDeEncuestas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGestionDeEncuestas.setBounds(170, 25, 218, 29);
		contentPane.add(lblGestionDeEncuestas);
		
		JLabel lblAnalisisDeEncuestas = new JLabel("Analisis de Encuestas");
		lblAnalisisDeEncuestas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnalisisDeEncuestas.setBounds(170, 248, 218, 29);
		contentPane.add(lblAnalisisDeEncuestas);
	}
}
