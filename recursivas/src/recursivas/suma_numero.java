package recursivas;

import java.util.Scanner;

public class suma_numero {

	public static void main(String[] args) {
			Scanner leer = new Scanner(System.in);
	        System.out.print("Introduce un número: ");
	        int n= leer.nextInt();
	        //guardamos el resultado en una variable
	        int resultado=sumaRecursiva(n);
	        //Mostramos el resultado
	        System.out.println(resultado);
	         
	    }
	     
	    public static int sumaRecursiva(int numero){
	         
	        int res;
	         
	        if(numero==1){
	            //Se termina la recursion
	            return 1;
	        }else{
	            //Se llama a si misma la función con el parametro numero menos 1
	            res = numero+sumaRecursiva(numero-1);
	        }
	         
	        //Devuelve el resultado
	        return res;
	}

}
