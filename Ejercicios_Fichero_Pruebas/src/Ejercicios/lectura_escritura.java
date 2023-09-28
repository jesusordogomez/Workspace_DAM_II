package Ejercicios;

import java.io.*;
public class lectura_escritura {
	public static void main(String[] args) {
		try {
			String texto;
			File ficheroEntero = new File("Ficheros\\lectura.txt");
			FileReader fr = new FileReader(ficheroEntero);
			BufferedReader bf = new BufferedReader(fr);
			FileWriter ficheroVacio = new FileWriter("Ficheros\\escritura.txt");
			PrintWriter pw = new PrintWriter(ficheroVacio);
			while ((texto = bf.readLine()) != null) {
				pw.println(texto);
			}
			if (bf != null) {
				bf.close();
			}
			if (fr != null) {
				fr.close();
			}
			if (pw != null) {
				pw.close();
			}
			if (ficheroVacio != null) {
				ficheroVacio.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
