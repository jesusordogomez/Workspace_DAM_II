package Banco_PALASACA;

public class Monedero extends Tarjetas {
    private double saldoAsignado;

	public Monedero(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente, Clientes cliente2, Cuentas cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad, double saldoAsignado) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cliente2, cuenta, nTarjeta, pIN, saldo,
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
