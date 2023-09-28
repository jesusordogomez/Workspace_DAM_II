package star_wars;

public interface IPersonaje {
    
    // Métodos get y set de los atributos del Personaje
    public String getNombre();
    public void setNombre(String nombre);
    public int getEdad();
    public void setEdad(int edad);
    public String getRaza();
    public void setRaza(String raza);
    public String getNacionalidad();
    public void setNacionalidad(String nacionalidad);
    public String getAfiliacion();
    public void setAfiliacion(String afiliacion);
	boolean Compare(Object obj);
	
	
    
    // Método Presentarse
    public void presentarse();
    
    // Método Hablar
    public void hablar();
    
    // Método Morir
    public void morir();
    
    // Método Luchar
    public void luchar();
    
    // Método Disparar
    public void disparar();
    
    // Método Pilotar
    public void pilotar();
    
    // Constantes
    public static final String HUMAN = "Human";
    public static final String CYBORG = "Cyborg";
    public static final String YODA = "Yoda";
    public static final String DROIDE = "Droide";
    public static final String WOOKIE = "Wookie";
    public static final String GUNGAN = "Gungan";
    public static final String DARTHOMIRIAN = "Darthomirian";
    public static final String DESCONOCIDO = "Desconocido";
    
    public static final String CORUSCANT = "Coruscant";
    public static final String ENDOR = "Endor";
    public static final String GEONOSIS = "Geonosis";
    public static final String HOTH = "Hoth";
    public static final String KAMINO = "Kamino";
    public static final String KASKYYYK = "Kaskyyyk";
    public static final String NABOO = "Naboo";
    public static final String TATOOINE = "Tatooine";
    public static final String CORELLIA = "Corellia";
    
    public static final String IMPERIO_GALACTICO = "Imperio Galáctico";
    public static final String REPUBLICA = "República";
    public static final String LEGION_501 = "Legión 501";
    public static final String ESCUADRON_DE_LA_MUERTE = "Escuadrón de la Muerte";

    
}
