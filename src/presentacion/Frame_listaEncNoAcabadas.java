package presentacion;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;

public class Frame_listaEncNoAcabadas extends JFrame {
	
	private Controlador_presentacion cp;
	private JPanel contentPane;
	private JList list;
	private String s;
	private JButton btnResponder;
	private JButton btnAtras;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_contestar frame = new Frame_contestar();
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
	
	public Frame_listaEncNoAcabadas(Controlador_presentacion cp) {
		this.cp = cp;
		initialize();
		
	}
	
	public void initialize(){
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
		r = cp.getListNoAcabadas();
		DefaultListModel<String> aux = new DefaultListModel<String>();
		if(! r.isEmpty()){
			for(int i = 0; i < r.size(); ++i){
				aux.addElement(r.get(i));
			}
		}
		else {
			aux.addElement("No tienes ninguna encuesta sin acabar");
		}
			list.setModel(aux);
			JScrollPane jsp = new JScrollPane(list);
			jsp.setBounds(10, 61, 414, 165);
			getContentPane().add(jsp);
			
			btnResponder = new JButton("Responder");
			btnResponder.setBounds(65, 238, 117, 29);
			list.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() == 1) {
			            s = (String) list.getSelectedValue();
						s = s.substring(0,1);
				    }
					btnResponder.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cp.selecionnarEncuesta(s);
							s = cp.getE(Integer.parseInt(s));
							Frame_contestar respuesta = new Frame_contestar(cp,s);
							respuesta.setVisible(true);
							dispose();
						}
					});
			    }
			});
			contentPane.add(btnResponder);
			
			btnAtras = new JButton("Atras");
			btnAtras.setBounds(287, 238, 117, 29);
			btnAtras.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Panel_usuario usu = new Panel_usuario(cp);
					usu.setVisible(true);
					dispose();
	        	}
	        });
			contentPane.add(btnAtras);
		
		
	}
}
