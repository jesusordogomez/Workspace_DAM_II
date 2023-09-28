package Banco_PALASACA;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EMPLEADOS extends DATOS_PERSONALES implements I_Empleados {

	//Atributos
	protected Date fecha_contratacion;
	protected String puesto_trabajo;
	protected Double sueldo;
	protected Double anyos_experiencia;
	
	
	//Metodos ( Getter y Setter )
	public Date getFecha_contratacion() {
		return fecha_contratacion;
	}
	protected void setFecha_contratacion(Date fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}
	public String getPuesto_trabajo() {
		return puesto_trabajo;
	}
	protected void setPuesto_trabajo(String puesto_trabajo) {
		this.puesto_trabajo = puesto_trabajo;
	}
	public double getSueldo() {
		return sueldo;
	}
	protected void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public double getAnyos_experiencia() {
		return anyos_experiencia;
	}
	protected void setAnyos_experiencia(double años_exp) {
		this.anyos_experiencia = años_exp;
	}
	
	
	//Metodos
	public void ModificarEmpleados( EMPLEADOS empleado ) {
		Scanner sc = new Scanner(System.in);
		String pregunta="";
		System.out.println("¿Seguro que quieres modificar los datos del empleado?");
		pregunta = sc.next();
		if ( pregunta.equals("si") ) {
			int opciones = 1;
			do {
				String nuevoDatoString="";
				int nuevoDatoInt;
				Double nuevoDatoDouble;
				
				System.out.println("(Pulse 1). Modificar DNI");
				System.out.println("(Pulse 2). Modificar nombre");
				System.out.println("(Pulse 3). Modificar primer apellido");
				System.out.println("(Pulse 4). Modificar segundo apellido");
				System.out.println("(Pulse 5). Modificar Teléfono");
				System.out.println("(Pulse 6). Modificar el correo electrónico");
				System.out.println("(Pulse 7). Modificar dirección");
				System.out.println("(Pulse 8). Modificar localidad");
				System.out.println("(Pulse 9). Modificar Código Postal");
				System.out.println("(Pulse 10). Modificar Provincia");
				System.out.println("(Pulse 11). Modificar Fecha de Nacimiento");
				System.out.println("(Pulse 12). Modificar Observaciones");
				System.out.println("(Pulse 13). Modificar la fecha de contratación");
				System.out.println("(Pulse 14). Modificar puesto de trabajo");
				System.out.println("(Pulse 15). Modificar sueldo");
				System.out.println("(Pulse 16). Modificar años de experiencia");
				System.out.println("(Pulse 0). Si desea salir");
				
				opciones = sc.nextInt();
				
				if ( opciones == 1 ) {
					System.out.print("Introduce el nuevo DNI: ");
					nuevoDatoString = sc.next();
					empleado.setDni(nuevoDatoString);
				}
				if ( opciones == 2 ) {
					System.out.print("Introduce el nuevo nombre: ");
					nuevoDatoString = sc.next();
					empleado.setNombre(nuevoDatoString);
				}
				if ( opciones == 3 ) {
					System.out.print("Introduce el nuevo primer apellido: ");
					nuevoDatoString = sc.next();
					empleado.setPrimer_apellido(nuevoDatoString);
				}
				if ( opciones == 4 ) {
					System.out.print("Introduce el nuevo segundo apellido: ");
					nuevoDatoString = sc.next();
					empleado.setSegundo_apellido(nuevoDatoString);
				}
				if ( opciones == 5 ) {
					System.out.print("Introduce el nuevo Teléfono: ");
					nuevoDatoString = sc.next();
					empleado.setTelefono(nuevoDatoString);
				}
				if ( opciones == 6 ) {
					System.out.print("Introduce el nuevo correo electrónico: ");
					nuevoDatoString = sc.next();
					empleado.setCorreo_electronico(nuevoDatoString);
				}
				if ( opciones == 7 ) {
					System.out.print("Introduce la nueva dirección: ");
					nuevoDatoString = sc.next();
					empleado.setDireccion(nuevoDatoString);
				}
				if ( opciones == 8 ) {
					System.out.print("Introduce la nueva localidad: ");
					nuevoDatoString = sc.next();
					empleado.setLocalidad(nuevoDatoString);
				}
				if ( opciones == 9 ) {
					try {
					    System.out.print("Introduce el nuevo Código Postal: ");
					    nuevoDatoInt = sc.nextInt();
					    empleado.setCp(nuevoDatoInt);
					} catch (InputMismatchException e) {
					    System.out.println("Debes introducir un número entero válido.");
					}
				}
				if ( opciones == 10 ) {
					System.out.print("Introduce la nueva Provincia: ");
					nuevoDatoString = sc.next();
					empleado.setProvincia(nuevoDatoString);
				}
				if ( opciones == 11 ) {
					System.out.print("Introduce la nueva fecha de nacimiento: ");
					String fechaComoTexto = sc.next();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yy");
					Date nuevaFecha = null;
					try {
						nuevaFecha = formatoFecha.parse(fechaComoTexto);
					} catch (ParseException e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					} catch (Exception e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					}
					empleado.setFecha_nac(nuevaFecha);
				}
				if ( opciones == 12 ) {
					System.out.print("Introduce las nuevas observaciones: ");
					nuevoDatoString = sc.next();
					empleado.setObervaciones(nuevoDatoString);
				}
				if ( opciones == 13 ) {
					System.out.print("Introduce la nueva fecha de contratación: ");
					String fechaComoTexto = sc.next();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yy");
					Date nuevaFecha = null;
					try {
						nuevaFecha = formatoFecha.parse(fechaComoTexto);
					} catch (ParseException e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					} catch (Exception e) {
						System.out.println("El formato de la fecha introducida es incorrecto.");
					}
					empleado.setFecha_contratacion(nuevaFecha);
				}
				if ( opciones == 13 ) {
					System.out.print("Introduce el nuevo puesto de trabajo: ");
					nuevoDatoString = sc.next();
					empleado.setPuesto_trabajo(nuevoDatoString);
				}
				if ( opciones == 13 ) {
					System.out.print("Introduce el nuevo sueldo: ");
					nuevoDatoDouble = sc.nextDouble();
					empleado.setSueldo(nuevoDatoDouble);
				}
				if ( opciones == 13 ) {
					System.out.print("Introduce los nuevos años de experiencia: ");
					nuevoDatoInt = sc.nextInt();
					empleado.setAnyos_experiencia(nuevoDatoInt);
				}
			}while ( opciones!=0 );
		}
		if ( pregunta.equals("no") ) System.out.println("Gracias, hasta la próxima!!!");
	}
	public void aumentoSalarial( double porcentaje ) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}
	public void ascenso( String nuevoPuesto, double nuevoSueldo ) {
		puesto_trabajo = nuevoPuesto;
		sueldo = nuevoSueldo;
	}
	
	
	
	//CONSTRUCTORES
	
	//Constructor por defecto
	public EMPLEADOS() {
		super();
	}
	
	
	//Constructor con todos los parámetros
	public EMPLEADOS(Date fecha_contratacion, String puesto_trabajo, double sueldo, Double anyos_experiencia) {
		super();
		this.fecha_contratacion = fecha_contratacion;
		this.puesto_trabajo = puesto_trabajo;
		this.sueldo = sueldo;
		this.anyos_experiencia = anyos_experiencia;
	}
	
	//Metodo toString
	public String toString() {
		return "EMPLEADOS [fecha_contratacion=" + fecha_contratacion + ", puesto_trabajo=" + puesto_trabajo
				+ ", sueldo=" + sueldo + ", anyos_experiencia=" + anyos_experiencia + "]";
	}


	



}