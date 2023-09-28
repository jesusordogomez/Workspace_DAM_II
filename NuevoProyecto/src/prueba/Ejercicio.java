package prueba;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Ejercicio {

	private JFrame frame;


		JButton boton1;
		JButton boton2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio window = new Ejercicio();
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
	public Ejercicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton boton1 = new JButton("Boton 1");
		boton1.setBackground(new Color(255, 128, 0));
		frame.getContentPane().add(boton1, BorderLayout.WEST);

		JButton boton2 = new JButton("Boton 2");
		boton2.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(boton2, BorderLayout.EAST);
		
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boton1.setEnabled(false);
			boton2.setEnabled(true);
			boton1.setBackground(new Color(255, 255, 255));
			boton2.setBackground(new Color(0, 128, 0));

	}
		});
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boton2.setEnabled(false);
			boton1.setEnabled(true);
			boton2.setBackground(new Color(255, 255, 255));
			boton1.setBackground(new Color(255, 128, 0));
			
	}			
		});
}
}
