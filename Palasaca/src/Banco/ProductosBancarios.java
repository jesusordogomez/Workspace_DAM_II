package Banco;

public class ProductosBancarios {
	
	public int clave;
	private String descripcion;
	private double comision;
	private String fechaInicio;
	private String fechaFinal;
	private Cliente cliente;
	

	
	public ProductosBancarios(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.comision = comision;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cliente = cliente;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean Acceso(int contraseña) {

		return false;
	}
	public String sacarDinero(int cantidad) {
		// TODO Auto-generated method stub
		return null;
	}
	public double ingresarDinero(int cantidad) {
		// TODO Auto-generated method stub
		return 0;
	}  
}
