package prueba;

import javax.swing.*;
import java.awt.*;

public class prueba {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	JFrame ventana = new JFrame("Titulo_ventanta");
	ventana.setBackground(new Color(255, 255, 255));
	ventana.setVisible(true);
	
	ventana.setSize(600, 400);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 255, 255));
	ventana.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel etiqueta = new JLabel();
	etiqueta.setBounds(306, 5, 171, 14);
	etiqueta.setBackground(new Color(255, 255, 255));
	etiqueta.setText("Primera prueba con jframes de java");
	
	panel.add(etiqueta);
	
	JRadioButton boton1 = new JRadioButton("New radio button");
	boton1.setBounds(24, 205, 109, 23);
	panel.add(boton1);
	
	JRadioButton boton2 = new JRadioButton("New radio button");
	boton2.setBounds(410, 126, 109, 23);
	panel.add(boton2);
	

	
	
	}
}
