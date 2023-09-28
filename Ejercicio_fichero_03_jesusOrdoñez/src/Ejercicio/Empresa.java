package Ejercicio;

import java.io.*;

public class Empresa {

	private String nombre;
    private int tamaño;
    private Empleado[] persona;

    public Empresa(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        persona = new Empleado[tamaño];
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Empleado getEmpleado(int indice) {
        return persona[indice];
    }

    public void despideEmpleado(int indice) {
        persona[indice] = null;
    }

    public void nuevoEmpleado(String nombre, int sueldo) {
        for (int i = 0; i < tamaño; i++) {
            if (persona[i] == null) {
                persona[i] = new Empleado(this, nombre, sueldo);
                guardarEmpleados();
                return;
            }
        }
        System.out.println("Empresa completa.");
    }

    public void guardarEmpleados() {
        try {
            ObjectOutputStream Output = new ObjectOutputStream(
                    new FileOutputStream("Fichero\\MisEmpleados.dat"));
            for (Empleado empleado : persona) {
                if (empleado != null) {
                    Output.writeObject(empleado);
                }
            }
            Output.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los empleados en el archivo.");
        }
    }
    
    public void despedirEmpleado(int numEmpleado) {
        if (numEmpleado >= 0 && numEmpleado < persona.length) {
            persona[numEmpleado] = null;
            actualizarFicheroEmpleados();
            System.out.println("   Empleado [#" + (numEmpleado+1) +"]"+ " despedido.");
        } else {
            System.out.println("Error.");
        }
    }
    
    public void actualizarFicheroEmpleados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Fichero\\MisEmpleados.dat"))) {
            for (Empleado e : persona) {
                if (e != null) {
                    out.writeObject(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero de empleados: " + e.getMessage());
        }
    }


}