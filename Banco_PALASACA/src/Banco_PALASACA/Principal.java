package Banco_PALASACA;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		
		//Creamos los objetos de cliente, empleado, cuentas, tarjetas y productos bancarios
		
		//En primer lugar, creamos el objeto cliente.
		CLIENTES cliente = new CLIENTES("Trabajando");
		
		System.out.println("\n-----------------------------------CLIENTES-------------------------------------");
		//Solicitamos al usuario si quiere modificar algún dato del cliente
		cliente.ModificarCliente(cliente);
		//En este caso le solicitamos un cambio de DNI y lo mostramos por pantalla
		System.out.println("Nuevo DNI: " + cliente.getDni());			
		System.out.println(cliente.toString());
		
		//Creamos un objeto tipo empleado
		EMPLEADOS empleado = new EMPLEADOS();
		System.out.println("\n----------------------------------EMPLEADOS-------------------------------------");
		//Solicitamos al usuario si quiere modificar algún dato del empleado
		empleado.ModificarEmpleados(empleado);
		//En este caso le solicitamos un cambio de Codigo Postal y de provincia, para más tarde mostramos por pantalla
		System.out.println("Nuevo Código Postal: " + empleado.getCp());
		System.out.println("Nueva Provincia: " + empleado.getProvincia());
		System.out.println(cliente.toString());
		
		System.out.println("\n-----------------------------PRODUCTOS BANCARIOS------------------------------");
		System.out.println("-----------------------------------CUENTA-------------------------------------");
		//Creamos un objeto cuenta
		CUENTAS cuenta = new CUENTAS(1234, 12345, 2000.0, 3.0, TiposCuenta.Ahorros);
		
		//Mostramos la cuenta por pantalla
		System.out.println(cuenta.toString());
		
		//Sacamos dinero
		cuenta.acceso(1234);
		cuenta.sacarDinero(400);
		System.out.println(cuenta.toString());
		
		//Intentamos ingresar dinero, pero al no dar aceso o dar un acceso incorrecto, no efectúa la operación
		cuenta.ingresarDinero(50);
		System.out.println(cuenta.toString());
		
		//Visualizamos por pantalla la cuenta
		System.out.println("Saldo de la cuenta: " + cuenta.visualizarCuenta());
		
		//Mostramos los datos de la cuenta
		System.out.println(cuenta.datosCuenta());
		
		//Mostramos el tipo de cuenta
		System.out.println("El tipo de la cuenta es: " + cuenta.tipoCuenta());
		
		//Mostramos los intereses
		System.out.println("Interés de la cuenta: "+ cuenta.devolverIntereses());
		
		
		System.out.println("\n-----------------------------------TARJETAS-------------------------------------");
		//Creamos un objeto monedero
		MONEDERO monedero = new MONEDERO(1234, 4000.0);
		
		//Sacamos dinero del monedero
		monedero.acceso(1234);
		monedero.sacarDinero(400);
		System.out.println(monedero.toString());
		
		//Ingresamos dinero al Monedero, pero al no usar la clave, no se efectúa el método
		monedero.cargarMonedero(150);
		System.out.println(monedero.toString());
		
		
		
		
		
	}

}