package Ejercicio_NIF;

import java.util.Scanner;

public class NIF {
	Scanner leer = new Scanner (System.in);

	 private int dni;
	 private char letra;

	    //Constructores
	    public NIF() {
	    }

	    public NIF(int dni) {
	        this.dni = dni;
	        letra = calcularLetra();
	    }

	    private char calcularLetra() {
	        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
	                                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};                      
	        return letras[dni % 23];
	    }
	    public void leer() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Introduce dni: ");
	        dni = sc.nextInt();	       
	        letra = calcularLetra();
	    }
	    public String toString() {
	    	String cadena= " ";
	    	cadena= String.valueOf(dni)+""+String.valueOf(letra);
	    	return cadena;
	    }
}
