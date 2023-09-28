package Banco;
public class Empleado extends DatosPersonales implements I_Empleado {


	private String FechaContratacion;
	private String PuestoTrabajo;
	private double Sueldo;
	private int AnyoExp;

	public Empleado(String dni, String nombre, String apellido, String telefono, String correo, String dP,
			String localidad, int cP, String provincia, String fechaN, String observaciones, String fechaContratacion,
			String puestoTrabajo, double sueldo, int anyoExp) {
		super(dni, nombre, apellido, telefono, correo, dP, localidad, cP, provincia, fechaN, observaciones);
		FechaContratacion = fechaContratacion;
		PuestoTrabajo = puestoTrabajo;
		Sueldo = sueldo;
		AnyoExp = anyoExp;
	}
	
	public String getFechaContratacion() {
		return FechaContratacion;
	}
	
	public void setFechaContratacion(String fechaContratacion) {
		FechaContratacion = fechaContratacion;
	}
	
	public String getPuestoTrabajo() {
		return PuestoTrabajo;
	}
	
	public void setPuestoTrabajo(String puestoTrabajo) {
		PuestoTrabajo = puestoTrabajo;
	}
	
	public double getSueldo() {
		return Sueldo;
	}
	
	public void setSueldo(double sueldo) {
		Sueldo = sueldo;
	}
	
	public int getAnyoExp() {
		return AnyoExp;
	}
	
	public void setAnyoExp(int anyoExp) {
		AnyoExp = anyoExp;
	}

	@Override
	public void aumentoSalarial(double porcentaje) {
        double aumento = Sueldo * porcentaje / 100;
        Sueldo += aumento;
    }

    public void ascenso(String nuevoPuesto, double nuevoSueldo) {
    	PuestoTrabajo = nuevoPuesto;
        Sueldo = nuevoSueldo;
    }

	@Override
	public String toString() {
		return "Empleados [FechaContratacion=" + FechaContratacion + ", PuestoTrabajo=" + PuestoTrabajo + ", Sueldo="
				+ Sueldo + ", AnyoExp=" + AnyoExp + "]";
	}
}

