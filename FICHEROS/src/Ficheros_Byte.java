import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ficheros_Byte {

	public static void main(String[] args) {
		try {
			FileOutputStream mf = new FileOutputStream("C:\\fichero2.dat");
			
			FileInputStream mf2 = new FileInputStream("C:\\\\fichero_aux.txt");
			
			mf2.read();
						
			mf2.close();
			
			mf.write(1);
			
			mf.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
