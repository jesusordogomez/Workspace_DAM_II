package Ejercicio;

public class Ejecutivo extends Empleado {
    private int presupuesto;

    public Ejecutivo(Empresa empresa, String nombre, int sueldo) {
        super(empresa, nombre, sueldo);
    }

    public Ejecutivo(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
        super(empresa, nombre, sueldo, numEmpleado);
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void asignaPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    
    public String toString() {
        return "Empleado Ejecutivo: " + super.toString();
    }

}
