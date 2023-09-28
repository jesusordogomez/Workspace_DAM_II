package recursivas;
		import java.util.Random;
		import java.util.Scanner;
		public class LoteriaAdivinar {
			
			static Scanner entradaTeclado = new Scanner(System.in);
			
			public static void main(String[] args) {
				int[] numerosUsuario = new int[6];
				int[] numerosGanadores = new int[6];
				
				do {	
				
					System.out.println("Elije 6 numero entre el 1 y el 49");
					creaNumeros(numerosUsuario, numerosGanadores);
					
					System.out.print("Numero Elejidos	: ");
					imprimeNumeros(numerosUsuario);
					
					System.out.print("Combinacion ganadora	:");
					imprimeNumeros(numerosGanadores);
					
					verificaAciertos(numerosUsuario, numerosGanadores);
					
					System.out.print("Quieres probar otra vez? (S/N): ");
				} while(entradaTeclado.next().toUpperCase().equals("S"));
				
				System.out.println("Adios");
				
			}
			
			public static void creaNumeros(int[] pNumerosUsuario, int[] pNumerosGanadores) {
				
				Random rnd = new Random();
				for (int i = 0; i < pNumerosUsuario.length; i++) {
					System.out.print("Elije el numero " + (i+1) + ": ");
					pNumerosUsuario[i] = entradaTeclado.nextInt();
					
					while((pNumerosUsuario[i] < 1) || (pNumerosUsuario[i] > 49)) {
						System.out.print("El numero esta fuera de rango, elije otro: ");
						pNumerosUsuario[i] = entradaTeclado.nextInt();
					}
					
					for (int j = 0; j < i; j++) {
						while((pNumerosUsuario[j]==pNumerosUsuario[i])) {
							System.out.print("El numero ya esta ingresado, elije otro: ");
							pNumerosUsuario[i] = entradaTeclado.nextInt();
						}
					}
					
					pNumerosGanadores[i] = (int) (rnd.nextDouble()*50);
					//System.out.println(pNumerosGanadores[i]);
				}	
			}
			
			public static void imprimeNumeros(int[] pListaNumeros) {
				for (int i = 0; i < pListaNumeros.length; i++) {
					System.out.print(pListaNumeros[i] + " ");
				}
				System.out.println();
			}
			
			public static void verificaAciertos(int[] pNumerosUsuario, int[] pNumerosGanadores) {
				int aciertos = 0;
				for (int i = 0; i < pNumerosGanadores.length; i++) {
					for (int j = 0; j < pNumerosUsuario.length; j++) {
						if(pNumerosGanadores[i] == pNumerosUsuario[j]) {
							aciertos += 1;
						}
					}
				}
				System.out.println("Has acertado: " + aciertos + " números");
	}

}
