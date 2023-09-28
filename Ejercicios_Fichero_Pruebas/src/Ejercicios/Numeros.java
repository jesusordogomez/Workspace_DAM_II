package Ejercicios;

import java.io.*;
import java.util.Random;

public class Numeros {

    public static void main(String[] args) {
        File archivo = null;
        FileWriter escribir = null;
        BufferedWriter buf = null;
        String nombreArchivo = "Ficheros\\numeros.txt";

        try {
            // Crear el archivo y el escritor
            archivo = new File(nombreArchivo);
            escribir = new FileWriter(archivo);
            buf = new BufferedWriter(escribir);

            // Generar números aleatorios y escribirlos en el archivo
            Random random = new Random();
            int cantidadNumeros = 20; // Cambia la cantidad de números que deseas generar
            for (int i = 0; i < cantidadNumeros; i++) {
                int numero = random.nextInt(101); // Números aleatorios entre 0 y 100
                buf.write(String.valueOf(numero));
                buf.newLine();
            }

            // Cerrar el escritor
            buf.close();
            escribir.close();

            // Calcular la media de los números en el archivo
            double suma = 0;
            int contador = 0;

            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                try {
                    double numero = Double.parseDouble(linea);
                    suma += numero;
                    contador++;
                } catch (NumberFormatException e) {
                }
            }

            br.close();

            if (contador > 0) {
                double media = suma / contador;
                System.out.println("La media de los números en el archivo es: " + media);
            } else {
                System.out.println("No hay números válidos en el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}