package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dominio.controladores.Controlador_dominio;

import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Frame_importar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private JTextArea textArea;
    private JButton btnImportar;
    
    private Controlador_dominio cd;
    private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_importar frame = new Frame_importar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_importar(Controlador_dominio cd){
		this.cd = cd;
		init();
	}
	
	public Frame_importar(){
		init();
	}
	
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 textField = new JTextField();
	        textField.setToolTipText("Inserta la ruta del fichero encuesta");
	        textField.setBounds(36, 12, 209, 20);
	        contentPane.add(textField);
	        textField.setColumns(10);
	 
	        JButton btnSeleccionar = new JButton("Browse...");
	        btnSeleccionar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JFileChooser fc=new JFileChooser();
	        		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        		 
	        		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	        		int seleccion=fc.showOpenDialog(contentPane);
	        		 
	        		//Si el usuario, pincha en aceptar
	        		if(seleccion==JFileChooser.APPROVE_OPTION){
	        		 
	        		    //Seleccionamos el fichero
	        		    File fichero=fc.getSelectedFile();
	        		 
	        		    //Ecribe la ruta del fichero seleccionado en el campo de texto
	        		    textField.setText(fichero.getAbsolutePath());
	        		 
	        		    try(FileReader fr=new FileReader(fichero)){
	        		        String cadena="";
	        		        int valor=fr.read();
	        		        while(valor!=-1){
	        		            cadena=cadena+(char)valor;
	        		            valor=fr.read();
	        		        }
	        		        textArea.setText(cadena);
	        		    } catch (IOException e1) {
	        		        e1.printStackTrace();
	        		    }
	        		    //Creamos el filtro
	        		    FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
	        		     
	        		    //Le indicamos el filtro
	        		    fc.setFileFilter(filtro);
	        		}
	        		
	        		
	        	}
	        });
	        btnSeleccionar.setBounds(272, 11, 109, 23);
	        contentPane.add(btnSeleccionar);
	 
	        textArea = new JTextArea();
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setBounds(52, 76, 360, 156);
	 
	        JScrollPane scroll=new JScrollPane(textArea);
	        scroll.setBounds(36, 62, 360, 156);
	        contentPane.add(scroll);
	        
	        btnImportar = new JButton("Importar");
	        btnImportar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (textField.getText() == "") JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo"
							,"Error", JOptionPane.ERROR_MESSAGE);
	        	
	        	else {
	        		String s = textField.getText();
	        		cd.importar(s);
	        		textField.setText("");
	        		textArea.setText("");
	        		
	        	}
	        		
	        	}
	        });
	        btnImportar.setBounds(335, 229, 89, 23);
	        contentPane.add(btnImportar);
	        
	        btnNewButton = new JButton("Salir");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Frame_admin ven = new Frame_admin(cd);
	        		ven.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton.setBounds(22, 229, 89, 23);
	        contentPane.add(btnNewButton);
	 
	        
	 
	}
}
