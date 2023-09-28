package paquete2;

public class MainLista {
	public static void main(String[] args) {
		ListaMultimedia lista = new ListaMultimedia(10);
		lista.add(new Pelicula("Avatar","James Cameron" ,Formato.DVD,150,"Sam Worthington ",null));
		lista.add(new Pelicula("Harry Potter","Chris Columbus ",Formato.MPG,200,"Daniel Radcliffe","Emma Watson"));
		lista.add(new Pelicula("El señor de los Anillos","Peter Jackson ",Formato.MP3,100,"Vigo Mortensen","Elijah Wood "));
		lista.add(new Disco("Motomami","Rosalia",Formato.CDAUDIO,51,Genero.POP));
		lista.add(new Disco("El Madrileño","C.Tangana",Formato.CDAUDIO,50,Genero.POP));
		lista.add(new Disco("Mi Sangre","Juanes",Formato.CDAUDIO,50,Genero.ROCK));
		System.out.println(lista.toString());
		
		
		
	}
} 
