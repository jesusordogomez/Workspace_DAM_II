package Colegio_Examen;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
    private List<Aula> aulas;

    public Colegio() {
        this.aulas = new ArrayList<>();
    }

    public Colegio(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void addAula(Aula aula) {
        this.aulas.add(aula);
    }

    public void removeAula(Aula aula) {
        this.aulas.remove(aula);
    }
}
