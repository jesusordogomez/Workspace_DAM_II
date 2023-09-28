package Clases;

import java.util.ArrayList;


public interface IGrupo {
    String getNombreGrupo();
    void setNombreGrupo(String nombreGrupo);
    ArrayList<Alumnos> getListaAlumnos();
    void setListaAlumnos(IAlumnos[] listaAlumnos);
	float getNotaMedia();
}
