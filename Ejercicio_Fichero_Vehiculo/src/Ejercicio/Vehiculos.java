package Ejercicio;

import java.io.*;

public class Vehiculos {
    private static final int LONGITUD_REGISTRO = 100;
    private static final int LONGITUD_MATRICULA = 20;
    private static final int LONGITUD_MARCA = 20;
    private static final int LONGITUD_MODELO = 30;
    private static final int LONGITUD_TAMANIO_DEPOSITO = 8;

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("Ficheros\\vehiculos.dat", "rw")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int opcion;
            do {
                System.out.println("********** MENU **********");
                System.out.println("1. Registrar un nuevo coche");
                System.out.println("2. Buscar coche por número de registro");
                System.out.println("3. Salir");
                System.out.print("Ingrese la opción deseada: ");
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        registrarCoche(file, reader);
                        break;
                    case 2:
                        buscarCoche(file, reader);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcian invalida, intentelo de nuevo");
                        break;
                }
            } while (opcion != 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    	private static void registrarCoche(RandomAccessFile file, BufferedReader reader) throws IOException {
    	    System.out.print("Ingrese la matricula del vehiculo: ");
    	    String matricula = reader.readLine();
    	    file.seek(0);
    	    while (file.getFilePointer() < file.length()) {
    	        String matriculaStored = readString(file, LONGITUD_MATRICULA);
    	        if (matricula.equalsIgnoreCase(matriculaStored)) {
    	            System.out.println("Error: Ya existe un vehículo registrado con esa matrícula.");
    	            return;
    	        }
    	        file.skipBytes(LONGITUD_MATRICULA);
    	        file.skipBytes(LONGITUD_MARCA);
    	        file.skipBytes(LONGITUD_TAMANIO_DEPOSITO);
    	        file.skipBytes(LONGITUD_MODELO);
    	    }

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = reader.readLine();
        System.out.print("Ingrese el tamaño del depósito del vehículo: ");
        double tamanioDeposito=0.0;
		try {
            tamanioDeposito = Double.parseDouble(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Valor inválido para el tamaño del depósito. Debe ser un número decimal.");
            return;
        }
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = reader.readLine();

        file.seek(file.length());
        writeString(file, matricula, LONGITUD_MATRICULA);
        writeString(file, marca, LONGITUD_MARCA);
        writeDouble(file, tamanioDeposito);
        writeString(file, modelo, LONGITUD_MODELO);

        System.out.println("Coche registrado correctamente.");
    }

    private static void buscarCoche(RandomAccessFile file, BufferedReader reader) throws IOException {
        int numVehiculos = (int) (file.length() / LONGITUD_REGISTRO);
        if (numVehiculos == 0) {
            System.out.println("No hay coches registrados.");
            return;
        }

        System.out.print("Ingrese el número de registro del coche: ");
        int numRegistro = Integer.parseInt(reader.readLine());

        if (numRegistro > 0 && numRegistro <= numVehiculos) {
            file.seek((numRegistro - 1) * LONGITUD_REGISTRO);
            String matriculaStored = readString(file, LONGITUD_MATRICULA);
            String marcaStored = readString(file, LONGITUD_MARCA);
            double tamanioDepositoStored = readDouble(file);
            String modeloStored = readString(file, LONGITUD_MODELO);
            System.out.println("Datos del vehículo " + numRegistro + ":" + "Matrícula: " + matriculaStored + "Marca: " + marcaStored + "Tamaño del depósito: " + tamanioDepositoStored + "Modelo: " + modeloStored);
        } else {
            System.out.println("El número de registro ingresado no es válido.");
        }
    }

    private static void writeString(RandomAccessFile file, String value, int length) throws IOException {
        StringBuilder sb = new StringBuilder(value);
        sb.setLength(length);
        file.writeChars(sb.toString());
    }

    private static String readString(RandomAccessFile file, int length) throws IOException {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars).trim();
    }

    private static void writeDouble(RandomAccessFile file, double value) throws IOException {
        file.writeDouble(value);
    }

    private static double readDouble(RandomAccessFile file) throws IOException {
        return file.readDouble();
    }
}
