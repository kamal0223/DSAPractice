package slidingwindow;

import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

/*Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of 
which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/


/*Input: int[] input, int target
Output: input
constraints: 1 <= target <= 109
			 1 <= nums.length <= 105
			 1 <= nums[i] <= 105
TestData set: Positive
			  Negative
			  Edge
Approaches Known: BruteForce
				  Slidingwindow
*/
public class MinimumSizeSubArraySum {
	
	@Test //positive
	public void test0() {
		int[] input = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
		int target = 80;
		Assert.assertEquals(6, usingSlidingWindow(input, target));
	}
	
	@Test //positive
	public void test1() {
		int[] input = {2,3,1,2,4,3};
		int target = 7;
		Assert.assertEquals(2, usingSlidingWindow(input, target));
	}
	
	@Test
	public void test2() {
		int[] input = {1,4,4};
		int target = 4;
		Assert.assertEquals(1, usingSlidingWindow(input, target));
	}
	
	@Test //edge
	public void test3() {
		int[] input = {1,1,1,1,1,1,1,1};
		int target = 11;
		Assert.assertEquals(0, usingSlidingWindow(input, target));
	}
	
	@Test //negative
	public void test4() {
		int[] input = {1,2,3,4,5};
		int target = 11;
		Assert.assertEquals(3, usingSlidingWindow(input, target));
	}
	
	
	
	/*
	 * declare a int min variable of integer max
	 * declare int output array
	 * iterate through the input array till length say index i
	 * 	declare a sum to zero
	 * 	iterate through the array starting with i and till length
	 * 		get the sum+currentElement and update sum variable
	 * 		if sum is greater than or equal to target and current length is less than previous
	 * 			get absolute value of i-j and update output
	 * 			min = sum;
	 *	
	 * if min value is integer max return 0
	 * return output+1
	 * 	
	
	
	*/

	private int usingBruteForce(int[] input, int target) {
		
		int min  = Integer.MAX_VALUE;
		int output = input.length;
		for(int i = 0;i<input.length;i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum = sum + input[i];
				if(sum>=target && output>Math.abs(i-j)) {
					output = Math.abs(i-j);
					min  = sum;
				}
			}
		}
		if(min == Integer.MAX_VALUE) return 0;
		return output+1;
	}
	
	/*sliding window
	 * 
	 * 2,3,1,2,4,3   target = 7
	 * delcare two pointer left and right with zero
	 * declare a sum int to zero
	 * delcare a min int of max integer value
	 * declare output with lenght of array
	 * iterate till left reaches end of input array
	 * 	update sum = sum+value at right
	 * 		if sum is greater than or equal to target
	 * 			iterate till left<right 
	 * 				subtract the value from left in sum
	 * 		 		if sum is greater than or equal to target, then update current length(output) and min as sum
	 * 
	  * if min value is integer max return 0
	 * return output+1
	
	
	*/
	
	private int usingSlidingWindow(int[] input, int target) {
		int min  = Integer.MAX_VALUE;
		int output = input.length;
		int sum = 0, left = 0, right=0;
		while(left<input.length && right<input.length){
			sum = sum+input[right];
			if(sum>=target) {
				output = Math.min(output, Math.abs(left-right));
				while(left<=right) {
					sum = sum-input[left++];
					if(sum>=target) {
						output = Math.min(output, Math.abs(left-right));
					}
				}
			}
			right++;
		}
		
		if(output == input.length) return 0;
		return output+1;
		
	}
}
