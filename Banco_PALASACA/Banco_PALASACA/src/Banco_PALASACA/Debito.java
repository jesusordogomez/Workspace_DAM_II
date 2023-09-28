package Banco_PALASACA;

public class Debito extends Tarjetas {
    private double maximoDiario;

	public Debito(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente, Clientes cliente2, Cuentas cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad, double maximoDiario) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente, cliente2, cuenta, nTarjeta, pIN, saldo,
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
