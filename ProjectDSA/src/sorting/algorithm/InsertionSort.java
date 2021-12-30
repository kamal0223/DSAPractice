package sorting.algorithm;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {

	@Test
	public void test1() {
		int[] nums = {11,14,17,18,2,22,1,8};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,8,11,14,17,18,22}, insertionSort2(nums)));
	}
	
	@Test
	public void test2() {
		int[] nums = {5,4,3,2,1};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, insertionSort2(nums)));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,3,4,5};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,3,4,5}, insertionSort2(nums)));
	}

	
	/*
	 * create two pointers left = 0 and right = 1 and two pointers keep on moving
	 * compare adjacent numbers left value and right value
	 * if(left>right) swap it
	 * else do nothing, keep moving
	 * when left 
	 * 
	 * 11,14,17,18,2,22,1,8
	 * 
	 * 11, 14, 17, 18, 2, 
	 */
	private int[] insertionSort(int[] nums) {	
		int loopCounter = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
			for (int j = i; j >0 ; j--) {
				loopCounter++;
				if(nums[j]<nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}else break;
			}
		}
		System.out.println(Arrays.toString(nums)+" loopcounter "+loopCounter);
		return nums;
	}
	
	/*
	 * iterate the array from 1 to n say i
	 * declare j as i-1
	 * loop and check if currentElement is smaller than predecessor say j
	 * 	yes-> move the previousChar to one up. To make way for insertion
	 *  decremetn j
	 * out of the loop now j is at the element at equal to or smaller 
	 * place the current value at j+1 index
	 */
	private int[] insertionSort2(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int j = i-1;
			int key = nums[i];
			while(j>=0 && key<nums[j]) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = key;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
