package paquete2;

public class ListaMultimedia {
	private Multimedia[] lista;
	private int contador;
	
	public ListaMultimedia(int tallaMaxima) {
		lista = new Multimedia[tallaMaxima];
		contador = 0;
	}
	public int talla() {
		return contador;
	}
	
	public boolean add(Multimedia m) {
		if (contador == lista.length ) {
			return false;
		} else {
			lista[contador] = m;
			contador++;
			return true;
		}
	}
	
	public Multimedia obtener(int pos) {
		if (pos >= contador) {
			return null;
		}
		return  lista[pos]  ;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < contador; i++) {
			s += lista[i].toString() + "\n";
		}
		return s;
	}
} 
