package slidingwindow;


import org.junit.Assert;
import org.junit.Test;

public class MaxAverageInArray {
	
	 
	
	@Test
	public void test1() {
		int[] input = {1,12,-5,-6,50,3};
		int target = 4;
		Assert.assertEquals(12.75, usingSlider(input, target), 0.00001);
	}
	
	@Test
	public void test2() {
		int[] input = {7};
		int target = 1;
		Assert.assertEquals(7.00, usingSlider(input, target), 0.00001);
	}
	
	
	/*
	 * given the subarray length k
	 * 
	 * add all elements get the sum and store it in a double
	 * 
	 * traverse through the lenght of array from index1 till element n-k
	 * 
	 * subtract the one element before the window
	 * 
	 * Add the element that comes up at end of the window
	 * 
	 * time complexity = O(n+m)
	 * 
	 * space complexity = o(1)
	 */
	
	private double usingSlider(int[] input, int target) {
		
		double maxSum = 0;
		for(int i =0;i<target;i++) {
			maxSum = maxSum+input[i];
		}
		
		double tempSum = maxSum;
		for(int i =1;i<input.length-target;i++) {
			tempSum = tempSum-input[i-1]+input[i+target-1];
			maxSum = Math.max(tempSum, maxSum);
		}
		
		return maxSum/target;
	}
	
	

}
