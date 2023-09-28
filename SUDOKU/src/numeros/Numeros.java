package numeros;

public class Numeros {
	
	public static int valor (int num, int lin, int colum, int[][] casilla) {
	
	num=(int)(Math.random()*9)+1;
	//if linea & columna & casilla
	
		return num;
	
	
	}
	//else
	//return Numeros.valor(valor);
			
		     
	
	
	public static boolean comprobaciones (int num, int lin, int colum, int[][] casilla, int tries) {
		
		if (tries>700) return true;
		
		return Numeros.columna(num, colum, casilla) & Numeros.fila(num, lin, casilla) & Numeros.cuadrante(num, lin, colum, casilla);
		
	}
			
	
	public static boolean fila (int num, int lin, int[][] casilla) {
		
		int cont=0;
		
		for (int i=0; i<9; i++) {
		
			if (casilla[lin][i]==num){
				
				cont++;
				
			}
			
		}	
		
		if (cont>1) {
			
			return false;
			
		} else {
		
		return true;
			
		}
		
	}
		
	
		
	
	
public static boolean columna (int num, int colum, int[][] casilla) {
		
		int cont=0;
		
		for (int i=0; i<9; i++) {
		
			if (casilla[i][colum]==num){
				
				cont++;
				
			}
			
		}	
		
		if (cont>1) {
			
			return false;
			
		} else {
		
		return true;
			
		}
		
	}
	

		
	
public static boolean cuadrante (int num, int lin, int colum, int[][] casilla) {
	
	int cont=0;
	  int localBoxRow = lin - lin % 3;
	    int localBoxColumn = colum - colum % 3;
	    
	    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
	      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
	        if (casilla[i][j] == num) {
	          cont++;
	        }
	      }
	    }
	    if (cont>1) {
			
			return false;
			
		} else {
		
		return true;
			
		}
	
}

}
