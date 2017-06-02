package presentacion;


import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Frame que muestra el resultado de la analisis con sus clusters, 
 * distancia dentro de cada cluster, distribucion de las respuestas etc...
 * 
 * @author Raphael
 *
 */
public class Frame_MonstrarResultado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador_presentacion cp;
	private String state;
	private SimpleBarPanel sbp;

	/**
	 * Create the frame.
	 */
	
	public Frame_MonstrarResultado(){
		init();
	}
	
	/**
	 * Creadora con el Controlador_presentacion para utilizar sus funcionnes 
	 * y con la varible state qui indique de donde viene el usuario para saber si puede guardar el resultado, volver etc..
	 * 
	 * @param cp
	 * 		el controlador presentacion para la applicacion
	 * @param state
	 * 		Varible que inidice de que frame precedente viene el usuario
	 * 		puede tener dos values from_analizar o from_menu
	 */
	public Frame_MonstrarResultado(Controlador_presentacion cp,String state){
		this.cp = cp;
		this.state = state;
		init();
	}
	
	/**
	 * Metodo que dibuja la frame con sus buttones y sus ActionListener
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JTextArea textArea = new JTextArea();
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(220, 11, 440, 495);
		contentPane.add(jsp);
		
		sbp = new SimpleBarPanel();
		JScrollPane jspGraf = new JScrollPane(sbp);
		jspGraf.setBounds(220, 220, 437, 280);
		getContentPane().add(jspGraf);
		jspGraf.setVisible(false);
		
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Resultado");
		createNodes(top);
		JTree tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener(){

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node != null){
					String nodeInfo = (String) node.getUserObject();
					if(nodeInfo.substring(0, 7).equals("Cluster")){
						String s = nodeInfo+":\n"+cp.getREinfo("c",nodeInfo.substring(8));
						textArea.setText(s);
						jsp.setBounds(220, 11, 440, 200);
						
						
						HashMap<String, Double> map = cp.getDistanceDistribClus(nodeInfo.substring(8));
						double[] dataD = new double[map.size()];
						String[] dataS = new String[map.size()];
						int index = 0;
						for(String name : map.keySet()){
							dataD[index] = map.get(name);
							dataS[index] = name;
							index++;
						}
						sbp.setSimpleBarPanel(dataD, dataS);
						jspGraf.setVisible(true);
						sbp.repaint();
						
						
					}
					else if(nodeInfo.substring(0, 9).equals("Respuesta")){
						String s = cp.getREinfo("re", nodeInfo.substring(13));
						textArea.setText(nodeInfo+"\n"+s);
						jsp.setBounds(220, 11, 440, 495);
						jspGraf.setVisible(false);
						
					}
					else if(nodeInfo.substring(0, 9).equals("Resultado")){
						String s = cp.getRespuestasDistrib();
						textArea.setText(nodeInfo+"\n"+s);
						jsp.setBounds(220, 11, 440, 495);
						jspGraf.setVisible(false);
					}
				}
			}
			
		});
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setBounds(10, 11, 200, 500);
		contentPane.add(treeView);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(state.equals("from_analizar")){
					Frame_analisis ven = new Frame_analisis(cp);
					ven.setVisible(true);
					dispose();
				}
				else if(state.equals("from_menu")){
					Frame_resultado ven = new Frame_resultado(cp);
					ven.setVisible(true);
					dispose();
				}

			}
		});
		btnAtras.setBounds(10, 533, 89, 23);
		contentPane.add(btnAtras);


		if(state.equals("from_analizar")){
			JButton btnGuardarResultado = new JButton("Guardar Resultado");
			btnGuardarResultado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cp.resuGuardar();
					JOptionPane.showMessageDialog(null, "Resultado guardado"
							,"Success", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnGuardarResultado.setBounds(257, 533, 154, 23);
			contentPane.add(btnGuardarResultado);
		}
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_admin ven = new Frame_admin(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnVolverAlMenu.setBounds(558, 533, 118, 23);
		contentPane.add(btnVolverAlMenu);
		
		
	}
	
	/**
	 * Metodo para crear la hierarcia de cluster y respuestas a la encuesta.
	 * 
	 * @param top
	 * 		La raiz del JTree
	 */
	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
	    DefaultMutableTreeNode result = null;
	    
	    category = new DefaultMutableTreeNode("Resultado Overview");
	    top.add(category);
	    
	    ArrayList<Integer> clusters = cp.getClusterNumbers();
	    
	    for(Integer i : clusters){
	    	category = new DefaultMutableTreeNode("Cluster "+i);
	    	top.add(category);
	    	result = new DefaultMutableTreeNode("Cluster "+i);
    		category.add(result);
    		ArrayList<String> respuestas = cp.getRespuestaDeCluster(i);
	    	for(String s : respuestas){
	    		result = new DefaultMutableTreeNode("Respuesta de "+s);
	    		category.add(result);
	    	}
	    }
	}
}
