package sorting.algorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {
	
	@Test
	public void test1() {
		int[] nums = {11,14,17,18,2,22,1,8};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,8,11,14,17,18,22}, simpleSort(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {5,4,3,2,1};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, simpleSort(nums)));
	}
	//4 5 3 2 1
	//4 3 5 2 1
	//4 3 2 5 1
	//4 3 2 1 5
	
	//1 2 3 4 5
	@Test
	public void test3() {
		int[] nums = {1,2,4,7,10};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,4,7,10}, simpleSort(nums)));
	}

	
	/*
	 * create two pointers left = 0 and right = 1 and two pointers keep on moving
	 * compare adjacent numbers left value and right value
	 * if(left>right) swap it
	 * else do nothing, keep moving
	 * when left 
	 */
	private int[] bubbleSort(int[] nums) {	
		
		for (int i = 0; i < nums.length-1; i++) {
			boolean isAlreadSorted = true;
			for (int j = 0; j < nums.length-i-1; j++) {
				if(nums[j]>nums[j+1]) {
					swap(nums, j, j+1);
					isAlreadSorted  = false;
				}
			}
			if(isAlreadSorted) break;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private int[] simpleSort(int[] charArray) {
		for(int i = 0;i<charArray.length;i++) {
			for(int j = i+1;j<charArray.length;j++) {
				if(charArray[i]>charArray[j]) {
					int temp = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = temp;
				}
			}
		}
		return charArray;	
	}

}
