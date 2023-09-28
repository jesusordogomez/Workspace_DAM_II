package Super;

import java.time.LocalDate;

public class Vino implements IEsLiquido,IesAlimento,IconDescuento {
	
	private String Marca;
	private String TipoVino;
	private int GradosAlcohol;
	private double Precio;
	private double Volumen;
	private String TipoEnvase;
	private LocalDate FechaCaducidad;
	private double Descuento;
	
	
	public Vino(String marca, String tipoVino, int gradosAlcohol, double precio) {

		this.Marca = marca;
		this.TipoVino = tipoVino;
		this.GradosAlcohol = gradosAlcohol;
		this.Precio = precio;
		
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getTipoVino() {
		return TipoVino;
	}

	public void setTipoVino(String tipoVino) {
		TipoVino = tipoVino;
	}

	public double getGradosAlcohol() {
		return GradosAlcohol;
	}

	public void setGradosAlcohol(int gradosAlcohol) {
		GradosAlcohol = gradosAlcohol;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public void setVolumen(double v) {
		this.Volumen = v;
		
	}

	public double getVolumen() {

		return this.Volumen;
	}

	public void setTipoEnvase(String env) {
		this.TipoEnvase = env;
		
	}

	public String getTipoEnvase() {

		return this.TipoEnvase;
	}


	public void setDescuento(double des) {
		this.Descuento = des;
		
	}

	public double getDescuento() {

		return this.Descuento;
	}

	public double getPrecioDescuento() {

		return this.Precio - (this.Precio *(this.Descuento/100));
	}

	public void setCaducidad(LocalDate fc) {
		this.FechaCaducidad = fc;
		
	}

	public LocalDate getCaducidad() {

		return this.FechaCaducidad;
	}


	public int getCalorias() {
		return this.GradosAlcohol*10;
	}

	public String toString() {
		return " · Vino:   Marca= " + Marca + " , TipoVino=" + TipoVino + 
				" , GradosAlcohol= " + GradosAlcohol + " , Precio= "+ Precio + " , Volumen= "
				+ Volumen + " , TipoEnvase=" + TipoEnvase + " , FechaCaducidad= " + FechaCaducidad
				+ " , Descuento= " + this.Descuento + "%" + " , Precio con descuento= " + getPrecioDescuento() +
				" , Calorias= "+getCalorias();
	}
	
	

}
