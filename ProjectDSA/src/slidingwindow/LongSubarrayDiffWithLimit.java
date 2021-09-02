package slidingwindow;

import java.util.ArrayDeque;
import java.util.TreeSet;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongSubarrayDiffWithLimit {
	
	@Test
	public void test1() {
		int[] input = {10,1,2,4,7,2};
		int limit = 5;
		int output = 4;
		Assert.assertEquals(4, longestSubarray(input,limit));
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
		int min = input[left], max = input[left];
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
		
	public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        set.add(0);
        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            set.add(right);
            while (nums[set.last()] - nums[set.first()] > limit) {
                set.remove(left++);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
