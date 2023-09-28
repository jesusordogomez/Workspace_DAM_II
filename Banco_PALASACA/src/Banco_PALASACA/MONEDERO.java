package Banco_PALASACA;

public class MONEDERO extends TARJETAS implements I_Monedero {
	
	//Atributos
	protected Double saldo_monedero;
	
	//Metodos ( Getter y Setter )
	public double getSaldo_monedero() {
		return saldo_monedero;
	}
	public void setSaldo_monedero(Double saldo_monedero) {
		this.saldo_monedero = saldo_monedero;
	}
	
	
	//Metodos
	public Double sacarDineroMonedero(int cantidad) {
		if ( correcto ) {
			if ( cantidad <= saldo_monedero && saldo_monedero >= cantidad ) {
				saldo_monedero -= cantidad;
				return saldo_monedero;
			}else {
				return saldo_monedero;
			}
		}
		return saldo_monedero;
	}
	
	
	//CONSTRUCTORES
	
	//Constructor por defecto
	public MONEDERO() {
		super();
	}
	
	//Constructor con el parámetro
	public MONEDERO(int clave, Double saldo_monedero) {
		super();
		this.clave = clave;
		this.saldo_monedero = saldo_monedero;
	}
	
	//Metodo toString
	public String toString() {
		return "MONEDERO [saldo_monedero=" + saldo_monedero + "]";
	}
	
	
	
	
}