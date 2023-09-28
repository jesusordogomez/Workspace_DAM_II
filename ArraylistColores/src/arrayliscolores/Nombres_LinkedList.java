package arrayliscolores;

import java.util.LinkedList;

public class Nombres_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> nombres = new LinkedList<String>();
		nombres.add("Jose");
		nombres.add("Manuel");
		nombres.add("Jesus");
		nombres.add("Luis");
		
		for (String a: nombres) {
			System.out.println(" -- " + a);
		}
		
		System.out.println("--------------");
		nombres.addFirst("Santiago");//añade al principio
		for (String a: nombres) {
			System.out.println(" -- " + a);
		}
		
		System.out.println("--------------");
		nombres.addLast("Pablo"); //añade al final
		for (String a: nombres) {
			System.out.println(" -- " + a);
		}
		
		System.out.println("Primero; " + nombres.getFirst()); //nos dice el primer elemento
		System.out.println("Ultimo; " + nombres.getLast()); //nos dice el ultimo elemento
		nombres.removeFirst(); //elimina al primer elemento
		nombres.removeLast();  //elimina el ultimo elemento
		for (String a: nombres) {
			System.out.println(a);
		
		}

	}
				
}
