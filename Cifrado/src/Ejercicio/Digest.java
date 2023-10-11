package Ejercicio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Digest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una contraseña: ");
        String inputPassword = scanner.nextLine();

        // Generar el hash de la contraseña
        String hashedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(inputPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Almacenar el hash de la contraseña en un archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("Digest.txt"))) {
            writer.println(hashedPassword);
            System.out.println("Contraseña almacenada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }//

        // Pedir la contraseña nuevamente para verificar
        System.out.print("Introduce la contraseña para acceder al archivo: ");
        String inputVerificationPassword = scanner.nextLine();

        // Verificar si la contraseña coincide
        String hashedInputPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(inputVerificationPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            hashedInputPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (hashedPassword.equals(hashedInputPassword)) {
            System.out.println("Contraseña correcta. Puedes acceder al archivo.");
            // Aquí puedes realizar las operaciones que desees con el archivo
        } else {
            System.out.println("Contraseña incorrecta. No puedes acceder al archivo.");
        }
    }
}