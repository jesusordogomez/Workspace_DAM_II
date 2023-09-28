package Banco2;

public class Main {
	
	public static void main(String[] args) {

        //Creamos los objetos
        Comercial c1 = new Comercial(150, "Jesus", 31, 1300);
        Repartidor r1 = new Repartidor("zona 3", "Fernando", 22, 900);
        Comercial c2 = new Comercial(300,"antonio", 25, 100);
        //Llamamos a plus
        c1.plus();
        r1.plus();
        c2.plus();

        //Mostramos la informacion
        System.out.println(c1);
        System.out.println(r1);
        System.out.println(c2);
        
    }
}
