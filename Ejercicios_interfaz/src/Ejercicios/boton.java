package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class boton {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boton window = new boton();
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
	public boton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 312, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(56, 33, 192, 32);
		frame.getContentPane().add(textArea);
		
		
		//metodo para pulsar las teclas que yo quiero que se pulse                                                                           		
		textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c != '1' && c != '2' && c != '3') {
                    e.consume(); // Evitar que se escriba el carácter no permitido
                }
            }
        });
		
		
		/*aqui empiezo a crear los tres botones*/
		JButton boton1 = new JButton("Pulse/teclea 1");	
		boton1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
                textArea.append("1");				
			}
		});
		boton1.setBackground(new Color(255, 255, 128));
		boton1.setBounds(96, 86, 114, 34);
		frame.getContentPane().add(boton1);
		
		//boton y tecla 2
		
		JButton boton2 = new JButton("Pulse/teclea 2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("2");
			}
		});
		boton2.setBackground(new Color(128, 255, 255));
		boton2.setBounds(96, 131, 114, 34);
		frame.getContentPane().add(boton2);
		
		//boton y tecla 3
		
		JButton boton3 = new JButton("Pulse/teclea 3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("3");
			}
		});
		boton3.setBackground(new Color(255, 128, 128));
		boton3.setBounds(96, 176, 114, 34);
		frame.getContentPane().add(boton3);
		
		//boton reiniciar textArea
		
		JButton reiniciar = new JButton("Limpiar");
		reiniciar.setBackground(new Color(255, 0, 0));
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                textArea.setText(""); 
            }
		});
		reiniciar.setBounds(106, 221, 94, 23);
		frame.getContentPane().add(reiniciar);
				

	}

}
