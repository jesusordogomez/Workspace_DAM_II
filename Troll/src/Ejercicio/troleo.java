package Ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class troleo {

	private JFrame frame;
	JButton boton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					troleo window = new troleo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public troleo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//hola
	
	private void initialize() {
		
		//creo el jframe
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//aqui hago que la ventana no se pueda cerrar dandole a la x
		//le doy un color y unas dimensiones especificas
		frame.getContentPane().setBackground(new Color(87, 87, 87));
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setResizable(false);//con el metodo resizable desactivo la capacidad de cambiar la dimension de la ventana
		frame.pack();// con el pack me aseguro de que no se pueda redimensionar la ventana
		frame.setVisible(true);
		frame.setTitle("Troleo");		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//me creo el boton con un texto, unas dimensiones y un color especifico
		boton = new JButton();
		boton.setBounds(222, 194, 150, 50);
		boton.setText("¿Jugamos?");
		boton.setBackground(new Color(202, 202, 202));
		frame.getContentPane().add(boton);
		
		JTextArea TextArea = new JTextArea();
		TextArea.setEnabled(false);
		TextArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		TextArea.setBounds(176, 40, 267, 50);
		frame.getContentPane().add(TextArea);
		TextArea.setBackground(new Color(87, 87, 87));
		TextArea.setText("PARA CERRAR TIENES QUE PULSAR");
		
		//con el metodo mouselistener implemento un par de metodos para manejar el raton
		boton.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();//con el dispose() lo que hace que cuando cliques el boton de la ventana se pueda cerrar el jframe
			}


			@Override
			public void mouseEntered(MouseEvent e) {//con este metodo interactuo con el raton y hago un random para que el boton se vaya moviendo
				// TODO Auto-generated method stub
				Random r = new Random();//
				boton.setBounds(r.nextInt(0,350),r.nextInt(0,350), 75, 40);
				boton.setText("Salir");
				
			}
		});

    }
}
