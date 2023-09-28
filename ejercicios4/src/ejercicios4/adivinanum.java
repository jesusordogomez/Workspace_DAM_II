package ejercicios4;
import java.util.Scanner;
public class adivinanum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 28;
		 int b; 
		 int i; 
		 System.out.println(" Hola Ana, Bienvenida!! ");
		 System.out.println("");
		 System.out.println(" Primero, MUCHISIMAS FELICIDADES!!!");
		 System.out.println("  ");
		 System.out.println(" Ahora para encontrar tu primer regalo tienes que adivinar un numero entre el 1 y el 30 ");
		 
		 System.out.println(" Si aciertas, te llevaras tu primer regalo, sino....GAME OVER ");
		 System.out.println(" Vas a tener 5 intentos, adelante!! ");
		 Scanner leer = new Scanner(System.in);
		 b = leer.nextInt();
		 for (i=0; i<=4; i++) { 
		    if (a == b) {  
		      System.out.println("Has acertado! el numero era: " +a); 
		  	System.out.println(" ________________________________________");
		  	System.out.println("|                                        |");
		  	System.out.println("|                                        |");
		  	System.out.println("|          -----26 FEBRERO----           |");
		  	System.out.println("|                                        |");
		  	System.out.println("| ---------- FALLA EN SEVILLA ---------  |");
		  	System.out.println("|                                        |");
		  	System.out.println("|                 FIBES                  |");
		  	System.out.println("|                                        |");
		  	System.out.println("|    PARAISO                             |");
		  	System.out.println("|    FILA 15                             |");
		  	System.out.println("|    BUTACAS 2 Y 4                       |");
		  	System.out.println("|________________________________________|");
		  	
		  	System.out.print("");
		
		      break; } 
		    else if (i == 4) { 
		      System.out.println("has fallado! el numero era : " + a); 
		      break; }  
		    else if (a > b) 
		      System.out.println("El número que tienes que adivinar es mayor que " + b);
		    else if (a < b)
		      System.out.println("El número que tienes que adivinar es menor que " + b); 
		    if (i <=1) { 
		     System.out.print("Otro intento: "); 
			 Scanner leer1 = new Scanner(System.in);
			 b = leer.nextInt(); } 
		    else if (i ==2) { 
		    System.out.print("Intentalo de nuevo: ");
			 Scanner leer3 = new Scanner(System.in);
			 b = leer.nextInt();} 
		   else if (i >= 3) {
		   System.out.print(" Ultimo intento: ");
			 Scanner leer4 = new Scanner(System.in);
			 b = leer.nextInt(); }
		    }

	}
	
}
