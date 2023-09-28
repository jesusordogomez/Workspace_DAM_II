package Banco;

public class DatosPersonales {
	
	private String DNI;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String DireccionPostal;
	private String localidad;
	protected int CodigoPostal;
	private String provincia;
	private String FechaNacimiento;
	private String observaciones;
	public DatosPersonales(String dNI, String nombre, String apeilldo, String telefono, String correo,
			String direccionPostal, String localidad, int codigoPostal, String provincia, String fechaNacimiento,
			String observaciones) {
		super();
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apeilldo;
		this.telefono = telefono;
		this.correo = correo;
		this.DireccionPostal = direccionPostal;
		this.localidad = localidad;
		this.CodigoPostal = codigoPostal;
		this.provincia = provincia;
		this.FechaNacimiento = fechaNacimiento;
		this.observaciones = observaciones;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApeilldo() {
		return apellido;
	}
	public void setApeilldo(String apeilldo) {
		this.apellido = apeilldo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccionPostal() {
		return DireccionPostal;
	}
	public void setDireccionPostal(String direccionPostal) {
		DireccionPostal = direccionPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		CodigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
