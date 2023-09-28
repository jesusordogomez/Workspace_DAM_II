package Jerarquia_clase;

public class Directivo extends Empleado{

    public Directivo() {
    }
   
    public Directivo(String nombre) {
        super(nombre);                                                       
    }
   
    public String toString() {
        return super.toString() + " -> Directivo";
    }

}
