package star_wars;

import java.util.Objects;

public class Sith extends Personaje implements ISith {

    private String sable;
    private boolean conSable;
    private String afiliacion;

    public Sith(String alias, String nombre, String raza, char sexo, double estatura, double peso,
                String colorOjos, String colorPelo, String ocupacion, String nacionalidad, String sable,
                boolean conSable, String afiliacion) {
        super(alias, nombre, raza, sexo, estatura, peso, colorOjos, colorPelo, ocupacion, nacionalidad);
        this.sable = sable;
        this.conSable = conSable;
        this.afiliacion = afiliacion;
    }

    // Implementación de los métodos de ISith

    @Override
    public void soyTuPadre() {
        System.out.println("Yo soy tu padre...");
    }

    // Métodos consultores y modificadores de los atributos de Sith

    public String getSable() {
        return sable;
    }

    public void setSable(String sable) {
        this.sable = sable;
    }

    public boolean isConSable() {
        return conSable;
    }

    public void setConSable(boolean conSable) {
        this.conSable = conSable;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    // Redefinición de los métodos Compare y toString

    @Override
    public boolean Compare(Object obj) {
        if (obj instanceof Sith) {
            Sith sith = (Sith) obj;
            return super.Compare(sith) &&
                    Objects.equals(this.sable, sith.sable) &&
                    this.conSable == sith.conSable &&
                    Objects.equals(this.afiliacion, sith.afiliacion);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSable: " + sable +
                "\nCon sable: " + conSable +
                "\nAfiliación: " + afiliacion;
    }
}
