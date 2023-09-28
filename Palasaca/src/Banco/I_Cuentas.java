package Banco;

public interface I_Cuentas {
	public boolean Acceso  (int contraseña);
	
	public String sacarDinero(int cantidad);
        
    public double ingresarDinero(int cantidad);
        
    public double visualizarCuenta();
        
    public String datosCuenta();
           
    public TipoCuenta tipoCuenta();
        
    public double devolverIntereses(int comision);
    
}
