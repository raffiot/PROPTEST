package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import com.sun.javafx.geom.Rectangle;

import dominio.clases.RespuestaPregunta;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class Frame_contestar extends JFrame {
	
	private JPanel contentPane;
	private JButton btnSalir;
	private Controlador_presentacion cp;
	private JTextField textField;
	private JTextArea textArea;
	private String s;
	private int x = 27;
    private int y = 249;
    private int z = 108;
    private int w = 16;
	
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
	
	public Frame_contestar(Controlador_presentacion cp, String s) {
		this.s = s;
		this.cp = cp;
		initialize();
		
	}
	
	public int tipo1(Integer x_bis, Integer index){
		int min = cp.getminOpt1(index);
		int max = cp.getmaxOpt1(index);
		
		SpinnerModel sm = new SpinnerNumberModel(0, min, max, 1);
		JSpinner spinner = new JSpinner(sm);
        spinner.setBounds(x_bis, y, z, w);
        contentPane.add(spinner);
        return (int) sm.getValue();
	}
	
	public void tipo2(Integer x_bis, Integer index){
		ArrayList<String> opcions = cp.getopcionest2(index);
		SpinnerListModel model = new SpinnerListModel(opcions);
		JSpinner spinner = new JSpinner(model);
        spinner.setBounds(x_bis, y, z, w);
        contentPane.add(spinner);
        
	}
	
	public void tipo3(Integer x_bis, Integer index){
		ArrayList<String> opcions = cp.getopcionest3(index);
		SpinnerListModel model = new SpinnerListModel(opcions);
		JSpinner spinner = new JSpinner(model);
        spinner.setBounds(x_bis, y, z, w);
        contentPane.add(spinner);
	}
	
	public void tipo4(Integer x_bis,Integer index){
	    /*String[] strs = { "swing", "home", "basic", "metal", "JList" };

	    final JList list = new JList(strs);

	    list.setCellRenderer(new ListCellRenderer());
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list.setBorder(new EmptyBorder(0, 4, 0, 0));
	    list.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(MouseEvent e) {
	        int index = list.locationToIndex(e.getPoint());
	        CheckableItem item = (CheckableItem) list.getModel()
	            .getElementAt(index);
	        item.setSelected(!item.isSelected());
	        java.awt.Rectangle rect = list.getCellBounds(index, index);
	        list.repaint(rect);
	      }
	    });*/
	}
	
	public void tipo5(Integer x_bis,Integer index){
		textField = new JTextField();
        textField.setBounds(x_bis, y, z, w);
        contentPane.add(textField);
        textField.setColumns(10);
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
     
        
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cp.update();
				principal p = new principal();
				p.frame.setVisible(true);
				dispose();
        	}
        });
        btnSalir.setBounds(302, 414, 89, 23);
        contentPane.add(btnSalir);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 414, 182);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setText(s);
        scrollPane.setViewportView(textArea);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnGuardar.setBounds(49, 411, 117, 29);
        contentPane.add(btnGuardar);
        //TODO GUARDAR INFO
        
        int x_bis = x;
        
        for (int i = 0; i < cp.getnpreguntas(); ++i){
        	y += 20;
        	
        	System.out.println("funciona");
        	
        	int tipo = cp.gettipo(i); 
        	
            JLabel lblNewLabel = new JLabel("Respesta " + (i+1) + ": ");
            lblNewLabel.setBounds(x, y, z, w);
            contentPane.add(lblNewLabel);
            
            System.out.println("pregunta: " + (i+1));
            System.out.println("tipo: " + tipo);
            
        	if (tipo == 1) {
        		int res = tipo1(x_bis+120,i);
        		//retorno int per dp poder fer la respuesta pregunta per fer la respuestaEncuesta --> GUARDAR
        	}
        	else if (tipo == 2) tipo2(x_bis+120,i);
        	else if (tipo == 3) tipo3(x_bis+120,i);
        	else if (tipo == 4) tipo4(x_bis+120,i);
        	else if (tipo == 5) tipo5(x_bis+120,i);
        	
        }
	}
}
