package Ejercicio3;

import java.io.*;

public class Ejercicio3 {

	public static void main(String[] args) {

		File miFichero = new File ("Fichero\\elQuijote.txt");
		if (miFichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			PrintWriter pw = null;
			int capitulo=1;
			String nombrearchivo=null ;
			String cap;
			File archivocopia=null;
			try {
				fr = new FileReader(miFichero);
				br = new BufferedReader(fr);
				while ((cap = br.readLine()) != null ) {
					if (cap.startsWith("CAPÍTULO " + capitulo + ": ") || cap.startsWith("Capitulo " + capitulo + " : ")) {
						if(fw!=null) fw.close();
						nombrearchivo="elQuijote_cap"+capitulo+".txt";
						archivocopia= new File("Fichero\\",nombrearchivo);
						fw= new FileWriter(archivocopia);
						pw= new PrintWriter(fw);
						capitulo++;
					}
					if (fw!=null && pw!=null) {
						pw.println(cap);
					}
				}
				System.out.println("El fichero se ha copiado correctamente capitulo por capitulo");
			}catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if ( br != null ) {
						br.close(); fr.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}



