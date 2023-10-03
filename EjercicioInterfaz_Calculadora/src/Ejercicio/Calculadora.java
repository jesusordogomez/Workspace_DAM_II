package Ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Calculadora {

	private JFrame frmCalculadora;
	private String recogerOperaciones;
	private JTextField textfield;
	private JButton igual;

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
		frmCalculadora.setBounds(100, 100, 345, 275);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);


		//creo el textArea
		textfield = new JTextField();
		textfield.setBounds(33, 37, 205, 31);
		Font fuente = new Font("Arial", Font.BOLD, 20);
		textfield.setFont(fuente);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		frmCalculadora.getContentPane().add(textfield);


		//con este metodo solo puedo teclear los caracteres que yo necesito para la calculadora
		textfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != '/' && c != '=' && c!='.') {
					e.consume(); 
				}
			}
		});


		//creo el boton7
		JButton boton7 = new JButton("7");
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "7");
				textfield.requestFocusInWindow();
			}
		});
		boton7.setBounds(33, 73, 61, 31);
		frmCalculadora.getContentPane().add(boton7);


		//creo el boton 8
		JButton boton8 = new JButton("8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "8");
				textfield.requestFocusInWindow();
			}
		});
		boton8.setBounds(107, 73, 64, 31);
		frmCalculadora.getContentPane().add(boton8);

		//creo el boton 9
		JButton boton9 = new JButton("9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "9");
				textfield.requestFocusInWindow();
			}
		});
		boton9.setBounds(181, 73, 57, 31);
		frmCalculadora.getContentPane().add(boton9);

		//creo el boton 4
		JButton boton4 = new JButton("4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "4");
				textfield.requestFocusInWindow();
			}
		});
		boton4.setBounds(33, 110, 61, 31);
		frmCalculadora.getContentPane().add(boton4);

		//creo el boton 5
		JButton boton5 = new JButton("5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "5");
				textfield.requestFocusInWindow();
			}
		});
		boton5.setBounds(107, 110, 64, 31);
		frmCalculadora.getContentPane().add(boton5);

		//creo el boton 6
		JButton boton6 = new JButton("6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "6");
				textfield.requestFocusInWindow();
			}
		});
		boton6.setBounds(181, 110, 57, 31);
		frmCalculadora.getContentPane().add(boton6);


		//creo el boton 1
		JButton boton1 = new JButton("1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "1");
				textfield.requestFocusInWindow();
			}
		});
		boton1.setBounds(33, 152, 61, 31);
		frmCalculadora.getContentPane().add(boton1);

		//creo el boton 2
		JButton boton2 = new JButton("2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "2");
				textfield.requestFocusInWindow();
			}
		});
		boton2.setBounds(107, 152, 64, 31);
		frmCalculadora.getContentPane().add(boton2);

		//creo el boton 3
		JButton boton3 = new JButton("3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "3");
				textfield.requestFocusInWindow();
			}
		});
		boton3.setBounds(181, 152, 57, 31);
		frmCalculadora.getContentPane().add(boton3);


		//creo el boton0
		JButton boton0 = new JButton("0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + "0");
				textfield.requestFocusInWindow();
			}
		});
		boton0.setBounds(33, 194, 61, 31);
		frmCalculadora.getContentPane().add(boton0);

		JButton coma = new JButton(",");
		coma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText(textfield.getText() + ",");
				textfield.requestFocusInWindow();
			}
		});
		coma.setBounds(107, 194, 64, 31);
		frmCalculadora.getContentPane().add(coma);

		JButton botonx = new JButton("x");
		botonx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerOperaciones = "*";
				textfield.setText(textfield.getText() + "*");
				textfield.requestFocusInWindow();
			}
		});
		botonx.setBounds(248, 110, 61, 31);
		frmCalculadora.getContentPane().add(botonx);

		JButton resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerOperaciones = "-";
				textfield.setText(textfield.getText() + "-");
				textfield.requestFocusInWindow();
			}
		});
		resta.setBounds(245, 152, 64, 31);
		frmCalculadora.getContentPane().add(resta);

		
		
		JButton suma = new JButton("+");
		suma.setBounds(248, 194, 61, 31);
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerOperaciones = "+";
				textfield.setText(textfield.getText() + "+");
				textfield.requestFocusInWindow();
			}
		});
		frmCalculadora.getContentPane().add(suma);

		
		
		
		JButton dividir = new JButton("/");
		dividir.setBounds(248, 73, 61, 31);
		dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerOperaciones = "/";
				textfield.setText(textfield.getText() + "/");
				textfield.requestFocusInWindow();
			}
		});
		frmCalculadora.getContentPane().add(dividir);

		
		
		
		JButton limpia = new JButton("CE");
		limpia.setFont(new Font("Arial", Font.PLAIN, 7));
		limpia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield.setText("");
				textfield.requestFocusInWindow();
			}
		});
		limpia.setBounds(248, 37, 61, 31);
		frmCalculadora.getContentPane().add(limpia);
		
		igual = new JButton("=");
		igual.setBounds(181, 194, 57, 31);
		igual.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String contenido = textfield.getText();
		        String operador = "";
		        double resultado = 0.0;

		        if (contenido.contains("+")) {
		            operador = "+";
		        } else if (contenido.contains("-")) {
		            operador = "-";
		        } else if (contenido.contains("*")) {
		            operador = "*";
		        } else if (contenido.contains("/")) {
		            operador = "/";
		        }

		        if (!operador.isEmpty()) {
		            String[] calcularNumeros = contenido.split(Pattern.quote(operador));
		            if (calcularNumeros.length == 2) {
		                double num1 = Double.parseDouble(calcularNumeros[0]);
		                double num2 = Double.parseDouble(calcularNumeros[1]);

		                if (operador.equals("+")) resultado = num1 + num2;
		                else if (operador.equals("-")) resultado = num1 - num2;
		                else if (operador.equals("/")) resultado = num1 / num2;
		                else if (operador.equals("*")) resultado = num1 * num2;
		            }
		        }

		        textfield.setText(String.valueOf(resultado));
		        textfield.requestFocusInWindow();
		    }
		});
		frmCalculadora.getContentPane().add(igual);
	}

}



