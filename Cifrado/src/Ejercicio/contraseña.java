package Ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class contraseña {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.println("Ingrese una nueva contraseña:");
        password = scanner.nextLine();

        // Almacenar la contraseña en un archivo txt
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("contraseña.txt"))) {
            escribir.write(password);
            System.out.println("Contraseña almacenada con éxito.");
        } catch (IOException e) {
            System.err.println("Error al almacenar la contraseña en el archivo.");
            e.printStackTrace();
            return;
        }

        System.out.println("Ingrese la contraseña para acceder:");
        String contraseña = scanner.nextLine();

        // Leer la contraseña almacenada en el archivo
        try (BufferedReader leer = new BufferedReader(new FileReader("contraseña.txt"))) {
            String leercontraseña = leer.readLine();

            // Verificar si la contraseña coincide
            if (contraseña.equals(leercontraseña)) {
                System.out.println("Contraseña correcta. Acceso permitido.");
            } else {
                System.out.println("Contraseña incorrecta. Acceso denegado.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer la contraseña almacenada.");
            e.printStackTrace();
        }
    }
}
