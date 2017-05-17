package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import dominio.clases.Cjt_encuestas;
import dominio.controladores.Controlador_dominio;

import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame_encuestas  extends JFrame {

	
	private Controlador_dominio cd;

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
	
	public Frame_encuestas(Controlador_dominio cd) {
		initialize();
		this.cd = cd;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JList<String> list = new JList<String>();
		Cjt_encuestas e = new Cjt_encuestas();
		/*e = cd.getEncuestas();
		DefaultListModel aux = new DefaultListModel();
		for(int i = 0; i < e.size(); ++i){
			String s = e.get(i).getId()+". " + e.get(i).getGenero();
			aux.addElement(s);
		}
		list.setModel(aux);*/
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		list.setBounds(10, 61, 414, 189);
		getContentPane().add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 61, 17, 189);
		getContentPane().add(scrollBar);
	}
}
