package Ejercicio;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Asimetrico {
    private static KeyPair parClaves;
    private static PublicKey clavePublica;
    private static PrivateKey clavePrivada;
//menu en el que hago  un switch, para elegir una opcion del menu
    //ademas le digo al usuario que si no tiene las claves generadas que primero se las tenga que crear
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("|_________________Bienvenido al cifrator_____________|");
                System.out.println("1. Cifrar texto");
                System.out.println("2. Descifrar texto");
                System.out.println("3. Generar claves");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");

                try {
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            if (parClaves == null) {
                                System.out.println("Tienes que tener unas claves");
                            } else {
                                System.out.print("Introduce el texto a cifrar: ");
                                String mensajeCifrar = scanner.nextLine();
                                String mensajeCifrado = cifrarAsimetrico(mensajeCifrar, clavePublica);
                                System.out.println("Texto cifrado: " + mensajeCifrado);
                            }
                            break;
                        case 2:
                            if (parClaves == null) {
                                System.out.println("Tienes que tener unas claves");
                            } else {
                                System.out.print("Introduce un texti cifrado: ");
                                String mensajeCifradoDescifrar = scanner.nextLine();
                                String mensajeDescifrado = descifrarAsimetrico(mensajeCifradoDescifrar, clavePrivada);
                                System.out.println("Texto descifrado: " + mensajeDescifrado);
                            }
                            break;
                        case 3:
                            parClaves = generarKeysAsimetrica();
                            clavePublica = parClaves.getPublic();
                            clavePrivada = parClaves.getPrivate();
                            System.out.println("Se han regenerado las claves.");
                            break;
                        case 4:
                            System.out.println("Muchas Gracias!!");
                            System.exit(0);
                        default:
                            System.out.println("ERROR. Selecciona una opcion");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR. Selecciona una opcion");
                    scanner.nextLine(); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//metodo para generar una clave asimetrica
    public static KeyPair generarKeysAsimetrica() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
//metoro para cifrar el texto
    public static String cifrarAsimetrico(String textoSinCifrar, PublicKey clavePublica) throws Exception {
        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] textoCifrado = cifrador.doFinal(textoSinCifrar.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }
//metodo para descifrar el texto
    public static String descifrarAsimetrico(String textoCifrado, PrivateKey clavePrivada) throws Exception {
        Cipher descifrador = Cipher.getInstance("RSA");
        descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] textoDescifrado = descifrador.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(textoDescifrado);
    }
}
