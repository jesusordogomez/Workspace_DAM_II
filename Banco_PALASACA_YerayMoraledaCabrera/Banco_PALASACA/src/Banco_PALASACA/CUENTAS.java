package Banco_PALASACA;

import java.util.Date;

public class CUENTAS extends PRODUCTOS_BANCARIOS implements I_Cuentas {

	//Atributos
	protected int iban;
	protected Double saldo_disponible;
	protected Double comision;
	protected TiposCuenta tipo_cuenta;

	//Metodos ( Getter y Setter )
	public int getIban() {
		return iban;
	}
	public void setIban(int iban) {
		this.iban = iban;
	}
	public double getSaldo_disponible() {
		return saldo_disponible;
	}
	public void setSaldo_disponible(double saldo_disponible) {
		this.saldo_disponible = saldo_disponible;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public TiposCuenta getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(TiposCuenta tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}


	//Metodos
	public double sacarDinero(int cantidad) {
		if ( correcto ) {
			if ( cantidad <= saldo_disponible ) {
				saldo_disponible -= cantidad;
			}
		}
		correcto = false;
		return saldo_disponible;
	}
	public double ingresarDinero(int cantidad) {
		if ( correcto ) {
			saldo_disponible += cantidad;
		}
		correcto = false;
		return saldo_disponible;
	}
	public double visualizarCuenta() {
		return saldo_disponible;
	}
	public String datosCuenta() {
		return toString();
	}
	public TiposCuenta tipoCuenta() {
		return tipo_cuenta;
	}
	public Double devolverIntereses() {
		return saldo_disponible * comision / 100;
	}

	public boolean isCorrecto() {
		return false;
	}


	//CONSTRUCTORES

	//Constructor por defecto
	public CUENTAS() {
		super();
	}


	//Constructor con todos los parámetros
	public CUENTAS(int clave, int iban, Double saldo_disponible, Double comision, TiposCuenta tipo_cuenta) {
		super();
		//Controlamos si el usuario introduce una clave de 4 cifras
		try {
			String claveString = Integer.toString(clave);
			if ( claveString.length() == 4 );
		} catch (IllegalArgumentException e) {
			System.out.println("Clave incorrecta, la clave de acceso debe tener 4 cifras!!!");
		} catch (Exception e) {
			System.out.println("Clave incorrecta, la clave de acceso debe tener 4 cifras!!!");
		}
		this.clave = clave;
		this.iban = iban;
		this.saldo_disponible = saldo_disponible;
		this.comision = comision;
		this.tipo_cuenta = tipo_cuenta;
	}	


	//Metodo toString
	public String toString() {
		return "CUENTAS [iban=" + iban + ", saldo_disponible=" + saldo_disponible + ", comision=" + comision
				+ ", tipo_cuenta=" + tipo_cuenta + "]";
	}






}