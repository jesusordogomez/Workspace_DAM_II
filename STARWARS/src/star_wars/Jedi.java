package star_wars;

public class Jedi extends Personaje implements IJedi {

    private String sable;
    private String afiliacion;
    private String titulo;

    public Jedi(String nombre, String raza, char sexo, double estatura, double peso, 
                String colorOjos, String colorPelo, String ocupacion, String nacionalidad, 
                String sable, String afiliacion, String titulo) {
        super(nombre, raza, titulo, sexo, estatura, peso, colorOjos, colorPelo, ocupacion, nacionalidad);
        this.sable = sable;
        this.afiliacion = afiliacion;
        this.titulo = titulo;
    }

    public String getSable() {
        return sable;
    }

    public void setSable(String sable) {
        this.sable = sable;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void soyUnJedi() {
        System.out.println("Soy un Jedi, guardián de la paz en la galaxia.");
    }

    @Override
    public boolean Compare(Object obj) {
        if (obj instanceof Jedi) {
            Jedi other = (Jedi) obj;
            return super.Compare(obj) && this.sable.equals(other.sable) 
                    && this.afiliacion.equals(other.afiliacion) && this.titulo.equals(other.titulo);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSable: " + this.sable 
                + "\nAfiliación: " + this.afiliacion + "\nTítulo: " + this.titulo;
    }

	public void usarLaFuerza() {
		// TODO Auto-generated method stub
		
	}

}