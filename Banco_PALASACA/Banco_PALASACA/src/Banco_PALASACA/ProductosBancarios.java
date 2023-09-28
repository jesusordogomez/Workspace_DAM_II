package Banco_PALASACA;

public class ProductosBancarios {
	
	public int clave;
	private String descripcion;
	private double comision;
	private String fechaInicio;
	private String fechaFinal;
	private Clientes cliente;
	
	public ProductosBancarios(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente) {
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
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}  
}
