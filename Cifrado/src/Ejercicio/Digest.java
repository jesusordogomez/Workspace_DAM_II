package Ejercicio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Digest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Introduce una contraseña: ");
        String inputPassword = scanner.nextLine();
        
        // Generar el hash de la contraseña y almacenarlo en un archivo
        String hashedPassword = hashPassword(inputPassword);
        guardarContraseñaEnArchivo(hashedPassword);
        
        System.out.println("Contraseña almacenada correctamente.");
        
        // Pedir la contraseña nuevamente para verificar
        System.out.print("Introduce la contraseña para acceder al archivo: ");
        String inputVerificationPassword = scanner.nextLine();
        
        // Verificar si la contraseña coincide
        if (verificarContraseña(inputVerificationPassword, hashedPassword)) {
            System.out.println("Contraseña correcta. Puedes acceder al archivo.");
            // Aquí puedes realizar las operaciones que desees con el archivo
        } else {
            System.out.println("Contraseña incorrecta. No puedes acceder al archivo.");
        }
	}
        
        // Método para generar el hash de la contraseña
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	private static void guardarContraseñaEnArchivo(String hashedPassword) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Digest.txt"))) {
            writer.println(hashedPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para verificar la contraseña ingresada con el hash almacenado en el archivo
    private static boolean verificarContraseña(String inputPassword, String storedPassword) {
        String hashedInputPassword = hashPassword(inputPassword);
        return storedPassword.equals(hashedInputPassword);
    }
}


