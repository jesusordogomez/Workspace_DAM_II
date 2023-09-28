package Banco_PALASACA;

public interface I_Débito extends I_Tarjertas {
	
	public Double sacarDineroDebito(int cantidad);
	public double getSaldo_maximo_diario();
	
	
}