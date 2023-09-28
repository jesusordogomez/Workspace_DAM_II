package star_wars;

public class Main {

	public static void main(String[] args) {
	    // Crear un Jedi
	    Jedi jedi = new Jedi("Luke", "Luke Skywalker", 'M', 1.75, 77.0,
	        "Azules", "Rubio", "Jedi", "Tatooine", "Verde", "Jedi", "Maestro");

	    // Crear un droide
	    Droides droide = new Droides("R2", "R2-D2", "Droide", 'N', 1.09, 32.0,
	        "Negros", "Blanco y Azul", "Astromecánico", "Naboo", true, true, true, true, true);

	    // Crear un humano
	    Personaje humano = new Personaje("Han", "Han Solo", "Humano", 'M', 1.8, 80.0,
	        "Marrones", "Negro", "Contrabandista", "Corellia");

	    // Imprimir la información de los personajes
	    System.out.println(jedi.toString());
	    System.out.println(droide.toString());
	    System.out.println(humano.toString());

	    // Realizar algunas operaciones con los personajes
	    jedi.luchar();
	    jedi.usarLaFuerza();
	    droide.navegacionEstelar();
	    droide.interpretarIdiomas();
	    droide.repararNave();
	    droide.repararDroide();
	    droide.operarHumano(humano);
	}
}


