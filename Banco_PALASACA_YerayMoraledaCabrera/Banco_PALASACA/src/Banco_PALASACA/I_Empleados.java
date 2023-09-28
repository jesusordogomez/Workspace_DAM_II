package Banco_PALASACA;

import java.util.Date;

public interface I_Empleados extends I_Datos_personales {
	
	public Date getFecha_contratacion();
	public String getPuesto_trabajo();
	public double getSueldo();
	public double getAnyos_experiencia();
	public void ModificarEmpleados( EMPLEADOS empleados );
	public void aumentoSalarial( double porcentaje );
	public void ascenso( String nuevoPuesto, double nuevoSueldo );
	
	
}