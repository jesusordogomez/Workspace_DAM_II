package Ejercicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashtable {
    private HashMap<Integer, Integer> table;

    public Hashtable() {
        table = new HashMap<>();
    }

    public void insertarDato(Integer clave, Integer valor) {
        int index = hash(clave);
        while (table.containsKey(index)) {
            index = linearProbe(index);
        }
        table.put(index, valor);
    }

    public void borrarDato(Integer clave) {
        int index = hash(clave);
        while (table.containsKey(index) && !table.get(index).equals(clave)) {
            index = linearProbe(index);
        }
        if (table.containsKey(index)) {
            table.remove(index);
            System.out.println("Número eliminado.");
        } else {
            System.out.println("La clave no existe.");
        }
    }

    public void mostrarDatos() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < 10; i++) {
            if (table.containsKey(i)) {
                System.out.println("Posición " + i + ": " + table.get(i));
            } else {
                System.out.println("Posición " + i + ": ( )");
            }
        }
    }

    private int hash(int key) {
        return key % 10;
    }

    private int linearProbe(int index) {
        return (index + 1) % 10;
    }

    public static void main(String[] args) {
        Hashtable tablaHash = new Hashtable();
        Scanner scanner = new Scanner(System.in);
        int contador = 0;

        while (true) {
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
                    if (contador < 10) {
                        System.out.print("Ingrese el número: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        tablaHash.insertarDato(numero, numero);
                        contador++;
                        System.out.println(" * Número insertado * ");
                    } else {
                        System.out.println("La tabla está llena. No puedes insertar más datos a menos que borres alguno.");
                    }
                    break;

                case 2:
                    tablaHash.mostrarDatos();
                    break;

                case 3:
                    System.out.print("Ingrese el número a borrar: ");
                    int numeroAEliminar = scanner.nextInt();
                    scanner.nextLine();
                    tablaHash.borrarDato(numeroAEliminar);
                    contador--;
                    break;

                case 4:
                    scanner.close();
                    System.out.println("Has salido de la aplicación");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }

}