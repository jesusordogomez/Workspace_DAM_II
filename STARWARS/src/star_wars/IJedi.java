package star_wars;

public interface IJedi extends IPersonaje {
    String SABLE_DEFECTO = "azul";
    String AFILIACION_JEDI = "Jedi";
    
    String getSable();
    void setSable(String sable);
    
    String getAfiliacion();
    void setAfiliacion(String afiliacion);
    
    String getTitulo();
    void setTitulo(String titulo);
	void soyUnJedi();
}

