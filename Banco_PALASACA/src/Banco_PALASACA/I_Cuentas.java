package Banco_PALASACA;

public interface I_Cuentas extends I_Productos_bancarios {
	
	public boolean acceso(int clave);
	public double sacarDinero(int cantidad);
	public double ingresarDinero(int cantidad);
	public double visualizarCuenta();
	public String datosCuenta();
	public TiposCuenta tipoCuenta();
	public Double devolverIntereses();
	public int getIban();
	public double getSaldo_disponible();
	public double getComision();
	
	
}