package ejercicio_Persona;
import java.util.*;

import ejercicios_fecha.Fecha;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        Scanner sc = new Scanner(System.in);

	        Persona[] persona = new Persona[3];
	        String nombre="", direccion="", ciudad="", fecha_nac="";
	        int codigo_postal;
	        for ( int i=0 ; i<persona.length; i++ ) {
	            System.out.println("Introduce el nombre de la persona " + (i+1) + ": ");
	            nombre = sc.nextLine();
	            System.out.println("Introduce la direccion de la persona " + (i+1) + ": ");
	            direccion = sc.nextLine();
	            System.out.println("Introduce la codigo postal de la persona " + (i+1) + ": ");
	            codigo_postal = sc.nextInt();
	            System.out.println("Introduce la ciudad de la persona " + (i+1) + ": ");
	            ciudad = sc.next();
	            System.out.println("Introduce la fecha de nacimiento de la persona " + (i+1));
	            fecha_nac = sc.next();
	            sc.nextLine();
	            String[] fecha = fecha_nac.split("/");
	            persona[i] = new Persona( nombre, direccion, codigo_postal, ciudad, new Fecha( Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2])) );
	        }
	        System.out.println("");
	        for ( int i=0 ; i<persona.length ; i++ ) {
	            System.out.println(persona[i]);
	            System.out.println("");
	        }
	        System.out.print("La tercera persona ");
	        persona[2].esMayorDeEdad();
	    }
	}


