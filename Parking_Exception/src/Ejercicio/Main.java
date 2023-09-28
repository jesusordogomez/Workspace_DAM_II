package Ejercicio;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {	    
	    Scanner scanner = new Scanner(System.in);
	    Parking parking = new Parking("Parking Central", 10);
	    
	    boolean continuar = true;
	    do {
	        System.out.println("\n|--------- MENU --------|");
	        System.out.println("|-----------------------|");
	        System.out.println("|  1. Entrada de coche  |");
	        System.out.println("|  2. Salida de coche   |");
	        System.out.println("|  3. Mostrar parking   |");
	        System.out.println("|  4. Salir             |");
	        System.out.println("|   Elija una opcion:   |");
	        try {
	            int opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	            case 1:
	                try {
	                    System.out.print("Introduzca la matricula: ");
	                    String matricula = scanner.nextLine();
	                    System.out.print("Introduzca la plaza: ");
	                    int plaza = Integer.parseInt(scanner.nextLine());
	                    
	                    parking.entrada(matricula, plaza);
	                    System.out.printf("Coche con matricula %s aparcado en la plaza %d%n",
	                                      matricula, plaza);
	                    System.out.printf("Plazas totales:%d%n", parking.getPlazasTotales());
	                    System.out.printf("Plazas ocupadas: %d%n", parking.getPlazasOcupadas());
	                    System.out.printf("Plazas libres: %d%n", parking.getPlazasLibres());
	                    
	                } catch (ParkingException e) {
                        System.out.println("Error: " + e.getMensaje() +"  : "+  e.getMatricula());
	                }catch (Exception e) {
	                    System.out.println("Error ");
	                }
	                break;  
	            case 2:
	                try {
	                    System.out.print("Introduzca la matricula: ");
	                    String matricula = scanner.nextLine();
	                    
	                    int plaza = parking.salida(matricula);
	                    System.out.printf("Coche con matricula %s salido de la plaza %d%n",
	                                      matricula, plaza);
	                    System.out.printf("Plazas totales: \n", parking.getPlazasTotales());
	                    System.out.printf("Plazas ocupadas: \n", parking.getPlazasOcupadas());
	                    System.out.printf("Plazas libres: \n", parking.getPlazasLibres());
	                    
	                } catch (ParkingException e) {
                        System.out.println("Error: " + e.getMensaje() + " Matricula: " + e.getMatricula());
	                }catch (Exception e) {
	                    System.out.println("Error ");
	                } 
	                break; 
	            case 3:
	                System.out.println(parking);
	                break;
	                
	            case 4:
	                continuar = false;
	                System.out.println("Muchas gracias por confiar en nosotros, hasta pronto");
	                break;      
	            default:
	                System.out.println("Opcion no valida");
	        }
	        } catch (NumberFormatException e) {
	            System.out.println("Error: Introduzca numero, por favor. ");
	        } 
	    } while (continuar);   
	    scanner.close();
	}
}

