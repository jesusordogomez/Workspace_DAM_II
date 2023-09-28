package Almacen;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Listados lista = new Listados();
		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("SELECCIONE OPCION - ALMACEN");
			System.out.println("---------------------------");
			System.out.println("1. Alta Articulo");
			System.out.println("2. Baja Articulo");
			System.out.println("3. Alta Proveedor");
			System.out.println("4. Baja Proveedor");
			System.out.println("5. Listar Articulo");
			System.out.println("6. Listar Proveedores");
			System.out.println("7. Baja Articulo");
			System.out.println("8. Stock Articulo");
			System.out.println("0. SALIR");
			opcion = sc.nextInt();
			
			if (opcion == 1) { lista.altaArticulo();}
			if (opcion == 2) { lista.bajaArticulo();}
			if (opcion == 3) { lista.altaProveedor();}
			if (opcion == 4) { lista.bajaProveedor();}
			if (opcion == 5) { lista.listaArticulo();}
			if (opcion == 6) { lista.listaProveeedores();}
			if (opcion == 7) { lista.venta();}
			if (opcion == 8) { lista.stock();}
			
		}while (opcion!=0);
		
	}

}
