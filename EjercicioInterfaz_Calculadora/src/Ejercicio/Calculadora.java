package Ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;

public class Calculadora {

	private JFrame frmCalculadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("CALCULADORA");
		frmCalculadora.getContentPane().setBackground(new Color(192, 192, 192));
		frmCalculadora.setBounds(100, 100, 332, 300);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 47, 260, 22);
		frmCalculadora.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setBounds(33, 114, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setBounds(104, 114, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setBounds(178, 114, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(33, 148, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("5");
		btnNewButton_3_1.setBounds(104, 148, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("6");
		btnNewButton_3_2.setBounds(178, 148, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("1");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_3.setBounds(33, 182, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("2");
		btnNewButton_3_4.setBounds(104, 182, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_4);
		
		JButton btnNewButton_3_5 = new JButton("3");
		btnNewButton_3_5.setBounds(178, 182, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_5);
		
		JButton btnNewButton_3_6 = new JButton("boton");
		btnNewButton_3_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_6.setBounds(33, 216, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_6);
		
		JButton btnNewButton_3_7 = new JButton("0");
		btnNewButton_3_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_7.setBounds(104, 216, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_7);
		
		JButton btnNewButton_3_8 = new JButton(",");
		btnNewButton_3_8.setBounds(178, 216, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_8);
		
		JButton btnNewButton_3_9 = new JButton("x");
		btnNewButton_3_9.setBounds(245, 114, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_9);
		
		JButton btnNewButton_3_10 = new JButton("-");
		btnNewButton_3_10.setBounds(245, 148, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_10);
		
		JButton btnNewButton_3_11 = new JButton("+");
		btnNewButton_3_11.setBounds(245, 182, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_11);
		
		JButton btnNewButton_3_12 = new JButton("=");
		btnNewButton_3_12.setBounds(245, 216, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_3_12);
		
		JButton btnBoton = new JButton("boton");
		btnBoton.setBounds(33, 80, 48, 23);
		frmCalculadora.getContentPane().add(btnBoton);
		
		JButton btnX = new JButton("xº");
		btnX.setBounds(104, 80, 48, 23);
		frmCalculadora.getContentPane().add(btnX);
		
		JButton btnNewButton_6 = new JButton("/");
		btnNewButton_6.setBounds(178, 80, 48, 23);
		frmCalculadora.getContentPane().add(btnNewButton_6);
		
		JButton btnCe = new JButton("CE");
		btnCe.setBounds(245, 80, 48, 23);
		frmCalculadora.getContentPane().add(btnCe);
		
		JTextArea txtrCalculadora = new JTextArea();
		txtrCalculadora.setEditable(false);
		txtrCalculadora.setFont(new Font("Sitka Heading", Font.BOLD, 21));
		txtrCalculadora.setForeground(new Color(0, 0, 0));
		txtrCalculadora.setBackground(new Color(192, 192, 192));
		txtrCalculadora.setText("CALCULADORA");
		txtrCalculadora.setBounds(96, 11, 152, 22);
		frmCalculadora.getContentPane().add(txtrCalculadora);
	}
}
