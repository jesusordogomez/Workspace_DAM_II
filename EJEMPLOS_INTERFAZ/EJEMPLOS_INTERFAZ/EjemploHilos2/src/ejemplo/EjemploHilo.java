package ejemplo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EjemploHilo extends JFrame implements ActionListener {

    private Mario mario;
    private List<Obstaculos> obstaculo;

    public static void main(String[] args) {
        new EjemploHilo();
    }

    public EjemploHilo() {
        // Configuraci�n del JFrame
        setTitle("Super Mario Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Inicializar Mario
        mario = new Mario();
        this.add(mario);

        // Inicializar obst�culos
        obstaculo = new ArrayList<>();
        Obstaculos obstaculo1 = new Obstaculos(600, 400, 50, 50);
        Obstaculos obstaculo2 = new Obstaculos(800, 350, 50, 50);
        obstaculo.add(obstaculo1);
        obstaculo.add(obstaculo2);
        for (Obstaculos obstaculo : obstaculo) {
            this.add(obstaculo);
        }

        // Configurar un temporizador para la animaci�n del juego
        Timer timer = new Timer(10, this);
        timer.start();

        // Configurar el fondo del JFrame
        getContentPane().setBackground(new Color(135, 206, 250));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // L�gica de actualizaci�n del juego (movimientos, colisiones, etc.)

        // Mover a Mario
        mario.mover();

        // Mover obst�culos
        for (Obstaculos obstaculo : obstaculo) {
            obstaculo.mover();
        }

        // Puedes agregar l�gica adicional aqu�, como verificar colisiones

        // Repintar el JFrame
        repaint();
    }
}
