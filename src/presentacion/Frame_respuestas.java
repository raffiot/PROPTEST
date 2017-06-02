package presentacion;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Frame para monstrar las respuestas de una encuesta y seleccionar las para la analisis.
 * 
 * @author Raphael
 *
 */
public class Frame_respuestas extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controlador_presentacion cp;
	
	/**
	 * Creadora frame respuestas
	 */
	public Frame_respuestas() {
		init();
	}
	
	/**
	 * Creadora con el Controlador_presentacion para utilizar sus funcionnes
	 * 
	 * @param cp
	 * 		el controlador presentacion para la applicacion
	 */
	public Frame_respuestas(Controlador_presentacion cp){
		this.cp = cp;
		init();
	}
	/**
	 * Metodo que dibuja la frame con sus buttones y sus ActionListener
	 */
	public void init() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
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
				boolean someSelected = false;
				for(int i = 0; i<selected.length; i++){
					if(selected[i] == 1)someSelected = true;
				}
				if(!someSelected){
					JOptionPane.showMessageDialog(null, "Ninguna respuesta seleccionada","Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					cp.selectedItem(selected);
					Frame_analisis ven = new Frame_analisis(cp);
					ven.setVisible(true);
					dispose();
				}
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
		
		JButton btnSeleccionarTodo = new JButton("Seleccionar todo");
		btnSeleccionarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i< items.size(); i++){
					CheckListItem item = (CheckListItem) list_1.getModel().getElementAt(i);
					item.setSelected(true); // Toggle selected state
					list_1.repaint(list_1.getCellBounds(i, i));// Repaint cell
					selected[i] = 1;
				}
			}
		});
		btnSeleccionarTodo.setBounds(154, 227, 123, 23);
		getContentPane().add(btnSeleccionarTodo);
	}
	
	/**
	 * Inner class to implement a checkbox of the list
	 * 
	 * @author Raphael
	 *
	 */
	class CheckListItem {

		  private String label;
		  private boolean isSelected = false;
		  
		  /**
		   * Creadora de la check box con su titulo
		   * 
		   * @param label
		   * 	el titulo
		   */
		  public CheckListItem(String label) {
		    this.label = label;
		  }
		  
		  /**
		   * Metodo para saber si la checkbox esta seleccionada
		   * 
		   * @return
		   * 	boolean true si la box esta seleccionada, false sino
		   */
		  public boolean isSelected() {
		    return isSelected;
		  }

		  /**
		   * Metodo para cambiar la seleccion de la check box
		   * 
		   * @param isSelected
		   * 	la nueva valor de seleccion de la checkbox
		   */
		  public void setSelected(boolean isSelected) {
		    this.isSelected = isSelected;
		  }

		  @Override
		  public String toString() {
		    return label;
		  }
	}
	
	/**
	 * Inner class that set the grafics of the list of checkboxes
	 * 
	 * @author Raphael
	 *
	 */
	class CheckListRenderer extends JCheckBox implements ListCellRenderer {
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Metodo que se crida cuando se dibuja la list de checkboxes.
		 */
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
