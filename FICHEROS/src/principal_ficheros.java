import java.io.File;

/**
 * 
 */

/**
 * @author Juan Carlos
 *
 */
public class principal_ficheros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File miFichero = new File ("C:\\ejemplo\\fichero_aux.txt");
		
		/* M�todos que INFORMAN sobre el FICHERO */
		
		if (miFichero.exists()) {
			System.out.println("EXISTE EL FICHERO");
		}
		
		if (miFichero.canExecute()) {
			System.out.println("Permiso para Ejecutar el fichero ..... ");
		}
		
		if (miFichero.canRead()) {
			System.out.println("Permiso para Leer el fichero ..... ");
		}
		
		if (miFichero.canWrite()) {
			System.out.println("Permiso para Escribir el fichero ..... ");
		}
		
		if (miFichero.isFile()) {
			System.out.println("El fichero indicado es ARCHIVO. ");
		}
		
		if (miFichero.isDirectory()) {
			System.out.println("El fichero indicado es DIRECTORIO. ");
		}
		
		System.out.println("Longitud Fichero: " + miFichero.length() + " bytes. ");
		
		System.out.println("Fichero modificado: " + miFichero.lastModified());
		
		System.out.println("Nombre del fichero: " + miFichero.getName());
		
		System.out.println("Directorio del fichero: " + miFichero.getPath());
		

	}

}
