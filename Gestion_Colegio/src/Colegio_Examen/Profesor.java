package Colegio_Examen;

import java.util.Arrays;

class Profesor extends Persona {
//los unicos atributos que tiene profesor son sueldo y que las asignaturas que pueden impartir son exactamente 3
    private Asignatura[] asignaturas = new Asignatura[3];
    private double sueldo;

    public Profesor() {}

    public Profesor(String nombre, String apellidos, String dni, int edad, Asignatura[] asignaturas, double sueldo) {
        super(nombre, apellidos, dni, edad);
        this.asignaturas = asignaturas;
        this.sueldo = sueldo;
    }

    public void incrementarSueldo(double porcentaje) {
        this.sueldo *= 1 + porcentaje/100;
    }

    public Asignatura[] getAsignaturas() {
    	return asignaturas; 
    	}
    public void setAsignaturas(Asignatura[] asignaturas) { 
    	this.asignaturas = asignaturas;
    	}

    public double getSueldo() {
    	return sueldo;
    	}
    public void setSueldo(double sueldo) { 
    	this.sueldo = sueldo; 
    	}

	@Override
	public String toString() {
		return "Profesor [asignaturas=" + Arrays.toString(asignaturas) + ", sueldo=" + sueldo + "]";
	}
    
    
}