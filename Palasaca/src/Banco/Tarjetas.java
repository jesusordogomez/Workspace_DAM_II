package Banco;

public class Tarjetas extends ProductosBancarios implements I_Tarjeta {

	private Cliente cliente;
	private Cuenta cuenta;
	private int NTarjeta;
	private int PIN;
	private double saldo;
	private String FechaCaducidad;
	
	public Tarjetas(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente, Cuenta cuenta, int nTarjeta, int pIN, double saldo,
			String fechaCaducidad) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente);
		this.cuenta = cuenta;
		NTarjeta = nTarjeta;
		PIN = pIN;
		this.saldo = saldo;
		FechaCaducidad = fechaCaducidad;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public int getNTarjeta() {
		return NTarjeta;
	}
	public void setNTarjeta(int nTarjeta) {
		NTarjeta = nTarjeta;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getFechaCaducidad() {
		return FechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		FechaCaducidad = fechaCaducidad;
	}

	@Override
	public boolean Acceso(int contraseña) {
		return this.clave == clave;
	}

	@Override
	public String sacarDinero(int cantidad) {
		if (!Acceso(clave)) {
            return "Error de acceso";
        }
        if (this instanceof Credito) {
            Credito tarjetaCredito = (Credito) this;
            if (cantidad > tarjetaCredito.getSaldoDisponible()) {
                return "Error: no tiene suficiente crédito disponible para esta operación.";
            }
            tarjetaCredito.setSaldoDisponible(tarjetaCredito.getSaldoDisponible() - cantidad);
            tarjetaCredito.setSaldoFactura(tarjetaCredito.getSaldoFactura() + cantidad);
            return "Saldo de crédito disponible: " + tarjetaCredito.getSaldoDisponible();
        } 
        if (this instanceof Debito) {
            Debito tarjetaDebito = (Debito) this;
            if (cantidad > tarjetaDebito.getMaximoDiario()) {
                return "Error: no tiene suficiente saldo en la cuenta asociada para esta operación.";
            }
            tarjetaDebito.setMaximoDiario(tarjetaDebito.getMaximoDiario() - cantidad);
            return "Saldo disponible de la cuenta asociada: " + tarjetaDebito.getMaximoDiario();
        }  
        
        if (this instanceof Monedero) {
            Monedero tarjetaMonedero = (Monedero) this;
            if (cantidad > tarjetaMonedero.getSaldoAsignado()) {
                return "Error: no tiene suficiente saldo en el monedero para esta operación.";
            }
            tarjetaMonedero.setSaldoAsignado(tarjetaMonedero.getSaldoAsignado() - cantidad);
            return "Saldo disponible en la tarjeta monedero: " + tarjetaMonedero.getSaldoAsignado();
        }
		return FechaCaducidad; 
    }
	

	@Override
	public double CargarDinero(int cantidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String datosTarjeta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double SaldoDisponible() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Double CargarMonedero(int dinero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double SaldoDisponible(int dinero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String DatosTarjeta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceso(int clave) {
		// TODO Auto-generated method stub
		return false;
	}
}