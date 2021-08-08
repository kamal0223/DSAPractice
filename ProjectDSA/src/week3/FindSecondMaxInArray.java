package week3;

import org.junit.Assert;
import org.junit.Test;

//Given a integer array find the second max in it

/*Input: String input, string target
Output: String output
constraints: time complexity O(n)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: bruteforce
*/
public class FindSecondMaxInArray {

	@Test //positive
	public void test1() {
		int[] input = {3,1,2,6};
		Assert.assertEquals(3, secondMaxUsingBrute(input));
	}
	
	@Test (expected = RuntimeException.class)//negative
	public void test2() {
		int[] input = {3,3,3,3};
		Assert.assertEquals(-1, secondMaxUsingBrute(input));
	}
	
	@Test //edge
	public void test3() {
		int[] input = {6,0};
		Assert.assertEquals(0, secondMaxUsingBrute(input));
	}

	/*
	 * get the max of first two elements
	 * get the min of first two elements and store in second max
	 * iterate through the input array
	 * 	check if the number is greater than second max and less than max than update secondmax to this ele
	 * 	get the max of current element and previosu max
	 * 
	 * return second max
	
	*/
	private int secondMaxUsingBrute(int[] input) {
		
		int max = Math.max(input[0], input[1]);
		int secondMax = Math.min(input[0], input[1]);
		for (int i = 0; i < input.length; i++) {
			
			if(input[i]>max) {
				secondMax = max;
				max = input[i];
			} else if(input[i]>secondMax && input[i]<max) {
				secondMax = input[i];
			}
		}
		return secondMax;
	}
}
