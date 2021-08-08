package marathon;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
Input: [-8,-3,4,3,10]
         64,9,16,9,100
         
Output: [9,9,16,64,100]*/


public class SquareOfEach {
	
	//@Test
	public void test1() {
		int[] input = {-8,-3,4,3,10};
		Assert.assertTrue(Arrays.equals(new int[] {9,9,16,64,100}, usingTwoPointer(input)));
	}
	
	@Test
	public void test2() {
		int[] input = {-8,0,4,8,10};
		Assert.assertTrue(Arrays.equals(new int[] {0,16,64,64,100}, usingTwoPointer(input)));
	}

	/*
	 * initialize 2 pointer left at 0 and right at length-1
	 * traverse through the input when left<right
	 * 		square value at left > square of value at right then swap, increment left and decrement right
	 * 		square value at right > square of value at left then right--
	*/
	private int[] usingTwoPointer(int[] input) {
		
		int[] output = new int[input.length];
		int left = 0; 
		int right = input.length-1;
		while(left<right) {
			output[left] = input[left]*input[left];
			output[right] = input[right]*input[right];
			if(output[left]>output[right]) {
				int temp = output[left];
				output[left++] = output[right];
				output[right--] = temp;
				
			}
			if(output[right]>output[left]) right--;
		}
		
		System.out.println(Arrays.toString(output));
		
		return output;
	}
}
