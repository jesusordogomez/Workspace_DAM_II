package ejercicios1;

import java.util.Scanner;

public class Bisiesto {
		public static void main(String[] args) {

		Scanner teclado=new Scanner(System.in);
		int dia,mes,year,falta,x=0,d=0;

		System.out.print("Ingresa el dia: ");
		dia=teclado.nextInt();
		System.out.print("Ingresa el mes: ");
		mes=teclado.nextInt();
		System.out.print("Ingresa el año: ");
		year=teclado.nextInt();

		if((year%4==0)&&!(year%100==0&&year%400!=0))
		{x=29;}
		else
		{x=28;} 
		 
		switch(mes)
		{ 
		 case 1:d=0;
		 break;

		 case 2:d=31;
		 break;

		 case 3:d=31+x;
		 break;

		 case 4:d=31+x+31;
		 break;

		 case 5:d=31+x+31+30;
		 break;

		 case 6:d=31+x+31+30+31;
		 break;

		 case 7:d=31+x+31+30+31+30; 
		 break;

		 case 8:d=31+x+31+30+31+30+31;
		 break;

		 case 9:d=31+x+31+30+31+30+31+31;
		 break;

		 case 10:d=31+x+31+30+31+30+31+31+30; 
		 break;

		 case 11:d=31+x+31+30+31+30+31+31+30+31;
		 break;

		 case 12:d=31+x+31+30+31+30+31+31+30+31+30; 
		 break;
		} 
		 falta=((337+x)-(dia+d)); 
		 System.out.println("\nLa fecha actual es: "+dia+"/"+mes+"/"+year+" y faltan "+falta+" dias para finalizar el año.");

		   }

		
	}

