package Ejercicios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdivinarNumero {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private int numeroAdivinar;
    private int intentosRestantes;
    private boolean juegoTerminado;
    private JButton reiniciar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdivinarNumero window = new AdivinarNumero();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdivinarNumero() {
        initialize();
        iniciarJuego();
        
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!juegoTerminado) {
                        try {
                            int intento = Integer.parseInt(textField.getText());
                            verificarIntento(intento);
                        } catch (NumberFormatException ex) {
                            textArea.setText("Ingresa un número válido.");
                        }
                    }
                }
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 255, 128));
        frame.setBounds(100, 100, 489, 242);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(154, 57, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton jugar = new JButton("Jugar");
        jugar.setBounds(250, 56, 71, 23);
        frame.getContentPane().add(jugar);
        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!juegoTerminado) {
                    try {
                        int intento = Integer.parseInt(textField.getText());
                        verificarIntento(intento);
                    } catch (NumberFormatException ex) {
                        textArea.setText("Ingresa un número válido.");
                    }
                }
            }
        });

        reiniciar = new JButton("Reiniciar");
        reiniciar.setVisible(false);
        reiniciar.setBounds(187, 148, 89, 23);
        frame.getContentPane().add(reiniciar);
        reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        textArea = new JTextArea();
        textArea.setBounds(21, 107, 413, 34);
        frame.getContentPane().add(textArea);
    }

    private void iniciarJuego() {
        numeroAdivinar = new Random().nextInt(101); // Genera un número aleatorio del 0 al 100
        intentosRestantes = 10; // Número de intentos permitidos
        juegoTerminado = false;
        textArea.setText("Adivina un número del 0 al 100. Tienes " + intentosRestantes + " intentos.");
        reiniciar.setVisible(false);
        frame.getContentPane().setBackground(new Color(255, 255, 128));
    }

    private void verificarIntento(int intento) {
        if (intento < 0 || intento > 100) {
            textArea.setText("El número debe estar entre 0 y 100.");
            return;
        }

        intentosRestantes--;

        if (intento == numeroAdivinar) {
            textArea.setText("¡Felicitaciones! Has adivinado el número " + numeroAdivinar + " en " + (10 - intentosRestantes) + " intentos.");
            juegoTerminado = true;
            reiniciar.setVisible(true);
            frame.getContentPane().setBackground(new Color(20, 90, 50));
        } else if (intentosRestantes == 0) {
            textArea.setText("¡Agotaste tus intentos! El número era " + numeroAdivinar + ". Presiona Reiniciar para jugar de nuevo.");
            juegoTerminado = true;
            reiniciar.setVisible(true);
            frame.getContentPane().setBackground(new Color(146, 43, 33));
        } else if (intento < numeroAdivinar) {
            textArea.setText("El número " + intento + " es mayor. Intentos restantes: " + intentosRestantes);
        } else {
            textArea.setText("El número " + intento + " es menor. Intentos restantes: " + intentosRestantes);
        }

        textField.setText("");
    }
}