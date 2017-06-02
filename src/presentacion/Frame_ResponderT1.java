package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Frame_ResponderT1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador_presentacion cp;
	private JPanel contentPane;
	private Integer numPreg;
	private Integer sp1;

	public Frame_ResponderT1(Controlador_presentacion cp, Integer i){
		this.cp = cp;
		this.numPreg = i;
		init();
	}
	
	public void init(){
		getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(292, 227, 117, 29);
		btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cp.guardarResT1(sp1,numPreg); //no esta hecho
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
		getContentPane().add(btnCancelar);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 41, 556, 59);
		contentPane.add(editorPane);
		
		editorPane.setEditable(false);
		editorPane.setText(cp.getPre().get(numPreg));
		
		int min = cp.getminOpt1(numPreg);
		int max = cp.getmaxOpt1(numPreg);
		JSpinner spinner_1 = new JSpinner();
		SpinnerModel sm = new SpinnerNumberModel(0, min, max, 1);
		spinner_1.setBounds(192, 173, 33, 26);
        spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sp1 = (int)spinner_1.getValue();
			}
		});
		getContentPane().add(spinner_1);
	
	}
}
