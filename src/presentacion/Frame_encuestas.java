package presentacion;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;


import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Frame que muestra todas las encuestas y permite seleccionar una para borrar la, modificar la o analizar la.
 * 
 * @author Miguel
 * @author Raphael
 *
 */
public class Frame_encuestas  extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador_presentacion cp;
	private String state;
	private JButton btnBorrarAnalizar;
	private JButton mod;
	private JList<String> list;

	/**
	 * Create the application.
	 */
	public Frame_encuestas() {
		initialize();
	}
	
	/**
	 * Creadora con el Controlador_presentacion para utilizar sus funcionnes
	 * y con la varible state qui indique de donde viene el usuario para saber donde va el usuario con el button siguiente etc...
	 * 
	 * @param cp
	 * 		el controlador presentacion para la applicacion
	 * @param state
	 * 		Varible que inidice de que frame precedente viene el usuario
	 * 		puede tener dos values borrar o analizar o modificar
	 */
	public Frame_encuestas(Controlador_presentacion cp, String state) {
		this.cp = cp;
		this.state = state;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 308);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);
		ArrayList<String> e = new ArrayList<String>();
		e = cp.getList();
		DefaultListModel<String> aux = new DefaultListModel<String>();
		for(int i = 0; i < e.size(); ++i){
			aux.addElement(e.get(i));
		}
		list.setModel(aux);
		
		
		
		list.setBounds(10, 62, 414, 164);
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            //int index = list.getSelectedIndex();
		          
		        	String s = (String) list.getSelectedValue();
					s = s.substring(0,1);
					s = cp.getE(Integer.parseInt(s));
					Frame_mostrar ven = new Frame_mostrar(s);
					ven.setVisible(true);
					setLocationRelativeTo(null);
		          
		        }
		    }
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_admin ven = new Frame_admin(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 235, 89, 23);
		//btnAtras.setBounds(335, 237, 89, 23);
		getContentPane().add(btnAtras);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 414, 34);
		if (state.equals("visualizar")){
			label.setText("Encuestas a visualizar");
		}
		else if (state.equals("borrar")){
			label.setText("Elija la encuesta que quiera borrar");
		}
		else if (state.equals("analizar")){
			label.setText("Elija la encuesta que quiera analizar");
		}
		
		else if (state.equals("modificar")){
			label.setText("Elija la encuesta que quiera modificar");
		}
			
		getContentPane().add(label);
		
		if (state.equals("borrar")){
			btnBorrarAnalizar = new JButton("borrar");
			btnBorrarAnalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = list.getSelectedIndex();

					if (i >= 0){
						String s = list.getSelectedValue();
						s = s.substring(0,1);
						aux.remove(i);
						cp.eliminarEncuesta(s);
					}
					else JOptionPane.showMessageDialog(null, "Debe seleccionar una encuesta"
							,"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
			
			//btnBorrarAnalizar.setBounds(20, 237, 89, 23);
			btnBorrarAnalizar.setBounds(335, 237, 89, 23);
			getContentPane().add(btnBorrarAnalizar);
		}
		
		if (state.equals("analizar")){
			btnBorrarAnalizar = new JButton("Siguiente");
			btnBorrarAnalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = list.getSelectedIndex();
					if (i >= 0){
						String s = list.getSelectedValue();
						s = s.substring(0,1);
						if(cp.encuestaWithoutRespuesta(s)){
							JOptionPane.showMessageDialog(null, "No hay ninguna respuesta para esta encuesta","Error", JOptionPane.ERROR_MESSAGE);
						}	
						else{
							cp.selecionnarEncuesta(s);
							Frame_respuestas ven = new Frame_respuestas(cp);
							ven.setVisible(true);
							dispose();
						}
					}
				}
			});
			//btnBorrarAnalizar.setBounds(20, 237, 89, 23);
			btnBorrarAnalizar.setBounds(335, 237, 89, 23);
			getContentPane().add(btnBorrarAnalizar);
		}
		
		if (state.equals("modificar")){
			mod = new JButton("Modificar");
			mod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = list.getSelectedIndex();
					if (i >= 0){
						String s = list.getSelectedValue();
						s = s.substring(0,1);
						cp.selecionnarEncuesta(s);
						Frame_modificar ven = new Frame_modificar(cp);
						ven.setVisible(true);
						dispose();
					}
				}
			});
			mod.setBounds(335, 237, 89, 23);
			getContentPane().add(mod);
		}
		
		
	}
}
		
		
		


