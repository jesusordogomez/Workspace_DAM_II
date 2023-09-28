package recursivas;
import java.util.*;
public class ArraySinRepetir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] randomArray = new int[10];
	       Random random = new Random();

	       for (int i = 0; i < randomArray.length; i++) {
	           int randomInt = random.nextInt(15);
	           randomArray[i] = randomInt;

	           for (int j = 0; j < i; j++) {
	               if (randomArray[i] == randomArray[j]) {
	                   i--;
	               }
	           }
	       }
	       System.out.println("Array de números aleatorios sin repetir:");
	       for (int i = 0; i < 10; i++) {
	           System.out.println(randomArray[i]+" ");
	       }
	}

}
