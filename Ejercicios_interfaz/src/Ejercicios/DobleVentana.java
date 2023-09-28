package Ejercicios;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DobleVentana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DobleVentana window = new DobleVentana();
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
	public DobleVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 301, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton boton1 = new JButton("Ventana 2");
		boton1.setBackground(new Color(255, 255, 128));
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentana2();			
			}
		});
		boton1.setBounds(69, 87, 147, 69);
		frame.getContentPane().add(boton1);
	}
    private void abrirVentana2() {
        // Crear la segunda ventana como un JDialog modal
        JDialog ventana2 = new JDialog(frame);
        ventana2.setSize(200, 200);
        
        // Configurar el contenido de la segunda ventana
        ventana2.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,150,125));
        JLabel  label = new JLabel(" =)");
        ventana2.getContentPane().add(label);

        // Mostrar la segunda ventana 
        ventana2.setVisible(true);
    }

}
