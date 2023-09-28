package Banco_PALASACA;
import java.util.Date;

public interface I_Productos_bancarios {
	
	public String getDescripcion();
	public double getComision();
	public Date getFecha_inicio();
	public Date getFecha_final();
	public DATOS_PERSONALES getCliente();
	public int getClave();
	public boolean isCorrecto();
	
	
}