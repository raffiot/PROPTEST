package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

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

	
	private Controlador_dominio cd;
	private String state;
	private JButton borrar;
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
	
	public Frame_encuestas(Controlador_dominio cd, String state) {
		this.cd = cd;
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
		e = cd.getList();
		DefaultListModel<String> aux = new DefaultListModel<String>();
		for(int i = 0; i < e.size(); ++i){
			aux.addElement(e.get(i));
		}
		list.setModel(aux);
		
		
		
		list.setBounds(10, 61, 414, 165);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_admin ven = new Frame_admin(cd);
				ven.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(335, 237, 89, 23);
		getContentPane().add(btnAtras);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 414, 34);
		if (state == "visualizar"){
			label.setText("Encuestas a visualizar");
		}
		if (state == "borrar"){
			label.setText("Elija la encuesta que quiere borrar");
		}
			
		getContentPane().add(label);
		
		borrar = new JButton("borrar");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				
				if (i >= 0){
					String s = list.getSelectedValue();
					s = s.substring(0,1);
					aux.remove(i);
					cd.eliminarEncuesta(s);
				}
				else JOptionPane.showMessageDialog(null, "Debe seleccionar una encuesta"
					     ,"Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		borrar.setBounds(20, 237, 89, 23);
		getContentPane().add(borrar);
	}
}
		
		
		


