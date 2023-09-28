package Banco_PALASACA;

public class Clientes extends DatosPersonales {
	
	private String SituacionLaboral;

	public Clientes(String dni, String nombre, String apellido, String telefono, String correo, String dP,
			String localidad, int cP, String provincia, String fechaN, String observaciones, String situacionLaboral) {
		super(dni, nombre, apellido, telefono, correo, dP, localidad, cP, provincia, fechaN, observaciones);
		SituacionLaboral = situacionLaboral;
	}

	public String getSituacionLaboral() {
		return SituacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		SituacionLaboral = situacionLaboral;
	}

	
	
	
	
	
}
