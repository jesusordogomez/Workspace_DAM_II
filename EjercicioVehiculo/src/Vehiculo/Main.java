package Vehiculo;

public class Main {
	  public static void main(String[] args) {
	    Parking parking1 = new Parking("Parking 1", 3);
	    Parking parking2 = new Parking("Parking 2", 50);

	    VehiculoCliente vehiculo1 = new VehiculoCliente("5595JVS");
	    VehiculoCliente vehiculo2 = new VehiculoCliente("4862LMN");
	    VehiculoCliente vehiculo3 = new VehiculoCliente("9876SJE");
	    System.out.println(" ");
	    System.out.println("Plazas libres en Parking 1: " + parking1.disponibles());
	    System.out.println("Plazas libres en Parking 2: " + parking2.disponibles());
	    System.out.println("--------------------------------------------------------------------------");

	    vehiculo1.setTiempo(1500);
	    if (vehiculo1.hayPlaza(parking1)) {
	      vehiculo1.aparca(parking1);
	    } else {
	      System.out.println("No hay plazas en Parking 1 para el vehiculo 1");
	    }

	    vehiculo2.setTiempo(120);
	    if (vehiculo2.hayPlaza(parking1)) {
	      vehiculo2.aparca(parking1);
	    } else {
	      System.out.println("No hay plazas en Parking 1 para el vehiculo 2");
	    }

	    vehiculo3.setTiempo(240);
	    if (vehiculo3.hayPlaza(parking2)) {
	      vehiculo3.aparca(parking2);
	    } else {
	      System.out.println("No hay plazas en Parking 2 para el vehiculo 3");
	    }
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("Plazas libres en Parking 1: " + parking1.disponibles());
	    System.out.println("Plazas libres en Parking 2: " + parking2.disponibles());
	    System.out.println("--------------------------------------------------------------------------");

	    System.out.println( vehiculo1 + " -> Total a pagar del vehiculo 1: " + vehiculo1.factura());
	    System.out.println( vehiculo2 + " -> Total a pagar del vehiculo 2: " + vehiculo2.factura());
	    System.out.println( vehiculo3 + " -> Total a pagar del vehiculo 3: " + vehiculo3.factura());

	  }
	}

