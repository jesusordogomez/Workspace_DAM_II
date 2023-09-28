package ejercicios1;

import java.util.Scanner;

public class recursivafactorial {
    public static int calcular(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
		Scanner leer=new Scanner (System.in);
		int n;
	    System.out.println ("Ingrese el numero del mes");
	    n= leer.nextInt();

        int factorial = calcular(n);
        System.out.println("El factorial de " + n + " es: " + factorial);
    }
}