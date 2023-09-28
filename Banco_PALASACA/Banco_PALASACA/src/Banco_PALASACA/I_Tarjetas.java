package Banco_PALASACA;

public interface I_Tarjetas {
	
	public boolean Acceso (int contraseña);
	
	public String sacarDinero(int cantidad);
        
    public double CargarDinero(int cantidad);
    
    public String datosTarjeta();
        
    public double SaldoDisponible();
        
    
           
    
	
}
