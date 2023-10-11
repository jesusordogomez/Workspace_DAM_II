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

        System.out.println("Introduce una contraseña: ");
        password = scanner.nextLine();

        // almaceno la contraseña en un archivo txt
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("contraseña.txt"))) {
            escribir.write(password);
            System.out.println("Contraseña almacenada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al almacenar la contraseña en el archivo.");
            e.printStackTrace();
            return;
        }

        System.out.println("Introduce la contraseña para acceder al archivo: ");
        String contraseña = scanner.nextLine();

        // metodo para poder leer la contraseñadel txt si la contraseña es correcta tal y como la ha escrito el usuario
        try (BufferedReader leer = new BufferedReader(new FileReader("contraseña.txt"))) {
            String leercontraseña = leer.readLine();

            // verificacion de la contraseña
            if (contraseña.equals(leercontraseña)) {
                System.out.println("Contraseña correcta. Puedes acceder al archivo.");
            } else {
                System.out.println("Contraseña incorrecta. No puedes acceder al archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer la contraseña almacenada.");
            e.printStackTrace();
        }
    }
}
