package Ejercicio;

import java.util.Random;

public class Vehiculo {
	protected int idVehiculo;
	protected String tipo;
	
	public Vehiculo(int id, String tipo) {
		this.idVehiculo = id;
		this.tipo = tipo;		
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Vehiculo [ idVehiculo: " + idVehiculo + ", tipo: " + tipo + " ]";
	}



}
