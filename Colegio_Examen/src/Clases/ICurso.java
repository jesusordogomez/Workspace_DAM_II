package Clases;

import java.util.List;

public interface ICurso {
    String getNombreCurso();
    void setNombreCurso(String nombreCurso);
    List<IGrupo> getListaGrupos();
    void setListaGrupos(IGrupo[] listaGrupos);
    float getNotaMedia();
}
