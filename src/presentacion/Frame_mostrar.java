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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;

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
		setBounds(100, 100, 483, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);
        scroll = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scroll, 11, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, scroll, 37, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scroll, 375, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, scroll, 427, SpringLayout.WEST, contentPane);
        contentPane.add(scroll);       
        txtArea = new JTextArea();
        scroll.setViewportView(txtArea);
        txtArea.setText(encuesta);
        txtArea.setEditable(false);
        setLocationRelativeTo(null);
        btnSalir = new JButton("Salir");
        sl_contentPane.putConstraint(SpringLayout.WEST, btnSalir, -99, SpringLayout.EAST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, -10, SpringLayout.EAST, contentPane);
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        contentPane.add(btnSalir);
		
		
	}
}
