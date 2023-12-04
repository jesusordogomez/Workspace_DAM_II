package prueba;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Fondo {
	//objeto de la clase juego
	Juego jueguito;
	//variables del tamaño del fondo
	int anchoFondo=1300;
	int altoFondo=400;
	//coordenadas iniciales para mover el fondo
	int x1=1300;
	int y1=0;
	//coordenadas auxiliares que mueven otro fondo
	int x2=0;
	int y2=0;
	
	public Fondo(Juego jueguito) {
		this.jueguito = jueguito;
	}
	
	public void paint(Graphics2D g) {
		ImageIcon animal= new ImageIcon(getClass().getResource("Images/fondofinal.jpg"));
		
		g.drawImage(animal.getImage(),x1,y1,anchoFondo,altoFondo,null);
		g.drawImage(animal.getImage(),x2,y2,anchoFondo,altoFondo,null);
	}
}
