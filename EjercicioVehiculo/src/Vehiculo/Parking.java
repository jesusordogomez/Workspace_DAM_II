package Vehiculo;
import java.util.Arrays;
public class Parking {
	private String nombre;
	private int capacidad;
	private int[] horasApertura = {6, 12, 18, 24};
	private int plazasOcupadas = 0;

	public Parking() {
		
	}
	
	public Parking(String nombre, int capacidad) {
	this.nombre = nombre;
	this.capacidad = capacidad;
	}

	public boolean libre() {
	return plazasOcupadas < capacidad;
	}

	public int disponibles() {
	return capacidad - plazasOcupadas;
	}

	public void ocuparPlaza() {
	plazasOcupadas++;
	System.out.println("Se ha ocupado una plaza en el " + nombre + ", quedan = "+(this.capacidad-this.plazasOcupadas)+" plazas libres");
	}

	public void liberarPlaza() {
	plazasOcupadas--;
	}

	@Override
	public String toString() {
	return "Parking [ Nombre=" + nombre + ", capacidad=" + capacidad + ", horas apertura="
	+ Arrays.toString(horasApertura) + ", plazas ocupadas=" + plazasOcupadas + " ]";
	}

}
