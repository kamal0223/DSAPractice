package binarysearch;

import org.junit.Assert;
import org.junit.Test;

/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.*/


/*Input: int[] input, int k
Output: int output
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: Binary search
*/

public class TargetInDistinct {
	
	
	@Test //positive
	public void test1() {
		int[] nums = {1,3,5,6};
		int target = 5;
		Assert.assertEquals(2, usingBinarySearch(nums, target));
	}
	
	@Test //negative
	public void test2() {
		int[] nums = {1,3,5,6};
		int target = 2;
		Assert.assertEquals(1, usingBinarySearch(nums, target));
	}
	
	@Test //edge
	public void test3() {
		int[] nums = {1,3,5,6};
		int target = 0;
		Assert.assertEquals(0, usingBinarySearch(nums, target));
	}

	/*
	 * delcare low as 0 and high as length-1
	 * iterate till low less than or equal to high
	 * find mid as low+high/2
	 * 	check if mid value is equal to target then return mid index
	 * 	check if mid value<target then move low to mid+1
	 * 	check if mid value>target then move high to mid-1
	 * 
	 * return low
		
	*/
	
	public int usingBinarySearch(int[] nums, int target) {
		
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid]<target) low = mid+1;
			if(nums[mid]>target) high = mid-1;
		}
		
		return low;
		
	}
}
