package marathon;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Input:  [1,2,3,4]
Output: [24,12,8,6]*/




public class ProductOfOtherElements {
	
	@Test
	public void test1() {
		int[] input = {1,2,3,4};
		Assert.assertTrue(Arrays.equals(new int[] {24,12,8,6}, usingTwoPointer(input)));
	}
	
	@Test
	public void test2() {
		int[] input = {0,1};
		Assert.assertTrue(Arrays.equals(new int[] {1,0}, usingTwoPointer(input)));
	}
	
	@Test
	public void test3() {
		int[] input = {1,2,0,4};
		Assert.assertTrue(Arrays.equals(new int[] {1,0}, usingTwoPointer(input)));
	}

	private int[] usingBruteForce(int[] input) {
		int[] output = new int[input.length];
		for(int i = 0;i<input.length;i++) {
			int temp = 1;
			for(int j = 0;j<input.length;j++) {
				if(i!=j) {
					temp = temp*input[j];
				}
			}
			output[i] = temp;
		}
		
		System.out.println(Arrays.toString(output));
		return output;
		
	}
	
	/*
	 * initialize output array of same lenght
	 * initialiaze a variable product
	 * traverse from index 1 to end of array
	 * 		get the product of it and store in product
	 * output[0] as product
	 * Traverse from index 1 till length
	 * divide the product by that element input[i] and multiple the previous element
	 * assign the value to product
	
	*/
	private int[] usingTwoPointer(int[] input) {
		int[] output = new int[input.length];
		int product = 1;
		for(int i = 1;i<input.length;i++) {
			product = product*input[i];
		}
		output[0] = product;
		
		for(int i = 1;i<input.length;i++) {
			product = (product/input[i])*input[i-1];
			output[i] = product;
		}
		System.out.println(Arrays.toString(output));
		return output;
}
	}
