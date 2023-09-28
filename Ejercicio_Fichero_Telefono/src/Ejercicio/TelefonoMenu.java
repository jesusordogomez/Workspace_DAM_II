package Ejercicio;

import java.io.*;
import java.util.*;

public class TelefonoMenu {
    public static void main(String[] args) {

        String rutaArchivo = "Fichero\\telefonos.txt";
        File archivo = null;
        FileReader leer = null;
        BufferedReader buf = null;
        String[] telefonos = null;

        try {
            archivo = new File(rutaArchivo);
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);

            int numLineas = 0;
            while (buf.readLine() != null) {
                numLineas++;
            }
            buf.close();
            telefonos = new String[numLineas];

            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);
            String linea;
            int i = 0;
            while ((linea = buf.readLine()) != null) {
                telefonos[i] = linea;
                i++;
            }

            Scanner sc = new Scanner(System.in);
            Random random = new Random();
            int opcion = 0;
            while (opcion != 2) {
                System.out.println("************** MENU **************");
                System.out.println("1. Obtener numero de telefono al azar");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        int indice = random.nextInt(numLineas);
                        System.out.println("Numero de telefono elegido al azar: " + telefonos[indice]);
                        break;
                    case 2:
                        System.out.println("Has salido correctamente.");
                        break;
                    default:
                        System.out.println("Opcion no valida, intentelo de nuevo.");
                        break;
                }
            }
        }catch(InputMismatchException e) {
        	System.out.println("Introduce un numero correcto");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != buf) {
                    buf.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

