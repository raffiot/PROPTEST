package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Frame_ListaPreguntas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll;
	private Controlador_presentacion cp;
	private ArrayList<String> e;
	private DefaultListModel<String> aux;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	Frame_ListaPreguntas(Controlador_presentacion cp){
		this.cp = cp;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 469);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(15, 400, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_usuario ven = new Panel_usuario(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar y salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cp.guardarRespUsuario();
				Panel_usuario ven = new Panel_usuario(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(285, 400, 153, 23);
	
		contentPane.add(btnNewButton_1);
		
		JList<String> list = new JList<String>();
		list.setBounds(20, 10, 414, 215);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);
		e = new ArrayList<String>();
		e = cp.getPre();
		 aux = new DefaultListModel<String>();
		for(int i = 0; i < e.size(); ++i){
			aux.addElement((i+1)+"."+e.get(i));
		}
		list.setModel(aux);
		list.setBounds(20,61,410,300);
		
		JLabel lblCambiarGnero = new JLabel("Haga doble click sobre la pregunta que desea contestar");
		lblCambiarGnero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarGnero.setBounds(15, 23, 423, 27);
		contentPane.add(lblCambiarGnero);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            //int index = list.getSelectedIndex();
		            String s = (String) list.getSelectedValue();
					s = s.substring(0,1);
					int tipo = cp.gettipo(Integer.parseInt(s)-1);
					
					if (tipo == 1){
					Frame_ResponderT1 ven = new Frame_ResponderT1 (cp,Integer.parseInt(s)-1);
					ven.setVisible(true);
					dispose();
					}
					
					else if (tipo == 2){
						Frame_ResponderT2 ven = new Frame_ResponderT2 (cp,Integer.parseInt(s)-1);
						ven.setVisible(true);
						dispose();
						}
					if (tipo == 3){
						Frame_ResponderT3 ven = new Frame_ResponderT3 (cp,Integer.parseInt(s)-1);
						ven.setVisible(true);
						dispose();
						}
					if (tipo == 4){
						Frame_ResponderT4 ven = new Frame_ResponderT4 (cp,Integer.parseInt(s)-1);
						ven.setVisible(true);
						dispose();
						}
					if (tipo == 5){
						Frame_ResponderT5 ven = new Frame_ResponderT5 (cp,Integer.parseInt(s)-1);
						ven.setVisible(true);
						dispose();
						}
				
		            
		        }
		    }
		});
		
		
	}
}
