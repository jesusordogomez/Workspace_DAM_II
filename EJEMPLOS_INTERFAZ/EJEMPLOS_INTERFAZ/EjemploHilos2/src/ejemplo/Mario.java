package ejemplo;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mario extends JLabel implements KeyListener {

    private int velocidadX;
    private int velocidadY;

    public Mario() {
        setIcon(new ImageIcon(getClass().getResource("/imagenes/jugador.png")));
        setBounds(50, 400, 50, 50);
        velocidadX = 0;
        velocidadY = 0;
        addKeyListener(this);
        setFocusable(true);
    }

    public void mover() {
        setLocation(getX() + velocidadX, getY() + velocidadY);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            velocidadX = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            velocidadX = 5;
        }

        if (key == KeyEvent.VK_UP) {
            velocidadY = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            velocidadY = 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            velocidadX = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            velocidadY = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No es necesario implementar este método, pero la interfaz KeyListener lo requiere
    }
}