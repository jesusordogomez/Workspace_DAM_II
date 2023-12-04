package hola;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class RunnerOne extends JFrame implements ActionListener, KeyListener {
    public static int FRAME_WIDTH = 1080;
    public static int FRAME_HEIGHT = 480;
    public static int MID_SCREEN = FRAME_WIDTH / 2;

    public final int DELAY = 10;

    private Background background;
    private Timer timer;
    private BufferedImage buffer;

    private Player player;

    private boolean leftKeyPressed = false;
    private boolean rightKeyPressed = false;

    public RunnerOne() {
        setTitle("RunnerONE");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        background = new Background("image/fondofinal.jpg");
        buffer = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        player = new Player(Player.Yoda, new Point(50, 410));

        // timer
        timer = new Timer(DELAY, this);
        timer.start();

        // Agregar el KeyListener a la ventana
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics bufferGraphics = buffer.getGraphics();

        // Dibuja la mitad izquierda o derecha de la imagen de fondo según la posición del jugador
        if (player.getX() > MID_SCREEN) {
            bufferGraphics.drawImage(background.getImageBackground(), -(player.getX() - MID_SCREEN), 0, this);
        } else {
            bufferGraphics.drawImage(background.getImageBackground(), 0, 0, this);
        }

        g.drawImage(buffer, 0, 0, this);

        g.drawImage(player.getImagePlayer(), player.getX(), player.getY(), null);
    }

    public void updateGame() {
        background.updateBackground();
        player.updatePlayer();

        // Manejar el movimiento del jugador y la imagen de fondo
        if (leftKeyPressed) {
            player.moveLeft();
            if (player.getX() > MID_SCREEN) {
                background.moveLeft();
            }
        } else if (rightKeyPressed) {
            player.moveRight();
            if (player.getX() > MID_SCREEN) {
                background.moveRight();
            }
        }
    }

    public static void main(String[] args) {
        // Swing debe ejecutarse en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            new RunnerOne();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint();
    }

    // Implementar métodos de KeyListener

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftKeyPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            leftKeyPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightKeyPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No es necesario para este ejemplo
    }
}