package Ejercicios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio3_EventosGUI {

	public static void main(String[] args) {
		// Crear el marco principal
		JFrame frame = new JFrame("Fecha/Horario");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		JButton boton = new JButton("Mostrar Fecha");

		boton.addActionListener((ActionEvent e) -> {
			Date fecha = new Date();

			//  Esta clase permite convertir objetos Date a cadenas de texto 
			//con un formato específico y viceversa.
			SimpleDateFormat formatoFecha = new SimpleDateFormat("EEE HH:mm 'del' dd 'de' MMMM 'de' yyyy");
			String mensaje = formatoFecha.format(fecha);

			JOptionPane.showMessageDialog(frame, "La fecha actual es:\n" + mensaje + "\nFeliz Navidad");
		});

		panel.add(boton);
		frame.add(panel);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}