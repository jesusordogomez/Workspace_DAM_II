package Proyecto;

import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class Proyecto {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String bd = "proyectofinal_dam";
	private static final String servidor = "localhost:3306/"+bd;
	private static final String url = "jdbc:mysql://"+servidor;
	private static final String USUARIO = "root" ;
	private static final String PASSWORD = "leiva";

	
	//metodo para conectarme con la base de datos creada 
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
	//metodo para cerrar la conexion para la bbdd
	public static void cerrarConexion(Connection conection) {
		try {
			conection.close();
			System.out.println("Conexion Cerrada");
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}
	
	/**
	 * Función que muestra el menú de inicio del servidor de centros educativos.
	 * donde hago un bucle para quesi el usuario se equivoca al meter datos te lo repita hasta que sea corrcto
	 */
	public static void menu() {
	    Connection conec = conexionBBDD(); 
	    Scanner scanner = new Scanner(System.in);
	    String usuario;
	    String contrasenia;

	    System.out.println("[____________BIENVENIDO AL SERVIDOR DE CENTROS EDUCATIVOS_________]\n");

	    String centroEducativo;
	    boolean centroValido = false;

	    do {
	        System.out.print("\t Ingrese el centro educativo: ");
	        centroEducativo = scanner.nextLine();
	         if (centroEducativo.equalsIgnoreCase("ilerna")) {
	            centroValido = true;
	        } else {
	            System.out.println("El centro educativo '" + centroEducativo + "' no está disponible en este momento.");
	        }
	    } while (!centroValido);

	    boolean credencialesValidas = false;
	    
	    while (!credencialesValidas) {
	        System.out.print("  Ingrese su usuario: ");
	        usuario = scanner.nextLine();

	        System.out.print("  Ingrese su contrasenia: ");
	        contrasenia = scanner.nextLine();
	        System.out.println("");

	        String rolUsuario = IdentificarUsuario(usuario, contrasenia);

	        if (rolUsuario != null) {
	            System.out.println("  Autorizado. Rol: " + rolUsuario);
	            System.out.println("");

	            switch (rolUsuario) {
	                case "profesor":
	                    menuProfesor();
	                    break;
	                case "secretaria":
	                    menuSecretaria();
	                    break;
	                case "direccion":
	                    menuDireccion();
	                    break;
	                default:
	                    System.out.println(" No hay ningún usuario con ese nombre.");
	            }          
	            credencialesValidas = true; 
	        } else {
	            System.out.println("\t Usuario y/o contrasenia incorrectos");
	        }
	    }
	}
	
    /**
     * Menú del rol profesor con los tipos de metodos que el puede realizar
     */
	
	public static void menuProfesor() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- MENU DE PROFESOR ------------------------|");
			System.out.println(" Seleccione una opcion:");
			System.out.println("\t 1. Consultar datos alumnos");
			System.out.println("\t 2. Consultar datos de las materias");
			System.out.println("\t 3. Consultar mis datos en el sistema");
			System.out.println(" 0. Volver al menu principal \n");

			System.out.print("\t Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println(" ");
				System.out.println("---------------------------------------");
				ConsultarDatosAlumnos();
				break;
			case 2:
				System.out.println(" ");
				System.out.println("---------------------------------------");
				ConsultarDatosMaterias();
				break;
			case 3:
				System.out.print("Introduce el NIF del profesor: ");
				scanner.nextLine(); 
				String nif = scanner.nextLine(); 
				System.out.println(" ");
				ConsultardatosProfe(nif);
				break;
			case 0:
				menu();
				return ;
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
    /**
     * Menú de secretaria
     */
	public static void menuSecretaria() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- MENU DE SECRETARIA ------------------------|");
			System.out.println("  Seleccione una opcion:");
			System.out.println("\t 1. Alta de un alumno");
			System.out.println("\t 2. Modificacion de un alumno");
			System.out.println("\t 3. Insercion de notas");
			System.out.println("\t 4. Gestion de aulas");
			System.out.println("\t 5. Listados de alumnos");
			System.out.println("\t 6. Listado de materias ");
			System.out.println("0. Volver al menu principal \n");

			System.out.print("\t  Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:

				System.out.println("  Ingrese el código de alumno:");
				int cod_alumnos = scanner.nextInt();

				System.out.println("  Ingrese la matrícula:");
				String matricula = scanner.next();

				System.out.println("  Ingrese el DNI:");
				String dni = scanner.next();

				System.out.println("  Ingrese el nombre del alumno:");
				String nombre_alumno = scanner.next();

				System.out.println("  Ingrese el primer apellido del alumno:");
				String apellido1_alumno = scanner.next();

				System.out.println("  Ingrese el segundo apellido del alumno:");
				String apellido2_alumno = scanner.next();

				System.out.println("  Ingrese el código postal:");
				int cod_postal = scanner.nextInt();

				System.out.println(" Ingrese la localidad:");
				String localidad = scanner.next();

				System.out.println("  Ingrese la provincia:");
				String provincia = scanner.next();

				System.out.println("  Ingrese el domicilio:");
				String domicilio = scanner.next();

				System.out.println("  Ingrese el número de teléfono:");
				int numero_telefono = scanner.nextInt();

				System.out.println("  Ingrese el correo electrónico:");
				String correo_electronico = scanner.next();

				System.out.println("  Ingrese la fecha de nacimiento (dd/mm/aaaa):");
				String fecha_nacimiento_str = scanner.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date utilFechaNacimiento = null;
				try {
					utilFechaNacimiento = dateFormat.parse(fecha_nacimiento_str);
				} catch (ParseException e) {
					System.out.println(" Formato de fecha incorrecto. Intente nuevamente.");
					return;
				}
				java.sql.Date fecha_nacimiento1 = new java.sql.Date(utilFechaNacimiento.getTime());
				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();

				AltaAlumno(cod_alumnos, matricula, dni, nombre_alumno, apellido1_alumno, apellido2_alumno, cod_postal, localidad, provincia,
						domicilio, numero_telefono, correo_electronico, fecha_nacimiento1, observaciones);
				break;
			case 2:

				System.out.print("Ingrese el código del alumno a modificar: ");
				int cod_alumnos_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese la nueva matrícula: ");
				String matricula_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo DNI: ");
				String dni_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo nombre: ");
				String nombre_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo primer apellido: ");
				String apellido_modificar_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo segundo apellido: ");
				String apellido2_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo código postal: ");
				int cod_postal_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese la nueva localidad: ");
				String localidad_modificar = scanner.nextLine();

				System.out.print("Ingrese la nueva provincia: ");
				String provincia_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo domicilio: ");
				String domicilio_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo número de teléfono: ");
				int numero_telefono_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese el nuevo correo electrónico: ");
				String correo_electronico_modificar = scanner.nextLine();

				System.out.print("Ingrese la nueva fecha de nacimiento (formato: dd/mm/yyyy): ");
				String fecha_nacimiento_str_modificar = scanner.next();
				scanner.nextLine();
				SimpleDateFormat dateFormat_modificar = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date utilFechaNacimiento_modificar = null;
				try {
					utilFechaNacimiento_modificar = dateFormat_modificar.parse(fecha_nacimiento_str_modificar);
				} catch (ParseException e) {
					System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
					return;
				}

				java.sql.Date fecha_nacimiento_modificar = new java.sql.Date(utilFechaNacimiento_modificar.getTime());

				System.out.print("Ingrese las nuevas observaciones: ");
				String observaciones_modificar = scanner.nextLine();
				ModificarAlumno(cod_alumnos_modificar, matricula_modificar, dni_modificar, nombre_alumno_modificar, apellido_modificar_alumno_modificar, apellido2_alumno_modificar, cod_postal_modificar,
						localidad_modificar, provincia_modificar, domicilio_modificar, numero_telefono_modificar, correo_electronico_modificar, fecha_nacimiento_modificar, observaciones_modificar);


				break;
			case 3:
				System.out.print("Ingrese el código de la nota: ");
				int cod_nota = scanner.nextInt();

				scanner.nextLine(); 

				System.out.print("Ingrese el curso: ");
				String curso = scanner.nextLine();

				System.out.print("Ingrese el valor de la nota: ");
				int valor_nota = scanner.nextInt();

				scanner.nextLine(); 

				System.out.print("Ingrese las observaciones: ");
				String observaciones_nota = scanner.nextLine();

				System.out.print("Ingrese el código del alumno: ");
				int cod_alumnos_nota = scanner.nextInt();

				System.out.print("Ingrese el código de la convocatoria: ");
				int cod_convocatoria = scanner.nextInt();

				System.out.print("Ingrese el código de la materia: ");
				int cod_materia = scanner.nextInt();

				InsertarNota(cod_nota, curso, valor_nota, observaciones_nota, cod_alumnos_nota, cod_convocatoria, cod_materia);
				break;
			case 4:
				gestionAulas();
				break;
			case 5:
				ConsultarDatosAlumnos();
				break;
			case 6:
				ConsultarDatosMaterias();
				break;
			case 0:
				return ; // Sale del metodo para volver al menu principal
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
    /**
     * Menú de direccion donde hay mas metodos que en otro rol
     * en la gestion de la direccion se puede consultar, dar de alta, dar de baja y 
     * modificar tantos datos como sea posible.
     */
	public static void menuDireccion() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- MENU DE DIRECCION ------------------------|");
			System.out.println(" Seleccione una opcion:");
			System.out.println("\t 1. Gestion de alumnos");
			System.out.println("\t 2. Gestion de personal");
			System.out.println("\t 3. Gestion de materias");
			System.out.println("\t 4. Gestion de aulas");
			System.out.println("\t 5. Gestion de cursos");
			System.out.println("\t 6. Gestion de notas");
			System.out.println("0. Volver al menu principal \n");

			System.out.print("\t  Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			// Implementa las acciones correspondientes a cada opcion del menu de direccion
			switch (opcion) {
			case 1:
				gestionAlumnos();
				break;
			case 2:
				gestionPersonal();
				break;
			case 3:
				gestionMaterias();
				break;
			case 4:
				gestionAulas();
				break;
			case 5:
				gestionCursos();
				break;
			case 6:
				gestionNotas();
				break;
			case 0:
				return; // Sale del metodo para volver al menu principal
			default:
				System.out.println(" Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
    /**
     *En este metodo ya empezamos cogiendo datos de la bbdd, 
     *donde en la pantalla de inicio de nuestra app
     *lo primero que preguntamos es el usuario y la contrasenia, 
     *que estan recogidos en la tabla de la bbdd, 
     *con esos datos ya cogemos el rol de cada persona
     */
	public static String IdentificarUsuario(String usuario, String contrasenia) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			ResultSet select = consulta.executeQuery("SELECT usuario, contrasenia, rol FROM usuario");

			while (select.next()) {
				String usuarioBD = select.getString("usuario");
				String contrasenaBD = select.getString("contrasenia");

				if (usuario.equals(usuarioBD) && contrasenia.equals(contrasenaBD)) {
					String rol = select.getString("rol");
					return rol;
				}
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return null; // Si no se encuentra el usuario o la contrasenia no coincide, devuelve null
	}

    /**
     * Para consultar los datos de los alumnos
     * cojo todo los atributos de mi tabla alumnos y luego lo muestro por pantalla
     */
	public static void ConsultarDatosAlumnos() {
		Connection conec = conexionBBDD(); 
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM alumnos");
			while (Select.next()) {
				int cod_alumnos = Select.getInt("cod_alumnos");
				int matricula = Select.getInt("matricula");
				String dni = Select.getString("dni");
				String nombre_alumno = Select.getString("nombre_alumno");
				String apellido1_alumno = Select.getString("apellido1_alumno");
				String apellido2_alumno = Select.getString("apellido2_alumno");
				int cod_postal = Select.getInt("cod_postal");
				String localidad = Select.getString("localidad");
				String provincia = Select.getString("provincia");
				String domicilio = Select.getString("domicilio");
				int numero_telefono = Select.getInt("numero_telefono");
				String correo_electronico = Select.getString("correo_electronico");
				Date fecha_nacimiento = Select.getDate("fecha_nacimiento");
				String observaciones = Select.getString("observaciones");

				System.out.println("Codigo de alumnos: " + cod_alumnos);
				System.out.println("Matricula: " + matricula);
				System.out.println("DNI: " + dni);
				System.out.println("Nombre del alumno: " + nombre_alumno);
				System.out.println("Apellido 1 del alumno: " + apellido1_alumno);
				System.out.println("Apellido 2 del alumno: " + apellido2_alumno);
				System.out.println("Codigo postal: " + cod_postal);
				System.out.println("Localidad: " + localidad);
				System.out.println("Provincia: " + provincia);
				System.out.println("Domicilio: " + domicilio);
				System.out.println("Numero de telefono: " + numero_telefono);
				System.out.println("Correo electronico: " + correo_electronico);
				System.out.println("Fecha de nacimiento: " + fecha_nacimiento);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("---------------------------------------");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	//Metodo para consultar los datos de las materias

	public static void ConsultarDatosMaterias() {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM materias");
			while (Select.next()) {
				int cod_materia = Select.getInt("cod_materia");
				String nombre_materia = Select.getString("nombre_materia");
				String descripcion = Select.getString("descripcion");
				String nomenclatura = Select.getString("nomenclatura");
				int n_horas = Select.getInt("n_horas");
				double coste = Select.getDouble("coste");
				boolean l_activo = Select.getBoolean("l_activo");
				String observaciones = Select.getString("observaciones");
				int cod_departamento = Select.getInt("cod_departamento");

				System.out.println("Codigo de materia: " + cod_materia);
				System.out.println("Nombre de la materia: " + nombre_materia);
				System.out.println("Descripcion: " + descripcion);
				System.out.println("Nomenclatura: " + nomenclatura);
				System.out.println("Numero de horas: " + n_horas);
				System.out.println("Coste: " + coste);
				System.out.println("Activo: " + l_activo);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("Codigo de departamento: " + cod_departamento);
				System.out.println("---------------------------------------");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

    /**
     * En el metodo de consultar datos del profesor,
     * ya que estamos en el rol profesor, lo que hacemos es asegurar de que profesor es, 
     * por lo que al usuario le pido que me de su DNI
     * para validar que ese profesor esta registrado en mi bbdd,
     * luego le muestro por pantalla sus datos
     */

	public static void ConsultardatosProfe (String nif) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM personal WHERE NIF = '" + nif + "'");
			if (Select.next()) {
				int Id_personal = Select.getInt("Id_personal");
				String nombre = Select.getString("nombre");
				String apellido1 = Select.getString("apellido1");
				String apellido2 = Select.getString("apellido2");
				String NIF = Select.getString("NIF");
				int num_telefono = Select.getInt("num_telefono");
				String correo_electronico = Select.getString("correo_electronico");
				String cargo = Select.getString("cargo");
				String titulacion = Select.getString("titulacion");
				String observaciones = Select.getString("observaciones");
				boolean l_activo = Select.getBoolean("l_activo");
				int Id_centro = Select.getInt("Id_centro");
				int Id_curso = Select.getInt("Id_curso");
				int cod_departamento = Select.getInt("cod_departamento");

				System.out.println("ID personal: " + Id_personal);
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellido 1: " + apellido1);
				System.out.println("Apellido 2: " + apellido2);
				System.out.println("NIF: " + NIF);
				System.out.println("Número de teléfono: " + num_telefono);
				System.out.println("Correo electrónico: " + correo_electronico);
				System.out.println("Cargo: " + cargo);
				System.out.println("Titulación: " + titulacion);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("Activo: " + l_activo);
				System.out.println("ID centro: " + Id_centro);
				System.out.println("ID curso: " + Id_curso);
				System.out.println("Código de departamento: " + cod_departamento);

				System.out.println("---------------------------------------");
			} else {
				System.out.println("No se encontró ningún profesor con el NIF proporcionado.");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void AltaAlumno(int cod_alumnos, String matricula, String dni, String nombre_alumno, String apellido1_alumno, String apellido2_alumno, 
			int cod_postal, String localidad, String provincia, String domicilio, int numero_telefono, String correo_electronico, 
			Date fecha_nacimiento, String observaciones) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO alumnos (cod_alumnos, matricula, dni, nombre_alumno, apellido1_alumno, apellido2_alumno, cod_postal, localidad, provincia, " +
					"domicilio, numero_telefono, correo_electronico, fecha_nacimiento, observaciones) VALUES ('" + cod_alumnos + "', '" + matricula + "', '" +
					dni + "', '" + nombre_alumno + "', '" + apellido1_alumno + "', '" + apellido2_alumno + "', '" + cod_postal + "', '" + localidad + "', '" +
					provincia + "', '" + domicilio + "', '" + numero_telefono + "', '" + correo_electronico + "', '" + fecha_nacimiento + "', '" + observaciones + "')";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public static void ModificarAlumno(int cod_alumnos, String matricula, String dni, String nombre_alumno,
			String apellido1_alumno, String apellido2_alumno, int cod_postal, String localidad, String provincia,
			String domicilio, int numero_telefono, String correo_electronico, Date fecha_nacimiento,
			String observaciones) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "UPDATE alumnos SET matricula = '" + matricula + "', dni = '" + dni
					+ "', nombre_alumno = '" + nombre_alumno + "', apellido1_alumno = '" + apellido1_alumno
					+ "', apellido2_alumno = '" + apellido2_alumno + "', cod_postal = '" + cod_postal
					+ "', localidad = '" + localidad + "', provincia = '" + provincia + "', domicilio = '" + domicilio
					+ "', numero_telefono = '" + numero_telefono + "', correo_electronico = '" + correo_electronico
					+ "', fecha_nacimiento = '" + fecha_nacimiento + "', observaciones = '" + observaciones
					+ "' WHERE cod_alumnos = " + cod_alumnos;

			consulta.executeUpdate(query);
			System.out.println("Datos modificados correctamente.");
			System.out.println("Presione Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al modificar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

	}    

	public static void InsertarNota(int cod_nota, String curso, int valor_nota, String observaciones, int cod_alumnos, int cod_convocatoria, int cod_materia) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO notas (cod_nota, curso, valor_nota, observaciones, cod_alumnos, cod_convocatoria, cod_materia) VALUES ('" + cod_nota + "', '" + curso + "', " +
					"'" + valor_nota + "', '" + observaciones + "', '" + cod_alumnos + "', '" + cod_convocatoria + "', '" + cod_materia + "')";

			consulta.executeUpdate(query);
			System.out.println("Nota insertada correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar nota: " + e.getMessage());
		}
	}


    /**
     * En el menú de gestion de alumnos, es el menu que sale del menú de direccion,
     * hago un switch para ver la opcion que quiere realizar el director/a
     * y luego implementamos los metodos
     * en el casi 1, 2 y 3 al usuario le tenemos que pedir los datos y luego llamo al metodo
     * y en el case 4 llamo al metodo mostraralumno()
     */

	public static void gestionAlumnos() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- GESTION ALUMNOS ------------------------|");

			System.out.println("  Seleccione una opcion:");
			System.out.println("\t 1. Modificar alumno");
			System.out.println("\t 2. Alta alumno");
			System.out.println("\t 3. Eliminar alumno");
			System.out.println("\t 4. Mostrar alumno");
			System.out.println("0. Volver al menu de direccion");

			System.out.print(" Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el código del alumno a modificar: ");
				int cod_alumnos_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese la nueva matrícula: ");
				String matricula_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo DNI: ");
				String dni_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo nombre: ");
				String nombre_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo primer apellido: ");
				String apellido_modificar_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo segundo apellido: ");
				String apellido2_alumno_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo código postal: ");
				int cod_postal_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese la nueva localidad: ");
				String localidad_modificar = scanner.nextLine();

				System.out.print("Ingrese la nueva provincia: ");
				String provincia_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo domicilio: ");
				String domicilio_modificar = scanner.nextLine();

				System.out.print("Ingrese el nuevo número de teléfono: ");
				int numero_telefono_modificar = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese el nuevo correo electrónico: ");
				String correo_electronico_modificar = scanner.nextLine();

				System.out.print("Ingrese la nueva fecha de nacimiento (formato: dd/mm/yyyy): ");
				String fecha_nacimiento_str_modificar = scanner.next();
				scanner.nextLine();
				SimpleDateFormat dateFormat_modificar = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date utilFechaNacimiento_modificar = null;
				try {
					utilFechaNacimiento_modificar = dateFormat_modificar.parse(fecha_nacimiento_str_modificar);
				} catch (ParseException e) {
					System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
					return;
				}

				java.sql.Date fecha_nacimiento_modificar = new java.sql.Date(utilFechaNacimiento_modificar.getTime());

				System.out.print("Ingrese las nuevas observaciones: ");
				String observaciones_modificar = scanner.nextLine();


				ModificarAlumno(cod_alumnos_modificar, matricula_modificar, dni_modificar, nombre_alumno_modificar, apellido_modificar_alumno_modificar, apellido2_alumno_modificar, cod_postal_modificar,
						localidad_modificar, provincia_modificar, domicilio_modificar, numero_telefono_modificar, correo_electronico_modificar, fecha_nacimiento_modificar, observaciones_modificar);
				break;
			case 2:
				System.out.println("Ingrese el código de alumno:");
				int cod_alumnos = scanner.nextInt();

				System.out.println("Ingrese la matrícula:");
				String matricula = scanner.next();

				System.out.println("Ingrese el DNI:");
				String dni = scanner.next();

				System.out.println("Ingrese el nombre del alumno:");
				String nombre_alumno = scanner.next();

				System.out.println("Ingrese el primer apellido del alumno:");
				String apellido1_alumno = scanner.next();

				System.out.println("Ingrese el segundo apellido del alumno:");
				String apellido2_alumno = scanner.next();

				System.out.println("Ingrese el código postal:");
				int cod_postal = scanner.nextInt();

				System.out.println("Ingrese la localidad:");
				String localidad = scanner.next();

				System.out.println("Ingrese la provincia:");
				String provincia = scanner.next();

				System.out.println("Ingrese el domicilio:");
				String domicilio = scanner.next();

				System.out.println("Ingrese el número de teléfono:");
				int numero_telefono = scanner.nextInt();

				System.out.println("Ingrese el correo electrónico:");
				String correo_electronico = scanner.next();

				System.out.println("Ingrese la fecha de nacimiento (en formato dd/mm/aaaa):");
				String fecha_nacimiento_str = scanner.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date utilFechaNacimiento = null;
				try {
					utilFechaNacimiento = dateFormat.parse(fecha_nacimiento_str);
				} catch (ParseException e) {
					System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
					return;
				}

				// Convert the java.util.Date to java.sql.Date
				java.sql.Date fecha_nacimiento1 = new java.sql.Date(utilFechaNacimiento.getTime());

				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();

				// Llama al método AltaAlumno con los datos ingresados
				AltaAlumno(cod_alumnos, matricula, dni, nombre_alumno, apellido1_alumno, apellido2_alumno, cod_postal, localidad, provincia,
						domicilio, numero_telefono, correo_electronico, fecha_nacimiento1, observaciones);
				break;
			case 3:
				System.out.println("Ingrese el codigo del alumno a borrar:");
				int codigo_alumno = scanner.nextInt();
				EliminarAlumno(codigo_alumno);
				break;
			case 4:
				ConsultarDatosAlumnos();
				break;
			case 0:
				return; // Sale del metodo para volver al menu de direccion
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
	
	public static void EliminarAlumno(int cod_alumnos) {
	    Connection conec = conexionBBDD();
	    try {
	        Statement consulta = conec.createStatement();
	        String query = "DELETE FROM alumnos WHERE cod_alumnos = '" + cod_alumnos + "'";

	        int filasAfectadas = consulta.executeUpdate(query);
	        if (filasAfectadas > 0) {
	            System.out.println("Alumno eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró ningún alumno con el código especificado.");
	        }
	        System.out.println("Presiona Enter para volver al menú de profesor.");
	        Scanner scanner = new Scanner(System.in);
	        scanner.nextLine();
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar alumno: " + e.getMessage());
	    }
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

    /**
     * En la gestionPersonal, lo que realizo son los metodos que una app debe tener para
     * realizar una buena gestion para saber, mostrar o modificar datos de los trabajadores del instituto
     */
	public static void gestionPersonal() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- GESTION PERSONAL ------------------------|\n");
			System.out.println("\t Seleccione una opcion:");
			System.out.println("\t 1. Modificar personal");
			System.out.println("\t 2. Alta personal");
			System.out.println("\t 3. Eliminar personal");
			System.out.println("\t 4. Mostrar personal");
			System.out.println("0. Volver al menu de direccion");
			System.out.print(" Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				modificarPersonal();
				break;
			case 2:
				System.out.println("Ingrese el Id_personal:");
				int Id_personal = scanner.nextInt();

				System.out.println("Ingrese el nombre:");
				String nombre = scanner.next();

				System.out.println("Ingrese el primer apellido:");
				String apellido1 = scanner.next();

				System.out.println("Ingrese el segundo apellido:");
				String apellido2 = scanner.next();

				System.out.println("Ingrese el NIF:");
				String NIF = scanner.next();

				System.out.println("Ingrese el número de teléfono:");
				int num_telefono = scanner.nextInt();

				System.out.println("Ingrese el correo electrónico:");
				String correo_electronico = scanner.next();

				System.out.println("Ingrese el cargo:");
				String cargo = scanner.next();

				System.out.println("Ingrese la titulación:");
				String titulacion = scanner.next();

				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();

				System.out.println("Ingrese el l_activo:");
				boolean l_activo = scanner.nextBoolean();

				System.out.println("Ingrese el Id_centro:");
				int Id_centro = scanner.nextInt();

				System.out.println("Ingrese el Id_curso:");
				int Id_curso = scanner.nextInt();

				System.out.println("Ingrese el cod_departamento:");
				int cod_departamento = scanner.nextInt();

				// Llama al método AltaAlumno con los datos ingresados
				AltaPersonal(Id_personal, nombre, apellido1, apellido2, NIF, num_telefono, correo_electronico, cargo,
						titulacion, observaciones, l_activo, Id_centro, Id_curso, cod_departamento);

				break;
			case 3:
				eliminarPersonal();
				break;
			case 4:
				ConsultarDatosPersonal();
				break;
			case 0:
				return; // Sale del metodo para volver al menu de direccion
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
	
	public static void ConsultarDatosPersonal () {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM personal");
			if (Select.next()) {
				int Id_personal = Select.getInt("Id_personal");
				String nombre = Select.getString("nombre");
				String apellido1 = Select.getString("apellido1");
				String apellido2 = Select.getString("apellido2");
				String NIF = Select.getString("NIF");
				int num_telefono = Select.getInt("num_telefono");
				String correo_electronico = Select.getString("correo_electronico");
				String cargo = Select.getString("cargo");
				String titulacion = Select.getString("titulacion");
				String observaciones = Select.getString("observaciones");
				boolean l_activo = Select.getBoolean("l_activo");
				int Id_centro = Select.getInt("Id_centro");
				int Id_curso = Select.getInt("Id_curso");
				int cod_departamento = Select.getInt("cod_departamento");

				System.out.println("ID personal: " + Id_personal);
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellido 1: " + apellido1);
				System.out.println("Apellido 2: " + apellido2);
				System.out.println("NIF: " + NIF);
				System.out.println("Número de teléfono: " + num_telefono);
				System.out.println("Correo electrónico: " + correo_electronico);
				System.out.println("Cargo: " + cargo);
				System.out.println("Titulación: " + titulacion);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("Activo: " + l_activo);
				System.out.println("ID centro: " + Id_centro);
				System.out.println("ID curso: " + Id_curso);
				System.out.println("Código de departamento: " + cod_departamento);

				System.out.println("---------------------------------------");
			} else {
				System.out.println("No se encontró ningún profesor con el NIF proporcionado.");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void AltaPersonal(int Id_personal, String nombre, String apellido1, String apellido2, String NIF, 
			int num_telefono, String correo_electronico, String cargo, String titulacion, String observaciones, 
			boolean l_activo, int Id_centro, int Id_curso, int cod_departamento) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO personal (Id_personal, nombre, apellido1, apellido2, NIF, num_telefono, correo_electronico, cargo, titulacion, observaciones, l_activo, Id_centro, Id_curso, cod_departamento) VALUES (" + Id_personal + ", '" + nombre + "', '" +
					apellido1 + "', '" + apellido2 + "', '" + NIF + "', '" + num_telefono + "', '" + correo_electronico + "', '" + cargo + "', '" +
					titulacion + "', '" + observaciones + "', " + (l_activo ? 1 : 0) + ", " + Id_centro + ", " + Id_curso + ", '" + cod_departamento + "')";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void eliminarPersonal() {
        Connection conec = conexionBBDD();
        try {
            Statement consulta = conec.createStatement();

            System.out.println("Seleccione el Id_personal del personal que desea eliminar (1-8):");
            Scanner scanner = new Scanner(System.in);
            int idPersonal = scanner.nextInt();

            if (idPersonal < 1 || idPersonal > 8) {
                System.out.println("Id_personal inválido. No se realizará ninguna eliminación.");
                return;
            }

            String query = "DELETE FROM personal WHERE Id_personal = " + idPersonal;

            int filasAfectadas = consulta.executeUpdate(query);
            if (filasAfectadas > 0) {
                System.out.println("Trabajador con Id_personal " + idPersonal + " eliminado correctamente.");
            } else {
                System.out.println("No se encontro nadie con el Id_personal especificado.");
            }
            System.out.println("Presiona Enter para volver al menu.");
            scanner.nextLine();
        } catch (SQLException e) {
            System.out.println("Error al eliminar personal: " + e.getMessage());
        }
		System.out.println("Presiona Enter para volver al menu de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
    }
	
	public static void modificarPersonal() {
        Connection conec = conexionBBDD();
        try {
            Statement consulta = conec.createStatement();

            System.out.println("Ingrese el ID del personal que desea modificar:");
            Scanner scanner = new Scanner(System.in);
            int idPersonal = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el nuevo primer apellido:");
            String apellido1 = scanner.nextLine();

            System.out.println("Ingrese el nuevo segundo apellido:");
            String apellido2 = scanner.nextLine();

            System.out.println("Ingrese el nuevo NIF:");
            String nif = scanner.nextLine();

            System.out.println("Ingrese el nuevo número de teléfono:");
            String numTelefono = scanner.nextLine();

            System.out.println("Ingrese el nuevo correo electrónico:");
            String correoElectronico = scanner.nextLine();

            System.out.println("Ingrese el nuevo cargo:");
            String cargo = scanner.nextLine();

            System.out.println("Ingrese la nueva titulación:");
            String titulacion = scanner.nextLine();

            System.out.println("Ingrese las nuevas observaciones:");
            String observaciones = scanner.nextLine();

            System.out.println("Ingrese el nuevo estado activo (0: inactivo, 1: activo):");
            int lActivo = scanner.nextInt();

            // Construir la consulta de actualización
            String query = "UPDATE personal SET nombre = '" + nombre + "', apellido1 = '" + apellido1 + "', apellido2 = '" + apellido2 +
                    "', NIF = '" + nif + "', num_telefono = '" + numTelefono + "', correo_electronico = '" + correoElectronico +
                    "', cargo = '" + cargo + "', titulacion = '" + titulacion + "', observaciones = '" + observaciones +
                    "', l_activo = " + lActivo + " WHERE Id_personal = " + idPersonal;

            int filasAfectadas = consulta.executeUpdate(query);
            if (filasAfectadas > 0) {
                System.out.println("Registro de personal con ID " + idPersonal + " modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro de personal con el ID especificado.");
            }
            System.out.println("Presiona Enter para volver al menú.");
            scanner.nextLine();
        } catch (SQLException e) {
            System.out.println("Error al modificar registro de personal: " + e.getMessage());
        }
    }
  
	public static void gestionMaterias() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- GESTION DE MATERIAS ------------------------|\n");
			System.out.println(" Seleccione una opcion:");
			System.out.println("\t 1. Modificar materias");
			System.out.println("\t 2. Alta materias");
			System.out.println("\t 3. Eliminar materias");
			System.out.println("\t 4. Mostrar materias");
			System.out.println("0. Volver al menu de direccion");

			System.out.print("Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				modificarMateria();
				break;
			case 2:
				System.out.println("Ingrese el cod_materia:");
				int cod_materia = scanner.nextInt();

				System.out.println("Ingrese el nombre de la materia:");
				String nombre_materia = scanner.next();

				System.out.println("Ingrese la descripción:");
				String descripcion = scanner.next();

				System.out.println("Ingrese la nomenclatura:");
				String nomenclatura = scanner.next();

				System.out.println("Ingrese el número de horas:");
				int n_horas = scanner.nextInt();

				System.out.println("Ingrese el coste:");
				double coste = scanner.nextDouble();

				System.out.println("Ingrese el estado activo (true o false):");
				boolean l_activo = scanner.nextBoolean();

				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();

				System.out.println("Ingrese el código del departamento:");
				String cod_departamento = scanner.next();

				AltaMaterias(cod_materia, nombre_materia, nombre_materia, nombre_materia, cod_materia, coste, l_activo, nombre_materia, cod_materia);

				break;
			case 3:
				eliminarMateria();
				break;
			case 4:
				ConsultarDatosMaterias();
				break;
			case 0:
				return; 
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
	
	public static void AltaMaterias(int cod_materia, String nombre_materia, String descripcion, String nomenclatura, 
			int n_horas, double coste, boolean l_activo, String observaciones, int cod_departamento) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO materias (cod_materia, nombre_materia, descripcion, nomenclatura, n_horas, coste, l_activo, observaciones, cod_departamento) VALUES (" + cod_materia + ", '" + nombre_materia + "', '" +
					descripcion + "', '" + nomenclatura + "', " + n_horas + ", " + coste + ", " + (l_activo ? 1 : 0) + ", '" +
					observaciones + "', " + cod_departamento + ")";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void eliminarMateria() {
	    Connection conec = conexionBBDD();
	    try {
	        Statement consulta = conec.createStatement();

	        System.out.println("Ingrese el código de la materia que desea eliminar:");
	        Scanner scanner = new Scanner(System.in);
	        String codMateria = scanner.nextLine();

	        String query = "DELETE FROM materias WHERE cod_materia = '" + codMateria + "'";

	        int filasAfectadas = consulta.executeUpdate(query);
	        if (filasAfectadas > 0) {
	            System.out.println("Materia con código " + codMateria + " eliminada correctamente.");
	        } else {
	            System.out.println("No se encontró ninguna materia con el código especificado.");
	        }
	        System.out.println("Presiona Enter para volver al menú.");
	        scanner.nextLine();
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar materia: " + e.getMessage());
	    }
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void modificarMateria() {
		Connection conec = conexionBBDD();
        try {
            Statement consulta = conec.createStatement();

            System.out.println("Ingrese el código de la materia que desea modificar:");
            Scanner scanner = new Scanner(System.in);
            String codMateria = scanner.nextLine();

            // Obtener los nuevos valores de la materia
            System.out.println("Ingrese el nuevo nombre de la materia:");
            String nombreMateria = scanner.nextLine();

            System.out.println("Ingrese la nueva descripción:");
            String descripcion = scanner.nextLine();

            System.out.println("Ingrese la nueva nomenclatura:");
            String nomenclatura = scanner.nextLine();

            System.out.println("Ingrese el nuevo número de horas:");
            int nHoras = scanner.nextInt();

            System.out.println("Ingrese el nuevo coste:");
            double coste = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese el nuevo estado activo (0: inactivo, 1: activo):");
            int lActivo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese las nuevas observaciones:");
            String observaciones = scanner.nextLine();

            System.out.println("Ingrese el nuevo código de departamento:");
            String codDepartamento = scanner.nextLine();

            // Construir la consulta de actualización
            String query = "UPDATE materias SET nombre_materia = '" + nombreMateria + "', descripcion = '" + descripcion +
                    "', nomenclatura = '" + nomenclatura + "', n_horas = " + nHoras + ", coste = " + coste +
                    ", l_activo = " + lActivo + ", observaciones = '" + observaciones + "', cod_departamento = '" +
                    codDepartamento + "' WHERE cod_materia = '" + codMateria + "'";

            int filasAfectadas = consulta.executeUpdate(query);
            if (filasAfectadas > 0) {
                System.out.println("Materia con código " + codMateria + " modificada correctamente.");
            } else {
                System.out.println("No se encontró ninguna materia con el código especificado.");
            }
            System.out.println("Presiona Enter para volver al menú.");
            scanner.nextLine();
        } catch (SQLException e) {
            System.out.println("Error al modificar materia: " + e.getMessage());
        }
    }
    /**
     * En la gestion de aulas, realizamos los mismos metodos que en los otros tipos
     * de gestion para el rol de direccion
     */
	public static void gestionAulas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- GESTION DE AULAS ------------------------|\n");
			System.out.println("  Seleccione una opcion:");
			System.out.println("\t 1. Modificar aulas");
			System.out.println("\t 2. Alta aulas");
			System.out.println("\t 3. Eliminar aulas");
			System.out.println("\t 4. Mostrar aulas");
			System.out.println("0. Volver al menu de direccion");

			System.out.print(" Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				modificarAula();
				break;
			case 2:
				System.out.println("Ingrese el cod_aula:");
				int cod_aula = scanner.nextInt();

				System.out.println("Ingrese la descripción:");
				String descripcion = scanner.next();

				System.out.println("Ingrese el código del aula:");
				int codigo_aula = scanner.nextInt();

				System.out.println("Ingrese la ubicación:");
				String ubicacion = scanner.next();

				System.out.println("Ingrese la capacidad:");
				int capacidad = scanner.nextInt();

				System.out.println("Ingrese el estado activo (true o false):");
				boolean l_activo = scanner.nextBoolean();

				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();
				AltaAula(cod_aula, descripcion, codigo_aula, ubicacion, capacidad, l_activo, observaciones);

				break;
			case 3:
				eliminarAula();
				break;
			case 4:
				ConsultarDatosAulas();
				break;
			case 0:
				return; 
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}

	public static void ConsultarDatosAulas() {
		Connection conec = conexionBBDD(); 
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM aulas");
			while (Select.next()) {
				int cod_aula = Select.getInt("cod_aula");
				String descripcion = Select.getString("descripcion");
				String codigo_aula = Select.getString("codigo_aula");
				String ubicacion = Select.getString("ubicacion");
				int capacidad = Select.getInt("capacidad");
				boolean l_activo = Select.getBoolean("l_activo");
				String observaciones = Select.getString("observaciones");

				System.out.println("Código de aula: " + cod_aula);
				System.out.println("Descripción: " + descripcion);
				System.out.println("Código de aula: " + codigo_aula);
				System.out.println("Ubicación: " + ubicacion);
				System.out.println("Capacidad: " + capacidad);
				System.out.println("Activo: " + l_activo);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("---------------------------------------");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void AltaAula(int cod_aula, String descripcion, int codigo_aula, String ubicacion, 
			int capacidad, boolean l_activo, String observaciones) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO aulas (cod_aula, descripcion, codigo_aula, ubicacion, capacidad, l_activo, observaciones) VALUES (" + cod_aula + ", '" + descripcion + "', '" +
					codigo_aula + "', '" + ubicacion + "', " + capacidad + ", " + (l_activo ? 1 : 0) + ", '" +
					observaciones + "')";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void eliminarAula() {
	    Connection conec = conexionBBDD();
	    try {
	        Statement consulta = conec.createStatement();

	        System.out.println("Ingrese el código del aula que desea eliminar:");
	        Scanner scanner = new Scanner(System.in);
	        String codAula = scanner.nextLine();

	        String query = "DELETE FROM aulas WHERE cod_aula = '" + codAula + "'";

	        int filasAfectadas = consulta.executeUpdate(query);
	        if (filasAfectadas > 0) {
	            System.out.println("Aula con código " + codAula + " eliminada correctamente.");
	        } else {
	            System.out.println("No se encontró ningún aula con el código especificado.");
	        }
	        System.out.println("Presiona Enter para volver al menú.");
	        scanner.nextLine();
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar aula: " + e.getMessage());
	    }
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void modificarAula() {
        Connection conec = conexionBBDD();
        try {
            Statement consulta = conec.createStatement();

            System.out.println("Ingrese el código del aula que desea modificar:");
            Scanner scanner = new Scanner(System.in);
            String codAula = scanner.nextLine();

            // Obtener los nuevos valores del aula
            System.out.println("Ingrese la nueva descripción del aula:");
            String descripcion = scanner.nextLine();

            System.out.println("Ingrese el nuevo código del aula:");
            String codigoAula = scanner.nextLine();

            System.out.println("Ingrese la nueva ubicación del aula:");
            String ubicacion = scanner.nextLine();

            System.out.println("Ingrese la nueva capacidad del aula:");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese el nuevo estado activo del aula (0: inactivo, 1: activo):");
            int lActivo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese las nuevas observaciones del aula:");
            String observaciones = scanner.nextLine();

            // Construir la consulta de actualización
            String query = "UPDATE aulas SET descripcion = '" + descripcion + "', codigo_aula = '" + codigoAula +
                    "', ubicacion = '" + ubicacion + "', capacidad = " + capacidad + ", l_activo = " + lActivo +
                    ", observaciones = '" + observaciones + "' WHERE cod_aula = '" + codAula + "'";

            int filasAfectadas = consulta.executeUpdate(query);
            if (filasAfectadas > 0) {
                System.out.println("Aula con código " + codAula + " modificada correctamente.");
            } else {
                System.out.println("No se encontró ningún aula con el código especificado.");
            }
            System.out.println("Presiona Enter para volver al menú.");
            scanner.nextLine();
        } catch (SQLException e) {
            System.out.println("Error al modificar aula: " + e.getMessage());
        }
    }
    /**
     * en la gestion de los cursos igualmente realizamos los mismos metodos
     */
	public static void gestionCursos() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("|----------------------- GESTION CURSOS ------------------------|\n");
			System.out.println("  Seleccione una opcion:");
			System.out.println("\t 1. Modificar curso");
			System.out.println("\t 2. Alta curso");
			System.out.println("\t 3. Eliminar curso");
			System.out.println("\t 4. Mostrar curso");
			System.out.println("0. Volver al menu de direccion");

			System.out.print(" Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			// Implementa las acciones correspondientes a cada opcion de gestion de cursos
			switch (opcion) {
			case 1:
				modificarCurso();
				break;
			case 2:
				System.out.println("Ingrese el Id_curso:");
				int Id_curso = scanner.nextInt();

				System.out.println("Ingrese el nombre del curso:");
				String nombre_curso = scanner.next();

				System.out.println("Ingrese el id_nivel:");
				int id_nivel = scanner.nextInt();

				System.out.println("Ingrese el n_maximo:");
				int n_maximo = scanner.nextInt();

				System.out.println("Ingrese el inicio del curso:");
				int inicio_curso = scanner.nextInt();

				System.out.println("Ingrese el fin del curso:");
				int fin_curso = scanner.nextInt();

				System.out.println("Ingrese las observaciones:");
				String observaciones = scanner.next();

				System.out.println("Ingrese el cod_aula:");
				int cod_aula = scanner.nextInt();

				// Llama al método AltaCurso con los datos ingresados
				AltaCurso(Id_curso, nombre_curso, id_nivel, n_maximo, inicio_curso, fin_curso, observaciones, cod_aula);
				break;
			case 3:
				eliminarCurso();
				break;
			case 4:
				ConsultarDatosCursos();
				break;
			case 0:
				return;
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
	
	public static void ConsultarDatosCursos() {
		Connection conec = conexionBBDD(); 
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM curso");
			while (Select.next()) {
				int Id_curso = Select.getInt("Id_curso");
				String nombre_curso = Select.getString("nombre_curso");
				int id_nivel = Select.getInt("id_nivel");
				int n_maximo = Select.getInt("n_maximo");
				int inicio_curso = Select.getInt("inicio_curso");
				int fin_curso = Select.getInt("fin_curso");
				String observaciones = Select.getString("observaciones");
				int cod_aula = Select.getInt("cod_aula");

				System.out.println("ID del curso: " + Id_curso);
				System.out.println("Nombre del curso: " + nombre_curso);
				System.out.println("ID del nivel: " + id_nivel);
				System.out.println("Número máximo: " + n_maximo);
				System.out.println("Fecha de inicio: " + inicio_curso);
				System.out.println("Fecha de fin: " + fin_curso);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("Código de aula: " + cod_aula);
				System.out.println("---------------------------------------");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void AltaCurso(int Id_curso, String nombre_curso, int id_nivel, int n_maximo, 
			int inicio_curso, int fin_curso, String observaciones, int cod_aula) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO curso (Id_curso, nombre_curso, id_nivel, n_maximo, inicio_curso, fin_curso, observaciones, cod_aula) VALUES (" +
					Id_curso + ", '" + nombre_curso + "', " + id_nivel + ", " + n_maximo + ", '" + inicio_curso + "', '" +
					fin_curso + "', '" + observaciones + "', " + cod_aula + ")";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void eliminarCurso() {
	    Connection conec = conexionBBDD();
	    try {
	        Statement consulta = conec.createStatement();

	        System.out.println("Ingrese el ID del cursos que desea eliminar:");
	        Scanner scanner = new Scanner(System.in);
	        int idCurso = scanner.nextInt();

	        String query = "DELETE FROM curso WHERE Id_curso = " + idCurso;

	        int filasAfectadas = consulta.executeUpdate(query);
	        if (filasAfectadas > 0) {
	            System.out.println("Curso con ID " + idCurso + " eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró ningún curso con el ID especificado.");
	        }
	        System.out.println("Presiona Enter para volver al menú.");
	        scanner.nextLine();
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar curso: " + e.getMessage());
	    }
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void modificarCurso() {
        Connection conec = conexionBBDD();
        try {
            Statement consulta = conec.createStatement();

            System.out.println("Ingrese el ID del curso que desea modificar:");
            Scanner scanner = new Scanner(System.in);
            int idCurso = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Obtener los nuevos valores del curso
            System.out.println("Ingrese el nuevo nombre del curso:");
            String nombreCurso = scanner.nextLine();

            System.out.println("Ingrese el nuevo ID del nivel:");
            int idNivel = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese el nuevo número máximo de estudiantes:");
            int nMaximo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese la nueva fecha de inicio del curso (YYYY-MM-DD):");
            String inicioCurso = scanner.nextLine();

            System.out.println("Ingrese la nueva fecha de fin del curso (YYYY-MM-DD):");
            String finCurso = scanner.nextLine();

            System.out.println("Ingrese las nuevas observaciones:");
            String observaciones = scanner.nextLine();

            System.out.println("Ingrese el nuevo código de aula:");
            String codAula = scanner.nextLine();

            // Construir la consulta de actualización
            String query = "UPDATE cursos SET nombre_curso = '" + nombreCurso + "', id_nivel = " + idNivel +
                    ", n_maximo = " + nMaximo + ", inicio_curso = '" + inicioCurso + "', fin_curso = '" + finCurso +
                    "', observaciones = '" + observaciones + "', cod_aula = '" + codAula + "' WHERE Id_curso = " + idCurso;

            int filasAfectadas = consulta.executeUpdate(query);
            if (filasAfectadas > 0) {
                System.out.println("Curso con ID " + idCurso + " modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún curso con el ID especificado.");
            }
            System.out.println("Presiona Enter para volver al menú.");
            scanner.nextLine();
        } catch (SQLException e) {
            System.out.println("Error al modificar curso: " + e.getMessage());
        }
    }

    /**
     * En esta gestion, no tengo los mismos metodos
     * A mi parecer, una nota no deberia de ser borrada, deberia ser guardada en la bbdd, 
     * porque nunca se sabe si un alumno necesita en un futuro un certificado de notas 
     * por lo que yo, he eliminado esa opcion al igual que la de modificar notas, porque pienso que una nota
     * si ya esta subida a la bbdd es porque esta puesta en seneca y a mi parecer,
     * una nota subida a seneca no deberia de ser cambiada, aunque a veces pueda suceder.
     */
	public static void gestionNotas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
			System.out.println("-----------Gestion notas--------------");
			System.out.println("Seleccione una opcion:");
			System.out.println("1. Alta notas");
			System.out.println("2. Mostrar notas");
			System.out.println("0. Volver al menu de direccion");

			System.out.print("Ingrese el numero correspondiente a la opcion deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Ingrese el código de nota: ");
			    int cod_nota = scanner.nextInt();

			    System.out.println("Ingrese el curso: ");
			    int curso = scanner.nextInt();

			    System.out.println("Ingrese el valor de la nota: ");
			    int valor_nota = scanner.nextInt();

			    System.out.println("Ingrese las observaciones: ");
			    scanner.nextLine(); // Limpiar el búfer
			    String observaciones = scanner.nextLine();

			    System.out.println("Ingrese el código de alumnos: ");
			    int cod_alumnos = scanner.nextInt();

			    System.out.println("Ingrese el código de convocatoria: ");
			    int cod_convocatoria = scanner.nextInt();

			    System.out.println("Ingrese el código de materia: ");
			    int cod_materia = scanner.nextInt();

			    AltaNotas(cod_nota, curso, valor_nota, observaciones, cod_alumnos, cod_convocatoria, cod_materia);
				break;
			case 2:
				ConsultarDatosNotas();
				break;
			case 0:
				return; 
			default:
				System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
			}
		}
	}
	
	public static void ConsultarDatosNotas() {
		Connection conec = conexionBBDD(); 
		try {
			Statement consulta = conec.createStatement();
			ResultSet Select = consulta.executeQuery("SELECT * FROM notas");
			while (Select.next()) {
				int cod_nota = Select.getInt("cod_nota");
				String curso = Select.getString("curso");
				int valor_nota = Select.getInt("valor_nota");
				String observaciones = Select.getString("observaciones");
				int cod_alumnos = Select.getInt("cod_alumnos");
				int cod_convocatoria = Select.getInt("cod_convocatoria");
				int cod_materia = Select.getInt("cod_materia");

				System.out.println("Código de nota: " + cod_nota);
				System.out.println("Curso: " + curso);
				System.out.println("Valor de la nota: " + valor_nota);
				System.out.println("Observaciones: " + observaciones);
				System.out.println("Código de alumnos: " + cod_alumnos);
				System.out.println("Código de convocatoria: " + cod_convocatoria);
				System.out.println("Código de materia: " + cod_materia);
				System.out.println("---------------------------------------");
			}
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void AltaNotas(int cod_nota, int curso, int valor_nota, String observaciones,
			int cod_alumnos, int cod_convocatoria, int cod_materia) {
		Connection conec = conexionBBDD();
		try {
			Statement consulta = conec.createStatement();
			String query = "INSERT INTO notas (cod_nota, curso, valor_nota, observaciones, cod_alumnos, " +
					"cod_convocatoria, cod_materia) VALUES (" +
					cod_nota + ", '" + curso + "', " + valor_nota + ", '" + observaciones + "', " +
					cod_alumnos + ", " + cod_convocatoria + ", " + cod_materia + ")";

			consulta.executeUpdate(query);
			System.out.println("Datos insertados correctamente.");
			System.out.println("Presiona Enter para volver al menú de profesor.");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos: " + e.getMessage());
		}
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	public static void eliminarNota() {
	    Connection conec = conexionBBDD();
	    try {
	        Statement consulta = conec.createStatement();

	        System.out.println("Ingrese el código de la nota que desea eliminar:");
	        Scanner scanner = new Scanner(System.in);
	        int codNota = scanner.nextInt();

	        String query = "DELETE FROM notas WHERE cod_nota = " + codNota;

	        int filasAfectadas = consulta.executeUpdate(query);
	        if (filasAfectadas > 0) {
	            System.out.println("Nota con código " + codNota + " eliminada correctamente.");
	        } else {
	            System.out.println("No se encontró ninguna nota con el código especificado.");
	        }
	        System.out.println("Presiona Enter para volver al menú.");
	        scanner.nextLine();
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar nota: " + e.getMessage());
	    }
		System.out.println("Presiona Enter para volver al menú de profesor.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	/**
	 * Función que convierte una cadena de texto en formato de fecha en un objeto Date.
	 * La cadena de texto que representa la fecha en formato "dd/MM/yyyy".
	 */
	private static Date parseFecha(String fechaStr) {
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        Date fecha = (Date) formatoFecha.parse(fechaStr);
	        return fecha;
	    } catch (ParseException e) {
	        System.out.println("Error al convertir la fecha: " + e.getMessage());
	    }
	    return null;
	}

}