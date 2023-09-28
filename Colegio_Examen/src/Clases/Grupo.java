package Clases;

import java.util.ArrayList;

public class Grupo implements IGrupo {
    
    private String nombreGrupo;
    private ArrayList<Alumnos> listaAlumnos;
    private float notaMedia;
    
    public Grupo(String nombreGrupo, ArrayList<Alumnos> alumnosGrupo1) {
        this.nombreGrupo = nombreGrupo.toUpperCase();
        this.listaAlumnos = alumnosGrupo1;
        this.notaMedia = calcularNotaMedia();
    }
    
    private float calcularNotaMedia() {
        float notaTotal = 0;
        for (IAlumnos alumno : listaAlumnos) {
            notaTotal += alumno.getNotaMedia();
        }
        return notaTotal / listaAlumnos.size();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grupo: ").append(nombreGrupo).append("\n");
        sb.append("Alumnos:\n");
        for (IAlumnos alumno : listaAlumnos) {
            sb.append(alumno.toString()).append("\n");
        }
        sb.append("Nota media: ").append(notaMedia);
        return sb.toString();
    }
    
    @Override
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    @Override
    public ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    @Override
    public float getNotaMedia() {
        return notaMedia;
    }

	@Override
	public void setNombreGrupo(String nombreGrupo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListaAlumnos(IAlumnos[] listaAlumnos) {
		// TODO Auto-generated method stub
		
	}
}