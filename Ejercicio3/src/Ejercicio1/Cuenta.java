package Ejercicio1;

public class Cuenta {
	/*atributos*/
	private String Nombre_cliente;
	private String Numero_cuenta;
	private double Interes;
	private double Saldo;
	
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
	
	/*metodos ingreso y reintegro*/
	
	public boolean Ingreso(double ingreso) {
		boolean correcto = true;
		if( ingreso > 0) {
			this.setSaldo(this.getSaldo()+ingreso);
			System.out.println(" ingreso realizado");
		} else {
			System.out.println(" No se puede ingresar una cantidad negativa");
			correcto = false;
		}
		return correcto;		
	}
	
	public boolean Reintegro(double reint) {
		boolean operacion= true;
		if (this.getSaldo()>reint) {
			this.setSaldo(this.getSaldo()-reint);
			System.out.println("Reintegro realizado");
			operacion = true;
		}else {
			System.out.println("No hay suficiente dinero");
			operacion=false;
		}
		
		return operacion;
	}
	/* metodo transferencia*/
	
	public void transferencia(Cuenta cuenta, double transferencia) {
		if(this.getSaldo()>transferencia && transferencia>0) {
			Reintegro(transferencia);
			System.out.println();
			cuenta.Ingreso(transferencia);
		}
	}
}
