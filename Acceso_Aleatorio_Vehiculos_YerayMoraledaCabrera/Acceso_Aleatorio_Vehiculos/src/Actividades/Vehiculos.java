package Actividades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Vehiculos {
	
	//Atributos
	public String matricula = "";
	public String marca = "";
	public String td = "";
	public Double tamanio_deposito = 0.0;
	public String modelo = "";
	
	//Métodos ( Getter y Setter )
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTd() {
		return td;
	}
	public void setTd(String td) {
		this.td = td;
	}
	public Double getTamanio_deposito() {
		return tamanio_deposito;
	}
	public void setTamanio_deposito(Double tamanio_deposito) {
		this.tamanio_deposito = tamanio_deposito;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//Constructor por defecto
	public Vehiculos() {
	}
	
	//Constructor con todos los parámetros
	public Vehiculos(String matricula, String marca, String td, Double tamanio_deposito, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.td = td;
		this.tamanio_deposito = tamanio_deposito;
		this.modelo = modelo;
	}
	
	public void datos() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuantos coches quiere introducir?");
		int opcion = sc.nextInt();

		for (int i = 0; i < opcion ; i++) {


			//Le pido al usuario los datos, utilizando un "do-while" para poner límite de caracteres 
			//a la hora de leer el dato.
			do {
				System.out.print("Introduce una matrícula: ");
				matricula = sc.next();
			}while( matricula.isEmpty() || matricula.length() > 7 );

			do {
				System.out.print("Introduce la marca del vehículo: ");
				marca = sc.next();
			}while( marca.isEmpty() || marca.length() > 20 );

			do {			
				System.out.print("Introduce el tamaño de depósito: ");
				td = sc.next();
				try {
					tamanio_deposito = Double.parseDouble(td);
				} catch (NumberFormatException e) {
					System.out.println("Has introducido");
				}
			}while( Double.isNaN(tamanio_deposito) || tamanio_deposito <=0 );

			do {
				System.out.print("Introduce el modelo del vehículo: ");
				modelo = sc.next();
			}while( modelo.isEmpty() || modelo.length() > 20 );
		}
		
		setMatricula(matricula);
		setMarca(marca);
		setTamanio_deposito(tamanio_deposito);
		setModelo(modelo);

	}
	
	public void escribirArchivo() {
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("ficheros/MisVehiculos.dat", "rw");
			raf.seek(raf.length());
			
			StringBuffer sb_marca = new StringBuffer();
			StringBuffer sb_modelo = new StringBuffer();
			
			if ( getMatricula() != null ) raf.writeChars(getMatricula());
			
			if ( getMarca() != null ) {
				sb_marca.append(getMarca());
				sb_marca.setLength(20);
				raf.writeChars(sb_marca.toString());
			}

			if ( getTamanio_deposito() != null ) raf.writeDouble(getTamanio_deposito());

			if ( getModelo() != null ) {
				sb_modelo.append(getModelo());
				sb_modelo.setLength(20);
				raf.writeChars(sb_modelo.toString());	
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
	

	
	
	
}