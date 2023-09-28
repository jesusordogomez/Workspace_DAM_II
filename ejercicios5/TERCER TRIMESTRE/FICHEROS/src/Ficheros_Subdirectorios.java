import java.io.File;

public class Ficheros_Subdirectorios {
/** 
 * Se desea mostar por pantalla cada uno de los archivos y subdirectorios que consta un directorio
 * que se transmite en la l�nea de �rdenes
 * 
 * Se crea objeto FILE inicializado con el nombre del directorio o ruta procedente de la l�nea de �rdenes.
 * El programa comprueba que es un directorio y llama al m�todo list() para obtener un array de cadenas 
 * con todos los elementos del directorio.
 * Mediante un bucle con tantas iteraciones como la longitud del array de cadenas se escriben en pantalla.
 * 
 *  */
	public static void main(String[] args) {
		
		File dir;
		String[] cd;
		String a = "C:\\";
		if (!a.isEmpty()) {
			dir = new File(a);
			if (dir.exists() && dir.isDirectory()) {
				cd=dir.list();
				System.out.println("Elementos del directorio " + a);
				for (int i=0; i<cd.length; i++) {
					System.out.println(i+1 + ".- " + cd[i]);
				}
			}else {
				System.out.println("Directorio Vac�o");
			}
		}else {
			System.out.println("No se ha especificado directorio....");
		}
		
		
		
	}

}
