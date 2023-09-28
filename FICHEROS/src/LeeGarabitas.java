import java.io.*;

public class LeeGarabitas {
/** 
 * El archivo SeptGara.tmp fue creado con un flujo DataOutputStream, 
 * su estructura de datos es; el primer registro es una cadena escrita con formato UTF; 
 * los demás registros tienen los datos hora (int), presión y temperatura (double)
 * Escribir un programa para leer cada uno de los datos, calcular la temperatura máxima y mínima 
 * y mostrar los resultados por pantalla. 
 * */
	
	public static void main(String[] args) {
		String dia;
		double mxt = -11.0;
		FileInputStream f;
		DataInputStream obf1 = null;
		try {
			f = new FileInputStream("C:\\septGara.tmp");
			obf1 = new DataInputStream(f);
		}catch (IOException io) {
			System.out.println("Anomalía al crear el flujo de entrada. . . . " + io.getMessage());
			return;
		}
		
		try {
			int hora;
			boolean mas = true;
			double p, temp;
			dia = obf1.readUTF();
			System.out.println(dia);
			while (mas) {
				hora = obf1.readInt();
				p = obf1.readDouble();
				temp = obf1.readDouble();
				System.out.println("Hora: " + hora + "\t Presión: " + p + "\t Temperatura: " + temp);
				mxt = Math.max(mxt, temp);
			}
		}catch (EOFException eof) {
			System.out.println("Fin de lectura del archivo \n");
		}catch (IOException io) {
			System.out.println("Anomalía al leer el flujo de entrada .... " + io.getMessage());
			return;
		}finally {
			try {
				obf1.close();
			}catch (IOException er) {
				er.printStackTrace();
			}
		}
		System.out.println("\n La temperatura máxima: " + (float)mxt);

	}

}
