package ficheros_ejemplo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class clase_file {

	    public static void main(String[] args) {
	        String directorio;
	        if (args.length > 0) {
	            directorio = args[0];
	        } else {
	            directorio = "." ;
	        }

	        File actual = new File(directorio);
	        System.out.println("El directorio es: ");
	        try {
	            System.out.println(actual.getCanonicalPath());
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
	        System.out.println("Su contenido es: ");

	        File[] archivos = actual.listFiles();
	        for (File archivo : archivos) {
	            System.out.println(archivo.getName());
	            if (archivo.isFile()) {
	                System.out.println(archivo.length());
	                System.out.println(new Date(archivo.lastModified()));
	            }
	        }
	    }
}


