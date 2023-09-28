package paquete2;

public class Pelicula extends Multimedia {
	private String actorPrincipal;
	private String actrizPrincipal;
	
	public Pelicula(String titulo, String autor,Formato formato, double duracion,String actor, String actriz) {
		super(titulo, autor, formato, duracion);
		actorPrincipal = actor;
		actrizPrincipal = actriz;
	}
	
	public String getActorPrincipal() {
		return actorPrincipal;
	}
	
	public String getActrizPrincipal() {
		return actrizPrincipal;
	}

	@Override
	public String toString() {
		String s = "    · Protagonizada por: ";
		if (actrizPrincipal != null) {
			s += actrizPrincipal;
			if (actorPrincipal != null) {
				s += " y " + actorPrincipal;
			}
		} else {
			if (actorPrincipal != null) {
				s += actorPrincipal;
			} else {
				s += "No hay actor";
			}

		}

		return super.toString() + s;
	}
} 
