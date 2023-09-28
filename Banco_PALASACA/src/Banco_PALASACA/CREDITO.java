package Banco_PALASACA;
import java.util.*;

public class CREDITO extends TARJETAS implements I_Credito {

	//Atributos
	protected Double saldo_disponible;
	protected Double saldo_factura;
	protected Date fecha_facturacion;
	protected Double recargo_credito;

	//Metodos ( Getter y Setters )
	public double getSaldo_disponible() {
		return saldo_disponible;
	}
	public void setSaldo_disponible(double saldo_disponible) {
		this.saldo_disponible = saldo_disponible;
	}
	public double getSaldo_factura() {
		return saldo_factura;
	}
	public void setSaldo_factura(double saldo_factura) {
		this.saldo_factura = saldo_factura;
	}
	public Date getFecha_facturacion() {
		return fecha_facturacion;
	}
	public void setFecha_facturacion(Date fecha_facturacion) {
		this.fecha_facturacion = fecha_facturacion;
	}
	public double getRecargo_credito() {
		return recargo_credito;
	}
	public void setRecargo_credito(double recargo_credito) {
		this.recargo_credito = recargo_credito;
	}


	//Metodos
	public Double sacarDineroCredito(int cantidad) {
		if ( correcto ) {
			if ( cantidad <= saldo_diponible ) {
				saldo_diponible -= cantidad;
				return saldo_diponible;
			}else {
				return saldo_diponible;
			}
		}
		return saldo_disponible;
	}
	public void creditoFinDeMes() {
		setSaldo_diponible(recargo_credito);
		getCuenta().setSaldo_disponible(getCuenta().getSaldo_disponible()-getSaldo_factura());
		setSaldo_factura(0.0);
	}
	
	
	
	//CONSTRUCTORES
	
	//Constructor por defecto
	public CREDITO() {
		super();
	}
	
	//Constructor con todos los parámetros
	public CREDITO(Double saldo_disponible, double saldo_factura, Date fecha_facturacion, double recargo_credito) {
		super();
		this.saldo_disponible = saldo_disponible;
		this.saldo_factura = 0.0;
		this.fecha_facturacion = fecha_facturacion;
		this.recargo_credito = saldo_disponible;
	}
	
	
	




}