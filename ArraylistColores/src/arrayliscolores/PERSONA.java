package arrayliscolores;

public class PERSONA {
	protected String NOMBRE; 
    protected String APELLIDO;
    protected String DNI;

    public PERSONA() {
        this.NOMBRE="";
        this.APELLIDO="";
        this.DNI="";
    }
    public PERSONA (String n, String a, String dni) { 
        this.NOMBRE=n; 
        this.APELLIDO=a; 
        this.DNI=dni;
    }
    
    public String toString() {
    	return this.NOMBRE + " " + this.APELLIDO +" con DNI " + this.DNI;
    }
    
}
