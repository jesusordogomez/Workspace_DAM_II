package Almacen;

public class Proveedor {
	public int codigo;
	public String nombre;
	public String direccion;
	public String fAlta;
	public String correoE;
	public String telefono;
	
	
	public Proveedor(int codigo, String nombre, String direccion, String fAlta, String correoE, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fAlta = fAlta;
		this.correoE = correoE;
		this.telefono = telefono;
	}


	public Proveedor() {
	
	}

	@Override
	public String toString() {
		return "Proveedor [codigo=" + getCodigo() + ", nombre=" + getNombre() + ", direccion=" + getDireccion() + ", fAlta=" + getfAlta()
				+ ", correoE=" + getCorreoE() + ", telefono=" + getTelefono() + "]";
	}




	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getfAlta() {
		return fAlta;
	}


	public void setfAlta(String fAlta) {
		this.fAlta = fAlta;
	}


	public String getCorreoE() {
		return correoE;
	}


	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
