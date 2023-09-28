package Ejercicio3;

public class Ejecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Electrodomestico[ ] lista = new Electrodomestico[10];
			
			lista[0]  = new Lavadora();
			lista[1]  = new Lavadora(100, 40, "negro", 'B', 100);
			lista[2]  = new Lavadora(100, 40);
			lista[3]  = new Television();
			lista[4]  = new Television(800, 15, "negro", 'D', 42, false);
			lista[5]  = new Television(700, 12);
			lista[6]  = new Electrodomestico();
			lista[7]  = new Electrodomestico(320, 15, "rojo", 'C');
			lista[8]  = new Electrodomestico(350, 8);
			lista[9]  = new Lavadora(120, 35, "azul", 'A', 70);
			
			for (int i=0; i<10; i++) {
				System.out.println("Electrodomestico: " + lista[i] + " - precio base: " + lista[i].getPrecioBase() + " - color: " + lista[i].getColor() +" - peso: " + lista[i].getPeso()+ " - consumo " + lista[i].getConsumo());
				if (lista[i].getTipo()=="television") System.out.println("pulgadas: " + lista[i].getPulgadas() + " - TDT: " + lista[i].isTdt());
				if (lista[i].getTipo()=="lavadora") System.out.println(" carga: " + lista[i].getCarga());
				lista[i].precioFinal();
				System.out.println(" Precio final: " + lista[i].getPrecioBase() + "€.\n\n");
				
			}
			
		}
	}


