package Gestor;

import java.util.Date;

public class Tarea {
    private String nombre;
    private String descripcion;
    private Date fecha;

    // Constructor
    public Tarea(String nombre, String descripcion, Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Métodos getter y setter para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Método toString para representar la tarea como una cadena
    @Override
    public String toString() {
        return "Tarea [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
    }
}
