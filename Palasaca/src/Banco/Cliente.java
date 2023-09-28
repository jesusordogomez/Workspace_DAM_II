package Banco;

public class Cliente extends DatosPersonales{
	public Cliente(String dNI, String nombre, String apeilldo, String telefono, String correo, String direccionPostal,
			String localidad, int codigoPostal, String provincia, String fechaNacimiento, String observaciones) {
		super(dNI, nombre, apeilldo, telefono, correo, direccionPostal, localidad, codigoPostal, provincia, fechaNacimiento,
				observaciones);
	}

	private String situacionLaboral;



	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}	
}
