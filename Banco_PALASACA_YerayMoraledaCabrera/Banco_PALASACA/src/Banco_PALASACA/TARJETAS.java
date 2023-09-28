package Banco_PALASACA;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.swing.DebugGraphics;

public abstract class TARJETAS extends PRODUCTOS_BANCARIOS implements I_Tarjertas {

	//Atributos
	protected CUENTAS cuenta;
	protected int numero_tarjeta;
	protected int clave_pin;
	protected String clave_seguridad;
	protected Double saldo_diponible;
	protected Date fecha_caducidad;
	protected String[] tipoTarjeta = { "Crédito", "Débito", "Monedero" };


	//Metodos ( Getter y Setter )
	public CUENTAS getCuenta() {
		return cuenta;
	}
	public void setCuenta(CUENTAS cuenta) {
		this.cuenta = cuenta;
	}
	public int getNumero_tarjeta() {
		return numero_tarjeta;
	}
	public void setNumero_tarjeta(int numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public int getClave_pin() {
		return clave_pin;
	}
	public void setClave_pin(int clave_pin) {
		this.clave_pin = clave_pin;
	}
	public String getClave_seguridad() {
		return clave_seguridad;
	}
	public void setClave_seguridad(String clave_seguridad) {
		this.clave_seguridad = clave_seguridad;
	}
	public double getSaldo_diponible() {
		return saldo_diponible;
	}
	public void setSaldo_diponible(Double saldo_diponible) {
		this.saldo_diponible = saldo_diponible;
	}
	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}
	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}



	//Metodos
	public Double sacarDinero(int cantidad) {
		if ( correcto ) {
			if ( this instanceof CREDITO ) return ((CREDITO) this).sacarDineroCredito(cantidad);
			else if ( this instanceof DÉBITO ) return ((DÉBITO) this).sacarDineroDebito(cantidad);
			else if ( this instanceof MONEDERO ) return ((MONEDERO) this).sacarDineroMonedero(cantidad);
		}
		correcto = false;
		return -1.0;
	}
	public Double cargarMonedero(int cantidad) {
		if (correcto && tipoTarjeta.equals("Monedero")) {
			return saldo_diponible += cantidad;
		}
		correcto = false;
		return saldo_diponible;
	}
	public double saldoDisponible() {
		if ( tipoTarjeta.equals("Crédito") ) return saldo_diponible;
		else if ( tipoTarjeta.equals("Débito") ) return saldo_diponible;
		else if ( tipoTarjeta.equals("Monedero")) return saldo_diponible;
		return -1;
	}
	public String datosTarjeta() {
		return toString();
	}
	public boolean accesoPing( int ping ) {
		if ( ping == clave_pin ) {
			correcto = true;
		}
		return correcto;
	}



	//CONSTRUCTORES

	//Constructor por defecto
	public TARJETAS() {
		super();
	}


	//Constructor con todos los parámetros
	public TARJETAS(CUENTAS cuenta, int numero_tarjeta, int clave_pin, String clave_seguridad, Double saldo_diponible,
			Date fecha_caducidad) {
		super();
		this.cuenta = cuenta;
		this.numero_tarjeta = numero_tarjeta;
		this.clave_pin = clave_pin;
		this.clave_seguridad = clave_seguridad;
		this.saldo_diponible = saldo_diponible;
		this.fecha_caducidad = fecha_caducidad;
	}
	
	//Metodo toString
	public String toString() {
		return "TARJETAS [cuenta=" + cuenta + ", numero_tarjeta=" + numero_tarjeta + ", clave_pin=" + clave_pin
				+ ", clave_seguridad=" + clave_seguridad + ", saldo_diponible=" + saldo_diponible + ", fecha_caducidad="
				+ fecha_caducidad + ", tipoTarjeta=" + Arrays.toString(tipoTarjeta) + "]";
	}
	
	
	




}