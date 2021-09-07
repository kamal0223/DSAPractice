package onspot;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of integers, return the minimum possible contiguous array with maximum sum value.
Examples:
int[] nums = {2,4,-11,0,3,7}
Output {3,7}
Explanation: Sum of 3+7 is the biggest sum of all elements in the array. 
Though 0+3+7 gives the same value, it is expected to return the min possible 
contiguous array, hence it is {3,7}
 */
public class MinimumSubArrayWithMaxSum {
	
	@Test
	public void test1() {
		int[] nums = {2,4,-11,0,3,7};
		Assert.assertTrue(Arrays.equals(new int[] {3,7}, minSubArrayOfMaxSum(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {-2,4,-11,0,3,-7};
		Assert.assertTrue(Arrays.equals(new int[] {4}, minSubArrayOfMaxSum(nums)));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,3,-8,3,3};
		Assert.assertTrue(Arrays.equals(new int[] {3,3}, minSubArrayOfMaxSum(nums)));
	}
	
	@Test
	public void test4() {
		int[] nums = {3,3,-8,1,2,3};
		Assert.assertTrue(Arrays.equals(new int[] {3,3}, minSubArrayOfMaxSum(nums)));
	}

	/*
	 * declare a windowSum to to first element
	 * declare a maxSum = minInteger, maxStart = -1, maxEnd = -1
	 * delcare a pointer left at 0
	 * iterate from 0 to last element using index right
	 * 		get the value at right and add to windowSum
	 * 		compare windowSum>maxSum
	 * 			then assign maxSum = windowSum and maxStart = left and maxEnd = right
	 * 		if windowSum = maxSum
	 * 			check if maxEnd-maxStart>right-left
	 * 				update maxstart = left and maxEnd = right
	 * 
	 * copy the elements of maxStart and maxEnd to output array 
	 * return output
	 */
	private int[] minSubArrayOfMaxSum(int[] nums) {
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE, maxStart = -1, maxEnd = -1;
		int left = 0;
		for(int right = 0;right<nums.length;right++) {
			windowSum += nums[right];
			if(windowSum>maxSum) {
				
			}
		}
		
		return null;
	}

}
