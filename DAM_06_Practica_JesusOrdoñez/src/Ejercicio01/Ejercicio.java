package Ejercicio01;

import java.sql.*;


public class Ejercicio {
		private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
		private final static String bd = "sakila";
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
		
		
	
		public static void  obtenerDatos() {
			
			Connection conec = conexionBBDD();
			
			try {
				Statement consulta = conec.createStatement();
				ResultSet salida = consulta.executeQuery(" select * from actor");
				while (salida.next()){
					String nombre = salida.getString("first_name");
					String apellido = salida.getString("last_name");
					
					System.out.println("Nombre " + nombre + " Apellido " + apellido);
				}
			}catch(SQLException e) {
				System.out.println("error" + e );
			} finally {
				cerrarConexion(conec);
			}
		}
		public static void cerrarConexion(Connection conection) {
			try {
				conection.close();
			}catch (SQLException e) {
				System.out.println("error" + e );
			}
		}
		
		public static void main(String[] args) {
			Connection conec = null;
			conec= conexionBBDD();
			if(conec!= null) {
				System.out.println("CONECTADO");
			}else {
				System.out.println("ERROR AL CONECTAR");
			}
			
			obtenerDatos();
		}	

}
