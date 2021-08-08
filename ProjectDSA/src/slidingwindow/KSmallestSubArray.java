package slidingwindow;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/*Given an integer array nums of length n and an integer k, return the kth smallest subarray sum.
A subarray is defined as a non-empty contiguous sequence of elements in an array. 
A subarray sum is the sum of all elements in the subarray.*/

/*Input: int[] input, int k
Output: int
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: BruteForce
				  Slidingwindow
*/

public class KSmallestSubArray {
	
	@Test //positive
	public void test1() {
		int[] input = {2,1,3};
		int k = 4;
		Assert.assertEquals(3, usingBruteForce(input, k));
	}
	
	@Test //positive
	public void test2() {
		int[] input = {3,3,5,5};
		int k = 7;
		Assert.assertEquals(10, usingBruteForce(input, k));
	}

	@Test (expected = RuntimeException.class)//negative
	public void test3() {
		int[] input = {1,2,3};
		int k = 7;
	    usingBruteForce(input, k);
	}
	
	@Test //edge
	public void test4() {
		int[] input = {0,0,0};
		int k = 4;
		Assert.assertEquals(0, usingBruteForce(input, k));
	}

	
	
	/*brute force
	 * find the count of number of subarrays possible by N*(N+1)/2
	 * Declare an arrray subArraySum of that size
	 * iterate through the length of input array say index i
	 * 	int a variable sum = 0;
	 * 	iterate from index i through the length of input array
	 * 		update the sum variable with addition of previous sum and current element
	 * 		assign sum value to subArraySum
	 * using array sort function sort it
	 * get the k-1 index to get kth element and return
	
	*/
	
	private int usingBruteForce(int[] input, int k) {
		
		int subArrayCount = (input.length * (input.length+1))/2;
		if(k>subArrayCount) throw new RuntimeException("k is greate than number of possible subarrays");
		
		int[] subArraySum = new int[subArrayCount];
		int a = 0;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum = sum+input[j];
				subArraySum[a++] = sum;
			}
		}
		
		Arrays.sort(subArraySum);
		System.err.println(subArraySum[k-1]);
		return subArraySum[k-1];
	}
	
}
