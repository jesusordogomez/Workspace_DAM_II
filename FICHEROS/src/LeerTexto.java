import java.io.*;

public class LeerTexto {
/** 
 * Para ver el contenido de un archivo de texto se va a leer l�nea a l�nea hasta
 * la marca de fin de fichero. 
 * El nombre completo del archivo se debe transmitir en la l�nea de �rdenes de la aplicaci�n.
 * 
 * Para realizar la lectura del archivo de texto, se va a crear un flujo BufferReader 
 * asociado con el flujo de caracteres del archivo; 
 * tambi�n se crea un objeto FILE con la cadena transmitida en la l�nea de �rdenes como argumento, 
 * y una vez creado el flujo, un bucle mientras la cadena le�da sea distinta de null procesa todo el archivo.
 * 
 * */
	public static void main(String[] arg) {
		
		File mf;
		BufferedReader br = null;
		String cd;
		String a = "C:\\Ejemplo\\fichero_aux.txt";
		if (!a.isEmpty()) {
			mf = new File(a);
			if (mf.exists()) {
				int k=0;
				try {
					br=new BufferedReader(new FileReader(mf));
					while ((cd=br.readLine())!=null) {
						System.out.println(cd);
					}
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("Directorio vac�o.....");
			}
		}

	}

}
