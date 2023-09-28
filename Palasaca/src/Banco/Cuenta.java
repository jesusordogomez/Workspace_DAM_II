package Banco;
public class Cuenta extends ProductosBancarios implements I_Cuentas {

	private Cliente cliente;
	private int IBAN;
	private double saldo;
	private double comision;
	private TipoCuenta tipo;
	
	public Cuenta(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Cliente cliente, int iBAN, double saldo, double comision2, TipoCuenta tipo) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente);
		IBAN = iBAN;
		this.saldo = saldo;
		comision = comision2;
		this.tipo = tipo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIBAN() {
		return IBAN;
	}

	public void setIBAN(int iBAN) {
		IBAN = iBAN;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	public TipoCuenta getTipo() {
		return tipo;
	}

	public void setTipo(TipoCuenta tipo) {
		this.tipo = tipo;
	}

	public boolean Acceso(int contraseña) {
		if(this.clave==contraseña) {
			return true;
		}
		return false;
	}

	public String sacarDinero(int cantidad) {
		if (saldo<cantidad) {
			return "No es posible retirar tanto dinero";
		}
		saldo= saldo-cantidad;
		return "Saldo disponible " + String.valueOf(saldo)  ;
	}


	public double ingresarDinero(int cantidad) {
		saldo=saldo+cantidad;
		return saldo;
	}

	@Override
	public double visualizarCuenta() {
		
		return saldo ;
	}

	@Override
	public String datosCuenta() {
		// TODO Auto-generated method stub
		return "Cuentas [cliente=" + cliente + ", IBAN=" + IBAN + ", saldo=" + saldo + ", comision=" + comision + "]";
	}
	

	@Override
	public TipoCuenta tipoCuenta() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public double devolverIntereses(int comision) {
		double interes = this.saldo * comision / 100;
        
		return interes;
	}
}
