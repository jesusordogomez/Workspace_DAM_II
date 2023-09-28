package Ejercicio2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Ejericio_2 {

	public static void main(String[] args) {

			try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Cuantos numeros aleatorios quieres generar?: ");
				int numeros = scanner.nextInt();

				System.out.print("Introduzca un numero entero para crear una ruta: ");
				String ruta = scanner.next();

				try {
					FileOutputStream fileOutputStream = new FileOutputStream(ruta, true);
					DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
					Random random = new Random();
					for (int i = 0; i < numeros; i++) {
						int aleatorio = random.nextInt(101);
						dataOutputStream.writeInt(aleatorio);
					}
					dataOutputStream.close();
					fileOutputStream.close();
					FileInputStream fileInputStream = new FileInputStream(ruta);
					DataInputStream dataInputStream = new DataInputStream(fileInputStream);
					
					System.out.println("Sus numeros en la ruta " + ruta + " son:");
					while (true) {
						try {
							int numero = dataInputStream.readInt();
							System.out.print(numero + " ");
						} catch (EOFException e) {
							break; 
						}
					}
					dataInputStream.close();
					fileInputStream.close();
				} catch (IOException e) {
					System.out.println("Ha ocurrido un error: " + e.getMessage());
			}
		}
	 }
}
