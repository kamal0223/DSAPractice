package binarysearch;

import org.junit.Assert;
import org.junit.Test;

/*There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, 
nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], 
nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be 
rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.*/



/*Input: int[] input, int target
Output: int output
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: binary search
*/
public class FindTargetInRotatedArray {
	
	@Test //positive
	public void test1() {
		int[] input = {4,5,6,7,0,1,2};
		int target = 0;
		Assert.assertEquals(4, optimizedBinarySearch(input, target));
	}
	
	@Test //edge
	public void test2() {
		int[] input = {4,5,6,7,0,1,2};
		int target = 10;
		Assert.assertEquals(-1, optimizedBinarySearch(input, target));
	}
	
	@Test //edge
	public void test4() {
		int[] input = {4,5,6,7,0,1,2};
		int target = 4;
		Assert.assertEquals(0, optimizedBinarySearch(input, target));
	}
	
	//negative
	@Test
	public void test3() {
		int[] input = {};
		int target = 10;
		Assert.assertEquals(-1, optimizedBinarySearch(input, target));
	}
	
	@Test //edge
	public void test5() {
		int[] input = {3,1};
		int target = 1;
		Assert.assertEquals(1, optimizedBinarySearch(input, target));
	}

	/*
	 * iterate through the array and get the pivot index of rotation
	 * declare a int array say beforeRotate
	 * iterate through the input array
	 * 		check if i>pivot index
	 * 		beforeRoata[i-pivot-1] = input[i]
	 * 		else
	 * 		beforeRotate[i+pivot] = input[i]
	 * delcare low, high as zero and beforeRotate.len-1
	 * iterate till low<=high
	 * 	get mid of low and high
	 * 	if value is mid equals target return the mid
	 *  if value at mid less than target move low = mid+1
	 * 	if value at mid high than target move high = mid-1
	 * 	
	 * check if mid<pivot index then return mid+1+pivot
	 *    else return mid-pivot
	
	
	*/
	
	private int usingBinarySearch(int[] input, int target) {
		
		if(input.length == 0) throw new RuntimeException("input array cannot be negative");
		
		int[] beforeRotate = new int[input.length];
		int low = 0, high = beforeRotate.length-1;
		int pivotIndex = 0;
		for(int i = 0;i<input.length-1;i++) {
			if(input[i]>input[i+1]) pivotIndex = i;
		}
		
		
		for(int i = 0;i<input.length;i++) {
			
			if(i>pivotIndex) {
				beforeRotate[i-(pivotIndex+1)] = input[i];
			} else beforeRotate[i+pivotIndex] = input[i];
		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(beforeRotate[mid] == target) {
				if(mid<pivotIndex) return mid+(pivotIndex+1);
				else return mid-pivotIndex;
			}
			else if(beforeRotate[mid]< target) low = mid+1;
			else high = mid-1;
			
		}
		
		return -1;
		
	}
	
	/*
	 * check the side which is sorted
	   if low<mid then left is sorted
	   check target<mid and target>lowvalue then high = mid-1
	   check if target<lowvalue then low = mid+1
	   if mid<high then right is sorted
	   check if the target<midvalue

		time- O(logn) and space - O(1)
	 */
	private int optimizedBinarySearch(int[] input, int target) {		
		int low = 0, high = input.length-1;
		while(low<=high) {
			//find mid value
			int mid = (low+high)/2;
			//
			if(target == input[mid]) return mid;
			//left side is sorted
			if(input[low]<=input[mid]) {
				if(target>=input[low] && target<input[mid]) high = mid-1;
				else low = mid+1;
			}else {   //right side is sorted
				if(target>input[mid] && target<=input[high]) low = mid+1;
				else high = mid-1;
			}
			
		}
		
		return -1;
		
	}


}
