package onspot;

import org.junit.Test;

import junit.framework.Assert;

/*Given an array of integers, return the highest sum of any consecutive elements in the array.*/


public class MaxSumInAnySubArray {

	@Test
	public void test1() {
		int[] input = {1,-5,2,-3,7,1};
		Assert.assertEquals(8, usingBruteForce(input));
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,3,1,2,3};
		Assert.assertEquals(12, usingBruteForce(input));
	}
	
	@Test
	public void test3() {
		int[] input = {0,12,-6,-7,4};
		Assert.assertEquals(12, usingBruteForce(input));
	}
	
	@Test
	public void test4() {
		int[] input = {-1,-2,-3};
		Assert.assertEquals(-1, usingBruteForce(input));
	}
	


	private int usingBruteForce(int[] input) {
		int maxSum = Integer.MIN_VALUE;
		if(input.length==1) return input[0];
		for(int i = 0;i<input.length;i++) {
			Math.max(maxSum, input[i]);
			int temp = 0;
			for(int j = i;j<input.length;j++) {
					temp  = temp+input[j];
					maxSum = Math.max(temp, maxSum);
			}
		}
		
		System.out.println(maxSum);
		
		
		return maxSum;
	}
	
	/*
	 * 
	
	
	*/
	private int usingSlidingWindow(int[] input) {
		return 0;
		
	}
	
	
}
