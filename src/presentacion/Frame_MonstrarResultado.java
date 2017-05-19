package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import dominio.clases.Cluster;
import dominio.clases.Encuesta;
import dominio.clases.RespuestaEncuesta;
import dominio.clases.Resultado;
import dominio.controladores.Controlador_dominio;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_MonstrarResultado extends JFrame {

	private JPanel contentPane;
	private Controlador_dominio cd;
	private Encuesta enc;
	private List<RespuestaEncuesta> listRE;
	private Resultado resu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_MonstrarResultado frame = new Frame_MonstrarResultado();
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
	
	public Frame_MonstrarResultado(){
		init();
	}
	
	public Frame_MonstrarResultado(Controlador_dominio cd, Encuesta enc, List<RespuestaEncuesta> listRE, Resultado resu){
		this.cd = cd;
		this.enc = enc;
		this.listRE = listRE;
		this.resu = resu;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(220, 11, 437, 495);
		contentPane.add(textArea);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Resultado");
		createNodes(top);
		JTree tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener(){

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				String nodeInfo = (String) node.getUserObject();
				/**
				System.out.println(nodeInfo.substring(0, 7));
				System.out.println(nodeInfo.substring(8));
				System.out.println(nodeInfo.substring(13));*/
				if(nodeInfo.substring(0, 7).equals("Cluster")){
					Cluster c = resu.getClusters().get(Integer.parseInt(nodeInfo.substring(8)));
					String s = "Cluster "+c.getIndex()+":\n"+c.getCentroid().toString();
					textArea.setText(s);
				}
				else if(nodeInfo.substring(0, 9).equals("Respuesta")){
					RespuestaEncuesta re = null;
					for(RespuestaEncuesta ree : listRE){
						if(ree.getNombre().equals(nodeInfo.substring(13))){
							re = ree;
						}
					}
					textArea.setText(nodeInfo+"\n"+re.toString());
					
				}
			}
			
		});
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setBounds(10, 11, 200, 500);
		contentPane.add(treeView);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame_analisis ven = new Frame_analisis(cd,enc,listRE);
				ven.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 533, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnGuardarResultado = new JButton("Guardar Resultado");
		btnGuardarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.anadirResuGuardar(resu);
				JOptionPane.showMessageDialog(null, "Resultado guardado"
						,"Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardarResultado.setBounds(257, 533, 154, 23);
		contentPane.add(btnGuardarResultado);
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_admin ven = new Frame_admin(cd);
				ven.setVisible(true);
				dispose();
			}
		});
		btnVolverAlMenu.setBounds(558, 533, 118, 23);
		contentPane.add(btnVolverAlMenu);
		
		
	}
	
	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
	    DefaultMutableTreeNode result = null;
	    
	    category = new DefaultMutableTreeNode("Resultado Overview");
	    top.add(category);
	    
	    for(Cluster c : resu.getClusters()){
	    	category = new DefaultMutableTreeNode("Cluster "+c.getIndex());
	    	top.add(category);
	    	result = new DefaultMutableTreeNode("Cluster "+c.getIndex());
    		category.add(result);
	    	for(RespuestaEncuesta re : c.getUsuarios()){
	    		result = new DefaultMutableTreeNode("Respuesta de "+re.getNombre());
	    		category.add(result);
	    	}
	    }
	}
}
