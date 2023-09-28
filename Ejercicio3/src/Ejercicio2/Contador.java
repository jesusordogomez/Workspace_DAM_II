package Ejercicio2;

public class Contador {

	private int cont;
	
	public Contador() {		
	}
	
	public Contador(int cont) {
		if(cont<0) {
			cont=0;
		}
	}
	
	public Contador(Contador cont) {
		this.cont= cont.cont;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void Incrementar() {
		cont++;	
	}
	
	public void Decrementar () {
		cont--;
		if (cont <0) {
			cont = 0;
			}
	}
	
}
