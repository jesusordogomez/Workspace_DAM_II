package Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1_filtradoDatos {
	 public static void main(String[] args) {
	        // Lista de números enteros
	       List<Integer> numeros = Arrays.asList(
	                23, 17, 4, 13, 10, 19, 7, 29, 16, 31,
	                5, 11, 8, 37, 2, 41, 20, 43, 14, 3,
	                47, 22, 53, 26, 59, 35, 61, 15, 67, 18
	        );
	        List<Integer> ordenados = numeros.stream()
	                .filter(Ejercicio1_filtradoDatos::esPrimo)
	                .sorted((a, b) -> Integer.compare(b, a))
	                .collect(Collectors.toList());

	        System.out.println("Numeros primos ordenados de mayor a menor: " + ordenados);
	    }

	    private static boolean esPrimo(int numero) {
	        if (numero <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

