package examen;
import java.util.*;
public class Bonoloto {
	public static void main(String[] args) {//este main es para generar nuestra bonoloto
        // TODO Auto-generated method stub
        int num;
        Scanner leer = new Scanner (System.in);
        System.out.println("POR FAVOR, INDIQUE SU NUMERO DE APUESTA: ");
        num = leer.nextInt();
        Genera(num);//con este genera se genera las apuestas que realizamos
    }
    private static void Genera(int cont) { //en este private static generamos los numeros al azar que recorren nuestro array
        if(cont<2||cont>10) {				//ademas tambien generamos lo que es el dibujo de las apuestas
            cont=2;		//como la apuesta minima son dos y maximo 10 hago un contador para que solo se realicen apuestas entre 2 y 10
            System.out.println("Numero no valido apuesta por defecto 2");
            System.out.println(" ");
        }
        double dinero=0;
        System.out.println("--APUESTA BONOLOTO SENCILLA--");
        System.out.println("-----------------------------");
        for(int i=0;i<cont;i++) {
            int r=0;
            int tamañoarray=6;
            int bonoloto[]= new int [tamañoarray];
            bonoloto[r]=(int)(Math.random()*50);
            for(r=0;r<tamañoarray;r++) {       //para que no se repite ningun numero de nuestro array
                bonoloto[r]=(int)(Math.random()*50);
                for(int j=0; j<r ;j++) {
                    if(bonoloto[r]==bonoloto[j]) {
                        r--;
                    }
                }
        }
            imprimir(bonoloto);
            System.out.println(" ");
            dinero=dinero+0.5;
        }
        System.out.println("-----------------------------");
        System.out.println("COSTE "+ dinero+" Euros");
        System.out.println("-----------------------------");
        System.out.println("         SUERTE!!! ");
    }
    private static void imprimir(int[] bonoloto) {
        for(int i=0;i<6;i++) {
            if(i==5) {
                System.out.print(bonoloto[i]);
            }else {
                System.out.print(bonoloto[i]+" - ");
            }
        }
    }
}




