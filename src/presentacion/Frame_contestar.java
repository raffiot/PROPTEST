package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dominio.clases.Main;
import dominio.clases.Pregunta;
import dominio.clases.RespuestaEncuesta;
import dominio.clases.RespuestaPregunta;
import dominio.clases.Respuesta_1;
import dominio.clases.Respuesta_2;
import dominio.clases.Respuesta_3;
import dominio.clases.Respuesta_4;
import dominio.clases.Respuesta_5;
import dominio.clases.Tipo_1;
import dominio.clases.Tipo_2;

import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame_contestar extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalir;
	private Controlador_presentacion cp;
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
    private JTextField txt_t5;
	
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
	
	public void init(String [] respPreg){
		for ( int r = 0; r < respPreg.length;++r) respPreg[r]= "pop";
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
		setLocationRelativeTo(null);
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
        textArea.setEditable(false);
        textArea.setText(s);
        scrollPane.setViewportView(textArea);
        
        //cada pos de los arrays es la misma pregunta-respuesta 
        int[] tiposPreg = new int[cp.getnpreguntas()];
        String[] respPreg = new String[cp.getnpreguntas()];
        init(respPreg);
        
        for (int i = 0; i < cp.getnpreguntas(); ++i){
        	y += 20;
        	
        	int tipo = cp.gettipo(i); 
        	
            JLabel lblNewLabel = new JLabel("Respuesta " + (i+1) + ": ");
            lblNewLabel.setBounds(x, y, z, w);
            contentPane.add(lblNewLabel);
            
        	if (tipo == 1) {
        		int index = i;
        		tiposPreg[i] = tipo;
        		
        		int min = cp.getminOpt1(i);
        		int max = cp.getmaxOpt1(i);
        		
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
        		}
        		
        		int aux = x+120;
        		int index = i;
        		for (int m = 0; m < items.size(); ++m){
        			JCheckBox chckbxNewCheckBox = new JCheckBox(items.get(m).toString());
	                chckbxNewCheckBox.setBounds(aux, y, z, w);
	                int n = m;
	       
	                chckbxNewCheckBox.addChangeListener(new ChangeListener() {
	        			public void stateChanged(ChangeEvent e) {
	        				JButton btnOK = new JButton("OK Tipo 4");
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
                txt_t5 = new JTextField();
                txt_t5.setBounds(96, 313, 284, 26);
                txt_t5.setColumns(10);
                int index = i;
                System.out.println(txt_t5.getText());
                txt_t5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						respPreg[index] = txt_t5.getText();
						
					}
                });
                /*JButton btnTipo = new JButton("tipo5");
                btnTipo.setBounds(81, 291, 117, 29);
                contentPane.add(btnTipo);
                int index = i;
	            btnTipo.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	            		respPreg[index] = txt_t5.getText();
                		System.out.println(txt_t5.getText()+ "-----------!!-------!!!");
	            		
	            	}
	            });
	            btnTipo.setBounds(500,y , z, w);*/
                
                contentPane.add(txt_t5);
                }
                
        }
        
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean nocomplete = false;
        		RespuestaPregunta r=null;
        		List<RespuestaPregunta> rp = new ArrayList<RespuestaPregunta>();
        		for(int q = 0; q < respPreg.length;++q){
	        		if(respPreg[q].equals("pop") || respPreg[q].equals("")){
	        			System.out.println("falta la " + (q+1));
	        			nocomplete=true;
	        		}
	        		else{
	        			//Pregunta p = cp.getPreguntaiessima(q);
	        			if (tiposPreg[q] == 1){
	        				System.out.println(respPreg[q]+"----------------1");
	        				//r = new Respuesta_1(p,(double) Integer.parseInt(respPreg[q]));
	        				cp.crearresp1(q,(double) Integer.parseInt(respPreg[q]));
	        			}
	        			else if (tiposPreg[q] == 2){
	        				int k = cp.getPosicion(p,respPreg[q],q);
	        				System.out.println(respPreg[q]+"----------------2 " + k);
	    					r = new Respuesta_2(p,k);
	    					cp.crearresp2(q,(double) Integer.parseInt(respPreg[q]));
	        			}
	        			else if (tiposPreg[q] == 3){
	        				System.out.println(respPreg[q]+"----------------3");
	        				r = new Respuesta_3(p,respPreg[q]);
	        			}
	        			else if (tiposPreg[q] == 4){
	        				Set<String> set = new HashSet<String>(Arrays.asList(respPreg[q].split(" ")));
	        				System.out.println(respPreg[q]+"----------------4");
	        				r = new Respuesta_4(p,set);
	        			}
	        			else if (tiposPreg[q] == 5){
	        				System.out.println(respPreg[q]+"----------------5");
	        				r = new Respuesta_5(p,respPreg[q]);
	        			}
	        			//rp.add(r);
	        		}
        		}
        		if (nocomplete) {
        			cp.guardarRespuestaEncNoAcabada(rp);
        			System.out.println("NO ACABADA");
        			System.out.println(rp);
        		}
        		else if (!nocomplete) cp.guardarRespuestaEnc(rp);
        		JOptionPane.showMessageDialog(null, "¡Respuestas guardadas!","Success", JOptionPane.INFORMATION_MESSAGE);
				Panel_usuario p = new Panel_usuario(cp);
				p.setVisible(true);
				dispose();
        	}
        });
        btnGuardar.setBounds(173, 411, 117, 29);
        contentPane.add(btnGuardar);
        
        JButton btnAtras = new JButton("Atras");
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
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
