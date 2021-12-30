package week1;

import java.util.Arrays;

public class TwoSumInArray {

	public int[] twoSumArray(int[] array, int target) {
		// initialize int sum to 0
		// traverse through the array till the last before array
		// get the first and second index and add
		// if the sum of 2 equals the target then break the loop

		int[] index = { -1, -1 };
		
		// pick first element and traverse till the last before element
		for (int i = 0; i < array.length - 1; i++) {
			// second iterate pointer to traverse array for each first pointer
			for (int j = i; j < array.length; j++) {
				if (array[i] + array[j] == target) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {

		/*
		 * 1. did I understand the problem Yes 
		 * 2. What is the input for the problem
		 * input t1-> int[] {2,4,2,8,3} t2-> int 10 
		 * 3. what is the output for the problem 
		 * the index that has the value which on addition gives target t2 output
		 * -> int[] {2,3} of value 2,8 
		 * if the target is not met by adding any of those
		 * elements of array output -> int[] {-1,-1}
		 * 
		 * if there are multiple occurence of of the target meet then pick first
		 * occurence
		 * 
		 * 4. Test Data
		 * positive {2,4,2,8,3,2}
		 * Negative {4,12,-2,1,3}
		 * Edgecase {2,2,5,7} When adding the same number i.e 5 with 5
		 */

		int[] i = {2,2,5,7};
		int target = 10;
		TwoSumInArray obj = new TwoSumInArray();
		System.out.println(Arrays.toString(obj.twoSumArray(i, target)));
		Arrays.copyOf(null, target)

	}
	public static void main(String[] args) {
		
	}

}
