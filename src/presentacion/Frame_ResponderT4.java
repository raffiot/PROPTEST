package presentacion;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentacion.Frame_respuestas.CheckListItem;
import presentacion.Frame_respuestas.CheckListRenderer;

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
		setSize(600, 500);
		setLocationRelativeTo(null);
		ArrayList<String> items = cp.getopcionest4(numPreg);
		sp4 = new ArrayList<String>();
		int [] selected = new int[items.size()];
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(292, 227, 117, 29);
		btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i =0; i<items.size(); i++){
        			if(selected[i] ==1){
        				sp4.add(items.get(i));
        			}
        		}
        		cp.guardarResT4(sp4,numPreg); //no esta hecho
        		JOptionPane.showMessageDialog(null, "¡Respuestas guardadas!","Success", JOptionPane.INFORMATION_MESSAGE);
				Frame_ListaPreguntas p = new Frame_ListaPreguntas(cp);
				p.setVisible(true);
				dispose();
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
		
		
		
		
		CheckListItem[] itemList = new CheckListItem [items.size()];
		for(int i = 0; i < items.size(); i++){
			selected[i] = 0;
			itemList[i] = new CheckListItem(items.get(i));
		}
		JList list_1 = new JList(itemList);
		list_1.setCellRenderer(new CheckListRenderer());
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				JList list = (JList) event.getSource();
				int index = list.locationToIndex(event.getPoint());// Get index of item
				// clicked
				CheckListItem item = (CheckListItem) list.getModel()
						.getElementAt(index);
				item.setSelected(!item.isSelected()); // Toggle selected state
				list.repaint(list.getCellBounds(index, index));// Repaint cell
				if(item.isSelected()){
					selected[index] = 1;
				}
				else{
					selected[index] = 0;
				}
			}
		});
		
		JScrollPane jsp = new JScrollPane(list_1);
		jsp.setBounds(0, 0, 434, 211);
		
		getContentPane().add(jsp);
	}
	
	class CheckListItem {

		  private String label;
		  private boolean isSelected = false;

		  public CheckListItem(String label) {
		    this.label = label;
		  }

		  public boolean isSelected() {
		    return isSelected;
		  }

		  public void setSelected(boolean isSelected) {
		    this.isSelected = isSelected;
		  }

		  @Override
		  public String toString() {
		    return label;
		  }
	}
	
	class CheckListRenderer extends JCheckBox implements ListCellRenderer {
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean hasFocus) {
		    setEnabled(list.isEnabled());
		    setSelected(((CheckListItem) value).isSelected());
		    setFont(list.getFont());
		    setBackground(list.getBackground());
		    setForeground(list.getForeground());
		    setText(value.toString());
		    return this;
		  }
	}
}	

