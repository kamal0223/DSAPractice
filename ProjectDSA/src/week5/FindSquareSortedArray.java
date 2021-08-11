package week5;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindSquareSortedArray {
	
	@Test
	public void test1() {
		int[] input = {4,5,6};
		Assert.assertTrue(Arrays.equals(new int[] {16,25,36}, usingTwoPointer(input)));
	}
	
	@Test
	public void test2() {
		int[] input = {-2,0,6};
		Assert.assertTrue(Arrays.equals(new int[] {0,4,36}, usingTwoPointer(input)));
	}	
	
	@Test
	public void test3() {
		int[] input = {-5,-1,0,1,2,3};
		Assert.assertTrue(Arrays.equals(new int[] {0,1,1,4,9,25}, usingTwoPointer(input)));
	}

	private int[] usingTwoPointer(int[] input) {
		
		if(input.length == 0) return input;
		int left = 0, right = input.length-1;
		//check the first and last abs values if left value > right value then swap it move both pointers
		//if left value<rightvalue then 
		//if
		while (left<right) {
			//get the absolute value and compare
			if(Math.abs(input[left])<=Math.abs(input[right])) right--;
			else {
				//swap left and right values
				int temp = input[left];
				input[left] = input[right];
				input[right] = temp;
				right--;
			}
		}
		for (int i = 0; i < input.length; i++) {
			input[i] = input[i]*input[i];
		}
		System.out.println(Arrays.toString(input));
		return input;
		
	}
}
