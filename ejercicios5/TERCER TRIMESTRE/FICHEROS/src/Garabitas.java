import java.io.*;

public class Garabitas {
/** 
 * Se dispone de los datos registrados en la estación metereológicas situada en el 
 * cerro GARABITAS, correspondientes a un día del mes de septiembre.
 * La esturcutra de los datos es: 
 * un primer registro con el día, y durante cada periodo; hora, presión y temperatura.
 * Los datos se graban en el archivo SeptGara.tmp
 * 
 * */
	
	public static void main(String[] args) {
		String dia = "1 Septiembre 2001";
		DataOutputStream obf1 = null;
		try {
			obf1 = new DataOutputStream(new FileOutputStream("C:\\septGara.tmp"));
			obf1.writeUTF(dia);
			for (int hora=0; hora<24; hora++) {
				double presion, temp;
				presion = presHora();
				temp = tempHora();
				obf1.writeInt(hora);
				obf1.writeDouble(presion);
				obf1.writeDouble(temp);
			}
		}catch (IOException e) {
			System.out.println(" Anomalía en el flujo de salida ... " + e.getMessage());
		}finally {
			try {
				obf1.close();
			}catch (IOException er) {
				er.printStackTrace();
			}
		}


	}
	static private double presHora() {
		final double PREINF = 680.0;
		final double PRESUP = 790.0;
		return (Math.random()*(PRESUP-PREINF)+PREINF);
	}
	
	static private double tempHora() {
		final double TEMPINF = 5.0;
		final double TEMPSUP = 40.0;
		return (Math.random()*(TEMPSUP-TEMPINF)+TEMPINF);
	}

}
