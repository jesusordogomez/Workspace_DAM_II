package Banco_PALASACA;
import java.util.Date;

public interface I_Prestamos extends I_Productos_bancarios {
	
	public double getSaldo_solicitado();
	public Date getPlazo_devolución();
	public double getIntereses_mensuales();
	public double getIntereses_anuales();
	public Date getFecha_revision();
	public Date getFecha_solicitud();
	public boolean isFinalizado();
	
	
}