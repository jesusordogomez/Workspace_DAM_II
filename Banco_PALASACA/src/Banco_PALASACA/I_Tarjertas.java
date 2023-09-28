package Banco_PALASACA;

import java.util.Date;

public interface I_Tarjertas extends I_Productos_bancarios {
	
	//METODOS
	public boolean acceso(int clave);
	public Double sacarDinero(int cantidad);
	public Double cargarMonedero(int cantidad);
	public double saldoDisponible();
	public String datosTarjeta();
	public CUENTAS getCuenta();
	public int getNumero_tarjeta();
	public int getClave_pin();
	public String getClave_seguridad();
	public double getSaldo_diponible();
	public Date getFecha_caducidad();
	
	
}