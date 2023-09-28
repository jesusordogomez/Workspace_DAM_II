package Vehiculo;

import Vehiculo.Parking;

public interface I_Vehiculo {
	public double factura();
    public boolean hayPlaza(Parking parking);
    public void aparca(Parking parking);
    public void setTiempo(int tiempo);
}

