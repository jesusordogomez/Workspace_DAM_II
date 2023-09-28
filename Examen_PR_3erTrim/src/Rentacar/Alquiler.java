package Rentacar;

import java.sql.*;
import java.util.Scanner;

public class Alquiler {
    public static void main(String[] args) {
        Connection connection = obtenerConexion();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("[______________MENU________________________]");
            System.out.println("\t 1. Coches disponibles");
            System.out.println("\t 2. Actualizar datos de un vehiculo");
            System.out.println("0. Salir\n");
            System.out.print("Selecciona una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error, intentalo de nuevo");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarVehiculosDisponibles(connection);
                    break;
                case 2:
                    actualizarDatosVehiculo(connection);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Error, intentalo de nuevo");
                    break;
            }

            System.out.println();
        } while (opcion != 0);

        cerrarConexion(connection);
        scanner.close();
    }

    public static void mostrarVehiculosDisponibles(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT v.matricula, v.marca, v.modelo, v.combustible, a.fecha_alquiler " +
                    "FROM vehiculos v " +
                    "LEFT JOIN alquileres a ON v.matricula = a.matricula_vehiculo";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String matricula = resultSet.getString("matricula");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String combustible = resultSet.getString("combustible");
                Date fechaAlquiler = resultSet.getDate("fecha_alquiler");

                System.out.println("\t Matricula: " + matricula);
                System.out.println("\t Marca: " + marca);
                System.out.println("\t Modelo: " + modelo);
                System.out.println("\t Combustible: " + combustible);
                System.out.println("\t Fecha de alquiler: " + fechaAlquiler);
                System.out.println("-----------------------------------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar los vehiculos : " + e.getMessage());
        }
    }

    public static void actualizarDatosVehiculo(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la matrícula del vehiculo a actualizar: ");
        String matricula = scanner.nextLine();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM vehiculos WHERE matricula = '" + matricula + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String marcaActual = resultSet.getString("marca");
                String modeloActual = resultSet.getString("modelo");
                String combustibleActual = resultSet.getString("combustible");

                System.out.println("Datos actuales del vehiculo:");
                System.out.println("Matricula: " + matricula);
                System.out.println("Marca: " + marcaActual);
                System.out.println("Modelo: " + modeloActual);
                System.out.println("Combustible: " + combustibleActual);

                System.out.print("\nIngrese la nueva marca del vehiculo: ");
                String nuevaMarca = scanner.nextLine();

                System.out.print("Ingrese el nuevo modelo del vehiculo: ");
                String nuevoModelo = scanner.nextLine();

                System.out.print("Ingrese el nuevo combustible del vehiculo: ");
                String nuevoCombustible = scanner.nextLine();

                String updateQuery = "UPDATE vehiculos SET marca = ?, modelo = ?, combustible = ? WHERE matricula = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, nuevaMarca);
                preparedStatement.setString(2, nuevoModelo);
                preparedStatement.setString(3, nuevoCombustible);
                preparedStatement.setString(4, matricula);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Datos actualizados.");

                    System.out.println("\nNuevos datos del vehiculo:");
                    System.out.println("Matricula: " + matricula);
                    System.out.println("Marca: " + nuevaMarca);
                    System.out.println("Modelo: " + nuevoModelo);
                    System.out.println("Combustible: " + nuevoCombustible);
                } else {
                    System.out.println("\nError, no se ha podido actualizar");
                }

                preparedStatement.close();
            } else {
                System.out.println("\nNo hay ningun coche con esa matricula");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del vehículo: " + e.getMessage());
        }
    }

    private static Connection obtenerConexion() {
        conexion conexion = new conexion();
        return conexion.getConnection();
    }

    private static void cerrarConexion(Connection connection) {
        conexion conexion = new conexion();
        conexion.cerrarConexion();
    }
}