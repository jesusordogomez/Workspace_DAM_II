package recursivas;

public class array {

	public static void main(String[] args) {
	

			int i=0;
			int tamañoarray=10;

			int arreglo[]= new int [tamañoarray];
			arreglo[i]=(int)(Math.random()*51);

			for(i=1;i<tamañoarray;i++) {
			arreglo[i]=(int)(Math.random()*51);


			for(int j=0; j<i ;j++) {
			if(arreglo[i]==arreglo[j]) {
			i--;
			}
			}
			}
			for (int k=0; k<tamañoarray;k++){
			System.out.print(arreglo[k]+" ");
			}

			}
	}


