package Ejercicio3;

import java.io.*;

public class Ejercicio_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
        String ruta = "Vehiculos.dat";
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduzca la matricula: ");
        String matricula = "";
        try {
            matricula = lectura.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        	}
        System.out.print("Introduzca la marca: ");
        String marca = "";
        try {
            marca = lectura.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        	}
        System.out.print("Introduzca el tamaño del deposito: ");
        double tamañoDeposito = 0;
        try {
            tamañoDeposito = Double.parseDouble(lectura.readLine());
        } catch (NumberFormatException e) {
            System.out.println("El dato introducido no es valido, introduzca un decimal.");
            tamañoDeposito = Double.parseDouble(lectura.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Introduzca el modelo: ");
        String modelo = "";
        try {
            modelo = lectura.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        	}

        try (DataOutputStream escribir = new DataOutputStream(new FileOutputStream(ruta, true));
             DataInputStream leer = new DataInputStream(new FileInputStream(ruta))) {
            escribir.writeUTF(matricula);
            escribir.writeUTF(marca);
            escribir.writeDouble(tamañoDeposito);
            escribir.writeUTF(modelo);
            leer.mark(0);

            while (true) {
                try {
                    System.out.println("El vehiculo tiene una matricula " + leer.readUTF() + ", su marca es " + leer.readUTF() +
                            ", el tamaño del deposito es de " + leer.readDouble() + " litros y su modelo es " + leer.readUTF());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
