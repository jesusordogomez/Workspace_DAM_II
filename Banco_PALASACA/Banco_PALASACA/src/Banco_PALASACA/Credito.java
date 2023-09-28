package Banco_PALASACA;

public class Credito extends Tarjetas {
    

	private double saldoDisponible;
    private double saldoFactura;
    private String fechaFacturacion;
    private double recargoCredito;
    
	public Credito(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente, Clientes cliente2, Cuentas cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad, double saldoDisponible, double saldoFactura, String fechaFacturacion,
			double recargoCredito) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cliente2, cuenta, nTarjeta, pIN, saldo,
				fechaCaducidad);
		this.saldoDisponible = saldoDisponible;
		this.saldoFactura = saldoFactura;
		this.fechaFacturacion = fechaFacturacion;
		this.recargoCredito = recargoCredito;
	}
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

