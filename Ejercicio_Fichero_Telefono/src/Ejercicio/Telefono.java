package Ejercicio;
import java.io.*;
import java.util.*;

public class Telefono {
	public static void main(String[] args) {
		//Para escribir
		File archivo = null;	
		FileWriter escribir = null;
		BufferedWriter buf = null;
		int telefonos;
		int num;
		int contador = 0;
		
		try {
			archivo = new File("Fichero\\telefonos.txt");
            escribir = new FileWriter(archivo);
            buf = new BufferedWriter(escribir);
            telefonos = (int)(Math.random()*(31-25)+25);
            
            for (int i = 0; i < telefonos; i++) {
            	num = (int)(Math.random()*1000000);
                String telefono = "954-" +  String.format("%06d", num);
                buf.write(telefono);
                buf.newLine();
                contador= contador+1;
            }   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				if(null != archivo) {
					buf.close();		
				}
			} catch (Exception e2) {		
				e2.printStackTrace();		
			}
        }	    
	}
}
