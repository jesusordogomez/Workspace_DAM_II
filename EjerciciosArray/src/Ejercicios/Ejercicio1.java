package Ejercicios;

import java.util.ArrayList;

public class Ejercicio1 {
  public static void main(String[] args) {
    ArrayList<String> nombre = new ArrayList<String>();

    nombre.add("Jesus");
    nombre.add("Pablo");
    nombre.add("Sergio");
    nombre.add("Santiago");
    nombre.add("kike");
    nombre.add("Jesus");
    nombre.add("Yerai");
    nombre.add("Michelle");
    nombre.add("Jose Luis");
    nombre.add("Alberto");
    nombre.add("Manuel");
    nombre.add("Joserra");
    nombre.add("Ruben");
    nombre.add("Fran");
    nombre.add("Luismi");
    nombre.add("Carolina");
    nombre.add("Rafa");
    nombre.add("Mario");
    nombre.add("Adolfo");
    

    System.out.println("Los alumnos del grupo son:");
    for (String alumno : nombre) {
      System.out.println(alumno);
    }
  }
}


