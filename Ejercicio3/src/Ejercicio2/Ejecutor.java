package Ejercicio2;
import java.util.*;
public class Ejecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        Contador contador1 = new Contador();
      
        int n;
        System.out.println("Introduce valor para inicializar el contador: ");                                     
        n = sc.nextInt();
       

        contador1.setCont(n);

        contador1.Incrementar();
        System.out.println(contador1.getCont());
       
        contador1.Incrementar();
        contador1.Incrementar();

        System.out.println(contador1.getCont());

        contador1.Decrementar();

        System.out.println(contador1.getCont());

        Contador contador2 = new Contador(10);
                                           
        contador2.Incrementar();
        System.out.println(contador2.getCont());
        contador2.Decrementar();
        System.out.println(contador2.getCont());

        Contador contador3 = new Contador(contador2);
        System.out.println(contador3.getCont());
	}

}
