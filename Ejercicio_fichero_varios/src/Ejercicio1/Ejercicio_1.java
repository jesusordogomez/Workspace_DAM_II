package Ejercicio1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = null;
		DataOutputStream escribir = null;
		FileInputStream fis = null;
		DataInputStream leer= null;

		try {
			fos = new FileOutputStream("ficheros\\datos.dat");
			escribir = new DataOutputStream(fos);
			escribir.writeInt(658765876);

			fis = new FileInputStream("ficheros\\datos.dat");
			leer = new DataInputStream(fis);

			fos = new FileOutputStream("CopiaFichero\\copia_datos.dat");
			escribir = new DataOutputStream(fos);

			byte[] pabolo = new byte[leer.available()];
			leer.read(pabolo);
			escribir.write(pabolo);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());	
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(escribir != null) {
					escribir.close();
				}
				if(fos != null) {
					fos.close();
				}
				if(leer != null) {
					leer.close();
				}
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				System.out.println(e.getMessage());
				//pablo prime > zinedine zidane
			}
		}		

	}

}
