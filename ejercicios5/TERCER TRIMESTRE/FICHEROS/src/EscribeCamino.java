import java.io.*;
import java.util.*;

public class EscribeCamino {

	static boolean datosValidos(String cad) throws Exception{
		StringTokenizer cd;
		
		boolean sw;
		cd = new StringTokenizer(cad);
		sw = cd.countTokens()==3;
		cd.nextToken();
		sw=sw&&(Integer.parseInt(cd.nextToken())>0);
		return sw;
	}
	
	public static void main(String[] args) {
		File mf;
		BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
		DataOutputStream d=null;
		PrintWriter pw = null;
		String cad;
		boolean modo;
		String a = "C:\\fichero_aux.txt";
		if (!a.isEmpty()) {
			mf = new File(a);
			if (mf.exists()) {
				modo = true;
			}else {
				modo=false;
			}
			try {
				pw = new PrintWriter (new DataOutputStream (new FileOutputStream(mf,modo)));
				System.out.println("Pueblo_A distancia Pueblo_B");
				while (((cad=entrada.readLine())!=null)&& (cad.length()>0)) {
					if (datosValidos(cad)) {
						pw.println(cad);
					}
				}
				pw.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}else{
			System.out.println("Archivo no existente");
		}
		
	}

}
