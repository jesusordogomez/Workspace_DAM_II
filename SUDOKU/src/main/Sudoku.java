package main;

import numeros.Numeros;

public class Sudoku {

	public static void main(String[] args) {
		
		int intentos=0;
		int totales=0;
		
		int[][] casilla = {
				
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				
		};
		
		do {
		
		for (int i=0; i<9; i++) {
			
			for (int j=0; j<9; j++) {
				
				do {
					
				intentos++;
				
				casilla[i][j]= (int)(Math.random()*9)+1;
				
				System.out.println("\n\nNUEVO\n\n");
				
						for (int h=0; h<9; h++) {
							
							
							
							System.out.print("|");
							
							for (int k=0; k<9; k++) {
								
								System.out.print("[" + casilla[h][k] + "]");
									
								if (k==2 | k==5 | k==8) {
									
									System.out.print(" | ");
									
									if (k==8 & (h==2 | h==5 | h==8)) {
										
										System.out.println("");
										System.out.print("————————————————————————————————————");
										
									}
									
								}
								
								
								
							}
							
							System.out.println("");
							
						}
						
				System.out.println("Intento: "+intentos);
				System.out.println("Ciclos totales: "+totales);
				
				
				
				}while(!Numeros.comprobaciones(casilla[i][j], i, j, casilla, intentos));
				
				if (intentos>700) {
					
					j=9;
					i=9;
					
					for (int a=0; a<9; a++) {
						
						for (int b=0; b<9; b++) {
							
							casilla[a][b]=0;
							
						}
					}
				}
				
	}
	
}		if (intentos>700) {
		intentos=0;
		totales++;
		System.out.println("\n\nIntentos totales: "+totales);
		}
		
		}while(casilla[8][8]==0);
				
			
			
		
		
		System.out.println("\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n————————————————————————————————————");
		
		int cont_1=0;
		int cont_2=0;
		int cont_3=0;
		int cont_4=0;
		int cont_5=0;
		int cont_6=0;
		int cont_7=0;
		int cont_8=0;
		int cont_9=0;
		
		for (int i=0; i<9; i++) {
			
			System.out.print("|");
			
			for (int j=0; j<9; j++) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco>4) {
					
					System.out.print("[" + casilla[i][j] + "]");
					
				}
					
				
				else if ((i==0 & j==0) | (i==0 & j==1) | (i==0 & j==2) | 
					(i==1 & j==0) | (i==1 & j==1) | (i==1 & j==2) | 
					(i==2 & j==0) | (i==2 & j==1) | (i==2 & j==2) & (cont_1<6)& (en_blanco < 5)) {
					
					System.out.print("[ ]");
					cont_1++;
					
					}
					
					else if ((i==0 & j==3) | (i==0 & j==4) | (i==0 & j==5) | 
							(i==1 & j==3) | (i==1 & j==4) | (i==1 & j==5) | 
							(i==2 & j==3) | (i==2 & j==4) | (i==2 & j==5) & (cont_2<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_2++;
							
							}
					else if ((i==0 & j==6) | (i==0 & j==7) | (i==0 & j==8) | 
							(i==1 & j==6) | (i==1 & j==7) | (i==1 & j==8) | 
							(i==2 & j==6) | (i==2 & j==7) | (i==2 & j==8) & (cont_3<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_3++;
							
							}
					else if ((i==3 & j==0) | (i==3 & j==1) | (i==3 & j==2) | 
							(i==4 & j==0) | (i==4 & j==1) | (i==4 & j==2) | 
							(i==5 & j==0) | (i==5 & j==1) | (i==5 & j==2) & (cont_4<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_4++;
							
							}
					else if ((i==3 & j==3) | (i==3 & j==4) | (i==3 & j==5) | 
							(i==4 & j==3) | (i==4 & j==4) | (i==4 & j==5) | 
							(i==5 & j==3) | (i==5 & j==4) | (i==5 & j==5) & (cont_5<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_5++;
							
							}
					else if ((i==3 & j==6) | (i==3 & j==7) | (i==3 & j==8) | 
							(i==4 & j==6) | (i==4 & j==7) | (i==4 & j==8) | 
							(i==5 & j==6) | (i==5 & j==7) | (i==5 & j==8) & (cont_6<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_6++;
							
							}
					else if ((i==6 & j==0) | (i==6 & j==1) | (i==6 & j==2) | 
							(i==7 & j==0) | (i==7 & j==1) | (i==7 & j==2) | 
							(i==8 & j==0) | (i==8 & j==1) | (i==8 & j==2) & (cont_7<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_7++;
							
							}
					else if ((i==6 & j==3) | (i==6 & j==4) | (i==6 & j==5) | 
							(i==7 & j==3) | (i==7 & j==4) | (i==7 & j==5) | 
							(i==8 & j==3) | (i==8 & j==4) | (i==8 & j==5) & (cont_8<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_8++;
							
							}
					else if ((i==6 & j==6) | (i==6 & j==7) | (i==6 & j==8) | 
							(i==7 & j==6) | (i==7 & j==7) | (i==7 & j==8) | 
							(i==8 & j==6) | (i==8 & j==7) | (i==8 & j==8) & (cont_9<6)& (en_blanco < 5)) {
							
							System.out.print("[ ]");
							cont_9++;
					}else {
						
						System.out.print("[" + casilla[i][j] + "]");
						
					}
				
				
					
				if (j==2 | j==5 | j==8) {
					
					System.out.print(" | ");
					
					if (j==8 & (i==2 | i==5 | i==8)) {
						
						System.out.println("");
						System.out.print("————————————————————————————————————");
						
					}
					
				}
				
			}
			
			System.out.println("");
			
		}

	}

}
