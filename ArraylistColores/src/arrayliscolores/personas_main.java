package arrayliscolores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class personas_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<PERSONA> p = new ArrayList();	
		
		PERSONA p1 = new PERSONA("Pepe", "Lopez", "11111111T");
		PERSONA p2 = new PERSONA("Veronica", "Sanchez", "989511T");
		p.add(p1);
		p.add(new PERSONA("Emilio", "Garcia", "0000000H"));		
		p.add(p2);
		p.add(new PERSONA("Jaime", "Ostos", "222000H"));
		
		for (PERSONA a:p) {
			System.out.println("Persona " + a.toString());
			
			if(a.NOMBRE.equals("Veronica")){
				System.out.println("ENcontrado Veronica --- " + p.indexOf(a));
				
			}
		}
		//para saber si esta añadido en el array
		//System.out.println(p.contains(p1));
		
		//para saber la posicion del elemento
		//System.out.println(p.indexOf(p2));
		

	}

}
