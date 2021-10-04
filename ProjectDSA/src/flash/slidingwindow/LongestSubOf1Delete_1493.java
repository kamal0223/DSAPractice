package flash.slidingwindow;

import org.junit.Test;

import junit.framework.Assert;

public class LongestSubOf1Delete_1493 {

	@Test
	public void test1() {
		int[] nums = {0,0,0};
		Assert.assertEquals(0, longestSubArrSlider(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,1,0,1};
		Assert.assertEquals(3, longestSubArrSlider(nums));
	}

	@Test
	public void test3() {
		int[] nums = {1,1,1};
		Assert.assertEquals(2, longestSubArrSlider(nums));
	}

	@Test
	public void test4() {
		int[] nums = {1,0,0};
		Assert.assertEquals(1, longestSubArrSlider(nums));
	}

	@Test
	public void test5() {
		int[] nums = {0,1,1,1,0,1,1,0,1};
		Assert.assertEquals(5, longestSubArrSlider(nums));
	}

	/*
	 * declare maxLen as 0
	 * get each sub array using a nested loop
	 * iterate each sub array and get the zeroCount
	 * 	if the zeroCount greater than 2 then break inner loop and go for next sub array
	 * 	get the maxLen of subarray -1. to delete one element -1 on each subarray 
	 * 
	 * return maxLen
	 * time = O(n^2) and space = O(n)
	 */

	private int longestSubArr(int[] nums) {
		int maxLen = 0;
		for(int start = 0;start<nums.length;start++){
			int zeroCount = 0;
			for(int end = start;end<nums.length;end++){
				if(nums[end] == 0) zeroCount++;
				if(zeroCount>1) break;
				maxLen = Math.max(maxLen,end-start);
			}
		}
		return maxLen;
	}

	/*
	 * sliding window
	 * delcare a left pointer at 0
	 * iterate the array from 0
	 * 	if element is zero increment the zeroCount
	 * 	if the zeroCount is more than 1 break the expanding window and shrink it
	 * 		loop till zeroCount becomes less than equal to 1
	 * 			if element at left pointer is zero then decrement zeroCount
	 * 			increment left pointer
	 * 	check the maxLen by getting the window length - 1 (delete one element)
	 * 	expand the array by moving i if element is 1
	 * 
	 */
	private int longestSubArrSlider(int[] nums) {
		int left = 0, zeroCount = 0,maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) zeroCount++;
			while(zeroCount>1) {
				if(nums[left] == 0) zeroCount--;
				left++;
			}
			maxLen = Math.max(i-left, maxLen);
		}
		return maxLen;
	}
}
