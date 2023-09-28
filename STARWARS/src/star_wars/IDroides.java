package star_wars;

public interface IDroides extends IPersonaje {
    
    boolean isHablar();
    
    boolean isReparar();
    
    boolean isNavegar();
    
    boolean isAndar();
    
    boolean isOperar();
    
    void setHablar(boolean hablar);
    
    void setReparar(boolean reparar);
    
    void setNavegar(boolean navegar);
    
    void setAndar(boolean andar);
    
    void setOperar(boolean operar);
    
    void navegacionEstelar();
    
    void interpretarIdiomas();
    
    void repararNave();
    
    void repararDroide();
    
    void operarHumano(Personaje humano);
    
}

