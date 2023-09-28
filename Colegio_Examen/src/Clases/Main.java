package Clases;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 // Creamos algunos grupos
        Grupo grupo1 = new Grupo(1, "A");
        Grupo grupo2 = new Grupo(1, "B");
        
        // Añadimos algunos alumnos a los grupos
        grupo1.addAlumnos(new Alumnos("Juan", "Pérez", 5));
        grupo1.addAlumno(new Alumnos("María", "García", 6));
        grupo2.addAlumno(new Alumnos("Pedro", "Sánchez", 3));
        grupo2.addAlumno(new Alumnos("Laura", "López", 8));
        
        // Creamos un curso con los grupos creados
        Curso curso1 = new Curso(1, "ESO", new Grupo[] {grupo1, grupo2});
        
        // Mostramos los datos del curso por pantalla
        System.out.println("Nombre del curso: " + curso1.getNombreCurso());
        System.out.println("Nota media del curso: " + curso1.getNotaMedia());
        
        // Mostramos los datos de los grupos por pantalla
        for (IGrupo grupo : curso1.getListaGrupos()) {
            System.out.println("Grupo " + grupo.getLetraGrupo() + " del curso " + grupo.getNumeroGrupo());
            System.out.println("Alumnos:");
            for (Alumno alumno : grupo.getListaAlumnos()) {
                System.out.println(alumno.getApellido() + ", " + alumno.getNombre() + " - DNI: " + alumno.getDni());
            }
        }
    
	}

}
