package Jerarquia_clase;

public class Tecnico extends Operario{

    public Tecnico() {
    }

    public Tecnico(String nombre) {
        super(nombre);                                                           
    }
   
    public String toString() {
        return super.toString() + " -> Tecnico";
    }

}
