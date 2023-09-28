package Banco_PALASACA;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CLIENTES extends DATOS_PERSONALES implements I_Clientes {

	//Atributos
	protected String situacio_laboral;


	//Metodos ( Getter y Setter )
	public String getSituacio_laboral() {
		return situacio_laboral;
	}
	protected void setSituacio_laboral(String situacio_laboral) {
		this.situacio_laboral = situacio_laboral;
	}


	//Metodos
	public void ModificarCliente( CLIENTES cliente ) {
		Scanner sc = new Scanner(System.in);
		String pregunta="";
		System.out.println("¿Seguro que quieres modificar los datos del cliente?");
		pregunta = sc.next();
		int opciones = 1;
		if ( pregunta.equals("si") ) {
			do {
				System.out.println("(Pulse 1). Modificar DNI \n"
						+ "(Pulse 2). Modificar nombre \n"
						+ "(Pulse 3). Modificar primer apellido \n"
						+ "(Pulse 4). Modificar segundo apellido \n"
						+ "(Pulse 5). Modificar Teléfono \n"
						+ "(Pulse 6). Modificar el correo electrónico \n"
						+ "(Pulse 7). Modificar dirección \n" 
						+ "(Pulse 8). Modificar localidad \n" 
						+ "(Pulse 9). Modificar Código Postal \n" 
						+ "(Pulse 10). Modificar Provincia \n" 
						+ "(Pulse 11). Modificar Fecha de Nacimiento \n" 
						+ "(Pulse 12). Modificar Observaciones \n" 
						+ "(Pulse 13). Modificar situación laboral \n" 
						+ "(Pulse 0). Si desea salir \n");

				opciones = sc.nextInt();

				if ( opciones == 1 ) {
					System.out.print("Introduce el nuevo DNI: ");
					String nuevoDato = sc.next();
					cliente.setDni(nuevoDato);
				}
				if ( opciones == 2 ) {
					System.out.print("Introduce el nuevo nombre: ");
					String nuevoDato = sc.next();
					cliente.setNombre(nuevoDato);
				}
				if ( opciones == 3 ) {
					System.out.print("Introduce el nuevo primer apellido: ");
					String nuevoDato = sc.next();
					cliente.setPrimer_apellido(nuevoDato);
				}
				if ( opciones == 4 ) {
					System.out.print("Introduce el nuevo segundo apellido: ");
					String nuevoDato = sc.next();
					cliente.setSegundo_apellido(nuevoDato);
				}
				if ( opciones == 5 ) {
					System.out.print("Introduce el nuevo Teléfono: ");
					String nuevoDato = sc.next();
					cliente.setTelefono(nuevoDato);
				}
				if ( opciones == 6 ) {
					System.out.print("Introduce el nuevo correo electrónico: ");
					String nuevoDato = sc.next();
					cliente.setCorreo_electronico(nuevoDato);
				}
				if ( opciones == 7 ) {
					System.out.print("Introduce la nueva dirección: ");
					String nuevoDato = sc.next();
					cliente.setDireccion(nuevoDato);
				}
				if ( opciones == 8 ) {
					System.out.print("Introduce la nueva localidad: ");
					String nuevoDato = sc.next();
					cliente.setLocalidad(nuevoDato);
				}
				if ( opciones == 9 ) {
					int nuevoDato;
					try {
						System.out.print("Introduce el nuevo Código Postal: ");
						nuevoDato = sc.nextInt();
						cliente.setCp(nuevoDato);
					} catch (InputMismatchException e) {
						System.out.println("Debes introducir un número entero válido!!!");
					}
				}
				if ( opciones == 10 ) {
					System.out.print("Introduce la nueva Provincia: ");
					String nuevoDato = sc.next();
					cliente.setProvincia(nuevoDato);
				}
				if ( opciones == 11 ) {
					System.out.print("Introduce la nueva fecha de nacimiento: ");
					String fechaComoTexto = sc.next();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
					Date nuevaFecha = null;
					try {
						nuevaFecha = formatoFecha.parse(fechaComoTexto);
					} catch (ParseException e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					} catch (Exception e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					}
					cliente.setFecha_nac(nuevaFecha);
				}
				if ( opciones == 12 ) {
					System.out.print("Introduce las nuevas observaciones: ");
					String nuevoDato = sc.next();
					cliente.setObervaciones(nuevoDato);
				}
				if ( opciones == 13 ) {
					System.out.print("Introduce la nueva situación laboral: ");
					String nuevoDato = sc.next();
					cliente.setSituacio_laboral(nuevoDato);
				}
			}while ( opciones!=0 );
		}
		if ( pregunta.equals("no") ) System.out.println("Gracias, hasta la próxima!!!");
	}



	//CONSTRUCTORES

	//Constructor por defecto
	public CLIENTES() {
		super();
		this.situacio_laboral = null;
	}


	//Constructor con parámetros
	public CLIENTES(String situacio_laboral) {
		super();
		this.situacio_laboral = situacio_laboral;
	}



	//Metodo toString
	public String toString() {
		return "CLIENTES [situacio_laboral=" + situacio_laboral + "]";
	}





}