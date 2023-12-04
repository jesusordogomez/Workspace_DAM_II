package prueba;

import java.awt.Graphics2D;
import java.awt.geom.Area;

import javax.swing.ImageIcon;

public class Obstaculo {
	//objeto de la clase juego
	Juego jueguito;
	//variables que delimitan el area del obstaculo
	Area cabeza,cuerpo,vaca;
	//variables del tamaño del personaje
	int anchoObstaculo=70;
	int altoObstaculo=70;
	//coordenadas iniciales donde se ubica el objeto
	static int x_inicial=1300;
	static int y_inicial=270;
	//coordenadas para mannipular el objeto obstaculo
	static int x_auxiliar=-4;
	static int y_auxiliar=3;
	public Obstaculo(Juego jueguito) {
		
		this.jueguito = jueguito;
	}
	
	public void paint(Graphics2D g) {
		ImageIcon animal= new ImageIcon(getClass().getResource("/Images/Vader0027.png"));
		g.drawImage(animal.getImage(),x_inicial,y_inicial,anchoObstaculo,altoObstaculo,null);
		
		
	}
}
