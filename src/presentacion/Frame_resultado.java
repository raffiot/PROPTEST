package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ListSelectionModel;

import dominio.clases.*;
import dominio.controladores.Controlador_dominio;

import javax.swing.JTree;

public class Frame_resultado extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;
	private JList<String> list;

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
	
	public Frame_resultado(Controlador_presentacion cp) {
		this.cp = cp;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ArrayList<String> r = new ArrayList<String>();
		r = cp.getListResu();
		DefaultListModel<String> aux = new DefaultListModel<String>();
		for(int i = 0; i < r.size(); ++i){
			aux.addElement(r.get(i));
		}
		list.setModel(aux);
		//list.setBounds(10, 61, 414, 165);
		//getContentPane().add(list);
		JScrollPane jsp = new JScrollPane(list);
		//jsp.add(list);
		jsp.setBounds(10, 61, 414, 165);
		getContentPane().add(jsp);
		
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
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				if (i >= 0){
					String s = list.getSelectedValue();
					s = s.substring(0,1);
					cp.selecionnarResultado(s);
					cp.selecionnarREdesdeResu();
					Frame_MonstrarResultado ven = new Frame_MonstrarResultado(cp,"from_menu");
					ven.setVisible(true);
					dispose();
				}
			}
		});
		btnSiguiente.setBounds(335, 237, 89, 23);
		getContentPane().add(btnSiguiente);
	}
}
