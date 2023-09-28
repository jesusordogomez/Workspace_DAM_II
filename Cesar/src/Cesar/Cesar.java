package Cesar;

import java.util.Scanner;

public class Cesar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la palabra a cifrar: ");
        String palabra = scanner.nextLine();

        System.out.print("Ingrese numero de posiciones a desplazar: ");
        int desplazamiento = scanner.nextInt();

        String palabraCifrada = cifrarCesar(palabra, desplazamiento);
        System.out.println("Palabra cifrada: " + palabraCifrada);

        scanner.close();
    }

    public static String cifrarCesar(String palabra, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (Character.isLetter(letra)) {
                char base = Character.isUpperCase(letra) ? 'A' : 'a';
                int codigoLetra = letra - base;
                int codigoCifrado = (codigoLetra + desplazamiento) % 26;
                char nuevaLetra = (char) (base + codigoCifrado);
                resultado.append(nuevaLetra);
            } else {
                resultado.append(letra);
            }
        }

        return resultado.toString();
    }
}
