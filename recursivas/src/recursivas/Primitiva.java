package recursivas;
		import java.util.HashSet;
		import java.util.Set;
		public class Primitiva {
			private static int[] Primitiva(){
				Set<Integer>Norepetir = new HashSet<>();//Creamos una lista para ir guardando los datos que no se repiten
				int[] numeros = new int[8];
				int i, auxiliar;
				boolean norepite=false;
				for (i=0; i<6; i++) {
					norepite =false;
					while(!norepite) {
						auxiliar=(int)(Math.random()*50); //Generamos números random entre el 0 y el 49
						if (!Norepetir.contains(auxiliar)) {
							Norepetir.add(auxiliar);
							numeros[i]=auxiliar;
							norepite=true;
						}
					}
				}
				numeros[6]=(int)(Math.random()*10);
				norepite =false;
				while(!norepite) {
					auxiliar=(int)(Math.random()*50);
					if (!Norepetir.contains(auxiliar)) {
						Norepetir.add(auxiliar);
						numeros[7]=auxiliar;
						norepite=true;
					}
				}
				return numeros;
			}
			private static void GenerarPrimitiva(int[] numeros) { //Generamos la plantilla de la primitiva
				int i;
				System.out.println("\n----APUESTA PRIMITIVA SENCILLA ---");
				System.out.println("\n----------------------------------");
				System.out.print("Números     ");
					for (i=0; i<5; i++) {
						System.out.print(numeros[i]+" - ");
					}
					System.out.print(numeros[5]);
					System.out.print("\n\nReintegro:          ");
					System.out.print(numeros[6]);
					System.out.print("\n\nComplementario:     ");
					System.out.print(numeros[7]);
				}
			public static void Primitivaexamen() { //En este apartado creamos un vector y llamamos a las demás funciones
				int[] numeros;
				numeros=Primitiva();
				GenerarPrimitiva(numeros);
	}	

}
