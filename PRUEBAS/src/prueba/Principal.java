package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import prueba.Auto;
import prueba.Fondo;
import prueba.Obstaculo;
import prueba.Juego;

public  class  Principal extends  JFrame  implements  ActionListener {
	public static void main(String[]args) {
		JFrame ventana=new JFrame("jueguito");
		Juego jueguito = new Juego();
		ventana.add(jueguito);
		ventana.setSize(1300,400);
		ventana.setLocation(70,200);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			jueguito.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
