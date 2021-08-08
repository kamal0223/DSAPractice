package binarysearch;

import org.junit.Assert;
import org.junit.Test;

//find the number of ones in a sorted 0 and 1 array




/*Input: int[] input
Output: int output
constraints: time complexity should be less than O(n)


TestData set: Positive
			  Negative
			  Edge
Approaches Known:
*/

public class FindNumberOfOnes {
	
	
	@Test //positive
	public void test1() {
		int[] input = {0,0,0,0,1,1,1,1};
		Assert.assertEquals(4, usingTwoPointer(input));
	}
	
	@Test //edge
	public void test2() {
		int[] input = {0,0,0,0};
		Assert.assertEquals(0, usingTwoPointer(input));
	}
	
	@Test //edge
	public void test3() {
		int[] input = {1,1,1,1};
		Assert.assertEquals(4, usingTwoPointer(input));
	}
	
	//negative
	@Test (expected = RuntimeException.class)
	public void test4() {
		int[] input = {};
		Assert.assertEquals(4, usingTwoPointer(input));
	}

	
	/*
	
	
	*/
	private int usingBinarySearch(int[] input) {
		
		if(input.length == 0) throw new RuntimeException("input cannot be empty");
		
		int low = 0, high = input.length-1;
		int mid = 0;
		while(low<=high) {
			mid = (low+high)/2;
			if(input[mid]==1) high = mid-1;
			else if(input[mid] == 0) low = mid+1;
		}
		if(input[mid] == 1) return input.length-mid;
		if(input[mid] == 0) return input.length-mid-1;
		
		
		return 0;
	}
	
	/*
	 * declare two pointers left to zero and right to last ele
	 * iterate till the left less than or equals right
	 * check if left pointer value is 0 increment left
	 * check if right pointer value is 1 decrement right
	 * 
	 * return length - right-1
	
	
	*/
	private int usingTwoPointer(int[] input) {
		
		if(input.length == 0) throw new RuntimeException("input cannot be empty");
		int left = 0, right = input.length-1;
		while(left<=right) {
			if(input[left] == 0) left++;
			if(input[right] == 1) right--;
		}
		
		return input.length-right-1;
		
	}

}
