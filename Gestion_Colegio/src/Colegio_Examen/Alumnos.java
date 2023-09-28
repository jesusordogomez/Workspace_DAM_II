package Colegio_Examen;

import java.util.ArrayList;

class Alumnos extends Persona {
    private String numeroAula;
    private ArrayList<Asignatura> asignaturas;

    public Alumnos() {
        asignaturas = new ArrayList<Asignatura>();
    }

    public Alumnos(String nombre, String apellidos, String dni, int edad, String numeroAula) {
        super(nombre, apellidos, dni, edad);
        this.numeroAula = numeroAula;
        asignaturas = new ArrayList<Asignatura>();
    }

    public void addAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public double getNotaAsignatura(String nombreAsignatura) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                return asignatura.getNota();
            }
        }
        return -1;
    }

    public String getNumeroAula() { 
    	return numeroAula;
    }
    public void setNumeroAula(String numeroAula) { 
    	this.numeroAula = numeroAula; 
    }

    public ArrayList<Asignatura> getAsignaturas() { 
    	return asignaturas; 
    }

	@Override
	public String toString() {
		return "Alumnos [numeroAula=" + numeroAula + ", asignaturas=" + asignaturas + "]";
	}
    
 }


