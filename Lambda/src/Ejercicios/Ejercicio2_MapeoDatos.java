package Ejercicios;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2_MapeoDatos {
	   public static void main(String[] args) {
	        // Lista de nombres de personas
	        List<String> nombres = Arrays.asList("Pablo", "Yeray", "Kike", "Jesus", "Adolfo", "Luismi", "Fran");
	        List<Integer> caracter = nombres.stream()
	                .map(nombre -> nombre.length())
	                .toList(); 
	        System.out.println("Caracteres de los nombres: " + caracter);

	        int sumacaracter = caracter.stream()
	                .reduce(0, (a, b) -> a + b);

	        System.out.println("Suma de todos los caracteres: " + sumacaracter);
	    }
	}