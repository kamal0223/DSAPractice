package binarysearch;
import org.junit.Test;

import junit.framework.Assert;

/*A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -infinity.

You must write an algorithm that runs in O(log n) time.*/

public class PeakElementUsingBinary {
	
	
	@Test
	public void test1() {
		int[] input = {1,2,1,3,5,6,4};
		Assert.assertEquals(5, usingBinarySearch(input));
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,1,3,5,7,8};
		Assert.assertEquals(1, usingBinarySearch(input));
	}

	private int usingBinarySearch(int[] input) {
		int low = 0, high = input.length-1;
		int mid = 0;
		while(low<high) {
			mid = (high+low)/2;
			if(input[mid-1]<input[mid] && input[mid]>input[mid+1]) return mid;
			else if(input[mid]<input[mid-1]) high = mid-1;
			else if(input[mid]<input[mid+1]) low = mid+1;
		}
		
		return -1;
	}

}
