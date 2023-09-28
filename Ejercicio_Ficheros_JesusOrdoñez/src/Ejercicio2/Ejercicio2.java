package Ejercicio2;

import java.io.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String archivo = "Fichero\\elQuijote.txt";
        int numCapitulos = 0;
        int numMolinos = 0;
        
        try {
        	FileReader fr = new FileReader(archivo);
        	BufferedReader br = new BufferedReader(fr); 
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("CAPÍTULO") || line.startsWith("Capítulo")) {
                    numCapitulos++;
                }
                if (line.contains("molinos")) {
                    numMolinos++;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Numero total de capitulos: " + numCapitulos);
        System.out.println("Numero de veces que aparecen los molinos: " + numMolinos);
	}

}
