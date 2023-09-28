package Ejercicio;

import java.io.Serializable;

public class Empleado implements Serializable {
	
		private String nombre;
	    private int sueldo;
	    private final int numEmpleado;
	    private static int contador = 0;
		private Empresa empresa;

	    public Empleado(Empresa empresa, String nombre, int sueldo) {
	        this.nombre = nombre;
	        this.sueldo = sueldo;
	        this.numEmpleado = ++contador;
	        empresa.guardarEmpleados();
	    }

	    protected Empleado(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
	        this.nombre = nombre;
	        this.sueldo = sueldo;
	        this.numEmpleado = numEmpleado;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getSueldo() {
	        return sueldo;
	    }

	    public int getNumEmpleado() {
	        return numEmpleado;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setSueldo(int sueldo) {
	        this.sueldo = sueldo;
	    }

	    public void aumentarSueldo(int porcentaje) {
	        sueldo += sueldo * porcentaje / 100;
	    }

	    public void despedir() {
	        empresa = null;
	        for (int i = 0; i < empresa.getTamaño(); i++) {
	            if (empresa.getEmpleado(i) != null && empresa.getEmpleado(i).getNumEmpleado() == numEmpleado) {
	                empresa.despideEmpleado(i);
	                empresa.guardarEmpleados();
	                break;
	            }
	        }
	    }
	    public String toString() {
	        return " * Empleado " + numEmpleado + ": " + nombre + " -> Sueldo: " + sueldo;
	    	}
	}