package presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Frame_ResponderT3 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador_presentacion cp;
	private JPanel contentPane;
	private Integer numPreg;
	private String sp3;

	public Frame_ResponderT3(Controlador_presentacion cp, Integer i){
		this.cp = cp;
		this.numPreg = i;
		init();
	}
	
	public void init(){
		getContentPane().setLayout(null);
		setSize(500, 400);
		setLocationRelativeTo(null);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(292, 227, 117, 29);
		btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cp.guardarResT3(sp3,numPreg); 
        		JOptionPane.showMessageDialog(null, "¡Respuestas guardadas!","Success", JOptionPane.INFORMATION_MESSAGE);
				Frame_ListaPreguntas p = new Frame_ListaPreguntas(cp);
				p.setVisible(true);
				dispose();
        	}
        });
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(30, 227, 117, 29);
		btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Frame_ListaPreguntas usu = new Frame_ListaPreguntas(cp);
				usu.setVisible(true);
				dispose();
        	}
        });
		getContentPane().add(btnCancelar);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(30, 11, 380, 141);
		getContentPane().add(textArea);
		textArea.setText((numPreg+1)+". " +cp.getPre().get(numPreg));
		
		ArrayList<String> opcions = cp.getopcionest3(numPreg);
		SpinnerListModel model = new SpinnerListModel(opcions);
		JSpinner spinner_1 = new JSpinner(model);
		spinner_1.setBounds(129, 180, 117, 20);
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sp3 = (String)spinner_1.getValue();
			}
		});
		getContentPane().add(spinner_1);
		       
	
	}
}
