package Almacen;

import java.util.ArrayList;
import java.util.Scanner;

public class Listados {
	
	ArrayList<Proveedor> prov = new ArrayList<Proveedor>();
	int contadorProveedor = 1;
	Scanner sc = new Scanner(System.in);
	
	public void altaProveedor() {
		/*Solicitar datos y altas de proveedor en listado*/
		Proveedor ProveAux = new Proveedor();
		ProveAux.setCodigo(contadorProveedor);
		System.out.println("Proveedor - - Nombre");
		ProveAux.setNombre(sc.nextLine());
		System.out.println("Proveedor - - Direccion");
		ProveAux.setDireccion(sc.nextLine());
		System.out.println("Proveedor - - Fecha ALta");
		ProveAux.setfAlta(sc.nextLine());
		System.out.println("Proveedor - - Telefono");
		ProveAux.setTelefono(sc.nextLine());
		System.out.println("Proveedor  - - Correo");
		ProveAux.setCorreoE(sc.nextLine());
		
		prov.add(ProveAux);
		
	
		
	}

	public void altaArticulo() {
		// TODO Auto-generated method stub
		
	}
	
}
