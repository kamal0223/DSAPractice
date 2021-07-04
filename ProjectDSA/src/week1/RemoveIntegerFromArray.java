package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



public class RemoveIntegerFromArray {
	
	@Test
	public void test1() {
		int[] input = {2,3,4,2};
		int target = 3;
		System.out.println(Arrays.toString(removeElementFromArray(input, target)));
	}
	
	
	@Test
	public void test2() {
		int[] input = {2,2,2,2};
		int target = 2;
		System.out.println(Arrays.toString(removeElementFromArray(input, target)));
	}
	
	@Test
	public void test3() {
		int[] input = {2,3,4,2};
		int target = 6;
		System.out.println(Arrays.toString(removeElementFromArray(input, target)));
	}
	
	@Test
	public void test4() {
		int[] input = {2,3,4,2};
		int target = 2;
		System.out.println(Arrays.toString(removeElementFromArray(input, target)));
		Assert.assertTrue(Arrays.equals(removeElementFromArray(input, target), new int[] {3,4}));
	}
	
	
	private int[] removeElementFromArray(int[] array, int target) {
		int count = 0;
		for(int i =0;i<array.length;i++) {
			if(array[i] == target) {
				count++;
			}	
		}
		if(count==0) return array;
		int[] output = new int[array.length-count];
		count = 0;
		for(int i =0;i<array.length;i++) {
			if(array[i] != target) {
				output[count++] = array[i];
			}
		}
		return output;
	}


	
		/*
		 * 1. Do we understand problem yes 
		 * a. Input - int[] array int target 
		 * b. Output int[] removedArray 
		 * c. constraint- Remove all occurence if there are multiple
		 * occurence 
		 * e. Do I have all information to solve the problem
		 * 
		 *2) Test Data Set
         *  Minimum of 3 data set !! Positive {2,3,4,6} target 3 or {-1,2,3} target -1, 
         *  Edge {1,2,3,3,4} target 3
         *  Negative {1,2,3,4} target 5
         *  Validate the data set with the interviewer 
         *
         *3) Do I know how to solver it? - yes with brute force
         *    Yes - great, Is there any alternate solution?
         *    No - Can I break down the problem to sub problems?
         *
         *4) Ask for the hint (If you don't know how to solve it)
         *
         *
         *5) Do I know alternate solution to solve this problem? 
         *
         *
         *
         */
		
		//PseudoCode:
		
		
		/*1. Input: int[] array, int target
		2. Output:int[] remvoedIntArray
		3. Traverse through each element in the array
		4. find the number of occurence of the target
		5. create an array with length = input array size - number of target occurence
		6. Traverse through the input array and add the not matching element in new array
		7. Return the new array
		*/
	
	    
	    
	    
	}

