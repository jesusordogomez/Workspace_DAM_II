package Ejercicio;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Simetrico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|_________________Bienvenido al registro_____________|");

        String respuesta;
        boolean respuestaValida;
        do {
            System.out.print("¿Tienes una contrasena secreta? (Si/No): ");
            respuesta = scanner.nextLine().toLowerCase();
            respuestaValida = respuesta.equals("si") || respuesta.equals("no");
            
            if (!respuestaValida) {
                System.out.println("ERROR: La respuesta debe ser 'Si' o 'No'.");
            }
        } while (!respuestaValida);

        String textoSinCifrar = "";
        String secretKey = null;

        if (respuesta.equals("si")) {
            // Si el usuario tiene una clave secreta, se la pido 
        	//ademas tiene que tener 16 caracteres porque al tener  128bits, solo puede tener 16 bytes
            do {
                System.out.print("Ingrese la clave secreta (debe tener 16 caracteres): ");
                secretKey = scanner.nextLine();
            } while (secretKey.length() != 16);
        } else {
            // Genero una clave secreta si el usuario no la tiene
            secretKey = generarClaveSecreta();
            System.out.println("Se ha generado una clave secreta.");
        }

        System.out.print("Ingrese el texto a cifrar: ");
        textoSinCifrar = scanner.nextLine();

        // Ciframos el texto
        String textoCifrado = cifrarSimetrico(secretKey, textoSinCifrar);
        System.out.println("Texto cifrado: " + textoCifrado);

        // Desciframos el texto
        String textoDescifrado = descifrarSimetrico(secretKey, textoCifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);
    }

    public static String generarClaveSecreta() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); 
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encodedKey = secretKey.getEncoded();
            return new String(encodedKey, StandardCharsets.ISO_8859_1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String cifrarSimetrico(String secretKey, String textoSinCifrar) {
        try {
            byte[] keyBytes = secretKey.getBytes(StandardCharsets.ISO_8859_1);
            SecretKey key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] textoCifradoBytes = cipher.doFinal(textoSinCifrar.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(textoCifradoBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String descifrarSimetrico(String secretKey, String textoCifrado) {
        try {
            byte[] keyBytes = secretKey.getBytes(StandardCharsets.ISO_8859_1);
            SecretKey key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] textoCifradoBytes = Base64.getDecoder().decode(textoCifrado);
            byte[] textoDescifradoBytes = cipher.doFinal(textoCifradoBytes);
            return new String(textoDescifradoBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
