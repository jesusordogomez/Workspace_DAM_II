package Ejercicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


		public class prueba extends JFrame {
		    private JButton botonCerrar;

		    public prueba() {
		        setTitle("Ventana No Cerrable");
		        setSize(300, 200);
		        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		        botonCerrar = new JButton("Cerrar");
		        botonCerrar.addActionListener((ActionListener) new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                cerrarVentana();
		            }
		        });

		        add(botonCerrar, BorderLayout.CENTER);

		        addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent e) {
		                cerrarVentana();
		            }
		        });
		    }

		    private void cerrarVentana() {
		        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar la ventana?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		            dispose(); // Cierra la ventana
		        }
		    }
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					prueba ventana = new prueba();
		                ventana.setVisible(true);
					
				}
			});
		}

		}

