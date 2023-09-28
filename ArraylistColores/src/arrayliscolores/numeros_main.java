package arrayliscolores;

import java.util.ArrayList;
import java.util.Collections;

public class numeros_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(27);
		nums.add(14);
		nums.add(34);
		nums.add(23);
		nums.add(12);
		nums.add(20);
		nums.add(8);
		nums.add(24);
		
		for ( Integer num: nums) {
			System.out.println(num);
		}
		
		Collections.sort(nums);
		
		System.out.println("Orden correcto");
		for ( int num:nums) {
			System.out.println(num);
		}
		
	}

}
