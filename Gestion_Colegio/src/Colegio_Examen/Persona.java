package Colegio_Examen;

class Persona {/*He decidido hacer una clase persona ya que alumno y 
	profesor tiene los mismo atributos exceptuando los que tienen propios*/

    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;
    public Persona() {}

    public Persona(String nombre, String apellidos, String dni, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) {
    	this.nombre = nombre; 
    }

    public String getApellidos() {
    	return apellidos; 
    }
    public void setApellidos(String apellidos) { 
    	this.apellidos = apellidos;
    	}

    public String getDni() { 
    	return dni; 
    	}
    public void setDni(String dni) { 
    	this.dni = dni;
    	}

    public int getEdad() {
    	return edad; 
    	}
    public void setEdad(int edad) {
    	this.edad = edad; 
    	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + "]";
	}
    
}