package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class Frame_modificar extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll;
	private Controlador_presentacion cp;
	private JTextField textField;
	private ArrayList<String> e;
	private DefaultListModel<String> aux;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_modificar frame = new Frame_modificar();
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
	Frame_modificar(){
		setForeground(new Color(204, 255, 204));
		setLocationRelativeTo(null);
		setTitle("Modificar Encuesta");
		init();
		
	}
	Frame_modificar(Controlador_presentacion cp){
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
				Frame_admin ven = new Frame_admin(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar y salir");
		btnNewButton_1.setBounds(280, 400, 153, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")){
					
					String s = textField.getText();
					cp.setGenero(s);
					Frame_admin ven = new Frame_admin(cp);
					ven.setVisible(true);
					dispose();
				}
				else {
					Frame_admin ven = new Frame_admin(cp);
					ven.setVisible(true);
					dispose();
				}
			}
		});
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
		
		JLabel lblCambiarGnero = new JLabel("Cambiar g\u00E9nero: ");
		lblCambiarGnero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambiarGnero.setBounds(25, 23, 133, 27);
		contentPane.add(lblCambiarGnero);
		
		textField = new JTextField();
		textField.setBounds(140, 28, 290, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            //int index = list.getSelectedIndex();
		            String s = (String) list.getSelectedValue();
					s = s.substring(0,1);
					Frame_pregunta ven = new Frame_pregunta(cp,Integer.parseInt(s)-1);
					ven.setVisible(true);
					dispose();
					
					
				
		            
		        }
		    }
		});
		
		
	}
}
