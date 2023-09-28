package Ejercicio02;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio2 {

			private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
			private final static String bd = "vehiculos";
			private final static String username = "root";
			private final static String password = "root";
			private final static String servidor= "localhost:3306/" + bd;
			private final static String url = "jdbc:mysql://" + servidor;

			public static Connection conexionBBDD () {
				Connection conec = null;

				try {
					Class.forName(DRIVER);
					conec = DriverManager.getConnection(url, username, password);
				} catch (Exception e) {
					System.err.println("error al conectar la base de datos."+ e);
				}
				return conec;
			}
			public static void cerrarConexion(Connection conection) {
				try {
					conection.close();
				}catch (SQLException e) {
					System.out.println("error" + e );
				}
			}
			
			public static void  insertarDatos() {
				
				Connection conec = conexionBBDD();
				
				try {
					Statement consulta = conec.createStatement(); 
					consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('ABC123', 'Ford', 'Focus', 2018, 120, 5, 50, 7.5, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('DEF456', 'Toyota', 'Corolla', 2020, 140, 5, 45, 6.8, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('GHI789', 'Renault', 'Clio', 2019, 90, 5, 40, 5.5, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('JKL012', 'Audi', 'A3', 2021, 150, 5, 55, 8.2, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('MNO345', 'Volkswagen', 'Golf', 2020, 115, 5, 50, 6.5, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('PQR678', 'BMW', 'X1', 2021, 190, 5, 60, 9.5, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('STU901', 'Seat', 'Ibiza', 2020, 110, 5, 45, 6.0, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('VWX234', 'Hyundai', 'Tucson', 2019, 130, 5, 55, 7.8, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('YZA567', 'Ford', 'Mustang', 2017, 300, 4, 60, 12.5, true, 'Sin observaciones');");
            consulta.executeUpdate("INSERT INTO VEHICULOS (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones) "
                            + "VALUES ('BCD890', 'Mercedes-Benz', 'E-Class', 2022, 250, 5, 65, 9.0, true, 'Sin observaciones');");				
					System.out.println("Datos insertados correctamente");
					
					consulta.close();
				}catch(SQLException e) {
					System.out.println("Error al insertar datos" + e );
				} finally {
					cerrarConexion(conec);
				}
			}
			
			
			public static void  consultaDatos() {
				
				Connection conec = conexionBBDD();
				
				try {
					Statement consulta = conec.createStatement(); 
					ResultSet select = consulta.executeQuery("select * from vehiculos");
		            while (select.next()) {
		                int idVehiculo = select.getInt("ID_Vehiculo");
		                String matricula = select.getString("Matricula");
		                String marca = select.getString("Marca");
		                String modelo = select.getString("Modelo");
		                int anyo = select.getInt("Anyo");
		                int potencia = select.getInt("Potencia");
		                int plazas = select.getInt("Plazas");
		                double deposito = select.getDouble("Deposito");
		                double consumo = select.getDouble("Consumo");
		                boolean lCorrecto = select.getBoolean("L_correcto");
		                String observaciones = select.getString("Observaciones");

		                System.out.println("ID: " + idVehiculo);
		                System.out.println("Matricula: " + matricula);
		                System.out.println("Marca: " + marca);
		                System.out.println("Modelo: " + modelo);
		                System.out.println("Año: " + anyo);
		                System.out.println("Potencia: " + potencia);
		                System.out.println("Plazas: " + plazas);
		                System.out.println("Depósito: " + deposito);
		                System.out.println("Consumo: " + consumo);
		                System.out.println("L_correcto: " + lCorrecto);
		                System.out.println("Observaciones: " + observaciones);
		                System.out.println("---------------------------");
		            }

		            select.close();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
					
				}

public static void  consultaDatos19() {
				
				Connection conec = conexionBBDD();
				
				try {
					Statement consulta = conec.createStatement(); 
					ResultSet select = consulta.executeQuery("select * from vehiculos where anyo=2019");
		            while (select.next()) {
		                int idVehiculo = select.getInt("ID_Vehiculo");
		                String matricula = select.getString("Matricula");
		                String marca = select.getString("Marca");
		                String modelo = select.getString("Modelo");
		                int anyo = select.getInt("Anyo");
		                int potencia = select.getInt("Potencia");
		                int plazas = select.getInt("Plazas");
		                double deposito = select.getDouble("Deposito");
		                double consumo = select.getDouble("Consumo");
		                boolean lCorrecto = select.getBoolean("L_correcto");
		                String observaciones = select.getString("Observaciones");
		                
		                
		                System.out.println("---------------------------");
		                System.out.println("ESTOS SON LOS VEHICULOS DEL AÑO 2019");
		                System.out.println("---------------------------");

		                System.out.println("ID: " + idVehiculo);
		                System.out.println("Matricula: " + matricula);
		                System.out.println("Marca: " + marca);
		                System.out.println("Modelo: " + modelo);
		                System.out.println("Año: " + anyo);
		                System.out.println("Potencia: " + potencia);
		                System.out.println("Plazas: " + plazas);
		                System.out.println("Depósito: " + deposito);
		                System.out.println("Consumo: " + consumo);
		                System.out.println("L_correcto: " + lCorrecto);
		                System.out.println("Observaciones: " + observaciones);
		                System.out.println("---------------------------");
		            }

		            select.close();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
					
				}

			public static void eliminarDato() {
				Connection conec = conexionBBDD();
				
				try {
					Statement borrar = conec.createStatement(); 
		            String sql = ("DELETE FROM VEHICULOS WHERE  marca='Ford'");
		            int filasAfectadas = borrar.executeUpdate(sql);

		            System.out.println("Registros eliminados: " + filasAfectadas);

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			}
		    public static void main(String[] args) {
		        Connection conexion = null;
		        boolean salir = false;
		        
		        while (!salir) {
		            System.out.println("***** MENÚ *****");
		            System.out.println("1. Conectar a la base de datos");
		            System.out.println("2. Insertar datos");
		            System.out.println("3. Consultar todos los datos");
		            System.out.println("4. Consultar datos del 2019");
		            System.out.println("5. Eliminar 2 registros");
		            System.out.println("6. Cerrar conexión");
		            System.out.println("7. Salir");
		            System.out.print("Ingrese la opción deseada: ");
		            
		            Scanner scanner = new Scanner(System.in);
		            int opcion = scanner.nextInt();
		            
		            switch (opcion) {
		                case 1:
		                    conexion = conexionBBDD();
		                    if (conexion != null) {
		                        System.out.println("Conexión establecida.");
		                    } else {
		                        System.out.println("Error al conectar.");
		                    }
		                    break;
		                case 2:
		                    if (conexion != null) {
		                        System.out.println("Insertar datos.");
		                        insertarDatos();
		                    } else {
		                        System.out.println("Debe establecer una conexión primero.");
		                    }
		                    break;
		                case 3:
		                    if (conexion != null) {
		                        System.out.println("Datos de la tabla.");
		                        consultaDatos();
		                    } else {
		                        System.out.println("Debe establecer una conexión primero.");
		                    }
		                    break;
		                case 4:
		                    if (conexion != null) {
		                        System.out.println("Datos del 2019.");
		                        consultaDatos19();
		                    } else {
		                        System.out.println("Debe establecer una conexión primero.");
		                    }
		                    break;
		                case 5:
		                    if (conexion != null) {
		                        System.out.println("Eliminar 2 registros.");
		                        eliminarDato();
		                    } else {
		                        System.out.println("Debe establecer una conexión primero.");
		                    }
		                    break;
		                case 6:
		                    if (conexion != null) {
		                        cerrarConexion(conexion);
		                        System.out.println("Conexión cerrada.");
		                    } else {
		                        System.out.println("No hay conexión establecida.");
		                    }
		                    break;
		                case 7:
		                    salir = true;
		                    System.out.println("Saliendo del programa...");
		                    break;
		                default:
		                    System.out.println("Opción inválida. Intente nuevamente.");
		                    break;
		            }
		            
		            System.out.println();
		        }
		    }

	}	
			

