package Ejercicios;

public class NIF {

	 private int dni;
	    private char letra;

	    //Constructores
	    public Nif() {
	    }

	    public Nif(int dni) {
	        this.dni = dni;
	        letra = calcularLetra();
	    }

	    //Método para calcular la letra del NIF
	    private char calcularLetra() {
	        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
	                                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};                      
	        return letras[dni % 23];
	    }

	
}
