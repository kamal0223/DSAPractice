package binarysearch;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.*/


/*Input: int[] input, int k
Output: int[] output
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and binary search
*/

public class FindStartEndOfTarget {

	@Test //positive
	public void test1() {
		int input[] = {5,7,7,8,8,10};
		int target = 8;
		Assert.assertTrue(Arrays.equals(new int[] {3,4}, usingBinarySearch(input, target)));
	}
	
	@Test //positive
	public void test2() {
		int input[] = {5,7,7,8,8,10};
		int target = 6;
		Assert.assertTrue(Arrays.equals(new int[] {-1,-1}, usingBinarySearch(input, target)));
	}
	
	@Test //positive
	public void test3() {
		int input[] = {};
		int target = 0;
		Assert.assertTrue(Arrays.equals(new int[] {-1,-1}, usingBinarySearch(input, target)));
	}
	
	@Test //positive
	public void test4() {
		int input[] = {5,7,7,8,8,10,10};
		int target = 5;
		Assert.assertTrue(Arrays.equals(new int[] {0,0}, usingBinarySearch(input, target)));
	}
	
	@Test //positive
	public void test5() {
		int input[] = {5,5,5,5,5};
		int target = 5;
		Assert.assertTrue(Arrays.equals(new int[] {0,4}, usingBinarySearch(input, target)));
	}

	/*
	 * declare a output array of size 2
	 * delcare low and high as zero and length-1
	 * iterate till low<=high
	 * 	calculate mid  = low+high/2
	 * 	if midvalue < target move low to mid+1
	 * 	if midvalue>=target move high to mid-1
	 * start index of target is at low output[0] = low
	 * 
	 * iterate till low<=high
	 * 	calculate mid  = low+high/2
	 * 	if midvalue < target move low to mid+1
	 * 	if midvalue>=target move high to mid-1
	 * 
	 * end index of target is at high output[1] = high 
	 * 
	 * return output
	
	
	*/
	
	private int[] usingBinarySearch(int[] input, int target) {
		
		if(input.length == 0) return new int[]{-1,-1};
		
		int[] output = new int[2];
		int low = 0, high = input.length;
		while(low<=high) {
			int mid  = (low+high)/2;
			if(input[mid]<target) low = mid+1;
			if(input[mid]>=target) high = mid-1;
		}
		if(input[low] == target) output[0] = low;
		else output[0] = -1;
		
		low = 0;
		high = input.length;
		while(low<=high) {
			int mid  = (low+high)/2;
			if(input[mid]<=target) low = mid+1;
			if(input[mid]>target) high = mid-1;
		}
		
		if(input[high] == target) output[1] = high;
		else output[1] = -1;
		
		
		System.out.println(Arrays.toString(output));
		return output;
	}
}
