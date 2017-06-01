package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sun.javafx.geom.Rectangle;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_mostrar extends JFrame {

	private JPanel contentPane;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private JButton btnSalir;
	private String encuesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_mostrar frame = new Frame_mostrar();
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
	public Frame_mostrar(String s){
		this.encuesta = s;
		init();
	}
	public Frame_mostrar(){
		
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtArea = new JTextArea();      
		txtArea.setText(encuesta);
		
        scroll = new JScrollPane(txtArea);    
        scroll.setBounds(27,11,375,210);                                                    
        contentPane.add(scroll);       
        
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setBounds(335, 232, 89, 23);
        contentPane.add(btnSalir);
		
		
	}
}
