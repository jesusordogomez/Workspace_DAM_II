package ficheros_ejemplo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Serializable {
	

	    public static void main(String[] args) throws ClassNotFoundException {

	        try {
	            FileOutputStream archivo = new FileOutputStream("prueba.txt");
	            ObjectOutputStream salida = new ObjectOutputStream(archivo);
	            salida.writeObject("Hoy es: ");
	            salida.writeObject(new Date());
	            salida.close();
	        } catch (IOException e) {
	            System.out.println("Problemas con el archivo");
	        }
	        try {
	            FileInputStream archivo_dos = new FileInputStream("prueba.txt");
	            ObjectInputStream entrada = new ObjectInputStream(archivo_dos);
	            String hoy = (String) entrada.readObject();
	            Date fecha = (Date) entrada.readObject();
	            entrada.close();
	            System.out.println(hoy + " " + fecha);
	        } catch (FileNotFoundException ef) {
	            System.out.println("No se pudo abrir el archivo");
	        } catch (IOException ex) {
	            System.out.println("Problemas con el archivo");
	        }
	    }


}
