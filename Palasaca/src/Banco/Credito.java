package Banco;
public class Credito extends Tarjetas {
    

	public Credito(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente, Cuenta cuenta, int nTarjeta, int pIN, double saldo, String fechaCaducidad) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cuenta, nTarjeta, pIN, saldo, fechaCaducidad);
		// TODO Auto-generated constructor stub
	}
	private double saldoDisponible;
    private double saldoFactura;
    private String fechaFacturacion;
    private double recargoCredito;
    

	public double getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public double getSaldoFactura() {
		return saldoFactura;
	}
	public void setSaldoFactura(double saldoFactura) {
		this.saldoFactura = saldoFactura;
	}
	public String getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public double getRecargoCredito() {
		return recargoCredito;
	}
	public void setRecargoCredito(double recargoCredito) {
		this.recargoCredito = recargoCredito;
	}
}
