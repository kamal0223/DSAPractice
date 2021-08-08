package KandaneAlgo;
import org.junit.Test;

import junit.framework.Assert;

//find min of sub array with positve and negative numbers
public class MinSubArraykandane {
	
	//time complexity O(n)
	
	@Test
	public void test1() {
		int[] input = {-2,3,5,-1};
		Assert.assertEquals(-2, minSubArray(input));
	}
	
	@Test
	public void Dtest2() {
		int[] input = {-3,-2,-5};
		Assert.assertEquals(-10, minSubArray(input));
	}
	
	@Test
	public void test3() {
		int[] input = {3,2,-5,0};
		Assert.assertEquals(-5, minSubArray(input));
	}
	
	
	/*
	 * {-2,3,5,-1}
	 * 
	 */
	private int minSubArray(int[] input) {
		int windowSum = input[0];
		int minSum = input[0];
		
		for(int i = 1;i<input.length;i++) {
			windowSum = Math.min(windowSum+input[i], input[i]);
			minSum = Math.min(windowSum, minSum);
		}
		System.out.println(minSum);
		
		return minSum;
		
	}

}
