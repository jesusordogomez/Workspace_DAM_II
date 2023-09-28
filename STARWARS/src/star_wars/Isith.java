package star_wars;

public interface ISith extends IPersonaje {
    // Atributos propios de la clase Sith
    String SABLE_POR_DEFECTO = "rojo";
    String AFILIACION_IMPERIO = "Imperio Galáctico";
    String AFILIACION_SITH = "Orden Sith";
    String AFILIACION_OTRA = "Otro";
    
    // Métodos propios de la clase Sith
    String getSable();
    void setSable(String sable);
    boolean isConSable();
    void setConSable(boolean conSable);
    String getAfiliacion();
    void setAfiliacion(String afiliacion);
    void soyTuPadre();
}
