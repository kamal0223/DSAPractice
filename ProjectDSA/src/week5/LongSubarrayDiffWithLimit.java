package week5;

import java.util.ArrayDeque;

import org.junit.Test;

import junit.framework.Assert;

public class LongSubarrayDiffWithLimit {
	
	@Test
	public void test1() {
		int[] input = {10,1,2,4,7,2};
		int limit = 5;
		int output = 4;
		Assert.assertEquals(4, slidingWindow(input,limit));
	}
	
	@Test
	public void test2() {
		int[] input = {4,2,2,2,4,4,2,2};
		int limit = 0;
		int output = 3;
		Assert.assertEquals(3, slidingWindow(input,limit));
	}
	
	@Test
	public void test3() {
		int[] input = {1,10,20,30,40};
		int limit = 8;
		int output = 1;
		Assert.assertEquals(1, slidingWindow(input,limit));
	}
	
	@Test
	public void test4() {
		int[] input = {1,5,6,7,8,10,6,5,6};
		int limit = 4;
		int output = 5;
		Assert.assertEquals(5, slidingWindow(input,limit));
	}
	
	//1,5,6,7,8,10,6,5,6

	/*
	 * declare two pointers left and rigth at zero
	 * delcare two variables max = int.min and min = int.max
	 * iterate till right pointer reaches end of array
	 * Math.max of value at max and right   //10
	 * Math.min of value at min tand right  //1
	 * 
	 * find absolute difference between min and max values and check if it is greater than limit, increment left and right = left
	 * if the abs differenc is less than or equl to limit, increment right
	 * 
	 */
	
	
	private int slidingWindow(int[] input, int limit) {
		
		int left = 0, right=0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int previousLong = 0;
		
		while(right<input.length) {
			max = Math.max(max, input[right]);
			min = Math.min(min, input[right]);
			
			if(Math.abs(max-min)>limit) {
				left++;
				right =left;
				 max = input[left];
				 min = input[left];
			} else {
				previousLong = Math.max(previousLong, right-left+1);
				right++;
			}
		}
		return previousLong;
	}
		
	private int usingQueue(int[] input, int limit) {
		
		int left = 0, right=0;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		
		return limit;
		
	}

}
