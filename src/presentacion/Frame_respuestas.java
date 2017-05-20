package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

import dominio.clases.Encuesta;
import dominio.clases.RespuestaEncuesta;
import dominio.controladores.Controlador_dominio;
import dominio.controladores.Controlador_persistencia;
import dominio.controladores.Controlador_presentacion;

public class Frame_respuestas extends JFrame {

	private JPanel contentPane;
	private Controlador_presentacion cp;
	private JList list;
	private JButton btnAnalizar;
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
	
	public Frame_respuestas(Controlador_presentacion cp){
		this.cp = cp;
		init();
	}
	/**
	 * Create the frame.
	 */
	public void init() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		 
		
		
		//List<RespuestaEncuesta> items = cd.getListResp(enc.getId());
		ArrayList<String> items = cp.getListResp();
		int [] selected = new int[items.size()];
		
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

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.selectedItem(selected);
				Frame_analisis ven = new Frame_analisis(cp);
				ven.setVisible(true);
				dispose();
			}
		});
		btnSiguiente.setBounds(335, 227, 89, 23);
		getContentPane().add(btnSiguiente);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame_encuestas ven = new Frame_encuestas(cp,"analizar");
				ven.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(15, 227, 89, 23);
		getContentPane().add(btnAtras);
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
