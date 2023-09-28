package recursivas;
import java.util.*;
public class Euromillon {

	public static void main(String[] args) {
		Euromillon();
	}
	private static int[] GenerarEuromillon() {
		//Generar los primeros numeros aleatorios hasta i=5
		int i=0;
		int tamañoarray=7;

		int arreglo[]= new int [tamañoarray];
		arreglo[i]=(int)(Math.random()*50+1);

		for(i=0;i<5;i++) {
			arreglo[i]=(int)(Math.random()*50+1);


			for(int j=0; j<i ;j++) {
				if(arreglo[i]==arreglo[j]) {
					i--;
				}
			}
		}
		//Generar numeros aleatorios desde i=5 hasta i=7
		for(i=5;i<7;i++) {
			arreglo[i]=(int)(Math.random()*12+1);
			
			for(int j=5; j<i ;j++) {
				if(arreglo[i]==arreglo[j]) {
					i--;
				}
			}
		}

		return arreglo;
	}
	
	private static void imprimir(int[] euromillon) {
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("             Euro[o]millones");
		System.out.println("-------------------------------------");
		for(int i=0;i<5;i++) {
			System.out.print("["+euromillon[i]+ "]");
		}
		for(int i=5;i<7;i++) {
			System.out.print("    ["+euromillon[i]+"*]");
		}
		System.out.println(" ");
		System.out.println("-------------------------------------");
	}
	
	public static void Euromillon() { //En este apartado creamos un vector y llamamos a las demás funciones
		int[] numeros;
		numeros=GenerarEuromillon();
		imprimir(numeros);
	}	
}

