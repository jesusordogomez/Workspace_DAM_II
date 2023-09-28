package Ejercicio;

public class Empresa {
	    private String nombre;
	    private final int tamaño;
	    private Empleado[] empleados;
	    private int contadorEmpleado;

	    
	    public Empresa(String nombre, int tamaño) {
	        this.nombre = nombre;
	        this.tamaño = tamaño;
	        this.empleados = new Empleado[tamaño];
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getTamaño() {
	        return tamaño;
	    }

	    public Empleado getEmpleado(int i) {
	        if (i >= 0 && i < tamaño) {
	            return empleados[i];
	        }
	        return null;
	    }

	    public void despideEmpleado(int i) {
	        if (i >= 0 && i < tamaño) {
	            empleados[i] = null;
	        }
	    }
	    public void nuevoEmpleado(String nombre, int sueldo) {
	        if (contadorEmpleado < tamaño) {
	          empleados[contadorEmpleado] = new Empleado(this, nombre, sueldo, contadorEmpleado);
	          contadorEmpleado++;
	        } else {
	          System.out.println("No es posible contratar mas empleados");
	        }
	      }

		public void setEmpleado(int index, Ejecutivo ejecutivo) {
		}
	  
}
