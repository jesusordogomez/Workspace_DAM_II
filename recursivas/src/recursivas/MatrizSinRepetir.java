package recursivas;
import java.util.*;
public class MatrizSinRepetir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] array = new int[5][5];
		 int numeros = 0;
		   
		   //Creamos un objeto Random
		   Random aleatorio = new Random();
		   
		   //Generamos números aleatorios dentro del array
		   for (int i=0; i<array.length; i++) {
		     for (int j=0; j<array[i].length; j++) {
		       do {
		         numeros = aleatorio.nextInt(59)+1;
		         array[i][j] = numeros;
		       } while (comprobarRepetidos(array, i, j, numeros));
		     }
		   }
		   
		   //Mostramos el array
		   for (int i=0; i<array.length; i++) {
		     for (int j=0; j<array[i].length; j++) {
		       System.out.print(array[i][j] + " ");
		     }
		     System.out.println();
		   }
		 }
		 
		 //Método para comprobar si hay números repetidos
		public static boolean comprobarRepetidos(int[][] array, int fila, int columna, int numero) {
		   for (int i=0; i<fila; i++) {
		     for (int j=0; j<array[i].length; j++) {
		       if (array[i][j] == numero)
		         return true;
		     }
		   }
		   for (int i=0; i<columna; i++) {
		     if (array[fila][i] == numero)
		       return true;
		   }
		   return false;
	}

}
