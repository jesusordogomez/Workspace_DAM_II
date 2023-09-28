package Banco_PALASACA;
import java.util.Date;

public interface I_Credito extends I_Tarjertas {
	
	public Double sacarDineroCredito(int cantidad);
	public double getSaldo_disponible();
	public double getSaldo_factura();
	public Date getFecha_facturacion();
	public double getRecargo_credito();
	
	
}