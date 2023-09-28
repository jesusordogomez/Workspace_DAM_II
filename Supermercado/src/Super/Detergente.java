package Super;

public class Detergente implements IEsLiquido, IconDescuento {
	private String marca;
	private double precio;
	private double volumen;
	private String tipoEnvase;
	private double descuento;
	
	public Detergente(String marca, double precio) {
		this.marca = marca;
		this.precio = precio;
	}
	
	
	
	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setVolumen(double v) {
		this.volumen = v;
	}

	public double getVolumen() {
		return this.volumen;
	}

	public void setTipoEnvase(String env) {
		this.tipoEnvase = env;
	}
	public String getTipoEnvase() {

		return this.tipoEnvase;
	}

	public void setDescuento(double des) {
		this.descuento = des;
	}
	public double getDescuento() {
		
		return this.descuento;
	}

	public double getPrecioDescuento() {
		
		return this.precio - (this.precio * (this.descuento/100));
	}

	public String toString() {
		return " · Detergente:  Marca= " + this.marca + ", Precio= "+ this.precio + ", volumen=" + this.volumen + ", Tipo Envase= " + this.tipoEnvase + ", Descuento= " + this.descuento +" ,Precio con descuento= "+ getPrecioDescuento() ;
	}
	
}
