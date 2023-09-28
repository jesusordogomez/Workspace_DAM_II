package Ejercicio;

public class Main {

	public static void main(String[] args) {
		   Empresa empresa = new Empresa("AMAZON", 5);

		    empresa.nuevoEmpleado("Sergio", 1800);
		    empresa.nuevoEmpleado("Ana", 2500);
		    empresa.nuevoEmpleado("Santiago", 1548);
		    empresa.nuevoEmpleado("Yerai", 3548);
		    empresa.nuevoEmpleado("Carolina", 1846);
		    empresa.nuevoEmpleado("Jesus", 4458);

		    for (int i = 1; i < empresa.getTamaño(); i++) {
		        Empleado empleado = empresa.getEmpleado(i);
		        if (empleado != null) {
		            System.out.println(empleado);
		        }
		    }

		    System.out.println("\nDespidiendo a Carolina");
		    empresa.despideEmpleado(2);

		    System.out.println("\nEmpleados despues de despedir a Carolina");
		    for (int i = 1; i < empresa.getTamaño(); i++) {
		        Empleado empleado = empresa.getEmpleado(i);
		        if (empleado != null) {
		            System.out.println(empleado);
		        }
		    }

		    System.out.println("\nAscendiendo a Ana");
		    empresa.getEmpleado(1).ascender();

		    System.out.println("\nEmpleados después de ascender a Ana");
		    System.out.println("Sueldo aumentado de Ana");
		    empresa.getEmpleado(1).aumentarSueldo(15);
		    for (int i = 1; i < empresa.getTamaño(); i++) {
		        Empleado empleado = empresa.getEmpleado(i);
		        if (empleado != null) {
		            System.out.println(empleado);
		        }
		    }
		}
}


