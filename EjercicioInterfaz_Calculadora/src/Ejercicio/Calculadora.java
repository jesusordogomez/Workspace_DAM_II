package Ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;

public class Calculadora {

	private JFrame frmCalculadora;
	private JTextArea textArea;
    private String expresion = "";
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
		
		
		//creo el textArea
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 81, 196, 22);
		frmCalculadora.getContentPane().add(textArea);
		
		
		//con este metodo solo puedo teclear los caracteres que yo necesito para la calculadora
		textArea.addKeyListener(new KeyAdapter() {
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
				textArea.append("7");
				textArea.requestFocusInWindow();
			}
		});
		boton7.setBounds(33, 114, 48, 23);
		frmCalculadora.getContentPane().add(boton7);
		
		
		//creo el boton 8
		JButton boton8 = new JButton("8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("8");
				textArea.requestFocusInWindow();
			}
		});
		boton8.setBounds(104, 114, 48, 23);
		frmCalculadora.getContentPane().add(boton8);
		
		//creo el boton 9
		JButton boton9 = new JButton("9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("9");
				textArea.requestFocusInWindow();
			}
		});
		boton9.setBounds(178, 114, 48, 23);
		frmCalculadora.getContentPane().add(boton9);
		
		//creo el boton 4
		JButton boton4 = new JButton("4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("4");
				textArea.requestFocusInWindow();
			}
		});
		boton4.setBounds(33, 148, 48, 23);
		frmCalculadora.getContentPane().add(boton4);
		
		//creo el boton 5
		JButton boton5 = new JButton("5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("5");
				textArea.requestFocusInWindow();
			}
		});
		boton5.setBounds(104, 148, 48, 23);
		frmCalculadora.getContentPane().add(boton5);
		
		//creo el boton 6
		JButton boton6 = new JButton("6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("6");
				textArea.requestFocusInWindow();
			}
		});
		boton6.setBounds(178, 148, 48, 23);
		frmCalculadora.getContentPane().add(boton6);
		
		
		//creo el boton 1
		JButton boton1 = new JButton("1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("1");
				textArea.requestFocusInWindow();
			}
		});
		boton1.setBounds(33, 182, 48, 23);
		frmCalculadora.getContentPane().add(boton1);
		
		//creo el boton 2
		JButton boton2 = new JButton("2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("2");
				textArea.requestFocusInWindow();
			}
		});
		boton2.setBounds(104, 182, 48, 23);
		frmCalculadora.getContentPane().add(boton2);
		
		//creo el boton 3
		JButton boton3 = new JButton("3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("3");
				textArea.requestFocusInWindow();
			}
		});
		boton3.setBounds(178, 182, 48, 23);
		frmCalculadora.getContentPane().add(boton3);
		
		
		//creo el boton0
		JButton boton0 = new JButton("0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("0");
				textArea.requestFocusInWindow();
			}
		});
		boton0.setBounds(33, 216, 48, 23);
		frmCalculadora.getContentPane().add(boton0);
		
		JButton coma = new JButton(",");
		coma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(",");
				textArea.requestFocusInWindow();
			}
		});
		coma.setBounds(104, 216, 48, 23);
		frmCalculadora.getContentPane().add(coma);
		
		JButton botonx = new JButton("x");
		botonx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("*");
				textArea.requestFocusInWindow();
			}
		});
		botonx.setBounds(245, 148, 48, 23);
		frmCalculadora.getContentPane().add(botonx);
		
		JButton resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("-");
				textArea.requestFocusInWindow();
			}
		});
		resta.setBounds(245, 182, 48, 23);
		frmCalculadora.getContentPane().add(resta);
		
		JButton suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("+");
				textArea.requestFocusInWindow();
			}
		});
		suma.setBounds(245, 216, 48, 23);
		frmCalculadora.getContentPane().add(suma);
		
		JButton igual = new JButton("=");
		igual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("=");
				textArea.requestFocusInWindow();
			}
		});
		igual.setBounds(178, 216, 48, 23);
		frmCalculadora.getContentPane().add(igual);
		
		JButton dividir = new JButton("/");
		dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("/");
				textArea.requestFocusInWindow();
			}
		});
		dividir.setBounds(245, 114, 48, 23);
		frmCalculadora.getContentPane().add(dividir);
		
		JButton limpia = new JButton("CE");
		limpia.setFont(new Font("Tahoma", Font.PLAIN, 7));
		limpia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.requestFocusInWindow();
			}
		});
		limpia.setBounds(245, 80, 48, 23);
		frmCalculadora.getContentPane().add(limpia);
		
		JTextArea txtrCalculadora = new JTextArea();
		txtrCalculadora.setEnabled(false);
		txtrCalculadora.setEditable(false);
		txtrCalculadora.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		txtrCalculadora.setForeground(new Color(0, 0, 0));
		txtrCalculadora.setBackground(new Color(192, 192, 192));
		txtrCalculadora.setText("CALCULADORA");
		txtrCalculadora.setBounds(75, 27, 188, 43);
		frmCalculadora.getContentPane().add(txtrCalculadora);
		
		JButton igual1 = new JButton("=");
        igual1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularExpresion();
            }
        });
        igual1.setBounds(178, 216, 48, 23);
        frmCalculadora.getContentPane().add(igual1);

        // ... (Resto del código) ...
    }

    private void calcularExpresion() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            Object result = engine.eval(expresion);
            textArea.setText(result.toString());
        } catch (ScriptException e) {
            textArea.setText("Error");
        }
    }

		
	}
	
	

