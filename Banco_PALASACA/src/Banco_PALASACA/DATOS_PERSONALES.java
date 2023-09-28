package Banco_PALASACA;
import java.util.*;

public class DATOS_PERSONALES {
	
	//Atributos
	protected String dni="";
	protected String nombre="";
	protected String primer_apellido="";
	protected String segundo_apellido="";
	protected String telefono="";
	protected String correo_electronico="";
	protected String direccion="";
	protected String localidad="";
	protected int cp;
	protected String provincia="";
	protected Date fecha_nac;
	protected String obervaciones="";
	
	
	//Metodos ( Getter y Setter )
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	protected void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	protected void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	protected void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getDireccion() {
		return direccion;
	}
	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	protected void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getCp() {
		return cp;
	}
	protected void setCp(int cp) {
		this.cp = cp;
	}
	public String getProvincia() {
		return provincia;
	}
	protected void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	protected void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getObervaciones() {
		return obervaciones;
	}
	protected void setObervaciones(String obervaciones) {
		this.obervaciones = obervaciones;
	}
	
	
	//Metodos
	public void ModificarDatos( DATOS_PERSONALES datos ) {
		Scanner sc = new Scanner(System.in);
		String pregunta;
		System.out.println("¿Desea modificar los datos? ( si/no )");
		pregunta = sc.next();
		if ( pregunta.equals("si") ) {
			if ( datos instanceof CLIENTES ) {
				//Se realiza la modificación del cliente
				CLIENTES cliente = (CLIENTES) datos;
				cliente.ModificarCliente(cliente);
			}
			if ( datos instanceof EMPLEADOS ) {
				//Realizamos la modificación del empleado
				EMPLEADOS empleado = (EMPLEADOS) datos;
				empleado.ModificarEmpleados(empleado);
			}
		}
		
	}
	
	
	
	//CONSTRUCTORES
	
	//Constructor por defecto
	public DATOS_PERSONALES() {
		super();
	}
	
	
	
	//Constructor con todos los parámetros
	public DATOS_PERSONALES(String dni, String nombre, String primer_apellido, String segundo_apellido, String telefono,
			String correo_electronico, String direccion, String localidad, int cp, String provincia, Date fecha_nac,
			String obervaciones) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.provincia = provincia;
		this.fecha_nac = fecha_nac;
		this.obervaciones = obervaciones;
	}
	
	
	
}