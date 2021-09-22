package flash.slidingwindow;

import org.junit.Test;

import junit.framework.Assert;

public class MaxOnesByKFlips {
	
	@Test
	public void test1() {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		Assert.assertEquals(6, longestOnes(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 2;
		Assert.assertEquals(10, longestOnes(nums, k));
	}
	
	/*
    sliding window
    create two pointers left and right at 0
    declare a zeroCount to 0
    traverse till right reaches end of the array
    check if the value at right pointer is 0 
    yes=>incrment zeroCount
    check if the zeroCount is greater than k
    yes=> loop till the zero count is less than or equal to k
            check if the left value is 0
             yes=> decrement zeroCount
             no=> increment left
    for all the window get the distance of left and right pointers
    check if this distance is greater than previous distance then update previsous distance
    return distance
*/
	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0, maxOnes = 0, zeroCount = 0;
		while(right<nums.length){
			if(nums[right] == 0) zeroCount++;
			while(zeroCount>k){
				if(nums[left] == 0) zeroCount--;
				left++;
			}
			maxOnes = Math.max(maxOnes, right-left+1);
			right++;
		}
		return maxOnes;
	}

}
