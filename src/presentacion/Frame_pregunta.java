package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Frame que muestra el enunciado de la pregunta que puedes modificar
 * 
 * @author Miguel
 *
 */
public class Frame_pregunta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador_presentacion cp;
	private int i;

	/**
	 * Create the frame.
	 */
	Frame_pregunta(){
		init();
		
	}
	
	/**
	 * Creadora con el Controlador_presentacion para utilizar sus funcionnes
	 * y el numero de la pregunta que se esta modificando.
	 * 
	 * @param cp
	 * 		el controlador presentacion para la applicacion
	 * @param i
	 * 		el index de la pregunta que se modifica
	 */
	Frame_pregunta(Controlador_presentacion cp, int i){
		this.cp = cp;
		this.i = i;
		init();
	}
	
	/**
	 * Metodo que dibuja la frame con sus buttones y sus ActionListener
	 */
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
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
					cp.guardarPre(editorPane.getText(), i);
					Frame_modificar ven = new Frame_modificar(cp);
					ven.setVisible(true);
					dispose();
				}
			}
		});
		btnGuardar.setBounds(477, 111, 89, 23);
		contentPane.add(btnGuardar);
	}

}
