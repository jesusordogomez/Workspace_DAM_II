package Ejercicio4;

import java.io.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
            String texto;
            File ficheroEntero1 = new File("Fichero\\elQuijote.txt");
            FileReader fr = new FileReader(ficheroEntero1);
            BufferedReader bf = new BufferedReader(fr); 
            FileWriter ficheroVacio = new FileWriter("Fichero\\COPIAelQuijote.txt");
            PrintWriter pw = new PrintWriter(ficheroVacio);

            while ((texto = bf.readLine()) != null) {
                if (texto.contains("dulcinea")) {
                    texto = texto.replaceAll("dulcinea", "DULCINEA");
                }
                if (texto.contains("hidalgo")) {
                    texto = texto.replaceAll("hidalgo", "HIDALGO");
                }
                if (texto.contains("molinos")) {
                    texto = texto.replaceAll("molinos", "MOLINOS");
                }
                pw.println(texto);
            }
            fr.close();
            pw.close();
        } catch (IOException IOErr) {
        	IOErr.printStackTrace();
     }
	}
}

