package Conexion;

import java.sql.*;
import java.util.*;

public class accesodatos {
	
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String bd = "proyectofinal_dam";
		private static final String servidor = "localhost:3306/"+bd;
		private static final String url = "jdbc:mysql://"+servidor;
		private static final String USUARIO = "root" ;
		private static final String PASSWORD = "leiva";

		
		public static Connection conexionBBDD() {
			Connection conec = null; 
			try {
				Class.forName(DRIVER);
				conec = DriverManager.getConnection(url, USUARIO, PASSWORD);
			} catch (Exception errores) {
				System.err.println("Se ha producido un error al conectar con la base de datos.\n" + errores);
			}
			return conec;
		}
		public static void cerrarConexion(Connection conection) {
			try {
				conection.close();
				System.out.println("Conexion Cerrada");
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
		
		public static void menu() {
	        Scanner scanner = new Scanner(System.in);
	        List<Usuario> usuariosRegistrados = new ArrayList<>();
	        boolean registrado = false;
	        String nombre = "";
	        String dni = "";
	        String centro = "";
	        String edad = "";

	        while (true) {
	            System.out.println("|__________Bienvenido al programa de registro___________|");
	            System.out.println("1. Registrarse");
	            System.out.println("2. Cambiar DNI");
	            System.out.println("3. Mostrar usuarios registrados");
	            System.out.println("4. Eliminar asistente");
	            System.out.println("5. Salir");
	            System.out.print("Elije una opcion : ");
	            int opcion = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcion) {

	                case 1:
	                    System.out.println("Vamos a registrarte \n");
	                    System.out.print("Nombre: ");
	                    nombre = scanner.nextLine();
	                    System.out.print("DNI: ");
	                    dni = scanner.nextLine();
	                    System.out.print("Centro: ");
	                    centro = scanner.nextLine();
	                    System.out.print("Edad: ");
	                    edad = scanner.nextLine();
	                    Usuario nuevoUsuario = new Usuario(nombre, dni, centro);
	                    usuariosRegistrados.add(nuevoUsuario);
	                    System.out.println("Registro exitoso");
	                    break;
	                case 2: 
	                    System.out.println("Cambiar DNI");
	                    System.out.print("Introduce el DNI actual: ");
	                    String Dni = scanner.nextLine();
	                    System.out.print("Introduce el nuevo DNI: ");
	                    String nuevoDni = scanner.nextLine();

	                    Usuario usuarioEncontrado = buscarUsuario(Dni, nuevoDni, usuariosRegistrados);

	                    if (usuarioEncontrado != null) {
	                        usuarioEncontrado.getDni();
	                        System.out.println("DNI actualizado con éxito.");
	                    } else {
	                        System.out.println("No se encontró un usuario con el DNI y centro especificados.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Usuarios registrados: \n");
	                    for (Usuario u : usuariosRegistrados) {
	                        System.out.println("Nombre: " + u.getNombre() + ", DNI: " + u.getDni() + ", centro: " + u.getCentro()+"\n");
	                    }
	                    break;
	                    
	                case 4:    
	                    
	                    
	                case 5:
	                    System.out.println("Gracias por usar la aplicacion");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Opcion no valida. Por favor, elige una opción valida.");
	                    break;
	            }
	        }
	    }

	    public static Usuario buscarUsuario(String dni, String centro, List<Usuario> usuarios) {
	        for (Usuario usuario : usuarios) {
	            if (usuario.getDni().equals(dni) && usuario.getCentro().equals(centro)) {
	                return usuario;
	            }
	        }
	        return null;
	    }
	}

class Usuario {
    private String nombre;
    private static String Dni;
    private String Centro;

    public Usuario(String nombre, String Dni, String Centro) {
        this.nombre = nombre;
        this.Dni = Dni;
        this.Centro = Centro;
    }

    public String getNombre() {
        return nombre;
    }



    public static String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCentro(String centro) {
		Centro = centro;
	}

	public String getCentro() {
        return Centro;
    }
		public static void eliminarAsistente() {
		    Connection conec = conexionBBDD();
		    try {
		        Statement consulta = conec.createStatement();

		        System.out.println("Ingrese el código de la nota que desea eliminar:");
		        Scanner scanner = new Scanner(System.in);
		        int codNota = scanner.nextInt();

		        String query = null;
				try {
					query = "DELETE FROM notas WHERE DNI = " + getDni();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        int filasAfectadas = consulta.executeUpdate(query);
		        if (filasAfectadas > 0) {
		            System.out.println("Asistente con DNI " + Dni + " eliminada correctamente.");
		        } else {
		            System.out.println("No hay ningun asistente con ese DNI");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al eliminar nota: " + e.getMessage());
		    }
		}

		private static Connection conexionBBDD() {
			return null;
		}
}
