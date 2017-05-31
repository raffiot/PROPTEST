package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_pregunta extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;
	private int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_pregunta frame = new Frame_pregunta();
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
	Frame_pregunta(){
		init();
		
	}
	
	Frame_pregunta(Controlador_presentacion cp, int i){
		this.cp = cp;
		this.i = i;
		init();
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifiqueLaPregunta = new JLabel("Modifique la pregunta");
		lblModifiqueLaPregunta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifiqueLaPregunta.setBounds(10, 11, 183, 19);
		contentPane.add(lblModifiqueLaPregunta);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 41, 556, 59);
		contentPane.add(editorPane);
		
		editorPane.setEditable(true);
		editorPane.setText(cp.getPre().get(i));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 113, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!editorPane.getText().equals("")){
					cp.setPre(editorPane.getText());
					dispose();
				}
			}
		});
		btnGuardar.setBounds(477, 111, 89, 23);
		contentPane.add(btnGuardar);
	}

}
