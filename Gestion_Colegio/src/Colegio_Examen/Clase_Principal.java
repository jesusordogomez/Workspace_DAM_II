package Colegio_Examen;

import java.util.Scanner;

public class Clase_Principal{

	public static void main(String[] args) {
        Asignatura[] asignaturas1 = {
        		new Asignatura("Programacion", 3), new Asignatura("Sistemas", 7), new Asignatura("Entornos", 0)
        		};
        Asignatura[] asignaturas2 = {
        		new Asignatura("Programacion", 3), new Asignatura("Sistemas", 7), new Asignatura("Entornos", 0)
        		};
        Profesor profesor1 = new Profesor("Jesus", "Ordoñez", "158145D", 35, asignaturas1, 1600);
        Profesor profesor2 = new Profesor("Pablo", "Nuñez", "878787B", 35, asignaturas2, 1800);
        Profesor profesor3 = new Profesor("Sergio", "Ruiz", "445112E", 35, asignaturas1, 1145);

        Aula aula1 = new Aula("1A", profesor1);

        Scanner sc = new Scanner(System.in);

        String numeroAula, dniAlumno, nombreAsignatura;
        int opcion;
        double porcentaje;

        do {
            System.out.println("------------------------------MENU PRINCIPAL-----------------------------");
            System.out.println("1. Insertar Alumno en un aula                                            |");
            System.out.println("2. Eliminar Alumno de un aula                                            |");
            System.out.println("3. Mostrar Alumnos que han aprobado una determinada asignatura           |");
            System.out.println("4. Ordenar Alumnos de un aula en orden creciente por sus apellidos       |");
            System.out.println("5. Mostrar la nota del alumno en una determinada asignatura              |");
            System.out.println("6. Cambiar el Profesor de un aula                                        |");
            System.out.println("7. Aumentar/Reducir sueldo de todo el profesorado                        |");
            System.out.println("0. Salir                                                                 |");
            System.out.println("Introduzca una opcion, gracias:                                          |");
            System.out.println("-------------------------------------------------------------------------");
            
     
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el numero de aula: ");
                    numeroAula = sc.next();
                    System.out.print("Introduzca el nombre del alumno: ");
                    String nombreAlumno = sc.next();
                    System.out.print("Introduzca los apellidos del alumno: ");
                    String apellidosAlumno = sc.next();
                    System.out.print("Introduzca el DNI del alumno: ");
                    dniAlumno = sc.next();
                    System.out.print("Introduzca la edad del alumno: ");
                    int edadAlumno = sc.nextInt();
                    Alumnos alumno = new Alumnos(nombreAlumno, apellidosAlumno, dniAlumno, edadAlumno, numeroAula);
                    aula1.addAlumno(alumno);
                    System.out.println("Alumno añadido correctamente al aula " + numeroAula);
                    break;
                case 2:
                    System.out.print("Introduzca el DNI del alumno que desea eliminar: ");
                    dniAlumno = sc.next();
                    Alumnos alumnoAEliminar = null;
                    for (Alumnos alumno1 : aula1.getAlumnos()) {
                        if (alumno1.getDni().equals(dniAlumno)) {
                            alumnoAEliminar = alumno1;
                            break;
                        }
                    }
                    if (alumnoAEliminar != null) {
                        aula1.removeAlumno(alumnoAEliminar);
                        System.out.println("Alumno eliminado correctamente del aula " + aula1.getNumero());
                    } else {
                        System.out.println("No se ha encontrado ningún alumno con ese DNI en este aula");
                    }
                    break;
                case 3:
                    System.out.print("Introduzca el nombre de la asignatura: ");
                    nombreAsignatura = sc.next();
                    aula1.mostrarAlumnosAprobados(nombreAsignatura);
                    break;
                case 4:
                    aula1.ordenarAlumnosPorApellidos();
                    break;
                case 5:
                    System.out.print("Introduzca el DNI del alumno: ");
                    dniAlumno = sc.next();
                    System.out.print("Introduzca el nombre de la asignatura: ");
                    nombreAsignatura = sc.next();
                    aula1.mostrarNotaAlumno(dniAlumno, nombreAsignatura);
                    break;
                case 6:
                    System.out.print("Introduzca el nombre del nuevo profesor: ");
                    String nombreProfesor = sc.next();
                    System.out.print("Introduzca los apellidos del nuevo profesor: ");
                    String apellidosProfesor = sc.next();
                    System.out.print("Introduzca el DNI del nuevo profesor: ");
                    String dniProfesor = sc.next();
                    System.out.print("Introduzca la edad del nuevo profesor: ");
                    int edadProfesor = sc.nextInt();
                    Asignatura[] asignaturasProfesor = {new Asignatura("Matemáticas", 0), new Asignatura("Lengua", 0), new Asignatura("Inglés", 0)};
                    Profesor nuevoProfesor = new Profesor(nombreProfesor, apellidosProfesor, dniProfesor, edadProfesor, asignaturasProfesor, 2000);
                    aula1.cambiarProfesor(nuevoProfesor);
                    System.out.println("El profesor del aula " + aula1.getNumero() + " ha sido cambiado correctamente");
                    break;
                case 7:
                    System.out.print("Introduzca el porcentaje de incremento o decremento del sueldo: ");
                    porcentaje = sc.nextDouble();
                    aula1.incrementarSueldoProfesorado(porcentaje);
                    System.out.println("El sueldo de todo el profesorado ha sido actualizado correctamente");
                    break;
                case 0:
                    System.out.println("Gracias por su tiempo, hasta pronto");
                    break;
                default:
                    System.out.println("Introduzca los numeros correspondiente al dato que quieres acceder, gracias");
            }

            System.out.println();
        } while (opcion != 0);

    }
}
