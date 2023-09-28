package paquete2;


public class Multimedia {
	private String titulo;
	private String autor;
	private Formato formato;
	private double duracion;
	
	
	public Multimedia(String titulo, String autor, Formato formato, double duracion) {
		this.titulo = titulo;
		this.autor = autor;
		this.formato = formato;
		this.duracion = duracion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public Formato getFormato() {
		return formato;
	}

	public double getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "  Multimedia: [ Titulo= " + titulo + ", autor= " + autor + ", formato= " + formato + ", duracion= " + duracion + "]"
				;
	}

	public boolean equals(Multimedia m) {
		return titulo.equals(m.getTitulo()) && autor.equals(m.getAutor());
	} 
}
