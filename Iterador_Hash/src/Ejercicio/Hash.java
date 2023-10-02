package Ejercicio;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Hash<table> {
    private Hashtable<String, table> hashtable = new Hashtable<String, table>();
    private Set<String> numerosEliminados = new HashSet<String>();


    public boolean existeNumero(String key) {
        return hashtable.containsKey(key);
    }

    public void insertarDato(String key, table value) {
        if (!existeNumero(key)) {
            hashtable.put(key, value);
        } else {
            System.out.println("El numero ya existe en la lista.");
        }
    }

    public void borrarDato(String key) {
        if (existeNumero(key) && !numerosEliminados.contains(key)) {
            hashtable.remove(key);
            numerosEliminados.add(key);
            System.out.println(" * Número eliminado * ");
        } else if (numerosEliminados.contains(key)) {
            System.out.println(" * El numero ya ha sido eliminado previamente *");
        } else {
            System.out.println("El numero no existe en la lista ");
        }
    }

    public void mostrarDatos() {
        Iterator<String> iterator = hashtable.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            table value = hashtable.get(key);
            System.out.println("Número: " + key + ", Valor: " + value);
        }
    }

    public static void main(String[] args) {
        Hash<Integer> numeros = new Hash<Integer>();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n|___________MENU__________|");
            System.out.println("1. Insertar numero");
            System.out.println("2. Mostrar numeros");
            System.out.println("3. Borrar numero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: \n");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero: ");
                    String numero = scanner.nextLine();
                    try {
                        Integer valor = Integer.parseInt(numero);
                        numeros.insertarDato(numero, valor);
                        System.out.println(" * Numero insertado * ");
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese un numero");
                    }
                    break;

                case 2:
                    System.out.println("Numeros almacenados:");
                    numeros.mostrarDatos();
                    break;

                case 3:
                    System.out.print("Ingrese el numero a borrar: ");
                    String numeroAEliminar = scanner.nextLine();
                    numeros.borrarDato(numeroAEliminar);
                    System.out.println("Número eliminado.");
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion erronea");
                    break;
            }
        }

        scanner.close();
        System.out.println("Has salido de la aplicacion");
    }
}

    

