package Ejercicios;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Scanner;

	public class Ejercicio3 {
	  public static void main(String[] args) {
	    ArrayList<String> palabras = new ArrayList<String>();
	    Scanner p = new Scanner(System.in);

	    System.out.println("Introduce 10 palabras:");
	    for (int i = 0; i < 10; i++) {
	      palabras.add(p.nextLine());
	    }

	    Collections.sort(palabras);

	    System.out.println("Las palabras ordenadas son:");
	    for (String palabra : palabras) {
	      System.out.println(palabra);
	    }
	  }
	}
