package Ejercicio;

import java.io.*;

public class Menu {

	  public static void main(String[] args) {
	        // Creamos la empresa
	        Empresa empresa = new Empresa("Amazon ", 5);

	        empresa.nuevoEmpleado("Pablo", 1700);
	        empresa.nuevoEmpleado("Sergio", 1000);
	        empresa.nuevoEmpleado("Ana", 2300);
	        empresa.nuevoEmpleado("Yiyi", 1300);
	        empresa.nuevoEmpleado("Kike", 1235);
	        empresa.actualizarFicheroEmpleados();

	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Fichero\\MisEmpleados.dat"))) {
	            System.out.println("...................................");
	            System.out.println(" Empleados guardados en el archivo");
	            System.out.println("...................................");
	            while (true) {
	                Empleado e = (Empleado) in.readObject();
	                System.out.println(e);
	            }
	        } catch (EOFException e) {
	        	
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al leer el fichero de empleados: " + e.getMessage());
	        }

	        empresa.despedirEmpleado(3);
	        empresa.actualizarFicheroEmpleados();
	        
	        System.out.println("  ");
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Fichero\\MisEmpleados.dat"))) {
	            System.out.println("...................................");
	            System.out.println("      Empleados actualizados  ");
	            System.out.println("...................................");
	            while (true) {
	                Empleado e = (Empleado) in.readObject();
	                System.out.println(e);
	            }
	        } catch (EOFException e) {
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al leer el fichero: " + e.getMessage());
	        }
	    }
	}
