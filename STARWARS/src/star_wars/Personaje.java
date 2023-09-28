package star_wars;

public class Personaje implements IPersonaje {
    private String alias;
    private String nombre;
    private String raza;
    private char sexo;
    private double estatura;
    private double peso;
    private String colorOjos;
    private String colorPelo;
    private String ocupacion;
    private String nacionalidad;


    public Personaje(String alias, String nombre, String raza, char sexo, double estatura, double peso,
                     String colorOjos, String colorPelo, String ocupacion, String nacionalidad) {
        this.alias = alias;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
        this.colorOjos = colorOjos;
        this.colorPelo = colorPelo;
        this.ocupacion = ocupacion;
        this.nacionalidad = nacionalidad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'H' || sexo == 'M' || sexo == 'D' || sexo == 'X') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("El valor del sexo debe ser H, M, D o X.");
        }
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public void presentarse() {
        System.out.println("Hola, soy " + this.alias + ". Soy " + this.raza + " y mi nacionalidad es " + this.nacionalidad + ".");
    }
    
	public boolean Compare(Object obj) {
		return false;
	}
    public void Hablar() {
        switch (this.raza) {
            case IPersonaje.HUMAN:
                System.out.println("May the Force be with you.");
                break;
            case IPersonaje.CYBORG:
                System.out.println("Resistance is futile.");
                break;
            case IPersonaje.YODA:
                System.out.println("Patience you must have my young padawan.");
                break;
            case IPersonaje.DROIDE:
                System.out.println("Beep boop beep.");
                break;
            case IPersonaje.WOOKIE:
                System.out.println("Rrrrrrr-ghghghghgh!");
                break;
            case IPersonaje.GUNGAN:
                System.out.println("Meesa Jar Jar Binks.");
                break;
            case IPersonaje.DARTHOMIRIAN:
                System.out.println("The dark side of the Force is a pathway to many abilities some consider to be unnatural.");
                break;
            default:
                System.out.println("I don't know how to speak.");
                break;
        }
        
    }

	@Override
	public int getEdad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEdad(int edad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAfiliacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAfiliacion(String afiliacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hablar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void luchar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pilotar() {
		// TODO Auto-generated method stub
	}
	}