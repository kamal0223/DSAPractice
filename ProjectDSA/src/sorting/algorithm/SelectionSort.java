package sorting.algorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {
	
	@Test
	public void test1() {
		int[] nums = {11,14,17,18,2,22,1,8};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,8,11,14,17,18,22}, selectionSort(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {5,4,3,2,1};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, selectionSort(nums)));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,3,4,5};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, selectionSort(nums)));
	}

	
	/*
	 * create two pointers left = 0 and right = 1 and two pointers keep on moving
	 * compare adjacent numbers left value and right value
	 * if(left>right) swap it
	 * else do nothing, keep moving
	 * when left 
	 * 
	 * 11,14,17,18,2,22,1,8
	 */
	private int[] selectionSort(int[] nums) {	
		for (int i = 0; i < nums.length-1; i++) {
			int min = nums[i];
			int minIndex = i;
			for (int j = i+1; j < nums.length; j++) {
				//find min of min and j
				if(nums[j]<min) minIndex = j;
				//min = Math.min(min, nums[j]);
				}
			//swap the min with i element
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}

}
