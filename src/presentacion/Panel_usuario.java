package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class Panel_usuario extends JFrame {

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
					Panel_usuario frame = new Panel_usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Panel_usuario() {
		init();
		
	}
	public Panel_usuario(Controlador_presentacion cp) {
		System.out.println("CREADORA");
		System.out.println(cp);
		this.cp = cp;
		init();
	}

	/**
	 * init the frame.
	 */
	public void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton contestar = new JButton("Responder encuesta");
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);
		ArrayList<String> e1 = new ArrayList<String>();
		System.out.println("Aqui arribo be");
		System.out.println(cp);
		e1 = cp.getList(); //e1 es null?????
		DefaultListModel<String> aux = new DefaultListModel<String>();
		System.out.println("Aqui ja arribo be x2");
		for(int i = 0; i < e1.size(); ++i){
			aux.addElement(e1.get(i));
		}
		list.setModel(aux);
		System.out.println("Aqui ja arribo be x3");
		list.setBounds(10, 61, 414, 165);
		
		contestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Aqui ja arribo be x4");
				list.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent evt) {
				        JList list = (JList)evt.getSource();
				        if (evt.getClickCount() == 2) {
				            String s = (String) list.getSelectedValue();
							s = s.substring(0,1);
							s = cp.getE(Integer.parseInt(s));
							Frame_contestar respuesta = new Frame_contestar();
							respuesta.setVisible(true);
							
				            
				        }
				    }
				});
				
			}
		});
		contestar.setBounds(20, 237, 89, 23);
		GridBagConstraints gbc_contestar = new GridBagConstraints();
		gbc_contestar.insets = new Insets(0, 0, 5, 5);
		gbc_contestar.gridx = 4;
		gbc_contestar.gridy = 2;
		getContentPane().add(contestar, gbc_contestar);
		

		
		
		/*JButton btnRecuperarEncuesta = new JButton("Recuperar encuesta");
		btnRecuperarEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_contestar recuperar = new Frame_contestar();
				recuperar.setVisible(true);
				dispose();
			}
		});
		btnRecuperarEncuesta.setBounds(20, 237, 89, 23);
		GridBagConstraints gbc_btnRecuperarEncuesta = new GridBagConstraints();
		gbc_btnRecuperarEncuesta.insets = new Insets(0, 0, 0, 5);
		gbc_btnRecuperarEncuesta.gridx = 4;
		gbc_btnRecuperarEncuesta.gridy = 4;
		contentPane.add(btnRecuperarEncuesta, gbc_btnRecuperarEncuesta);*/
	}

}
