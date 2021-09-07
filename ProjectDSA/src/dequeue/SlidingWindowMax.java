package dequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMax {
	
	@Test
	public void test1() {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		Assert.assertTrue(Arrays.equals(new int[] {3,3,5,5,6,7}, maxSlidingWindow(nums, k)));
	}

	@Test
	public void test2() {
		int[] nums = {1,-1};
		int k = 1;
		Assert.assertTrue(Arrays.equals(new int[] {1,-1}, maxSlidingWindow(nums, k)));
	}
	
	@Test
	public void test3() {
		int[] nums = {4,-2};
		int k = 2;
		Assert.assertTrue(Arrays.equals(new int[] {4}, maxSlidingWindow(nums, k)));
	}

	 public Integer[] maxSlidingWindow(int[] nums, int k) {
		 if(k==1) return nums;
		 
		 ArrayDeque<Integer> dequeue = new ArrayDeque<Integer>();
		 dequeue.add(0);
			for(int i =0;i<nums.length-1;i++) {
				//check element with next element and add the max to dequeue
				if(nums[i]>nums[i+1]) dequeue.add(nums[i]);
				else dequeue.add(nums[i+1]);
			}
			if(k==2) return (Integer[]) dequeue.toArray();
			for(int i=3;i<=k;i++) {
				//compare two elements and remove the 
				dequeue.pee
			}
			//deque is obtained loop the deque 
			
			//max is present in the dequeue
			
			for(int i = k;i<nums.length;i++) {
				//compare first element from nums and increment for every addition
	            if(nums[i]>nums[i-k]) nums[i-k+1] = nums[i];
	            else nums[i-k+1] = nums[i-k];
			}
			System.out.println(Arrays.toString(Arrays.copyOf(nums, nums.length-k+1)));
			return Arrays.copyOf(nums, nums.length-k+1);   
	 }
}
