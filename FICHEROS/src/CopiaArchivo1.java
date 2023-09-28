import java.io.*;

public class CopiaArchivo1 {
/** 
 * Dado el archivo ficheroaux.txt se desea escribir toda su información en el archivo ficheroOLD.txt
 * */
	
	public static void main(String[] args) {
		
		FileInputStream origen = null;
		FileOutputStream destino = null;
		File f1 = new File ("C:\\fichero_aux.txt");
		File f2 = new File ("C:\\ficheroOLD.txt");
		
		try {
			origen = new FileInputStream(f1);
			destino = new FileOutputStream(f2);
			int c;
			while ((c=origen.read()) !=-1) {
				destino.write((byte)c);
			}
		} catch (IOException e) {
			System.out.println("Excepción de los flujos " + e.getMessage());
		} finally {
			try {
				origen.close();
				destino.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}

}
