package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import dominio.clases.Encuesta;
import dominio.controladores.Controlador_dominio;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_encuestas  extends JFrame {

	
	private Controlador_presentacion cp;
	private String state;
	private JButton btnBorrarAnalizar;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_encuestas frame = new Frame_encuestas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame_encuestas() {
		initialize();
	}
	
	public Frame_encuestas(Controlador_presentacion cp, String state) {
		this.cp = cp;
		this.state = state;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
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
		
		
		
		list.setBounds(10, 61, 414, 165);
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
		btnAtras.setBounds(20, 237, 89, 23);
		//btnAtras.setBounds(335, 237, 89, 23);
		getContentPane().add(btnAtras);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 414, 34);
		if (state == "visualizar"){
			label.setText("Encuestas a visualizar");
		}
		else if (state == "borrar"){
			label.setText("Elija la encuesta que quiere borrar");
		}
		else if (state == "analizar"){
			label.setText("Elija la encuesta que quieres analizar");
		}
			
		getContentPane().add(label);
		
		if (state == "borrar"){
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
		
		if (state == "analizar"){
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
	}
}
		
		
		


