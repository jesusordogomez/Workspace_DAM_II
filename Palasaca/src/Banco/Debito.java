package Banco;

public class Debito extends Tarjetas {
    private double maximoDiario;

	public Debito(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente, Cuenta cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad, double maximoDiario) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cuenta, nTarjeta, pIN, saldo,
				fechaCaducidad);
		this.maximoDiario = maximoDiario;
	}

	public double getMaximoDiario() {
		return maximoDiario;
	}

	public void setMaximoDiario(double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}
}