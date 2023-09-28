package arrayliscolores;

import java.util.ArrayList;

public class colores_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> misColores = new ArrayList();
		
		misColores.add("ROJO");
		misColores.add("NEGRO");
		misColores.add("CYAN");
		misColores.add("SALMON");
		misColores.add("BLANCO");
		misColores.add("AMARILLO");
		
		for (int i=0; i<misColores.size();i++) {
			
			System.out.println("Color -- " + misColores.get(i));
			
		}
		
		System.out.println("------------------");
		misColores.remove(3);//Para eliminar un elemento de nuestro array, empieza por 0
		for (String brafs: misColores) {
			System.out.println("Color " + brafs);
		}
		int i = misColores.indexOf("BLANCO"); //Nos dice la posicion del elemento
		System.out.println("Posicion  : " + i);
		for (String brafs: misColores) {
		misColores.add(i, "VIOLETA");
		}
	}

}
