package prueba;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;

import javax.swing.ImageIcon;

public class Auto {
	
	//objeto de la clase juego
	Juego jueguito;
	//variables que nos ayudan a saber si el auto salta o no
	
	static boolean saltando=false;
	boolean sube = false;
	boolean baja= false;
	//variables que delimitan el area del objeto
	Area llantaDelantera, llantaTrasera, carroceria, tractor;
	//variables de tamaño del personaje
	int anchoPersonaje = 112;
	int altoPersonaje =78;
	//coordenadas iniciales de personaje
	static int x_inicial =50;
	static int y_inicial=270;
	//coordenadas para manipular el personaje
	int x_auxiliar=0;
	int y_auxiliar =0;
	
	
	
	
	public Auto(Juego jueguito) {
		this.jueguito = jueguito;
	}
	
	public void paint(Graphics2D g) {
		ImageIcon auto = new ImageIcon(getClass().getResource("Images/R2/R20001.png"));
		g.drawImage(auto.getImage(),x_inicial, y_inicial, anchoPersonaje, altoPersonaje,null);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			saltando=true;
		}
	}
}
