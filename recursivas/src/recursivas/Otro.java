package recursivas;
import java.util.Random;
import java.util.Scanner;
public class Otro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				int numA, numB;
				int pGanadas=0, pPerdidas=0;
				Scanner entradaTeclado = new Scanner(System.in);
				Random rnd = new Random();
				char seleccion;
				boolean valida = false;
				do {
					do {
						numA = rnd.nextInt(100);
						numB = rnd.nextInt(100);
					}while(numA==numB);
				
					System.out.print("Apuestas por A o por B ? :");
					do {
						seleccion = entradaTeclado.next().toUpperCase().charAt(0);
						if((seleccion == 'A') || (seleccion == 'B')) {
							valida = true;
						}else {
							System.out.print("Elija opcion valida por A o por B ? ");
						}
					}while(!valida);
					
					System.out.print("A saca un " + numA + " y B saca un " + numB);
					if(seleccion =='A' && (numA > numB) || seleccion =='B' && (numB > numA) ) {
						System.out.println("		HAS GANADO!!!");
						pGanadas+=1;
					}else {
						System.out.println("		HAS PERDIDO!!!");
						pPerdidas+=1;
					}
					
					System.out.println("Llevas " + pGanadas + " partidas ganadas y " + pPerdidas + " partidas perdidas");
					
					System.out.print("Quieres probar otra vez ? (S/N) : ");
				} while(entradaTeclado.next().toUpperCase().equals("S"));
	}

}
