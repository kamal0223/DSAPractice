package binarysearch;

import org.junit.Assert;
import org.junit.Test;

/*Given an array nums of integers and integer k, return the maximum sum such that there 
exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.*/

/*Input: int[] input, int k
Output: int
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: Binary search
*/

public class MaxSumInArrayLessThanK {
	
	@Test
	public void test1() {
		int input[] = {34,23,1,24,75,33,54,8};
		int k = 60;
		Assert.assertEquals(58, usingBinarySearch(input, k));
	}
	
	@Test
	public void test2() {
		int input[] = {10,20,30};
		int k = 15;
		Assert.assertEquals(-1, usingBinarySearch(input, k));
	}
	
	@Test
	public void test3() {
		int input[] = {10,20,30};
		int k = 15;
		Assert.assertEquals(-1, usingBinarySearch(input, k));
	}

	/*
	 * sort the array 
	 * declare two pointers low and high as zero
	 * iterate 
	
	
	*/
	private int usingBinarySearch(int input, int k) {
		
		return -1;
	}
}
