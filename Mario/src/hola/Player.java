package hola;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    public static int Yoda = 0;
    public static final int STATE_IDLE = 0;
    public static final int STATE_RUN = 1;

    private Point position;
    private int type;
    private int state = STATE_IDLE;

    private int width = 32;
    private int height = 32;

    private BufferedImage[] images;
    private int currentImageIndex = 0;

    public Player(int type, Point initialPoint) {
        this.type = type;
        this.position = initialPoint;
        loadImage();
    }

    private void loadImage() {
        images = new BufferedImage[8];

        for (int i = 0; i < 8; i++) {
            try {
                String fileName = String.format("image/Yoda/Yoda00%02d.png", i + 19);
                images[i] = ImageIO.read(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int frameDelay = 5; // Ajusta este valor para controlar la velocidad de la animación
    private int frameCounter = 0;

    public void updatePlayer() {
        if (state == STATE_RUN) {
            // Actualizar el fotograma de animación
            if (frameCounter < frameDelay) {
                frameCounter++;
            } else {
                frameCounter = 0;
                if (currentImageIndex < images.length - 1) {
                    currentImageIndex++;
                } else {
                    currentImageIndex = 0;
                }
            }
        }
    }

    public BufferedImage getImagePlayer() {
        return images[currentImageIndex].getSubimage(0, 0, width, height);
    }

    public int getX() {
        return position.x;
    }

    public int getY() {
        return position.y;
    }

    public Point getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void moveLeft() {
        position.x -= 5; // Puedes ajustar la velocidad del movimiento
    }

    public void moveRight() {
        position.x += 5; // Puedes ajustar la velocidad del movimiento
    }
}