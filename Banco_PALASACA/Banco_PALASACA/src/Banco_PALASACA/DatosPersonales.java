package Banco_PALASACA;

import java.util.Scanner;

public class DatosPersonales {
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String Telefono;
	private String Correo;
	private String DP;
	private String localidad;
	private int CP;
	private String Provincia;
	private String FechaN;
	private String Observaciones;
	
	public DatosPersonales(String dni, String nombre, String apellido, String telefono, String correo, String dP,
			String localidad, int cP, String provincia, String fechaN, String observaciones) {
		super();
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Correo = correo;
		DP = dP;
		this.localidad = localidad;
		CP = cP;
		Provincia = provincia;
		FechaN = fechaN;
		Observaciones = observaciones;
	}
	
	public String getDni() {
		return Dni;
	}
	
	public void setDni(String dni) {
		Dni = dni;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public String getTelefono() {
		return Telefono;
	}
	
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	public String getCorreo() {
		return Correo;
	}
	
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	public String getDP() {
		return DP;
	}
	
	public void setDP(String dP) {
		DP = dP;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public int getCP() {
		return CP;
	}
	
	public void setCP(int cP) {
		CP = cP;
	}
	
	public String getProvincia() {
		return Provincia;
	}
	
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	
	public String getFechaN() {
		return FechaN;
	}
	
	public void setFechaN(String fechaN) {
		FechaN = fechaN;
	}
	
	public String getObservaciones() {
		return Observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	

	

    // Constructor
   

     
//    public void revisarYModificarDatos() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("¿Desea modificar el nombre? (Si / No)");
//        String respuesta = scanner.nextLine();
//        if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca el nuevo nombre:");
//            String nombre = scanner.nextLine();
//            setNombre(nombre);
//        }
//
//        System.out.println("¿Desea modificar los apellidos? (Si / No)");
//        respuesta = scanner.nextLine();
//        if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca los nuevos apellidos:");
//            String apellidos = scanner.nextLine();
//            setApellido(apellidos);
//        }
//
//        System.out.println("¿Desea modificar el DNI? (Si / No)");
//        respuesta = scanner.nextLine();
//       if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca el nuevo DNI:");
//            String dni = scanner.nextLine();
//            setDni(dni);
//        }
//
//        System.out.println("¿Desea modificar la dirección? (Si / No)");
//        respuesta = scanner.nextLine();
//        if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca la nueva dirección:");
//            String Localidad = scanner.nextLine();
//            setLocalidad(Localidad);
//        }
//
//        System.out.println("¿Desea modificar el teléfono? (Si / No)");
//       respuesta = scanner.nextLine();
//        if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca el nuevo teléfono:");
//            String telefono = scanner.nextLine();
//            setTelefono(telefono);
//       }
//
//        System.out.println("¿Desea modificar el email? (Si / No)");
//        respuesta = scanner.nextLine();
//        if (respuesta.equalsIgnoreCase("Si")) {
//            System.out.println("Introduzca el nuevo email:");
//            String Correo = scanner.nextLine();
//            setCorreo(Correo);
//        }
//    }

    
}
