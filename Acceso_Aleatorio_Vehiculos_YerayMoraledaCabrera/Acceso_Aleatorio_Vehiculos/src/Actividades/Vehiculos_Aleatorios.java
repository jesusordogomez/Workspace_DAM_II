package Actividades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.GuardedObject;
import java.util.Scanner;

public class Vehiculos_Aleatorios {

	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile raf = null;

	static String codigoarticulo = ""; // 7 caracteres por 2 bytes = 14 bytes
	static String descripcion = ""; // 20 caracteres como límite = 40 bytes
	static String caracteristicas = "";
	static String Departamento = ""; // 8 bytes
	static Double Precio = 0.00; 
	static int Stock=0;
	static String Proveedor="";// 20 caracteres como limite = 40 bytes

	//Sumamos y obtenemos el total de bytes que ocupa cada vehículo
	static int longitudRegistro = 145;

	static Vehiculos vehiculos = new Vehiculos();


	public static void leerArchivo() {

		try{
			raf = new RandomAccessFile("almacen.dat", "r");

			System.out.println("\n¿Qué vehículo quiere visualizar?");
			int numero_vehiculo = sc.nextInt();

			String cadena_vehiculos = "";

			raf.seek(longitudRegistro * (numero_vehiculo - 1));

			byte[] arrayBytes = new byte[102];

			raf.read(arrayBytes, 0, 14);
			String matricula = new String(arrayBytes, 0 , 14);

			raf.read(arrayBytes, 14, 40);
			String marca = new String(arrayBytes, 14, 40).trim();

			Double td_aux = raf.readDouble();

			raf.read(arrayBytes, 62, 40);
			String modelo = new String(arrayBytes, 62, 40).trim();

			cadena_vehiculos += "Matrícula: " + matricula + "\t Marca: " + marca + "\t Tamaño depósito: " + td_aux + "\t Modelo: " + modelo;

			System.out.println(cadena_vehiculos);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if ( raf != null ) raf.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

public static void leerTodosVehiculos() {
		
		try {
			raf = new RandomAccessFile("ficheros/MisVehiculos.dat", "r");
			int num_vehiculo = 1;
			String cadena_vehiculo = "";
			
			while (raf.getFilePointer() < raf.length()) {
				byte[] arrayBytes = new byte[longitudRegistro];
				
				raf.read(arrayBytes);
				raf.read(arrayBytes, 0, 14);
				String matricula = new String(arrayBytes, 0 , 14);
				
				raf.read(arrayBytes, 14, 40);
				String marca = new String(arrayBytes, 14, 40).trim();
				
				Double td_aux = raf.readDouble();
				
				raf.read(arrayBytes, 62, 40);
				String modelo = new String(arrayBytes, 62, 40).trim();
				
				cadena_vehiculo += "\nVehículo [" + num_vehiculo + "]\t Matricula: " + matricula + "\t Marca:" + marca + "\t Tamaño del depósito: " + td_aux + "\t Modelo: " + modelo;
				
				System.out.println(cadena_vehiculo);
				num_vehiculo++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if ( raf != null ) raf.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}


	}




	public static void main(String[] args) {

		vehiculos.datos();

		try {
			vehiculos.escribirArchivo();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		leerTodosVehiculos();
		leerArchivo();


	}

}