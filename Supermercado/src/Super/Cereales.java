package Super;

import java.time.LocalDate;

public class Cereales implements IesAlimento{
	private String Marca;
	private double precio;
	private String TipoCereal;
	private LocalDate caducidad;
	
	public Cereales(String marca, double precio, String tipoCereal) {
		this.Marca = marca;
		this.precio = precio;
		this.TipoCereal= tipoCereal;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		this.Marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipoCereal() {
		return TipoCereal;
	}

	public void setTipoCereal(String tipoCereal) {
		TipoCereal = tipoCereal;
	}

	public void setCaducidad(LocalDate fc) {
		this.caducidad =fc;
	}

	public LocalDate getCaducidad() {

		return this.caducidad;
	}

	public int getCalorias() {
		if(TipoCereal.equalsIgnoreCase("espelta")) {
			return 5 ;
		}else if(TipoCereal.equalsIgnoreCase("Maiz")) {
			return 8;
		} else if(TipoCereal.equalsIgnoreCase("Trigo")) {
			return 12;
		} else {
			return 15;
		}
		
	}

	public String toString() {
		return " · Cereales:   Marca= " + this.Marca + " , Precio= " + this.precio  + " ,Tipo de Cereal= " + this.TipoCereal + " , Fecha de Caducidad= " + this.caducidad + " , calorias="+ getCalorias();

	}
	
}
