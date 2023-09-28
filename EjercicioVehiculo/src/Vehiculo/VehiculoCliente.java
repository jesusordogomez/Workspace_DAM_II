package Vehiculo;

public class VehiculoCliente implements I_Vehiculo {
	private final String matricula;
	private int tiempo;
	private final double precio_dia = 25.0;
	private final double precio_hora = 1.2;

	public VehiculoCliente(String matricula) {
	this.matricula = matricula;
	this.tiempo = 0;
	}

	public void setTiempo(int tiempo) {
	this.tiempo = tiempo;
	}

	public double factura() {
	int dias = tiempo / 1440;
	int horas = (tiempo % 1440) / 60;
	return dias * precio_dia + horas * precio_hora;
	}

	public boolean hayPlaza(Parking parking) {
	return parking.libre();
	}

	public void aparca(Parking parking) {
	parking.ocuparPlaza();
	}

	@Override
	public String toString() {
	return "Vehiculo [ Matricula = " + matricula + ", tiempo en el parking = " + tiempo + " min" + ", precio dia completo = " + precio_dia
	+ ", precio/horas = " + precio_hora + "]";
	}
}
