package onspot;

import java.text.DecimalFormat;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Input: int[] input, int target
Output: boolean output
constraints: 

TestData set: Positive
			  Negative
			  Edge
Approaches Known: sliding window
*/

public class FindTargetSubarray {

	@Test
	public void test1() {
		int[] input = {2,4,20,3,10,5};
		int target = 33;
		Assert.assertTrue(findTargetSlidingWindow(input, target));
	}
	
	@Test
	public void test2() {
		int[] input = {1};
		int target = 1;
		Assert.assertTrue(findTargetSlidingWindow(input, target));
	}
	
	@Test
	public void test3() {
		int[] input = {1,5,6};
		int target = 12;
		Assert.assertTrue(findTargetSlidingWindow(input, target));
	}

	/*
	 * use sliding window
	 * declare 2 pointers left and right to 0
	 * iterate till left less than equal last element
	 * if right reached end then move left
	 * find the sum of left to right elements
	 * check the sum is equal to target if found return true
	 * at end return false
	
	*/	
	private boolean findTargetTwoPointer(int[] input, int target) {
		
		int left  = 0, right = 0;
		int sum = 0;
		while(left<=input.length-1) {
			if(right == input.length-1) {
				sum += input[right];
				if(sum == target) return true;
				sum = 0;
				left++;
				right = left;
				
			}
			sum += input[right++];
			if(sum == target) return true;
		}
		return false;
	}
	
	private boolean findTargetSlidingWindow(int[] input, int target) {
		
		//declare two pointers low and high for sliding
		//declare a int variable for sum
		//iterate till the right pointers reach end of array
		
		int left = 0,right = 0;
		int sum = 0;
		while(right<input.length) {
			//add the element if the sum is less than target
			if(sum<target) sum += input[right++];
			else if(sum == target) return true;
			else sum -= input[left++];
		}
		if(sum == target) return true;
		else return false;
	}
	
	
}
