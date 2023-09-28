package ejercicio_Persona;
import java.util.*;

import ejercicios_fecha.Fecha;
public class Persona {
	 private String nombre;
	    private String direccion;
	    private int codigoPostal;
	    private String ciudad;
	    private Fecha fechaNacimiento;
	    
	    public Persona() {
	    	
	    }
	    public Persona(String nombre, String direccion, int codigoPostal, String ciudad, Fecha fechaNacimiento) {
	    	this.nombre= nombre;
	    	this.direccion=direccion;
	    	this.codigoPostal=codigoPostal;
	    	this.ciudad=ciudad;
	    	this.fechaNacimiento=fechaNacimiento;
	        fechaNacimiento = new Fecha();
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

	    public int getCodigoPostal() {
	        return codigoPostal;
	    }

	    public void setCodigoPostal(int codigoPostal) {
	        this.codigoPostal = codigoPostal;
	    }

	    public String getCiudad() {
	        return ciudad;
	    }

	    public void setCiudad(String ciudad) {
	        this.ciudad = ciudad;
	    }

	    public Fecha getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(Fecha fecha) {
	        fechaNacimiento.setDia(fecha.getDia());
	        fechaNacimiento.setMes(fecha.getMes());
	        fechaNacimiento.setAño(fecha.getAño());
	    }

	    public String toString() {
	    	String cadena=" ";
	    	cadena = "Nombre"+nombre + "\nFecha de Nacimiento" + String.valueOf(fechaNacimiento)+ "\nDireccion" + direccion +"\n" +String.valueOf(codigoPostal)+"\n"+ciudad;
	    	return cadena;
	    }

	    public boolean esMayorDeEdad() {
	        boolean correcto=false;
	        Fecha mayor= new Fecha(fechaNacimiento.getDia(), fechaNacimiento.getMes(), fechaNacimiento.getAño()+18);


	        Date fecha1=new Date();
	        Fecha actual= new Fecha(fecha1.getDate(), fecha1.getMonth()+1, fecha1.getYear()+1900);

	        if (actual.esMayorQue(mayor)) {
	            correcto=true;    
	            System.out.println("es mayor de edad");
	        }else {
	            System.out.println("es menor de edad");
	        }
	        return correcto;
	    }
	
}
