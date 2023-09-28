package Banco;

public class PrestamosPersonales extends ProductosBancarios{
	
	private double saldoSolicitado;
	private double intereses;
	private String fechaRevision;
	private String fechaSolicitud;
	private String finalProducto;

	public PrestamosPersonales(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente);
		// TODO Auto-generated constructor stub
	}

	

	public double getSaldoSolicitado() {
		return getSaldoSolicitado();
	}

	public void setSaldoSolicitado(double saldoSolicitado) {
		this.saldoSolicitado = saldoSolicitado;
	}

	public double getIntereses() {
		return getIntereses();
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public String getFechaRevision() {
		return getFechaRevision();
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getFechaSolicitud() {
		return getFechaSolicitud();
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFinalProducto() {
		return getFinalProducto();
	}

	public void setFinalProducto(String finalProducto) {
		this.finalProducto = finalProducto;
	}
	
	
	
	

}
