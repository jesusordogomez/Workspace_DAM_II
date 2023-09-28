package Banco;

public interface I_Tarjeta {
	
	public boolean Acceso (int contraseña);
	
	public String sacarDinero(int cantidad);
        
    public double CargarDinero(int cantidad);
    
    public String datosTarjeta();
        
    public double SaldoDisponible();

	Double CargarMonedero(int dinero);

	double SaldoDisponible(int dinero);

	String DatosTarjeta();

	boolean acceso(int clave);

}
