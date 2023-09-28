package Banco_PALASACA;
import java.util.*;

public abstract class PRODUCTOS_BANCARIOS implements I_Productos_bancarios {

	//Atributos
	protected String descripcion="";
	protected Double comision;
	protected Date fecha_inicio;
	protected Date fecha_final;
	protected DATOS_PERSONALES cliente;
	protected int clave;
	protected boolean correcto;

	//Metodos ( Getter y Setter )
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public DATOS_PERSONALES getCliente() {
		return cliente;
	}
	public void setCliente(DATOS_PERSONALES cliente) {
		this.cliente = cliente;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public boolean isCorrecto() {
		return correcto;
	}
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	
	//Metodos
	public boolean acceso( int clave ) {
		if ( this.clave == clave ) {
			this.correcto = true;
		}else {
			this.correcto = false;
		}
		return this.correcto;
	}



	//CONSTRUCTORES

	//Constructor por defecto
	public PRODUCTOS_BANCARIOS() {
		super();
	}

	//Constructor con todos los parámetros
	public PRODUCTOS_BANCARIOS(String descripcion, double comision, Date fecha_inicio, Date fecha_final,
			DATOS_PERSONALES cliente, int clave) {
		super();
		this.descripcion = descripcion;
		this.comision = comision;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.cliente = cliente;

		//Controlamos si el usuario introduce una clave de 4 cifras
		try {
			String claveString = Integer.toString(clave);
			if ( claveString.length() == 4 );
		} catch (IllegalArgumentException e) {
			System.out.println("Clave incorrecta, la clave de acceso debe tener 4 cifras!!!");
		} catch (Exception e) {
			System.out.println("Clave incorrecta, la clave de acceso debe tener 4 cifras!!!");
		}
		this.clave = clave;
	}
	
	
	//Metodo toString
	public String toString() {
		return "PRODUCTOS_BANCARIOS [descripcion=" + descripcion + ", comision=" + comision + ", fecha_inicio="
				+ fecha_inicio + ", fecha_final=" + fecha_final + ", cliente=" + cliente + ", clave=" + clave
				+ ", correcto=" + correcto + "]";
	}	



}