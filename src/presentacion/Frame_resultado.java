package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import dominio.clases.*;
import dominio.controladores.Controlador_dominio;

import javax.swing.JTree;

public class Frame_resultado extends JFrame {

	private JPanel contentPane;
	private Controlador_dominio cd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_resultado frame = new Frame_resultado();
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
	
	public Frame_resultado() {
		initialize();
	}
	
	public Frame_resultado(Controlador_dominio cd) {
		this.cd = cd;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Resultados de la Analisis");
		createNodes(top);
		JTree tree = new JTree(top);
		tree.setBounds(0, 0, 79, 321);
		contentPane.add(tree);
		
	}
	
	private void createNodes(DefaultMutableTreeNode top) {
	    DefaultMutableTreeNode category = null;
	    DefaultMutableTreeNode respuesta = null;
	    
	    category = new DefaultMutableTreeNode("Resultado general");
	    top.add(category);
	    
	    for(Cluster c : cd.getCurrenResu().getClusters()){
	    	category = new DefaultMutableTreeNode("Cluster "+c.getIndex());
		    top.add(category);
		    for(RespuestaEncuesta ra : c.getUsuarios()){
		    	respuesta = new DefaultMutableTreeNode("Respuesta "+(cd.getCurrenAna().getRespEncuestas().getListRP().indexOf(ra)+1)+" de "+ra.getNombre());
		    	category.add(respuesta);
		    }
	    }
	}
}
