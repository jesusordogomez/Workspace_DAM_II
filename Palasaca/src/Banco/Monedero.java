package Banco;

public class Monedero extends Tarjetas{
    private double saldoAsignado;

	public Monedero(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente, Cuenta cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad, double saldoAsignado) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cuenta, nTarjeta, pIN, saldo,
				fechaCaducidad);
		this.saldoAsignado = saldoAsignado;
	}

	public double getSaldoAsignado() {
		return saldoAsignado;
	}

	public void setSaldoAsignado(double saldoAsignado) {
		this.saldoAsignado = saldoAsignado;
	}	
}
