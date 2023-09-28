
public class Cuenta {
	/*atributos*/
	private String Nombre_cliente;
	private String Numero_cuenta;
	private double Interes;
	private double Saldo;
	private boolean posible;
	
	/*constructor por defecto*/
	public Cuenta() {	
	}
	
	/*contrusctores con parametros*/
	
	public Cuenta(String Nombre_cliente, String Numero_cuenta, double Interes, double Saldo) {
		this.Nombre_cliente= Nombre_cliente;
		this.Numero_cuenta = Numero_cuenta;
		this.Interes = Interes;
		this.Saldo = Saldo;	
	}
	
	/*constructor copia*/
	
	public Cuenta(Cuenta micuenta) {
		this.Nombre_cliente = micuenta.Nombre_cliente;
		this.Numero_cuenta = micuenta.Numero_cuenta;
		this.Interes = micuenta.Interes;
		this.Saldo = micuenta.Saldo;
	}

	/*Getter y setter*/
	
	public String getNombre_cliente() {
		return Nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		Nombre_cliente = nombre_cliente;
	}

	public String getNumero_cuenta() {
		return Numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		Numero_cuenta = numero_cuenta;
	}

	public double getInteres() {
		return Interes;
	}

	public void setInteres(double interes) {
		Interes = interes;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	
	public boolean isPosible() {
		return posible;
	}

	public void setPosible(boolean posible) {
		this.posible = posible;
	}
	/*metodos ingreso y reintegro*/
	
	public boolean Ingreso(double ingreso) {
		if( ingreso < 0) {
			this.setPosible(false);
		} else {
			Saldo = Saldo + ingreso;
			this.setPosible(true);
		}
		return this.isPosible();		
	}
	
	public boolean Reintegro(double reintegro) {
		if ( reintegro < 0) {
			this.setPosible(false);
		} else {
			this.setPosible(true);
		}
		return this.isPosible();		
	}
	/* metodo transferencia*/
	
	public boolean transferencia(Cuenta cuenta, double transferencia) {
		boolean operacion = true;
		
		
		return operacion;
	}
}
