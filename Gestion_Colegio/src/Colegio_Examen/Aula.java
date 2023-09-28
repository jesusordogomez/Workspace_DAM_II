package Colegio_Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Aula {
    private String numero;
    private Profesor profesor;
    private ArrayList<Alumnos> alumnos;

    public Aula() {
        alumnos = new ArrayList<Alumnos>();
    }

    public Aula(String numero, Profesor profesor) {
        this.numero = numero;
        this.profesor = profesor;
        alumnos = new ArrayList<Alumnos>();
    }
    public void addAlumno(Alumnos alumno) {
        if (alumnos.size() >= 15) {
            throw new RuntimeException("No se puede añadir más de 15 alumnos al aula");
        } alumnos.add(alumno);
    }
    public void removeAlumno(Alumnos alumno) {
        alumnos.remove(alumno);
    }

    public void mostrarAlumnosAprobados(String nombreAsignatura) {
        System.out.println("Alumnos aprobados en " + nombreAsignatura + ":");
        for (Alumnos alumno : alumnos) {
            double nota = alumno.getNotaAsignatura(nombreAsignatura);
            if (nota >= 5) {
                System.out.println(alumno.getNombre() + " " + alumno.getApellidos());
            }
        }
    }

    public void ordenarAlumnosPorApellidos() {
        Collections.sort(alumnos, new Comparator<Alumnos>() {
            public int compare(Alumnos alumno1, Alumnos alumno2) {
                return alumno1.getApellidos().compareTo(alumno2.getApellidos());
            }
        });
        mostrarAlumnos();
    }

    public void mostrarNotaAlumno(String dniAlumno, String nombreAsignatura) {
        for (Alumnos alumno : alumnos) {
            if (alumno.getDni().equals(dniAlumno)) {
                double nota = alumno.getNotaAsignatura(nombreAsignatura);
                if (nota != -1) {
                    System.out.println("La nota de " + alumno.getNombre() + " " + alumno.getApellidos() +
                            " en " + nombreAsignatura + " es " + nota);
                } else {
                    System.out.println("El alumno no está matriculado en esa asignatura");
                }
                return;
            }
        }
        System.out.println("No se ha encontrado ningún alumno con ese DNI en este aula");
    }

    public void cambiarProfesor(Profesor nuevoProfesor) {
        this.profesor = nuevoProfesor;
    }

    public void incrementarSueldoProfesorado(double porcentaje) {
        this.profesor.incrementarSueldo(porcentaje);
    }

    public void mostrarAula() {
        System.out.println("Aula " + numero + " - Profesor: " + profesor.getNombre() + " " +
                profesor.getApellidos() + " - Asignaturas: " + asignaturasToString());
        System.out.println("Alumnos:");
        mostrarAlumnos();
    }

    private void mostrarAlumnos() {
        for (Alumnos alumno : alumnos) {
            System.out.println(alumno.getNombre() + " " + alumno.getApellidos());
        }
    }

    private String asignaturasToString() {
        String asignaturasString = "";
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            asignaturasString += asignatura.getNombre() + ", ";
        }
        asignaturasString = asignaturasString.substring(0, asignaturasString.length() - 2);
        return asignaturasString;
    }


    public String getNumero() {
    	return numero; 
    	}
    public void setNumero(String numero) { 
    	this.numero = numero; 
    	}

    public Profesor getProfesor() {
    	return profesor; 
    	}
    public void setProfesor(Profesor profesor) {
    	this.profesor = profesor; 
    	}

    public ArrayList<Alumnos> getAlumnos() {
    	return alumnos; 
    	}

	@Override
	public String toString() {
		return "Aula [numero=" + numero + ", profesor=" + profesor + ", alumnos=" + alumnos + "]";
	}
    
    
}