package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class Frame_contestar extends JFrame {
	
	private JPanel contentPane;
	private JButton btnSalir;
	private Controlador_presentacion cp;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
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
	public Frame_contestar() {
		initialize();
	}
	
	public Frame_contestar(Controlador_presentacion cp, String state) {

		initialize();
		
	}
	
	/**
	 * Create the frame.
	 */
	public void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 500);
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
        btnSalir.setBounds(338, 449, 89, 23);
        contentPane.add(btnSalir);
                        
        for (int i = 0; i < npreguntas; ++i){
            JLabel lblNewLabel = new JLabel("Respesta " + (i+1) + ": ");
            lblNewLabel.setBounds(27, 249, 108, 16);
            contentPane.add(lblNewLabel);
            
        	if (cp.encuesta.getipo() == 1){
                JSpinner spinner = new JSpinner();
                spinner.setBounds(59, 321, 33, 26);
                contentPane.add(spinner);
                //cambiar datos
        	}
        	else if (cp.encuesta.getipo() == 2){
        		 JSpinner spinner = new JSpinner();
                 spinner.setBounds(59, 321, 33, 26);
                 contentPane.add(spinner);
                 //cambiar datos
        	}
        	else if (cp.encuesta.getipo() == 3){
        		JSpinner spinner = new JSpinner();
                spinner.setBounds(59, 321, 33, 26);
                contentPane.add(spinner);
                //cambiar datos
        	}
        	else if (cp.encuesta.getipo() == 4){
        		
        		for (int j = 0; j < encuesta.pregunta.numPreguntas; ++j ){
	                JCheckBox chckbxNewCheckBox = new JCheckBox(/*opcion j+1*/);
	                chckbxNewCheckBox.setBounds(99, 343, 128, 23);
	                contentPane.add(chckbxNewCheckBox);
        		}
        	}
        	else if (cp.encuesta.getipo() == 5){
                textField = new JTextField();
                textField.setBounds(83, 291, 319, 26);
                contentPane.add(textField);
                textField.setColumns(10);
        	}
        }
	}
}
