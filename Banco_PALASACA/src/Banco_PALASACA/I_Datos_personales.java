package Banco_PALASACA;

import java.util.Date;

public interface I_Datos_personales {
	
	public String getDni();
	public String getNombre();
	public String getPrimer_apellido();
	public String getSegundo_apellido();
	public String getTelefono();
	public String getCorreo_electronico();
	public String getDireccion();
	public String getLocalidad();
	public int getCp();
	public String getProvincia();
	public Date getFecha_nac();
	public String getObervaciones();
	
	
}