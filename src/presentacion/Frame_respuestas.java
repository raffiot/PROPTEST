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
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import dominio.clases.Encuesta;
import dominio.controladores.Controlador_dominio;

public class Frame_respuestas extends JFrame {

	private JPanel contentPane;
	private Controlador_dominio cd;
	private Encuesta enc;
	private JList list;
	private JButton btnBorrarAnalizar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_respuestas frame = new Frame_respuestas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame_respuestas() {
		init();
	}
	
	public Frame_respuestas(Controlador_dominio cd, Encuesta e){
		enc = e;
		this.cd = cd;
		init();
	}
	/**
	 * Create the frame.
	 */
	public void init() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		ArrayList<String> r = new ArrayList<String>();
		r = cd.getListResp(enc.getId());
		for(String s : r){
			
		}
		
		
		btnBorrarAnalizar = new JButton("analizar");
		btnBorrarAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				if (i >= 0){
					int[] s = list.getSelectedValue();
					Encuesta enc = cd.selecionnarEncuesta(s);
					Frame_respuestas ven = new Frame_respuestas(cd,enc);
					ven.setVisible(true);
					dispose();
				}
			}
		});
		
	}

}
