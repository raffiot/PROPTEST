package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dominio.clases.Pregunta;
import dominio.clases.Tipo_1;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Frame_contestar extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    private Integer sp1 = 0;
    private String sp2;
    private String sp3;
    ArrayList<Integer> selected = new ArrayList<Integer>();
    ArrayList<String> items = new ArrayList<String>();
    private JSpinner spinner;
	
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
        
        //cada pos de los arrays es la misma pregunta-respuesta 
        int[] tiposPreg = new int[cp.getnpreguntas()];
        String[] respPreg = new String[cp.getnpreguntas()];
        
        for (int i = 0; i < cp.getnpreguntas(); ++i){
        	y += 20;
        	
        	System.out.println("funciona");
        	
        	int tipo = cp.gettipo(i); 
        	
            JLabel lblNewLabel = new JLabel("Respuesta " + (i+1) + ": ");
            lblNewLabel.setBounds(x, y, z, w);
            contentPane.add(lblNewLabel);
            
            System.out.println("pregunta: " + (i+1));
            System.out.println("tipo: " + tipo);
            
        	if (tipo == 1) {
        		int index = i;
        		tiposPreg[i] = tipo;
        		
        		int min = cp.getminOpt1(i);
        		int max = cp.getmaxOpt1(i);
        		System.out.println("--------------------------" + min + " MAX: " + max);
        		
        		
        		SpinnerModel sm = new SpinnerNumberModel(0, min, max, 1);
        		spinner = new JSpinner(sm);
                spinner.setBounds(x+120, y, z, w);
                spinner.addChangeListener(new ChangeListener() {
        			public void stateChanged(ChangeEvent e) {
        				sp1 = (int)spinner.getValue();
        				respPreg[index] = sp1.toString(); //comprobar
        				 System.out.println(respPreg[index]);
        				//System.out.println("SPINNER 1 :"+ respPreg[index]);
        			}
        		});
                contentPane.add(spinner);
                
        	}
        	else if (tipo == 2){
        		int index = i;
        		tiposPreg[i] = tipo;
        		
        		ArrayList<String> opcions = cp.getopcionest2(index);
        		SpinnerListModel model = new SpinnerListModel(opcions);
        		JSpinner spinner = new JSpinner(model);
                spinner.setBounds(x+120, y, z, w);
                spinner.addChangeListener(new ChangeListener() {
        			public void stateChanged(ChangeEvent e) {
        				sp2 = (String)spinner.getValue();
        				respPreg[index] = sp2.toString(); //comprobar
        				 System.out.println(respPreg[index]);
        			}
        		});
                contentPane.add(spinner);
        	}
        	else if (tipo == 3) {
        		int index = i;
        		tiposPreg[i] = tipo;
        		
        		ArrayList<String> opcions = cp.getopcionest3(index);
        		SpinnerListModel model = new SpinnerListModel(opcions);
        		JSpinner spinner = new JSpinner(model);
                spinner.setBounds(x+120, y, z, w);
                spinner.addChangeListener(new ChangeListener() {
        			public void stateChanged(ChangeEvent e) {
        				sp3 = (String)spinner.getValue();
        				respPreg[index] = sp3.toString(); //comprobar
        				 System.out.println(respPreg[index]);
        			}
        		});
                contentPane.add(spinner);
        	}
        	else if (tipo == 4) {
        		tiposPreg[i] = tipo;
        		items = cp.getopcionest4(i);
        		for (int h = 0; h < items.size(); ++h) {
        			int n = 0;
        			selected.add(h,n);
        			System.out.println("INICIALITZACIO");
        		}
        		
        		int aux = x+120;
        		int index = i;
        		for (int m = 0; m < items.size(); ++m){
        			System.out.println("SPINNER 4 " + m + " :"+ items.get(m).toString());
        			JCheckBox chckbxNewCheckBox = new JCheckBox(items.get(m).toString());
	                chckbxNewCheckBox.setBounds(aux, y, z, w);
	                int n = m;
	       
	                chckbxNewCheckBox.addChangeListener(new ChangeListener() {
	        			public void stateChanged(ChangeEvent e) {
	        			
	        				if(chckbxNewCheckBox.isBackgroundSet()){
	        					System.out.println(selected.get(n));
	        					if (selected.get(n)==0){
	        						//System.out.println("SELECCIONADO");
	        						selected.set(n,1);
	        					}
	        					else if (selected.get(n)==1){
	        						selected.set(n,0);
	        						//System.out.println("--- NO SELECCIONADO---");
	        					}
	        				}
	        				
	        				JButton btnOK = new JButton("OK Tipo 4");
	        	            btnOK.addActionListener(new ActionListener() {
	        	            	public void actionPerformed(ActionEvent e) {
	        	            		String aux1 = "";
	        	            		for (int l = 0; l < selected.size();++l){
	        	            			if(selected.get(l)==1){
	        	            				System.out.println(items.get(l));
	        	            				if(aux1.isEmpty()) aux1 = items.get(l)+',';
	        	            				else aux1+=items.get(l)+',';
	        	            			}
	        	            		}
	        	            		System.out.println(aux1 + " " + index);
	        	            		respPreg[index] = aux1;
	        	            		 System.out.println(respPreg[index]);
	        	            		
	        	            	}
	        	            });
	        	            
	        	            btnOK.setBounds(400,y , z, w);
	        	            contentPane.add(btnOK);
	        	            
	        				System.out.println(selected);
	        			}
	        		});
	                contentPane.add(chckbxNewCheckBox);
	                aux+=100;
	                
        		}
        		
        	}
        	else if (tipo == 5) {
        		tiposPreg[i] = tipo;
        		textField = new JTextField();
                textField.setBounds(x+120, y, 200, w);
                contentPane.add(textField);
                textField.setColumns(10);
                respPreg[i] = textField.toString();
                System.out.println(respPreg[i]);
        	}
        	
        }
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		for(int q = 0; q < tiposPreg.length;++q){
        			Pregunta p = cp.getPreguntaiessima(q);
        			if (tiposPreg[q] == 1){
        				
        				
        			}
        			if (tiposPreg[q] == 2){
        				
        			}
        			if (tiposPreg[q] == 3){
        				
        			}
        			if (tiposPreg[q] == 4){
        				
        			}
        			if (tiposPreg[q] == 5){
        				
        			}
        			
        			
        		}

        		
        	}
        });
        btnGuardar.setBounds(173, 411, 117, 29);
        contentPane.add(btnGuardar);
        
        JButton btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Panel_usuario usu = new Panel_usuario(cp);
				usu.setVisible(true);
				dispose();
        	}
        });
        btnAtras.setBounds(49, 411, 117, 29);
        contentPane.add(btnAtras);
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
