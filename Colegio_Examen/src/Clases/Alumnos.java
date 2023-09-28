package Clases;

public class Alumnos implements IAlumnos{
	private String nombreApellidos;
    private String grupo;
    private float notaMedia;


	public Alumnos(String nombreApellidos, String grupo, float notaMedia) {
        setNombreApellidos(nombreApellidos);
        setGrupo(grupo);
        setNotaMedia(notaMedia);
    }

    @Override
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    @Override
    public void setNombreApellidos(String nombreApellidos) {
        // Convertir la primera letra de cada palabra a mayúscula y el resto a minúscula
        this.nombreApellidos = nombreApellidos.substring(0,1).toUpperCase() + nombreApellidos.substring(1).toLowerCase();
    }

    @Override
    public String getGrupo() {
        return grupo;
    }

    @Override
    public void setGrupo(String grupo) {
        // Convertir a mayúsculas y validar formato
        if (!grupo.matches("\\d-\\p{Upper}{3}-\\p{Upper}")) {
            throw new IllegalArgumentException("Formato de grupo inválido");
        }
        this.grupo = grupo.toUpperCase();
    }

    @Override
    public float getNotaMedia() {
        return notaMedia;
    }

    @Override
    public void setNotaMedia(float notaMedia) {
        if (notaMedia < 0) {
            throw new IllegalArgumentException("La nota media no puede ser negativa");
        }
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return nombreApellidos + ", " + notaMedia;
    }
}
