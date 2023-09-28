package paquete2;

public class Disco extends Multimedia {
	private Genero genero;
	
	public Disco(String titulo, String autor,Formato formato, double duracion,Genero genero) {
		super(titulo, autor, formato, duracion);
		this.genero = genero;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public String toString() {
		return super.toString() + "  ·  Genero: " + genero; 
	}
} 
