package fullweek.onsite;

import org.junit.Assert;
import org.junit.Test;

/*
Search in a rotated array


There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

input - int[] array, int target
output - int targetIndex
 */

public class SearchTargetInRoatedArray {

	@Test
	public void test1() {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		Assert.assertEquals(4,searchTarget(nums, target));
	}
	
	@Test
	public void test2() {
		int[] nums = {0,1,2,4,5,6,7};
		int target = 4;
		Assert.assertEquals(3,searchTarget(nums, target));
	}
	@Test
	public void test3() {
		int[] nums = {7,0,1,2,4,5,6};
		int target = 4;
		Assert.assertEquals(4,searchTarget(nums, target));
	}

	/*
	 * declare two pointer low = 0 and high = length-1
	 * iterate till low is less than high
	 *   declare mid with low+high/2
	 * 	 check if the value at mid == target then return that index
	 *   check the value at mid<value at high
	 *   yes -> right side is sorted
	 *   		check the target>highvalue if yes move high to mid-1
 				else move low to mid+1
 		 no -> left side is sorted
 		  	   check the target>low if yes then move low to mid+1
 			   else low to mid-1
 			   
 		return -1;
	 */
	private int searchTarget(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid]<nums[high]) {
				//right side is sorted
				
				if(target>=nums[mid] && target<=nums[high]) low = mid+1;
				else high = mid-1;
			}
			else {
				//left side is sorted
				if(target>=nums[low] && target<=nums[mid]) high = mid-1;
				else low = mid+1;
			}
		}
		
		return -1;
	}
}
