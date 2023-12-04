package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Juego extends JPanel {

    /**
	 * 
	 */

	// sonido del juego


    // objetos de las clases auto, obstaculos y fondo

    Auto auto = new Auto(this);
    Obstaculo obstaculo = new Obstaculo(this);
    Fondo fondo = new Fondo(this);

    // variables para el juego

    static boolean juegoFinalizado = false;
    static boolean pierdeVida = false;
    static int vidas = 3;
    static int puntos = 0;
    static int nivel = 1;

    Clip sonidoChoque, sonidoSalto;
    
    public Juego() {
/*
        try {
            sonidoChoque = cargarSonido("/Multimedia/mariomuere.mp3");
            sonidoSalto = cargarSonido("/Multimedia/mariosalto.mp3");
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
*/
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                // el salto se activa cuando se presiona la tecla espacio
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    auto.keyPressed(e);
                    repaint(); // Asegúrate de repintar la interfaz después de la acción
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        setFocusable(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }

    public void dibujar(Graphics2D g) {
        fondo.paint(g);
        auto.paint(g);
        obstaculo.paint(g);
    }

    public void dibujarPuntaje(Graphics2D g) {

    	Graphics2D g1=g,g2=g;
    	Font score= new Font("Arial", Font.BOLD,30);
    	g.setFont(score);
    	g.setColor(Color.blue);
    	g1.drawString("Puntaje: "+puntos,110,30);
    	g1.drawString("Vidas: "+vidas,20,30);
    	g1.drawString("Nivel: "+nivel,570,30);
    	
    	if(juegoFinalizado) {
    		g2.setColor(Color.red);
    		g2.drawString("has perdido", ((float)getBounds().getCenterX()/2)+170,70);
    	}
    	
    	
    }
    private Clip cargarSonido(String ruta) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        URL url = getClass().getResource(ruta);
        
        if (url == null) {
            throw new IllegalArgumentException("Archivo de sonido no encontrado: " + ruta);
        }

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para indicar el fallo
        }
        
    }
    
    
    

}
