package Principal;

import java.time.LocalDate;
import java.util.ArrayList;
import Super.Cereales;
import Super.Detergente;
import Super.IesAlimento;
import Super.Vino;

public class Prueba {

	public static void main(String[] args) {
		System.out.println("");
		Detergente det1 = new Detergente("Bosque Verde", 2.5);
		det1.setVolumen(33);
		det1.setDescuento(2);
		det1.setTipoEnvase("Plastico");
		System.out.println(det1);
		
		Cereales cer1 = new Cereales("Mercadona", 3, "MAIZ");
		cer1.setCaducidad(LocalDate.of(2022, 12, 20));
		System.out.println("     -                  ");
		System.out.println(cer1);
		
		Vino vin1 = new Vino(" Don Simon", " Tinto", 12, 10);
		vin1.setVolumen(330);
		vin1.setTipoEnvase(" Botella de cristal ");
		vin1.setCaducidad(LocalDate.of(2026, 12, 29));
		vin1.setDescuento(5);
		System.out.println("     -                  ");
		System.out.println(vin1);
		
	
		ArrayList<IesAlimento> lista = new ArrayList<>();
		lista.add(vin1);
		lista.add(cer1);
		int totalcalorias = 0;
		for (IesAlimento alimento: lista) {
			totalcalorias +=alimento.getCalorias();
		}
		System.out.println("     -                  ");
		System.out.println(" · Total calorias: "+ totalcalorias);
		}
	}


