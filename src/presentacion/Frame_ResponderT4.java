package presentacion;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Frame_ResponderT4 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador_presentacion cp;
	private JPanel contentPane;
	private Integer numPreg;
	private ArrayList<String> sp4;

	public Frame_ResponderT4(Controlador_presentacion cp, Integer i){
		this.cp = cp;
		this.numPreg = i;
		init();
	}
	
	public void init(){
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(292, 227, 117, 29);
		btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cp.guardarResT4(sp4,numPreg); //no esta hecho
        	}
        });
		getContentPane().setLayout(null);
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
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 41, 556, 59);
		contentPane.add(editorPane);
		editorPane.setEditable(false);
		editorPane.setText(cp.getPre().get(numPreg));
		
		JList list = new JList<String>();
		list.setBounds(18, 106, 414, 87);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		getContentPane().add(list);
		ArrayList<String> e = new ArrayList<String>();
		e = cp.getList();
		DefaultListModel<String> aux = new DefaultListModel<String>();
		for(int i = 0; i < e.size(); ++i){
			aux.addElement(e.get(i));
		}
		list.setModel(aux);
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            //int index = list.getSelectedIndex();
		          
		        	String s = (String) list.getSelectedValue();
					s = s.substring(0,1);
					s = cp.getE(Integer.parseInt(s));
					Frame_mostrar ven = new Frame_mostrar(s);
					ven.setVisible(true);
					setLocationRelativeTo(null);
		          
		        }
		    }
		});
	}
}	

