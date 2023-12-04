package ejemplo;


import javax.swing.*;
import java.awt.*;

public class Obstaculos extends JLabel {

    private int velocidadX;

    public Obstaculos(int x, int y, int width, int height) {
        setIcon(new ImageIcon(getClass().getResource("/imagenes/pelota2.png")));
        setBounds(x, y, width, height);
        velocidadX = -2; // Velocidad inicial en el eje X
    }

    public void mover() {
        setLocation(getX() + velocidadX, getY());

        // Lógica para reiniciar el obstáculo cuando se sale del borde izquierdo de la pantalla
   
        }
    }


