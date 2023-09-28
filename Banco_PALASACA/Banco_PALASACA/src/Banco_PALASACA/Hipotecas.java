package Banco_PALASACA;

public class Hipotecas extends ProductosBancarios {
	
	private double saldoSolicitado;
    private int plazoDevolucion;
    private double interesMensual;
    private double interesAnual;
    private String fechaRevision;
    private String fechaSolicitud;
    private String fechaFinal;
    
	public Hipotecas(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente, double saldoSolicitado, int plazoDevolucion, double interesMensual, double interesAnual,
			String fechaRevision, String fechaSolicitud, String fechaFinal2) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente);
		this.saldoSolicitado = saldoSolicitado;
		this.plazoDevolucion = plazoDevolucion;
		this.interesMensual = interesMensual;
		this.interesAnual = interesAnual;
		this.fechaRevision = fechaRevision;
		this.fechaSolicitud = fechaSolicitud;
		fechaFinal = fechaFinal2;
	}

	public double getSaldoSolicitado() {
		return saldoSolicitado;
	}

	public void setSaldoSolicitado(double saldoSolicitado) {
		this.saldoSolicitado = saldoSolicitado;
	}

	public int getPlazoDevolucion() {
		return plazoDevolucion;
	}

	public void setPlazoDevolucion(int plazoDevolucion) {
		this.plazoDevolucion = plazoDevolucion;
	}

	public double getInteresMensual() {
		return interesMensual;
	}

	public void setInteresMensual(double interesMensual) {
		this.interesMensual = interesMensual;
	}

	public double getInteresAnual() {
		return interesAnual;
	}

	public void setInteresAnual(double interesAnual) {
		this.interesAnual = interesAnual;
	}

	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
