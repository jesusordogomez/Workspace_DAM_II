package Banco_PALASACA;

public class DÉBITO extends TARJETAS implements I_Débito  {
	
	//Atributos
	protected Double saldo_maximo_diario;
	
	//Metodos ( Getter y Setter )
	public double getSaldo_maximo_diario() {
		return saldo_maximo_diario;
	}
	public void setSaldo_maximo_diario(Double saldo_maximo_diario) {
		this.saldo_maximo_diario = saldo_maximo_diario;
	}
	
	
	//Metodos
	public Double sacarDineroDebito(int cantidad) {
		if ( correcto ) {
			if ( cantidad <=  saldo_maximo_diario ) {
				saldo_maximo_diario -= cantidad;
				return saldo_maximo_diario;
			}else {
				return saldo_maximo_diario;
			}
		}
		return saldo_maximo_diario;
	}
	
	
}