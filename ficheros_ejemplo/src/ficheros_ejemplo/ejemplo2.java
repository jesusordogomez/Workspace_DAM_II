package ficheros_ejemplo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejemplo2 {


	    public static void main(String[] args) {
	        String nombreArchivo = "ejemplo.txt";
	        FileWriter escritura;
	        try{
	            escritura = new FileWriter(nombreArchivo);
	            for(char car='a';car<='z';car++){
	                escritura.write(car);
	            }
	            escritura.close();
	        }catch(IOException ex){
	            System.out.println("Imposible abrir archivo");
	        }
	        
	        FileReader lectura;
	        int c;
	        try{
	            lectura = new FileReader(nombreArchivo);
	            c=lectura.read();
	            while(c!=-1){
	                System.out.println((char)c);
	                c=lectura.read();
	            }
	            lectura.close();
	        }catch(IOException exc){
	            System.out.println("Imposible abrir el archivo");
	        }
	    }
}
