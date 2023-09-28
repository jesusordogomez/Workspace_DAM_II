import java.io.*;

public class LeerTexto {
/** 
 * Para ver el contenido de un archivo de texto se va a leer línea a línea hasta
 * la marca de fin de fichero. 
 * El nombre completo del archivo se debe transmitir en la línea de órdenes de la aplicación.
 * 
 * Para realizar la lectura del archivo de texto, se va a crear un flujo BufferReader 
 * asociado con el flujo de caracteres del archivo; 
 * también se crea un objeto FILE con la cadena transmitida en la línea de órdenes como argumento, 
 * y una vez creado el flujo, un bucle mientras la cadena leída sea distinta de null procesa todo el archivo.
 * 
 * */
	public static void main(String[] arg) {
		
		File mf;
		BufferedReader br = null;
		String cd;
		String a = "C:\\fichero_aux.txt";
		if (!a.isEmpty()) {
			mf = new File(a);
			if (mf.exists()) {
				int k=0;
				try {
					br=new BufferedReader(new FileReader(mf));
					while ((cd=br.readLine())!=null) {
						System.out.println(cd);
						if ((++k)%21==0) {
							System.out.println("Pulse una tecla ...");
							System.in.read();
						}
					}
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("Directorio vacío.....");
			}
		}

	}

}
