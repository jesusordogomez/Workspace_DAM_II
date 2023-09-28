package star_wars;

public class Droides extends Personaje implements IDroides {
    private boolean hablar;
    private boolean reparar;
    private boolean navegar;
    private boolean andar;
    private boolean operar;

    public Droides(String alias, String nombre, String raza, char sexo, double estatura, double peso, 
                   String colorOjos, String colorPelo, String ocupacion, String nacionalidad, boolean hablar, 
                   boolean reparar, boolean navegar, boolean andar, boolean operar) {
        super(alias, nombre, raza, sexo, estatura, peso, colorOjos, colorPelo, ocupacion, nacionalidad);
        this.hablar = hablar;
        this.reparar = reparar;
        this.navegar = navegar;
        this.andar = andar;
        this.operar = operar;
    }

    public boolean isHablar() {
        return hablar;
    }

    public void setHablar(boolean hablar) {
        this.hablar = hablar;
    }

    public boolean isReparar() {
        return reparar;
    }

    public void setReparar(boolean reparar) {
        this.reparar = reparar;
    }

    public boolean isNavegar() {
        return navegar;
    }

    public void setNavegar(boolean navegar) {
        this.navegar = navegar;
    }

    public boolean isAndar() {
        return andar;
    }

    public void setAndar(boolean andar) {
        this.andar = andar;
    }

    public boolean isOperar() {
        return operar;
    }

    public void setOperar(boolean operar) {
        this.operar = operar;
    }

    @Override
    public void navegacionEstelar() {
        if (navegar) {
            System.out.println("Iniciando navegación estelar...");
        } else {
            System.out.println("No es posible iniciar la navegación estelar, el droide no tiene esta habilidad.");
        }
    }

    @Override
    public void interpretarIdiomas() {
        if (hablar) {
            System.out.println("Interpretando idiomas...");
        } else {
            System.out.println("No es posible interpretar idiomas, el droide no tiene esta habilidad.");
        }
    }

    @Override
    public void repararNave() {
        if (reparar) {
            System.out.println("Reparando nave...");
        } else {
            System.out.println("No es posible reparar la nave, el droide no tiene esta habilidad.");
        }
    }

    @Override
    public void repararDroide() {
        if (reparar) {
            System.out.println("Reparando droide...");
        } else {
            System.out.println("No es posible reparar el droide, el droide no tiene esta habilidad.");
        }
    }

    @Override
    public void operarHumano(Personaje humano) {
        if (operar) {
            System.out.println("Operando humano " + humano.getNombre() + "...");
        } else {
            System.out.println("No es posible operar al humano, el droide no tiene esta habilidad.");
        }
    }

    @Override
    public boolean Compare(Object obj) {
        if (!(obj instanceof Droides)) {
            return false;
        }
        Droides d = (Droides) obj;
        return super.Compare(obj) && hablar == d.hablar
        		&& reparar == d.reparar && navegar == d.navegar && andar == d.andar && operar == d.operar;
    }
    @Override
    public String toString() {
        return super.toString() +
               "Hablar: " + hablar + "\n" +
               "Reparar: " + reparar + "\n" +
               "Navegar: " + navegar + "\n" +
               "Andar: " + andar + "\n" +
               "Operar: " + operar + "\n";
    }
}

