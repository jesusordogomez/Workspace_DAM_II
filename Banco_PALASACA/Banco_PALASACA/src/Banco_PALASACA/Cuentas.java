package Banco_PALASACA;

public class Cuentas extends ProductosBancarios implements I_Cuentas {

	private Clientes cliente;
	private int IBAN;
	private double saldo;
	private double comision;
	private TipoCuenta tipo;
	
	

	public Cuentas(int clave, String descripcion, double comision, String fechaInicio, String fechaFinal,
			Clientes cliente, Clientes cliente2, int iBAN, double saldo, double comision2, TipoCuenta tipo) {
		super(clave, descripcion, comision, fechaInicio, fechaFinal, cliente);
		cliente = cliente2;
		IBAN = iBAN;
		this.saldo = saldo;
		comision = comision2;
		this.tipo = tipo;
	}
	
	

	//Metodos
	
	public Clientes getCliente() {
		return cliente;
	}



	public void setCliente(Clientes cliente) {
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



	@Override
	public boolean Acceso(int contraseña) {
		if(this.clave==contraseña) {
			return true;
		}
		return false;
	}

	@Override
	public String sacarDinero(int cantidad) {
		if (saldo<cantidad) {
			return "No se puede sacar tanto dinero";
		}
		saldo= saldo-cantidad;
		return "Saldo disponible " + String.valueOf(saldo)  ;
	}

	@Override
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
