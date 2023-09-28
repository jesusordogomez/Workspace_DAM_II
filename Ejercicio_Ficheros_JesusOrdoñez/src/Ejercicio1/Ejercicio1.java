package Ejercicio1;

	import java.io.*;

	public class Ejercicio1 {
	     public static void main(String[] args) {

	            String archivo = "Fichero\\elQuijote.txt";
	            int caracteres = 0;
	            int palabras = 0;
	            try {
	                FileReader fr = new FileReader(archivo);
	                BufferedReader br = new BufferedReader(fr);
	                String linea;
	                while ((linea = br.readLine()) != null) {
	                  caracteres += linea.length();
	                    String[] words = linea.split(" ");
	                    palabras += words.length;
	                }
	                fr.close(); 
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            System.out.println("El archivo tiene " + caracteres + " caracteres.");
	            System.out.println("El archivo tiene " + palabras + " palabras.");
	        }
	}