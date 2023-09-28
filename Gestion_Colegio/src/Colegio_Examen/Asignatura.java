package Colegio_Examen;

public class Asignatura {
	//En la clase asignatura solo tiene como atributo nombre y nota
    private String nombre;
    private double nota;

    public Asignatura() {}

    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
