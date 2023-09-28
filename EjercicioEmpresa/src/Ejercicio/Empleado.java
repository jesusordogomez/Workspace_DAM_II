package Ejercicio;

public class Empleado {
	 protected String nombre;
	  protected int sueldo;
	  protected int numEmpleado;
	  private static int contador = 0;
	  private Empresa empresa;


	  public Empleado(Empresa empresa, String nombre, int sueldo) {
	    this.empresa = empresa;
	    this.nombre = nombre;
	    this.sueldo = sueldo;
	    this.numEmpleado = ++contador;
	  }

	  protected Empleado(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
	    this.empresa = empresa;
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

	  public final void aumentarSueldo(int porcentaje) {
	    sueldo += sueldo * porcentaje / 100;
	  }

	  public void despedir() {
	    empresa.despideEmpleado(numEmpleado);
	  }

	  public void ascender() {
		    Ejecutivo ejecutivo = new Ejecutivo(empresa, nombre, sueldo, numEmpleado);
		    int index = numEmpleado - 1;
		    empresa.setEmpleado(index, ejecutivo);
		  }
	  
	  public String toString() {
	    return "Empleado " + numEmpleado + ": " + nombre + ", sueldo = " + sueldo;
	  }
}
